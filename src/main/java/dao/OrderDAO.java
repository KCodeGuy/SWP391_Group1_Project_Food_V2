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
    public boolean createOrder(String orderNote, int accountID, String accountName, int accountPhone, String accountAddress, String voucherID, int productSalePercent) {
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

    /**
     * This function get new ID of voucher
     *
     * @return ID of voucher
     */
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

    /**
     * This function get list product have status is pending
     *
     * @return list order
     */
    public ArrayList<Order> getListOrder() {
        try {
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].UserFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].OrderStatus = 'PENDING'\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].UserFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                listOrder.add(new Order(rs.getInt(1), OrderStatus.valueOf(rs.getString(4)), rs.getString(3), rs.getString(2), rs.getInt(5), rs.getInt(6)));
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
    public Order getOrderByOrderID(int orderID) {
        try {
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].AccountID,\n"
                    + "   [ORDER].UserFullName, \n"
                    + "   [ORDER].UserPhone,\n"
                    + "   [ORDER].UserAddress,\n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderNote,\n"
                    + "   [ORDER].VoucherID,\n"
                    + "   [ORDER].ProductSalePercent,\n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].OrderStatus = 'PENDING' AND [ORDER].OrderID = ?\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].AccountID,\n"
                    + "   [ORDER].UserFullName, \n"
                    + "   [ORDER].UserPhone,\n"
                    + "   [ORDER].UserAddress,\n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderNote,\n"
                    + "   [ORDER].VoucherID,\n"
                    + "   [ORDER].ProductSalePercent"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setInt(1, orderID);
            rs = ps.executeQuery(); // execute query
            Order order = null;
            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getString(7), rs.getString(6), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
            } // end while
            return order; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function to accept order
     * @param orderID ID of order
     * @return true if accept successful, false if can not accept
     */
    public boolean acceptOrderByOrderID(int orderID) {
        try {
            String query = "UPDATE [ORDER]\n"
                    + "SET OrderStatus = 'ACCEPT'\n"
                    + "WHERE OrderID = ?"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setInt(1, orderID);
            rs = ps.executeQuery(); // execute query
            if (ps.executeUpdate() == 1) {
                // if insert successfull to return true
                return true;
            } // end if ps.executeUpdate() == 1
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return false; // return null if not order
    }

}
