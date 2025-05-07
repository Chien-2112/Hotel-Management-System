/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public class tables {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try 
        {
            con = ConnectionProvider.getCon(); // Lấy kết nối.
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Connect database failed");
                return; // Thoát nếu không connect được.
            }
            st = con.createStatement();
            //st.executeUpdate("DROP TABLE IF EXISTS customer");
//            st.executeUpdate("DROP TABLE IF EXISTS services");
            //st.executeUpdate("DROP TABLE IF EXISTS customer_services");
            
            //st.executeUpdate("create table users(name varchar(200), email varchar(200), password varchar(50), securityQuestion varchar(500), answer varchar(200), address varchar(200), status varchar(20))");
            //st.executeUpdate("create table room(roomNo varchar(10), roomType varchar(200), bed varchar(200), price int, status varchar(20))");
            //st.executeUpdate("create table customer(id int primary key, name varchar(200), mobileNumber varchar(20), nationality varchar(200), gender varchar(50), email varchar(200), idProof varchar(200), address varchar(500), checkIn varchar(50), roomNo varchar(10), bed varchar(200), roomType varchar(200), pricePerDay int(10), numberOfDaysStay int(10), totalAmount varchar(200), checkout varchar(50))");
//            st.executeUpdate("create table services(serviceId int AUTO_INCREMENT primary key, serviceName varchar(200), price int, description varchar(500))");
            st.executeUpdate("create table customer_services(id int AUTO_INCREMENT primary key, customerId int, serviceId int, usageDate varchar(50), foreign key (customerId) references customer(id), foreign key (serviceId) references services(serviceId))");
            JOptionPane.showMessageDialog(null, "Table Created Successfully");
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally
        {
            try 
            {
                if (st != null) {
                    st.close(); // Đóng Statement nếu không null.
                }
                if (con != null) {
                    con.close(); // Đóng connection nếu không null.
                }
            } 
            catch(SQLException e) 
            {
                JOptionPane.showMessageDialog(null, "Error when close connection: " + e.getMessage());
            }
        }
    }
}
