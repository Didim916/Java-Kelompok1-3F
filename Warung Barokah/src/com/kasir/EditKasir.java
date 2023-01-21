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
public class EditKasir {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    
    public String id;
    public String nama;
    public String username;
    public String password;
    public String nohp;
    
    
    
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO kasir (id,nama,username,password,nohp)VALUES(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        pst.setString(2, nama);
        pst.setString(3, username);
        pst.setString(4, password);
        pst.setString(5, nohp);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE kasir SET nama=?, username=?, password=?, nohp=? WHERE id=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, username);
        pst.setString(3, password);
        pst.setString(4, nohp);
        pst.setString(5, id);
        pst.execute();
        pst.close();
    }
    
    public void hapus()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "DELETE FROM kasir WHERE id=?";
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
        sql = "SELECT * FROM kasir";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}
