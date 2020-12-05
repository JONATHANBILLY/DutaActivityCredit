/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

import com.mycompany.cobagan.Models.PointModel;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author billy
 */
public class DashboardUserController implements Initializable {

    ObservableList<PointModel> users;
   
    @FXML
    private TableView<PointModel> tabel_info;
    @FXML
    private TableColumn<PointModel, String> col_username;
    @FXML
    private TableColumn<PointModel, String>col_jenis_kegiatan;
    @FXML
    private TableColumn<PointModel, String>col_nama_kegiatan;
    @FXML
    private TableColumn<PointModel, String> col_jml_poin;
@   FXML
    private TableColumn<PointModel, String> col_tanggal;
    
    public static String initUsername;
    
    @FXML
    public DatePicker from;

    @FXML
    public DatePicker to;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("username: " + this.initUsername);
        users = FXCollections.observableArrayList();
        String query = "SELECT * FROM poinmhs where username='"+this.initUsername+"'";
        System.out.println(query);
        Connection con = DBUtil.connect();
        Statement stmt = null;
       
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery(query);
            PointModel user = null;
            while(rs.next()){
                System.out.println(rs.getString("username"));
                user = new PointModel();
                user.setUsername(rs.getString("username"));
                user.setJenisKegiatan(rs.getString("jenis_kegiatan"));
                user.setNamaKegiatan(rs.getString("nama_kegiatan"));
                user.setJumlahPoint(rs.getInt("jml_poin"));
                user.setTanggal(rs.getString("tanggal"));
                
                users.add(user);
                System.out.println("Jenis Kegiatan model: "+ user.getJenisKegiatan());
                System.out.println("Jenis Kegiatan db: "+ rs.getString("jenis_kegiatan"));
            }
            System.out.println(users.size());
            col_username.setCellValueFactory(new PropertyValueFactory("Username"));
            col_jenis_kegiatan.setCellValueFactory(new PropertyValueFactory("JenisKegiatan"));
            col_nama_kegiatan.setCellValueFactory(new PropertyValueFactory("NamaKegiatan"));
            col_jml_poin.setCellValueFactory(new PropertyValueFactory("JumlahPoint"));
            col_tanggal.setCellValueFactory(new PropertyValueFactory("Tanggal"));
           
            //nama_mhs.setCellFactory(TextFieldTableCell.forTableColumn());
            tabel_info.setItems(users);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void getData(String id){
        System.out.println("username in fc: " + id);
        this.initUsername=id;
    }
    
    @FXML
    private void search(ActionEvent event){
        String dateDari = "";
        String dateKe = "";
        dateKe = convertDate(to.getValue().toString());
        dateDari = convertDate(from.getValue().toString());
        users = FXCollections.observableArrayList();
        String query = "SELECT * FROM poinmhs where username='"+this.initUsername+"' AND tanggal between '"+dateDari+"' and '"+dateKe+"'";
        System.out.println(query);
        Connection con = DBUtil.connect();
        Statement stmt = null;
       
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery(query);
            PointModel user = null;
            while(rs.next()){
                System.out.println(rs.getString("username"));
                user = new PointModel();
                user.setUsername(rs.getString("username"));
                user.setJenisKegiatan(rs.getString("jenis_kegiatan"));
                user.setNamaKegiatan(rs.getString("nama_kegiatan"));
                user.setJumlahPoint(rs.getInt("jml_poin"));
                user.setTanggal(rs.getString("tanggal"));
                
                users.add(user);
                System.out.println("Jenis Kegiatan model: "+ user.getJenisKegiatan());
                System.out.println("Jenis Kegiatan db: "+ rs.getString("jenis_kegiatan"));
            }
            System.out.println(users.size());
            col_username.setCellValueFactory(new PropertyValueFactory("Username"));
            col_jenis_kegiatan.setCellValueFactory(new PropertyValueFactory("JenisKegiatan"));
            col_nama_kegiatan.setCellValueFactory(new PropertyValueFactory("NamaKegiatan"));
            col_jml_poin.setCellValueFactory(new PropertyValueFactory("JumlahPoint"));
            col_tanggal.setCellValueFactory(new PropertyValueFactory("Tanggal"));
           
            //nama_mhs.setCellFactory(TextFieldTableCell.forTableColumn());
            tabel_info.setItems(users);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private String convertDate(String d) {
        if (d.isEmpty()) {
            return "0";
        } else {

            String[] date = d.split("-");
            String year = date[0];
            String month = date[1];
            String day = date[2];

            return year + "/" + month + "/" + day;
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
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardUser.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/dashboardadmin.css");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void tmbhpoin(ActionEvent event) throws IOException {
        /*
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TambahPoin.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/dashboardadmin.css");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        */
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TambahPoin.fxml"));
        Parent root = loader.load();
        TambahPoinController userController= loader.getController();
        userController.getData(this.initUsername);
        root = FXMLLoader.load(getClass().getResource("/fxml/TambahPoin.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/dashboardadmin.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
