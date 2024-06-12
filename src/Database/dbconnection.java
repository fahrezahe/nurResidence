/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author fahre
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dbconnection {
    public static Connection koneksi(){
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection koneksidb = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kontrakan", "root", "");
           return koneksidb;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
