/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

import static com.mycompany.cobagan.DBUtil.nama;
import static com.mycompany.cobagan.DBUtil.username;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author billy
 */
public class DashboardAdminController implements Initializable {

    @FXML
    private TableColumn<DashboardAdmin, String> nama_mhs;
    @FXML
    private TableColumn<DashboardAdmin, String> nim_mhs;
    @FXML
    private TableView tableMahasiswa;

    /**
     * Initializes the controller class.
     */
    private void loadData(){
        try {
            ObservableList<DashboardAdmin> dataMahasiswa = FXCollections.observableArrayList();
            String sql = "SELECT * FROM user WHERE username ='"+DBUtil.username+"'";
            Connection con = DBUtil.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String user = rs.getString(username);
                String name = rs.getString(nama);
                dataMahasiswa.add(new DashboardAdmin(user, name));
            }
            tableMahasiswa.setItems(dataMahasiswa);
            con.close();
        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void keluar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/login.css");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
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
    private void tmbhmhs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TambahMhs.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/tambahmhs.css");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
