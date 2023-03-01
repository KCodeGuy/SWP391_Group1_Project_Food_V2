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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Cart;
import model.Order;
import model.OrderStatus;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class OrderDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    /**
     * This function to create order
     *
     * @param orderNote Note of order
     * @param accountID Account ID of user
     * @param accountName Name of user
     * @param accountPhone Phone of user
     * @param accountAddress Address of user
     * @param voucherID ID of voucher
     * @param productSalePercent Product sale percent
     * @return true if create successful, false if can not create
     */
    public boolean createOrder(String orderNote, String accountID, String accountName, String accountPhone, String accountAddress, String voucherID, int productSalePercent) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = now.format(formatter);
        String query = "INSERT INTO [ORDER] VALUES (?,?,'PROCESSING',?,?,?,?,?,?,?,null,null)"; // string query insert cart
        String id = new GenerateID().generateNewID("OR", getLastIDOfOrder());
        try {
            con = new DBContext().getConnection(); // open connect database
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id);
            ps.setString(2, orderNote);
            ps.setString(3, formattedDateTime);
            ps.setString(4, accountID);
            ps.setString(5, accountName);
            ps.setString(6, accountPhone);
            ps.setString(7, accountAddress);
            ps.setString(8, voucherID);
            ps.setInt(9, productSalePercent);
            if (ps.executeUpdate() == 1) {
                // if insert successfull to return true
                return true;
            } // end if ps.executeUpdate() == 1
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return false; // if can not insert
    }

    /**
     * Get last id in table order
     *
     * @return last id
     */
    public String getLastIDOfOrder() {
        String lastID = null;
        String query = "SELECT TOP 1 OrderID FROM [ORDER] ORDER BY CAST(RIGHT(OrderID, 4) AS INT) DESC;";
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
     * This function get list product have status is pending
     *
     * @return list order
     */
    public ArrayList<Order> getListOrderForChef() {
        try {
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].OrderStatus = 'PROCESSING'\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), rs.getString(3), rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     *
     * This method retrieves a list of orders that are ready to be shipped from
     * the database.
     *
     * It executes a SELECT query that retrieves order information from the
     * ORDER and ORDER_DETAIL tables,
     *
     * and returns an ArrayList of Order objects containing the retrieved data.
     *
     * @return An ArrayList of Order objects that are ready to be shipped, or
     * null if there are no orders.
     */
    public ArrayList<Order> getListOrderForShip() {
        try {
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].OrderStatus = 'ACCEPTED'\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), rs.getString(3), rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try catch
        return null; // return null if not order
    }

    /**
     *
     * This method retrieves a list of orders that are ready to be shipped from
     * the database.
     *
     * It executes a SELECT query that retrieves order information from the
     * ORDER and ORDER_DETAIL tables,
     *
     * and returns an ArrayList of Order objects containing the retrieved data.
     *
     * @param accountID ID of order
     * @return An ArrayList of Order objects that are ready to be shipped, or
     * null if there are no orders.
     */
    public ArrayList<Order> getListOrderHistoryForUser(String accountID) {
        try { //Database query statement
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName,\n"
                    + "   [ORDER].OrderDate,\n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].AccountID = ?\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName,\n"
                    + "   [ORDER].OrderDate,\n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountID);
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrderHistory = new ArrayList<>(); // create list product in order
            while (rs.next()) { //Value access loop from the database
                listOrderHistory.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), rs.getString(3), rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrderHistory; // return list order
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function get list product have status is accept reject and
     * successful
     *
     * @return list order
     */
    public ArrayList<Order> getListOrderForAdmin() {
        try {
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                listOrder.add(new Order(rs.getString(1),
                        OrderStatus.valueOf(rs.getString(4)),
                        rs.getString(3),
                        rs.getString(2),
                        rs.getInt(5),
                        rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function get order by order ID
     *
     * @param orderID ID of order
     * @return order of user
     */
    public Order getOrderByOrderID(String orderID) {
        try {
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].AccountID,\n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].BuyerPhone,\n"
                    + "   [ORDER].BuyerAddress,\n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderNote,\n"
                    + "   [ORDER].VoucherID,\n"
                    + "   [ORDER].ProductSalePercent,\n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].OrderStatus = 'PROCESSING' AND [ORDER].OrderID = ?\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].AccountID,\n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].BuyerPhone,\n"
                    + "   [ORDER].BuyerAddress,\n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderNote,\n"
                    + "   [ORDER].VoucherID,\n"
                    + "   [ORDER].ProductSalePercent"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, orderID);
            rs = ps.executeQuery(); // execute query
            Order order = null;
            while (rs.next()) {
                order = new Order(rs.getString(1), rs.getString(7), rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
            } // end while
            return order; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This method retrieves an Order object for a given orderID
     *
     * @param orderID the ID of the order
     * @return the Order object associated with the given orderID, or null if an
     * error occurs
     */
    public Order getOrderByOrderIDForShipper(String orderID) {
        try {
            //SQL query to select data from the database
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].AccountID,\n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].BuyerPhone,\n"
                    + "   [ORDER].BuyerAddress,\n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderNote,\n"
                    + "   [ORDER].VoucherID,\n"
                    + "   [ORDER].ProductSalePercent,\n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].OrderStatus = 'ACCEPTED' AND [ORDER].OrderID = ?\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].AccountID,\n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].BuyerPhone,\n"
                    + "   [ORDER].BuyerAddress,\n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderNote,\n"
                    + "   [ORDER].VoucherID,\n"
                    + "   [ORDER].ProductSalePercent";
            con = new DBContext().getConnection(); //Establish a database connection
            //Set order ID parameter into the query
            ps = con.prepareStatement(query);
            ps.setString(1, orderID);
            //Execute the query
            rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {
                //Create an Order object with the retrieved data
                order = new Order(rs.getString(1), rs.getString(7), rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
            }
            return order; //Return the Order object
        } catch (Exception e) {
            e.getMessage();
        }
        return null; //Return null if there is no order found
    }

    /**
     * This function to accept order
     *
     * @param orderID ID of order
     * @param accountID Account ID of chef
     * @return true if accept successful, false if can not accept
     */
    public boolean acceptOrderByOrderID(String accountID, String orderID) {
        try {
            String query = "UPDATE [ORDER]\n"
                    + "SET OrderStatus = 'ACCEPTED', AccIDOfChef = ?\n"
                    + "WHERE OrderID = ?"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountID);
            ps.setString(2, orderID);
            if (ps.executeUpdate() == 1) {
                // if accept successfull to return true
                return true;
            } // end if ps.executeUpdate() == 1
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return false; // return null if not order
    }

    /**
     * This function to reject order
     *
     * @param orderID ID of order
     * @param accountID Account ID of chef
     * @return true if reject successful, false if can not reject
     */
    public boolean rejectOrderByOrderID(String accountID, String orderID) {
        try {
            String query = "UPDATE [ORDER]\n"
                    + "SET OrderStatus = 'REJECTED', AccIDOfChef = ?\n"
                    + "WHERE OrderID = ?"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountID);
            ps.setString(2, orderID);
            if (ps.executeUpdate() == 1) {
                // if reject successfull to return true
                return true;
            } // end if ps.executeUpdate() == 1
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return false; // return null if not order
    }

    /**
     *
     * Deliver the order by the order ID and update its status to "DELIVERING"
     * and assign the account ID of the shipper to the order.
     *
     * @param accountID the ID of the shipper who is delivering the order.
     * @param orderID the ID of the order being delivered.
     * @return true if the delivery process is successful, otherwise false.
     */
    public boolean deliveringOrderByOrderID(String accountID, String orderID) {
        try {
            String query = " UPDATE [ORDER] SET OrderStatus = 'DELIVERING', AccIDOfShipper = ? "
                    + "WHERE OrderID = ?"; //SQL query to update the order status
            con = new DBContext().getConnection(); //Open database connection
            ps = con.prepareStatement(query); //Set the account ID and order ID in the query
            ps.setString(1, accountID);
            ps.setString(2, orderID);
            if (ps.executeUpdate() == 1) {
                //If the query is successful, return true
                return true;
            } //End if ps.executeUpdate() == 1
        } catch (Exception e) {
            e.getMessage();
        } //End try catch
        return false; //Return false if the delivery fails
    }

    /**
     *
     * Update the order status to "DELIVERED" and assign the account ID of the
     * chef who delivers the order.
     *
     * @param accountID the account ID of the chef who delivers the order.
     * @param orderID the ID of the order to be updated.
     * @return true if the update is successful, false otherwise.
     */
    public boolean deliveredOrderByOrderID(String accountID, String orderID) {
        try {
            String query = "UPDATE [ORDER]\n"
                    + "SET OrderStatus = 'DELIVERED', AccIDOfShipper = ?\n"
                    + "WHERE OrderID = ?"; // SQL query to update the order status
            con = new DBContext().getConnection(); //Get a connection to the database
            ps = con.prepareStatement(query); //Create a prepared statement for the query
            ps.setString(1, accountID); //Set the chef account ID parameter
            ps.setString(2, orderID); //Set the order ID parameter
            if (ps.executeUpdate() == 1) {
                //If the update is successful, return true
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        //If the update fails, return false
        return false;
    }

    /**
     *
     * Retrieves the list of order history for a given shipper account ID from
     * the database.
     *
     * @param accountOfIDShipper the account ID of the shipper
     * @return an ArrayList of Order objects representing the order history for
     * the given shipper
     */
    public ArrayList<Order> getListOrderHistoryForShipper(String accountOfIDShipper) {
        try { //Database query statement
            String query = " SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName,\n"
                    + "   [ORDER].OrderDate,\n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].AccIDOfShipper = ?\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName,\n"
                    + "   [ORDER].OrderDate,\n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountOfIDShipper);
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrderHistory = new ArrayList<>(); // create list product in order
            while (rs.next()) { //Value access loop from the database
                listOrderHistory.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), rs.getString(3), rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrderHistory; // return list order
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function to check shipper has order delivering
     *
     * @param accountID Account ID of chef
     * @return true if accept successful, false if can not accept
     */
    public String getDelivering(String accountID) {
        try {
            String query = "SELECT OrderID FROM [ORDER] WHERE AccIDOfShipper = ? AND OrderStatus = 'DELIVERING'"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountID);
            rs = ps.executeQuery();
            String orderID = null;
            while (rs.next()) {
                orderID = rs.getString(1);
            }
            return orderID;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try catch
        return null; // return null if not order
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new OrderDAO().getDelivering("SP0008"));
    }

}
