/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

import com.mycompany.cobagan.Models.UserModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author billy
 */
public class DashboardAdminController implements Initializable {

    ObservableList<UserModel> users;
   
    @FXML
    private TableView<UserModel> tabel_info;
    @FXML
    private TableColumn<UserModel, String> nama_mhs;
    @FXML
    private TableColumn<UserModel, String> nim_mhs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        users = FXCollections.observableArrayList();
        String query = "SELECT * FROM user where role=2";
        Connection con = DBUtil.connect();
        Statement stmt = null;
       
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery(query);
            UserModel user = null;
            while(rs.next()){
                user = new UserModel(rs.getString("nama"), rs.getString("username"));
                users.add(user);
            }
            System.out.println(users.size());
            nama_mhs.setCellValueFactory(new PropertyValueFactory("Nama"));
            nim_mhs.setCellValueFactory(new PropertyValueFactory("Nim"));
           
            //nama_mhs.setCellFactory(TextFieldTableCell.forTableColumn());
            tabel_info.setItems(users);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
