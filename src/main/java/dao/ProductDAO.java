/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.ProductStatus;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class ProductDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    /**
     * Function get list product
     *
     * This function use to take all products in a condition other than REMOVED
     * to upload to the home page
     *
     * @return List<Product> list of product
     */
    public List<Product> getListProduct() {
        try {
            String query = "SELECT * FROM PRODUCT WHERE ProductStatus <> 'REMOVED'"; //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>(); //list products
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        ProductStatus.valueOf(rs.getString(6)),
                        rs.getString(7),
                        rs.getString(8))
                ); // add new item in list
            } // end while rs.next
            return list;// return list product
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Function get list product
     *
     * @return List<Product> list of product
     */
    public List<Product> getListProductManagePage() {
        try {
            String query = "SELECT ProductID, ProductImage, ProductName, ProductDescription,ProductSalePercent,ProductPrice,ProductStatus FROM PRODUCT";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>(); //list products
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        ProductStatus.valueOf(rs.getString(7))
                )); // add new item in list
            } // end while rs.next
            return list;// return list product
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }   
    
    /**
     * Get last id in table Product
     * @return last id
     */
    public String getLastIDOfProduct() {
        String lastID = null;
        String query = "SELECT TOP 1 AccountID FROM [Product] ORDER BY CAST(RIGHT(ProductID, 4) AS INT) DESC;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // excute query and return result to rs.
            while (rs.next()) {
                // return an account
                lastID = rs.getString(1);
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return lastID;
    }
    /**
     *
     * Get product by productID from the database
     *
     * @param productID the ID of the product to retrieve
     *
     * @return a Product object representing the retrieved product, or null if
     * the product does not exist or there was an error retrieving it
     */
    public Product getProductByProductID(String productID) {

        try {
            //Declare a SQL query string
            String query = "SELECT ProductName, ProductDescription, ProductPrice, ProductSalePercent, ProductStatus, ProductImage "
                    + "FROM [PRODUCT] WHERE ProductID = ?"; // Specify the condition for selecting a specific product ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setString(1, productID); //Set productID
            //Execute the query and get the result set
            rs = ps.executeQuery();
            // Initialize a new product object
            Product product = null;
            // Loop through the result set and create a new product object with the retrieved data
            while (rs.next()) {
                // Create a new Product object using data retrieved from the database
                product = new Product(
                        rs.getString(1), // The product's name
                        rs.getString(2), // The product's description
                        rs.getInt(3), // The product's price
                        rs.getInt(4), // The product's sale percent
                        ProductStatus.valueOf(rs.getString(5)), // The product's status
                        rs.getString(6) // The product's image link
                );
            } // End while
            // Return the product object
            return product;
        } catch (Exception e) {
            e.getMessage();
        } // End try-catch
        // If an exception is caught or no product is found, return null
        return null;
    }
    
    /**
     * Create method delete product by productID 
     * @param productID
     */
    public void deleteProduct(String productID) {
        //Create query update status of the product
        String query ="UPDATE PRODUCT SET ProductStatus = 'REMOVED' WHERE ProductID = ?";   
        try {
            // Open connection to database
            con = new DBContext().getConnection();
            //Move query from Netbean to SQL
            ps = con.prepareStatement(query);
            //Set the value of the productID parameter in the SQL statement
            ps.setString(1, productID);
            // Excuse query
            ps.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }// End method

}
