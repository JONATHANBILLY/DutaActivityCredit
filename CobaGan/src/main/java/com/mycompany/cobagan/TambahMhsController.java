/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author billy
 */
public class TambahMhsController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField nama;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void lhtmhs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardAdmin.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/dashboardadmin.css");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void keluar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/login.css");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void tmbhmhs(ActionEvent event) {

    }

    @FXML
    private void buttonTmbh(ActionEvent event) throws SQLException, IOException {
        String username = this.username.getText();
        String password = this.password.getText();
        String nama = this.nama.getText();
        String role;
        role = "2";

        Connection con = DBUtil.connect();
        Statement stmt = con.createStatement();
        System.out.println(username);
        System.out.println(password);
        System.out.println(nama);
        String query = "INSERT INTO user VALUES ('" + username + "', '" + nama + "', '" + password + "', '" + role + "')";
        System.out.println(query);

        int rs = stmt.executeUpdate(query);
        System.out.println("OK");
        if (username.equals("") && (password.equals(""))) {
            Alert alert_up = new Alert(Alert.AlertType.INFORMATION, "Masukan username dan password terlebih dahulu! ", ButtonType.YES);
            alert_up.showAndWait();

        } else if (username.equals("")) {
            Alert alert_u = new Alert(Alert.AlertType.INFORMATION, "Masukan username terlebih dahulu! ", ButtonType.YES);
            alert_u.showAndWait();

        } else if (password.equals("")) {
            Alert alert_p = new Alert(Alert.AlertType.INFORMATION, "Masukan password terlebih dahulu! ", ButtonType.YES);
            alert_p.showAndWait();

        } else if (password != username + ("UKDW")) {
            Alert alert_p = new Alert(Alert.AlertType.INFORMATION, "Coba Lagi", ButtonType.YES);
            alert_p.showAndWait();
        } else if(rs == 1){
            System.out.println("data masuk");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Data Telah terupdate! ", ButtonType.YES);
            alert.showAndWait();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardAdmin.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/dashboardadmin.css");
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
    }
}


