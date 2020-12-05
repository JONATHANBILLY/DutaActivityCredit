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
public class PointModel {

    /**
     * @return the username
     */
    private String username;
    private String jenisKegiatan;
    private String namaKegiatan;
    private int jumlahPoint;
    private String tanggal;
    
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the jenisKegiatan
     */
    public String getJenisKegiatan() {
        return jenisKegiatan;
    }

    /**
     * @param jenisKegiatan the jenisKegiatan to set
     */
    public void setJenisKegiatan(String jenisKegiatan) {
        this.jenisKegiatan = jenisKegiatan;
    }

    /**
     * @return the namaKegiatan
     */
    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    /**
     * @param namaKegiatan the namaKegiatan to set
     */
    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    /**
     * @return the jumlahPoint
     */
    public int getJumlahPoint() {
        return jumlahPoint;
    }

    /**
     * @param jumlahPoint the jumlahPoint to set
     */
    public void setJumlahPoint(int jumlahPoint) {
        this.jumlahPoint = jumlahPoint;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
}
