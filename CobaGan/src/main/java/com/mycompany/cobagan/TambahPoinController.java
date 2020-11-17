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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author billy
 */
public class TambahPoinController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField jenis_kegiatan;
    @FXML
    private TextField nama_kegiatan;
    @FXML
    private TextField jml_poin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void lhtmhs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardUser.fxml"));
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
    private void tmbhpoin(ActionEvent event) {

    }

    private Connection conn = null;

    @FXML
    private void buttonTmbh(ActionEvent event) throws SQLException, IOException {
        String user = username.getText();
        String jk = jenis_kegiatan.getText();
        String nk = nama_kegiatan.getText();
        String jp = jml_poin.getText();

        Connection con = DBUtil.connect();
        Statement stmt = con.createStatement();
        System.out.println(user);
        System.out.println(jk);
        System.out.println(nk);
        System.out.println(jp);
        String query = "INSERT INTO poinmhs VALUES ('" + user + "','" + jk + "','" + nk + "','" + jp + "')";
        System.out.println(query);

        int rs = stmt.executeUpdate(query);

        System.out.println("ok");

        if (rs == 1) {

            System.out.println("data masuk");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Data Telah terupdate! ", ButtonType.YES);
            alert.showAndWait();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboarUser.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/dashboardadmin.css");
            // scene.getStylesheets().add("/styles/Style.css");
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else {
            if (user.equals("") && (nk.equals(""))) {
                Alert alert_up = new Alert(Alert.AlertType.INFORMATION, "Masukan data terlebih dahulu! ", ButtonType.YES);
                alert_up.showAndWait();

            } else if (user.equals("")) {
                Alert alert_u = new Alert(Alert.AlertType.INFORMATION, "Masukan username terlebih dahulu! ", ButtonType.YES);
                alert_u.showAndWait();

            } else if (jk.equals("")) {
                Alert alert_p = new Alert(Alert.AlertType.INFORMATION, "Masukan jenis kegiatan terlebih dahulu! ", ButtonType.YES);
                alert_p.showAndWait();
             
            } else if (nk.equals("")) {
                Alert alert_p = new Alert(Alert.AlertType.INFORMATION, "Masukan nama kegiatan terlebih dahulu! ", ButtonType.YES);
                alert_p.showAndWait();
            
            } else if (jp.equals("")) {
                Alert alert_p = new Alert(Alert.AlertType.INFORMATION, "Masukan jumlah poin terlebih dahulu! ", ButtonType.YES);
                alert_p.showAndWait();
                
            } else {
                Alert alert_unk = new Alert(Alert.AlertType.INFORMATION, "data salah!", ButtonType.YES);
                alert_unk.showAndWait();

                System.out.println("tidak ada");
            }
        }
    }
}
