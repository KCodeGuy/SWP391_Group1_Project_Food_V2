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
import java.util.ArrayList;
import model.Cart;
import model.Product;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class OrderDetailDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    public void createOrderDetails(ArrayList<Cart> cart, int orderID) {
        String query = "INSERT INTO [ORDER_DETAIL] VALUES (?,?,?,?)"; // string query insert cart
        try {
            con = new DBContext().getConnection(); // open connect database
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            for (Cart c : cart) {
                ps.setInt(1, c.getCartQuantity());
                ps.setDouble(2, c.getProductPrice());
                ps.setInt(3, c.getProductID());
                ps.setInt(4, orderID);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
    }
    
    
}
