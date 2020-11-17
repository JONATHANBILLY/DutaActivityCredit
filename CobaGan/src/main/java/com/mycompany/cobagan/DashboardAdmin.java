/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan;

/**
 *
 * @author billy
 */
public class DashboardAdmin {
    private String username;
    private String nama;
    private String password;
    
    public DashboardAdmin(String user, String name, String pass){
        this.username = user;
        this.password = pass;
        this.nama = name;
    }

    DashboardAdmin(String username, String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
