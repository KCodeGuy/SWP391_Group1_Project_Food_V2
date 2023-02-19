/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class OrderDAO {
    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query
    
    public boolean createOrder(String orderNote, int accountID,  String accountName, int accountPhone, String accountAddress, String voucherID, int productSalePercent) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = now.format(formatter);
        String query = "INSERT INTO [ORDER] VALUES (?,'PENDING',?,?,?,?,?,?,?,null,null)"; // string query insert cart
        try {
            con = new DBContext().getConnection(); // open connect database
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, orderNote);
            ps.setString(2, formattedDateTime);
            ps.setInt(3, accountID);
            ps.setString(4, accountName);
            ps.setString(5, "0" + accountPhone);
            ps.setString(6, accountAddress);
            ps.setString(7, voucherID);
            ps.setInt(8, productSalePercent);
            if (ps.executeUpdate() == 1) {
                // if insert successfull to return true
                return true;
            } // end if ps.executeUpdate() == 1
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return false; // if can not insert
    }
    
    public int getNewOrderID() {
        String query = "SELECT TOP 1 OrderID FROM [ORDER] ORDER BY OrderID DESC";
        // string query select quantity of a product in cart
        try {
            con = new DBContext().getConnection(); // open connect database
            ps = con.prepareStatement(query); // move query to database
            rs = ps.executeQuery(); // execute query
            int quantity = 0; // create quantity
            while (rs.next()) {
                quantity = rs.getInt(1);
            } // end while
            return quantity; // return quantity of a product in cart
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return 0 if can not select quantity of a product in cart
    }

}
