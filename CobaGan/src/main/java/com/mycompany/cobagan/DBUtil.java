/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author reksy
 */
public class DBUtil {

    public static String username;
    public static String nama;
    public static String password;
    public static String nim;
    public static Integer role;

    public static Connection connect() {
        Connection con = null;
        String url = "jdbc:sqlite:dac.db";
        try {
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
        return con;
    }
}
