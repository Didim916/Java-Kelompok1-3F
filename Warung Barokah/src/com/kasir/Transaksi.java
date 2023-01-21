/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.koneksi.Koneksi;

/**
 *
 * @author Dim
 */
public class Transaksi {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    
    public String id_transaksi;
    public String NamaBarang;
    public String HarSatuan;
    public String JmlBarang;
    public String TotalBarang;
    public String id_barang;
    
    
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO transaksi (id_transaksi,id_barang,NamaBarang,HarSatuan,JmlBarang,TotalBarang)VALUES(?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, id_transaksi);
        pst.setString(2, id_barang);
        pst.setString(3, NamaBarang);
        pst.setString(4, HarSatuan);
        pst.setString(5, JmlBarang);
        pst.setString(6, TotalBarang);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE transaksi SET JmlBarang=?, TotalBarang=? WHERE id_barang=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, JmlBarang);
        pst.setString(2, TotalBarang);
        pst.setString(3, id_barang);
        pst.execute();
        pst.close();
    }
    
    public void hapus()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "DELETE FROM transaksi WHERE id_barang=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_barang);
            pst.execute();
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    public ResultSet UpdateTable()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "SELECT id_barang,NamaBarang,HarSatuan,JmlBarang,TotalBarang FROM transaksi WHERE id_transaksi=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, id_transaksi);
        rs = pst.executeQuery();
        return rs;
    }
}
