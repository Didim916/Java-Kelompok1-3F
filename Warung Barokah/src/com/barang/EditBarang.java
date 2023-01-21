/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barang;

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
public class EditBarang {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    
    public String id;
    public String nama;
    public Float harga;
    
    
    
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO barang (id,nama,harga)VALUES(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        pst.setString(2, nama);
        pst.setFloat(3, harga);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE barang SET nama=?, harga=? WHERE id=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setFloat(2, harga);
        pst.setString(3, id);
        pst.execute();
        pst.close();
    }
    
    public void hapus()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "DELETE FROM barang WHERE id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public ResultSet UpdateTable()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "SELECT * FROM barang";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
//    public ResultSet cari()throws SQLException{
//        conn = Koneksi.getKoneksi();
//        sql = "select * from barang order by id asc";
//        pst = conn.prepareStatement(sql);
//        rs = pst.executeQuery();
//        return rs;
//    }
}
