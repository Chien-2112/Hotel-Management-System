/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionProvider {
    public static Connection getCon() {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver MySQL.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "21122004");
            return con;
        } 
        catch(ClassNotFoundException | SQLException e) 
        {
            System.out.println("Connect failed: " + e.getMessage());
            return null;
        }
    }
}
