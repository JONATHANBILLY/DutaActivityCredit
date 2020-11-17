/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

import static com.mycompany.cobagan.DBUtil.role;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;
import static java.time.Clock.system;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author reksy
 */
public class LoginController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;

    /**
     * Initializes the controller class.
     */
    private Connection conn = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LoginGan(ActionEvent event) throws SQLException, IOException {
        String username = user.getText();
        String password = pass.getText();

        String query = "SELECT * FROM user WHERE username = '" + username + "' and password='" + password + "'";
        Connection con = DBUtil.connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            DBUtil.username = rs.getString("username");
            DBUtil.nama = rs.getString("nama");
            DBUtil.password = rs.getString("password");
            DBUtil.role = rs.getInt("role");
            if (role == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardAdmin.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/styles/dashboardadmin.css");
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } else if(role == 2){
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardUser.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/styles/dashboardadmin.css");
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "User belum terdaftar", ButtonType.YES);
                alert.showAndWait();
            }
        } else {
            if (username.equals("") && (password.equals(""))) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Masukan username dan password terlebih dahulu! ", ButtonType.YES);
                alert.showAndWait();

            } else if (username.equals("")) {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Masukan username terlebih dahulu! ", ButtonType.YES);
                alert1.showAndWait();

            } else if (password.equals("")) {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Masukan password terlebih dahulu! ", ButtonType.YES);
                alert2.showAndWait();

            } else {
                Alert alert3 = new Alert(Alert.AlertType.WARNING, "username atau password salah!", ButtonType.YES);
                alert3.showAndWait();
            }
        }

        con.close();
    }

    private void ifelse(boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
