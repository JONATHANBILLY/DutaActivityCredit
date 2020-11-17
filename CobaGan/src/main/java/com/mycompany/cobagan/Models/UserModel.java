/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cobagan.Models;

/**
 *
 * @author eka
 */


public class UserModel {

    /**
     * @return the nama
     */
    private String nama;
    private String nim;
    
    public UserModel(String nama, String nim){
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
    
}
