
package com.koneksi;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Dim
 */
public class Koneksi {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getKoneksi(){
        if (koneksi == null) {
            try{
                //jdbc:mysql://localhost:3306/NAMA DATABASE
                String url = "jdbc:mysql://localhost:3306/dbbarokah";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,password);
                System.out.println("Connection Successfully");
            }catch (Exception e){
                System.out.println("Error in : " + e);
                JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
            }
        }
        return koneksi;
    }
    
    public static void main(String[] args){
        getKoneksi();
    }

    public static Object createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
