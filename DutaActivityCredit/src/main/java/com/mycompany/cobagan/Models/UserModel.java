/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan.Models;

import com.mycompany.cobagan.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author eka
 */
public class UserModel {

    private String nama;
    private String nim;
    private Button update;
    private Button delete;

    public UserModel() {
    }

    public UserModel(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the nim
     */
    public String getNim() {
        return nim;
    }

    /**
     * @param nim the nim to set
     */
    public void setNim(String nim) {
        this.nim = nim;
    }

    /**
     * @return the update
     */
    public Button getUpdate() {
        return update;
    }

    /**
     * @param update the update to set
     */
    public void setUpdate(Button update) {
        this.update = update;

        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String query = "UPDATE user SET nama=" + nama + " where username =" + nim;
                System.out.println(query);
                Connection con = DBUtil.connect();
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                } catch (SQLException ex) {
                }
            }
        });
    }

    /**
     * @return the delete
     */
    public Button getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(Button delete) {
        this.delete = delete;
        delete.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String query = "DELETE FROM user where username =" + nim;
                System.out.println(query);
                Connection con = DBUtil.connect();
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                    Alert alert_p = new Alert(Alert.AlertType.INFORMATION, "Data Berhasil Dihapus!", ButtonType.YES);
                    alert_p.showAndWait();
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardAdmin.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("/styles/dashboardadmin.css");
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (SQLException ex) {
                } catch (IOException ex) {
                    Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
