/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import hash.GenerateID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
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
     *
     * @return last id
     */
    //SELECT TOP 1 ProductID FROM [Product] ORDER BY CAST(RIGHT(ProductID, 4) AS INT) DESC;
    public String getLastIDOfProduct() {
        String lastID = null;
        String query = "SELECT TOP 1 ProductID FROM [Product] ORDER BY CAST(RIGHT(ProductID, 4) AS INT) DESC;";
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
        //If an exception, return null
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

    /**
     * This method retrieves the CategoryID of a product given its ProductID.
     *
     * @param ProductID the ProductID of the product whose CategoryID is to be
     * retrieved.
     * @return the CategoryID of the product or null if the ProductID is not
     * found in the database.
     *
     */
    public String getCategoryIDByProductID(String ProductID) {
        //Initialize category variable to null
        String category = null;
        //Prepare the SQL query to select the CategoryID of a product with the given ProductID
        String query = "SELECT CategoryID FROM [PRODUCT] WHERE ProductID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // Prepare the SQL statement with the query and set the ProductID parameter value
            ps.setString(1, ProductID);
            rs = ps.executeQuery();
            //Extract the CategoryID from the result set and assign it to the category variable
            while (rs.next()) {
                category = rs.getString(1); //The category of product
            } //End while
            //Return the CategoryID or null if the ProductID was not found in the database
            return category;
        } catch (Exception e) {
            e.getMessage();
        } //End try catch
        //Return null if an exception was caught or the ProductID was not found in the database
        return null;
    }

    /**
     * This method retrieves a list of top 4 products in the same category as a
     * given product, based on their total order quantities.
     *
     * @param categoryID the ID of the category to search for products in
     * @param productID the ID of the product to exclude from the search
     * @return an ArrayList of up to 4 Product objects representing the
     * top-selling products in the same category
     */
    public ArrayList<Product> getTop4ProductByCategoryID(String categoryID, String productID) {
        try {
            //SQL query to retrieve top 4 products based on total order quantities
            String query = "   SELECT TOP 4 *\n"
                    + "FROM (\n"
                    + "    SELECT P.ProductID,P.ProductName, P.ProductDescription, P.ProductImage, P.ProductPrice, P.ProductSalePercent, SUM(D.OrderDQuantity) AS TotalQuantity\n"
                    + "    FROM [PRODUCT] P \n"
                    + "    JOIN [ORDER_DETAIL] D ON D.ProductID = P.ProductID\n"
                    + "    JOIN [CATEGORY] C ON P.CategoryID = C.CategoryID\n"
                    + "    JOIN [ORDER] O ON O.OrderID = D.OrderID\n"
                    + "    WHERE C.CategoryID = ? AND P.ProductID <> ? AND (O.OrderStatus = 'ACCEPT' OR O.OrderStatus = 'PICKUP' OR O.OrderStatus = 'SUCCESSFUL')\n"
                    + "    GROUP BY P.ProductID,P.ProductName, P.ProductDescription, P.ProductImage, P.ProductPrice, P.ProductSalePercent\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "    SELECT P.ProductID,P.ProductName, P.ProductDescription, P.ProductImage, P.ProductPrice, P.ProductSalePercent, 0 AS TotalQuantity\n"
                    + "    FROM [PRODUCT] P\n"
                    + "    JOIN [CATEGORY] C ON P.CategoryID = C.CategoryID\n"
                    + "    WHERE C.CategoryID = ? AND P.ProductID <> ? AND P.ProductID NOT IN (SELECT P.ProductID\n"
                    + "    FROM [PRODUCT] P \n"
                    + "    JOIN [ORDER_DETAIL] D ON D.ProductID = P.ProductID\n"
                    + "    JOIN [CATEGORY] C ON P.CategoryID = C.CategoryID\n"
                    + "    JOIN [ORDER] O ON O.OrderID = D.OrderID\n"
                    + "    WHERE C.CategoryID = ? AND P.ProductID <> ? AND (O.OrderStatus = 'ACCEPT' OR O.OrderStatus = 'PICKUP' OR O.OrderStatus = 'SUCCESSFUL')\n"
                    + "    GROUP BY P.ProductID) \n"
                    + "    GROUP BY P.ProductID,P.ProductName, P.ProductDescription, P.ProductImage, P.ProductPrice, P.ProductSalePercent\n"
                    + "    HAVING COUNT(*) < 4\n"
                    + ") AS combined\n"
                    + "ORDER BY TotalQuantity DESC";
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query from Netbeen to SQl
            //Set the values of the parameters in the query
            ps.setString(1, categoryID);
            ps.setString(2, productID);
            ps.setString(3, categoryID);
            ps.setString(4, productID);
            ps.setString(5, categoryID);
            ps.setString(6, productID);
            rs = ps.executeQuery(); //Execute the query and retrieve the result set
            //Create an ArrayList to hold the retrieved products
            ArrayList<Product> list = new ArrayList<>();
            //Iterate through the result set and add each product to the ArrayList
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getInt(6), rs.getInt(5), ProductStatus.AVAILABLE));
            } //End while
            // Return the list object
            return list;
        } catch (Exception e) {
            e.getMessage();
        } //End try-catch
        //If an exception is caught or no product is found, return null
        return null;
    }

    /**
     * Search product information by name
     * @param search product name to search
     * @return Return the product and show the message
     */
    public List<Product> findProductByName(String search) {
        List<Product> list = new ArrayList<>(); //list products
        try {
            String query = "SELECT * FROM PRODUCT WHERE ProductStatus <> 'REMOVED' AND ProductName like ?"; //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery(); // the same with click to "excute" btn;

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
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    
        
/**
       * Method to add new products
       *
       * @param productName The name of the new product
       * @param productPrice The price of the new product
       * @param productSale The sale percent of new products
       * @param categoryID The category ID of the new product
       * @param productDescription The description of the new product
       * @param productImage The link image of the new product
       */
    public void insertProduct( String productName, int productPrice,
        int productSale, String categoryID, String productDescription, String productImage) {
        ProductDAO pdao = new ProductDAO();
        GenerateID gi = new GenerateID();
        String prefix = gi.getPrefixFromProductName(productName);
        String productID = gi.generateNewID(prefix, pdao.getLastIDOfProduct());
        //query used to add products
        String query = "INSERT INTO PRODUCT VALUES (?,?,?,?,?,'AVAILABLE',?,?)";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);  // move query from Netbeen to SQl
            ps.setString(1, productID);
            ps.setString(2, productName);
            ps.setString(3, productDescription);
            ps.setInt(4, productPrice);
            ps.setInt(5, productSale);  
            ps.setString(6, productImage);
            ps.setString(7, categoryID);
            ps.executeUpdate();                 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    /**
     * Search by product name in database
     * @param search String search
     * @param category string Category 
     * @return Product name to search
     */
    public List<Product> findProductByName(String search,String category) {
        List<Product> list = new ArrayList<>(); //list products
        try {
            String query = "SELECT * FROM PRODUCT WHERE ProductStatus <> 'REMOVED' AND ProductName like ?"; //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            
            if(category != null && !category.isEmpty()){
                query += " AND CategoryID = '"+category+"'";
            }
            
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery(); // the same with click to "excute" btn;

            while (rs.next()) {
                // add new product
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
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

}

