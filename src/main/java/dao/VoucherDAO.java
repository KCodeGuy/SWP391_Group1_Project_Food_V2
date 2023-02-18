/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class VoucherDAO {
    Connection con; //connect to SQL server
    PreparedStatement ps; //Move query from Netbeen to SQl
    ResultSet rs; //Save result query
    
    public int getProductSalePrecent(String voucherID) {
        try {
            //Declare a SQL query string
            String query = "SELECT ProductSalePercent FROM VOUCHER WHERE VoucherID = ?"; // Specify the condition for selecting a specific account ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setString(1, voucherID); //Set voucherID
            //Execute the query and get the result set
            rs = ps.executeQuery();
            //Initialize a new user object
            int productSalePercent = 0;
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                productSalePercent = rs.getInt(1);
            } //End while
            //Return the user object
            return productSalePercent;
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return 0;
    }
}
