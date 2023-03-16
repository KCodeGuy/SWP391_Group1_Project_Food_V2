package dao;

import context.DBContext;
import hash.GenerateID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cart;
import model.OrderDetail;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class OrderDetailDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    /**
     * This function to create list order details
     *
     * @param cart list product to order
     * @param orderID ID of order
     */
    public void createOrderDetails(ArrayList<Cart> cart, String orderID) {
        String query = "INSERT INTO [ORDER_DETAIL] VALUES (?,?,?,?,?)"; // string query insert cart
        GenerateID g = new GenerateID();
        String lastID;
        String id;
        for (Cart c : cart) {
            lastID = getLastIDOfOrderDetail();
            id = g.generateNewID("OD", lastID);
            try {
                con = new DBContext().getConnection(); // open connect database
                ps = con.prepareStatement(query); // move query from Netbeen to SQl
                ps.setString(1, id);
                ps.setInt(2, c.getCartQuantity());
                ps.setDouble(3, c.getProductPrice());
                ps.setString(4, c.getProductID());
                ps.setString(5, orderID);
                ps.executeUpdate();

            } catch (Exception e) {
                e.getMessage();
            } // end try catch
        }
    }

    /**
     * Get last id in table account
     *
     * @return last id
     */
    public String getLastIDOfOrderDetail() {
        String lastID = null;
        String query = "SELECT TOP 1 OrderDID FROM [ORDER_DETAIL] ORDER BY CAST(RIGHT(OrderDID, 4) AS INT) DESC;";
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
     * /**
     * This function get list product in cart
     *
     * Function get accountID from parameter then use query into database to get
     * all product in table cart by accountID.
     *
     * @param orderID ID of order
     * @return list product in cart of user
     */
    public ArrayList<OrderDetail> getListOrderDetailByOrderID(String orderID) {
        try {
            String query = "SELECT D.OrderDQuantity, D.OrderDPrice, P.ProductName, P.ProductImage FROM ORDER_DETAIL D JOIN PRODUCT P ON D.ProductID = P.ProductID WHERE D.OrderID = ?"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, orderID); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<OrderDetail> listOrder = new ArrayList<>(); // create list 
            while (rs.next()) {
                listOrder.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
                // add new item into list 
            } // end while
            return listOrder; // return list 
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null
    }

    /**
     *
     * Get list of order details by order ID for a shipper.
     *
     * @param orderID ID of the order to get details for
     * @return list of OrderDetail objects for the specified order ID
     */
    public ArrayList<OrderDetail> getListOrderDetailByOrderIDForShipper(String orderID) {
        try {
            //Query select form database
            String query = "SELECT D.OrderDQuantity, D.OrderDPrice, P.ProductName, P.ProductImage FROM ORDER_DETAIL D JOIN PRODUCT P ON D.ProductID = P.ProductID WHERE D.OrderID = ?"; 
            con = new DBContext().getConnection(); //Open conect database
            ps = con.prepareStatement(query); //Set account ID into query
            ps.setString(1, orderID); //Set account ID into query
            rs = ps.executeQuery(); //Execute query
            ArrayList<OrderDetail> listOrder = new ArrayList<>(); //Create list 
            while (rs.next()) {
                listOrder.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
                //Add new item into list 
            } //End while
            return listOrder; //Return list 
        } catch (Exception e) {
            e.getMessage();
        } //End try catch
        return null; //Return null
    }

}
