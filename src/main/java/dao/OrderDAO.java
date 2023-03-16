package dao;

import context.DBContext;
import hash.GenerateID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Order;
import model.OrderStatus;
import model.Product;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class OrderDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    /**
     * Creates a new order in the database with the specified order details.
     *
     * @param orderNote a string containing the order note
     * @param accountID a string containing the ID of the account associated
     * with the order
     * @param accountName a string containing the name of the account associated
     * with the order
     * @param accountPhone a string containing the phone number of the account
     * associated with the order
     * @param accountAddress a string containing the address of the account
     * associated with the order
     * @param voucherID a string containing the ID of the voucher used for the
     * order, if any
     * @param productSalePercent an integer value indicating the percentage of
     * discount applied to the products in the order
     * @return a Boolean value indicating whether the order was successfully
     * created in the database
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
     * This function get top 5 best product from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return list of top 5 product is buy at most - List
     */
    public ArrayList<Product> getTop5BestSellerProducts(String startDate, String endDate) {
        try {
            // query to insert to database get top 5 best products.
            String query = "SELECT TOP 5\n"
                    + "    P.ProductID,\n"
                    + "    P.ProductName,\n"
                    + "	P.ProductImage,\n"
                    + "	P.CategoryID,\n"
                    + "	P.ProductPrice,\n"
                    + "    SUM(OD.OrderDQuantity) AS TotalQuantitySold\n"
                    + "FROM\n"
                    + "    [PRODUCT] AS P\n"
                    + "    INNER JOIN [ORDER_DETAIL] AS OD\n"
                    + "        ON P.ProductID = OD.ProductID\n"
                    + "    INNER JOIN [ORDER] AS O\n"
                    + "        ON OD.OrderID = O.OrderID\n"
                    + "WHERE\n"
                    + "    O.OrderStatus = 'DELIVERED'\n"
                    + "	AND O.OrderDate BETWEEN ? and ?\n"
                    + "GROUP BY\n"
                    + "    P.ProductID,\n"
                    + "    P.ProductName,\n"
                    + "	P.ProductImage,\n"
                    + "	P.CategoryID,\n"
                    + "	P.ProductPrice\n"
                    + "ORDER BY\n"
                    + "    TotalQuantitySold DESC;"; // query select form database
            con = new DBContext().getConnection();  // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            ArrayList<Product> listProduct = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                listProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6))));
                // add new item into list order
            } // end while
            return listProduct; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function get top 5 best customer. It means they spending at most
     * money from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return list of top 5 customer is buy at most
     */
    public ArrayList<Account> getTop5BesTCustomers(String startDate, String endDate) {
        try {
            // query to insert to database get top 5 best customers. 
            String query = "SELECT TOP 5\n"
                    + "    A.AccountID,\n"
                    + "    A.AccountName,\n"
                    + "    SUM(OD.OrderDPrice * OD.OrderDQuantity) AS TotalSpending\n"
                    + "FROM \n"
                    + "    [ACCOUNT] A\n"
                    + "    INNER JOIN [ORDER] O ON A.AccountID = O.AccountID\n"
                    + "    INNER JOIN [ORDER_DETAIL] OD ON O.OrderID = OD.OrderID\n"
                    + "WHERE\n"
                    + "    O.OrderStatus = 'DELIVERED'\n"
                    + "	AND O.OrderDate BETWEEN ? and ?\n"
                    + "GROUP BY \n"
                    + "    A.AccountID, \n"
                    + "    A.AccountName\n"
                    + "ORDER BY \n"
                    + "    TotalSpending DESC;"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            ArrayList<Account> list5BestCutomers = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                list5BestCutomers.add(new Account(rs.getString(1), rs.getString(2), String.valueOf(rs.getInt(3))));
                // add new item into list order
            } // end while
            return list5BestCutomers; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function to get total of quantity food is sell. It means they
     * spending at most money from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return quantity of food is sell
     */
    public int getTotalQuantityFoodSelled(String startDate, String endDate) {
        try {
            String query = "SELECT c.CategoryDescription, SUM(od.OrderDQuantity) AS Quantity\n"
                    + "FROM CATEGORY c\n"
                    + "JOIN PRODUCT p ON c.CategoryID = p.CategoryID\n"
                    + "JOIN ORDER_DETAIL od ON p.ProductID = od.ProductID\n"
                    + "JOIN [ORDER] o ON od.OrderID = o.OrderID\n"
                    + "WHERE (O.OrderDate BETWEEN ? AND ?) AND\n"
                    + "(O.OrderStatus = 'DELIVERED') AND \n"
                    + "(c.CategoryDescription = 'Food') \n"
                    + "GROUP BY c.CategoryDescription"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getInt(2);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of quantity drink is sell. It means they
     * spending at most money from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return quantity of drink is sell
     */
    public int getTotalQuantityDrinkSelled(String startDate, String endDate) {
        try {
            String query = "SELECT c.CategoryDescription, SUM(od.OrderDQuantity) AS Quantity\n"
                    + "FROM CATEGORY c\n"
                    + "JOIN PRODUCT p ON c.CategoryID = p.CategoryID\n"
                    + "JOIN ORDER_DETAIL od ON p.ProductID = od.ProductID\n"
                    + "JOIN [ORDER] o ON od.OrderID = o.OrderID\n"
                    + "WHERE (O.OrderDate BETWEEN ? AND ?) AND\n"
                    + "(O.OrderStatus = 'DELIVERED') AND \n"
                    + "(c.CategoryDescription = 'Drink') \n"
                    + "GROUP BY c.CategoryDescription"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getInt(2);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of quantity combo is sell. It means they
     * spending at most money from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return quantity of combo is sell
     */
    public int getTotalQuantityComboSelled(String startDate, String endDate) {
        try {
            String query = "SELECT c.CategoryDescription, SUM(od.OrderDQuantity) AS Quantity\n"
                    + "FROM CATEGORY c\n"
                    + "JOIN PRODUCT p ON c.CategoryID = p.CategoryID\n"
                    + "JOIN ORDER_DETAIL od ON p.ProductID = od.ProductID\n"
                    + "JOIN [ORDER] o ON od.OrderID = o.OrderID\n"
                    + "WHERE (O.OrderDate BETWEEN ? AND ?) AND\n"
                    + "(O.OrderStatus = 'DELIVERED') AND \n"
                    + "(c.CategoryDescription = 'Combo') \n"
                    + "GROUP BY c.CategoryDescription"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getInt(2);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of quantity soup is sell. It means they
     * spending at most money from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return quantity of soup is sell
     */
    public int getTotalQuantitySoupSelled(String startDate, String endDate) {
        try {
            String query = "SELECT c.CategoryDescription, SUM(od.OrderDQuantity) AS Quantity\n"
                    + "FROM CATEGORY c\n"
                    + "JOIN PRODUCT p ON c.CategoryID = p.CategoryID\n"
                    + "JOIN ORDER_DETAIL od ON p.ProductID = od.ProductID\n"
                    + "JOIN [ORDER] o ON od.OrderID = o.OrderID\n"
                    + "WHERE (O.OrderDate BETWEEN ? AND ?) AND\n"
                    + "(O.OrderStatus = 'DELIVERED') AND \n"
                    + "(c.CategoryDescription = 'Soup') \n"
                    + "GROUP BY c.CategoryDescription"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getInt(2);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of revenue is sell. It means they spending at
     * most money from start date to end date
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return total of revenue is sell
     */
    public long getTotalRevenue(String startDate, String endDate) {
        try {
            // query select form database
            String query = "SELECT SUM(od.OrderDPrice * od.OrderDQuantity) \n"
                    + "FROM [ORDER] AS o, ORDER_DETAIL AS od \n"
                    + "WHERE o.OrderID = od.OrderID \n"
                    + "AND o.OrderStatus = 'DELIVERED'\n"
                    + "AND o.OrderDate BETWEEN ? AND ?;";
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getLong(1);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of order by status from start date to end date
     * with some of status as below: PROCESSING, ACCEPTED, DELIVERING, PENDING,
     * DELIVERED.
     *
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @param status
     * @return total of revenue is sell
     */
    public int getTotalOrderByStatus(String startDate, String endDate, String status) {
        try {
            // query select form database
            String query = "SELECT COUNT(*) FROM [ORDER] \n"
                    + "WHERE OrderDate BETWEEN ? AND ? AND \n"
                    + "OrderStatus = ?;";
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ps.setString(3, status);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getInt(1);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of product is sell from start date to end date.
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return total of product is sell 
     */
    public long getTotalOfProductSelled(String startDate, String endDate) {
        try {
            // query select form database
            String query = "SELECT COUNT(OrderDID) AS NumOfProducts\n"
                    + "FROM [ORDER_DETAIL] od\n"
                    + "INNER JOIN [ORDER] o ON od.OrderID = o.OrderID\n"
                    + "WHERE o.OrderDate BETWEEN ? AND ? AND\n"
                    + "o.OrderStatus = 'DELIVERED';";
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getLong(1);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * This function to get total of customer has been bought product from start date to end date.
     * @param startDate the start date in range is selected by admin.
     * @param endDate the end date in range is selected by admin.
     * @return total of customer has been bought product 
     */
    public int getTotalOfCustomerBought(String startDate, String endDate) {
        try {
            // query select form database
            String query = "SELECT COUNT(DISTINCT [ORDER].AccountID) AS NumCustomers\n"
                    + "FROM [ORDER]\n"
                    + "JOIN ACCOUNT ON [ORDER].AccountID = ACCOUNT.AccountID\n"
                    + "WHERE [ORDER].OrderDate BETWEEN ? AND ? AND\n"
                    + "OrderStatus = 'DELIVERED';";
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery(); // execute query
            while (rs.next()) {
                return rs.getInt(1);
            } // end while
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return 0; // return null if not order
    }

    /**
     * Get last id in table order to insert into order detail.
     *
     * @return last id of order.
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
     * @return list order for chef can confirm.
     */
    public ArrayList<Order> getListOrderForChef() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            String query = "SELECT [ORDER].OrderID\n"
                    + ", [ORDER].BuyerFullName\n"
                    + ", [ORDER].OrderDate\n"
                    + ", [ORDER].OrderStatus\n"
                    + ",SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + " SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER]\n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID\n"
                    + "WHERE [ORDER].OrderStatus = 'PROCESSING'\n"
                    + "GROUP BY [ORDER].OrderID, [ORDER].BuyerFullName,[ORDER].OrderDate,[ORDER].OrderStatus\n"
                    + "ORDER BY [ORDER].OrderDate ASC;"; // query select form database

            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function get list product have status is pending
     * 
     * @return list order is sorted be descending.
     */
    public ArrayList<Order> getListSortedOrderForChefByPriceDesc() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            String query = "SELECT [ORDER].OrderID\n"
                    + ", [ORDER].BuyerFullName\n"
                    + ", [ORDER].OrderDate\n"
                    + ", [ORDER].OrderStatus\n"
                    + ",SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + " SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER]\n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID\n"
                    + "WHERE [ORDER].OrderStatus = 'PROCESSING'\n"
                    + "GROUP BY [ORDER].OrderID, [ORDER].BuyerFullName,[ORDER].OrderDate,[ORDER].OrderStatus\n"
                    + "ORDER BY Price DESC;"; // query select form database

            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function get list product have status is pending
     * 
     * @return list order is sorted be ascending.
     */
    public ArrayList<Order> getListSortedOrderForChefByPriceAsc() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            String query = "SELECT [ORDER].OrderID\n"
                    + ", [ORDER].BuyerFullName\n"
                    + ", [ORDER].OrderDate\n"
                    + ", [ORDER].OrderStatus\n"
                    + ",SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + " SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER]\n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID\n"
                    + "WHERE [ORDER].OrderStatus = 'PROCESSING'\n"
                    + "GROUP BY [ORDER].OrderID, [ORDER].BuyerFullName,[ORDER].OrderDate,[ORDER].OrderStatus\n"
                    + "ORDER BY Price ASC;"; // query select form database

            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {

                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function to search orders that contains txtSearch that is user's full name.
     *
     * @param txtSearch txtSearch entered by user.
     * @param status status of order.
     * @return list order that contains txtSearch that is user's full name.
     */
    public ArrayList<Order> searchOrderByUserName(String txtSearch, String status) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            String query = "SELECT [ORDER].OrderID\n"
                    + ", [ORDER].BuyerFullName\n"
                    + ", [ORDER].OrderDate\n"
                    + ", [ORDER].OrderStatus\n"
                    + ",SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + " SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER]\n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID\n"
                    + "WHERE [ORDER].BuyerFullName LIKE ? \n"
                    + "AND [ORDER].OrderStatus = ? \n"
                    + "GROUP BY [ORDER].OrderID, [ORDER].BuyerFullName,[ORDER].OrderDate,[ORDER].OrderStatus\n"
                    + "ORDER BY [ORDER].OrderDate desc;"; // query select form database

            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, status);
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {

                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

   /**
     * This function to search orders that contains txtSearch that is user's full name.
     *
     * @param txtSearchOrderID txtSearch entered by user.
     * @param accountID account id of user that need to search.
     * @return list order that contains txtSearch that is user's full name.
     */
    public ArrayList<Order> searchOrderByID(String txtSearchOrderID, String accountID) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            String query = "SELECT [ORDER].OrderID\n"
                    + ", [ORDER].BuyerFullName\n"
                    + ", [ORDER].OrderDate\n"
                    + ", [ORDER].OrderStatus\n"
                    + ",SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + " SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER]\n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID\n"
                    + "WHERE [ORDER].AccountID = ? AND [ORDER].OrderID LIKE ?\n"
                    + "GROUP BY [ORDER].OrderID, [ORDER].BuyerFullName,[ORDER].OrderDate,[ORDER].OrderStatus\n"
                    + "ORDER BY [ORDER].OrderDate desc;"; // query select form database

            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountID);
            ps.setString(2, "%" + txtSearchOrderID + "%");
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrder; // return list order
        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return null; // return null if not order
    }

    /**
     * To get total of order's price
     * @param listOrder list of order to sum
     * @return total of order's price
     */
    public long sumOfOrderPrice(List<Order> listOrder) {
        long sumOfOrderPrice = 0;
        for (Order order : listOrder) {
            sumOfOrderPrice += order.getTotalPrice();
        }
        return sumOfOrderPrice;
    }

    /**
     *
     * Retrieves the list of order history for a given shipper account ID from
     * the database.
     *
     * @param accountOfIDChef the account ID of the chef
     * @return an ArrayList of Order objects representing the order history for
     * the given chef
     */
    public ArrayList<Order> getListOrderHistoryForChef(String accountOfIDChef) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try { //Database query statement
            String query = "SELECT [ORDER].OrderID\n"
                    + ", [ORDER].BuyerFullName\n"
                    + ", [ORDER].OrderDate\n"
                    + ", [ORDER].OrderStatus\n"
                    + ",SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + " SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER]\n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID\n"
                    + "WHERE [ORDER].AccIDOfChef = ? \n"
                    + "GROUP BY [ORDER].OrderID, [ORDER].BuyerFullName,[ORDER].OrderDate,[ORDER].OrderStatus\n"
                    + "ORDER BY [ORDER].OrderDate desc;"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountOfIDChef);
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrderHistory = new ArrayList<>(); // create list product in order
            while (rs.next()) { //Value access loop from the database
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrderHistory.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrderHistory; // return list order
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
     * @return An ArrayList of Order objects that are ready to be shipped, or
     * null if there are no orders.
     */
    public ArrayList<Order> getListOrderForShip() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
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
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try { //Database query statement
            String query = "SELECT \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName,\n"
                    + "   [ORDER].OrderDate,\n"
                    + "   [ORDER].OrderStatus, \n"
                    + "   SUM([ORDER_DETAIL].OrderDQuantity) AS Quantity, \n"
                    + "   SUM(([ORDER_DETAIL].OrderDPrice * (100 - [ORDER].ProductSalePercent) / 100) * [ORDER_DETAIL].OrderDQuantity) AS Price \n"
                    + "FROM [ORDER] \n"
                    + "INNER JOIN [ORDER_DETAIL] ON [ORDER].OrderID = [ORDER_DETAIL].OrderID \n"
                    + "WHERE [ORDER].AccountID = ?\n"
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName,\n"
                    + "   [ORDER].OrderDate,\n"
                    + "   [ORDER].OrderStatus\n"
                    + "ORDER BY [ORDER].OrderDate desc;"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, accountID);
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrderHistory = new ArrayList<>(); // create list product in order
            while (rs.next()) { //Value access loop from the database
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrderHistory.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
                // add new item into list order
            } // end while
            return listOrderHistory; // return list order
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try catch
        return null; // return null if not order
    }

    /**
     * This function return list of sorted order by ascending
     * @param orders list is unsorted orders.
     * @return  list of sorted orders.
     */
    public List<Order> sortOrdersByTotalPriceAscending(List<Order> orders) {
        // Sort orders by totalPrice attribute
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getTotalPrice() - o2.getTotalPrice();
            }
        });
        return orders;
    }

     /**
     * This function return list of sorted order by descending
     * @param orders list is unsorted orders.
     * @return  list of sorted orders.
     */
    public List<Order> sortOrdersByTotalPriceDescending(List<Order> orders) {
        // Sort orders by totalPrice attribute in descending order
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getTotalPrice() - o1.getTotalPrice();
            }
        });

        return orders;
    }

    /**
     * This function get list product have status is accept reject and
     * successful
     *
     * @return list order load to admin page.
     */
    public ArrayList<Order> getListOrderForAdmin() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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
                    + "   [ORDER].OrderStatus \n"
                    + "ORDER BY [ORDER].OrderDate desc;";// query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            rs = ps.executeQuery(); // execute query
            ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
            while (rs.next()) {
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1),
                        OrderStatus.valueOf(rs.getString(4)),
                        outputDateStr,
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
     * @param orderID ID of order passed to get a specified order.
     * @return order of user.
     */
    public Order getOrderByOrderID(String orderID) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
                    + "WHERE [ORDER].OrderID = ?\n"
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
                Date date = inputFormat.parse(rs.getString(6));
                String outputDateStr = outputFormat.format(date);
                order = new Order(rs.getString(1), rs.getString(7), outputDateStr, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
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
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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
                    + "WHERE [ORDER].OrderID = ?\n"
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
                Date date = inputFormat.parse(rs.getString(6));
                String outputDateStr = outputFormat.format(date);
                //Create an Order object with the retrieved data
                order = new Order(rs.getString(1), rs.getString(7), outputDateStr, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
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
     * the function list order for Admin
     *
     * @param search the list in order database SQL
     * @return list order
     */
    public ArrayList<Order> getListOrderForAdmin(String search) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ArrayList<Order> listOrder = new ArrayList<>(); // create list product in order
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
                    + " WHERE [ORDER].BuyerFullName like ?  "
                    + "GROUP BY \n"
                    + "   [ORDER].OrderID, \n"
                    + "   [ORDER].BuyerFullName, \n"
                    + "   [ORDER].OrderDate, \n"
                    + "   [ORDER].OrderStatus"; // query select form database
            con = new DBContext().getConnection(); // open conect database
            ps = con.prepareStatement(query); // set account ID into query
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery(); // execute query

            while (rs.next()) {
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrder.add(new Order(rs.getString(1),
                        OrderStatus.valueOf(rs.getString(4)),
                        outputDateStr,
                        rs.getString(2),
                        rs.getInt(5),
                        rs.getInt(6)));
                // add new item into list order
            } // end while

        } catch (Exception e) {
            e.getMessage();
        } // end try catch
        return listOrder; // return list order
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
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
                    + "WHERE [ORDER].AccIDOfShipper = ? AND [ORDER].OrderStatus = 'DELIVERED'\n"
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
                Date date = inputFormat.parse(rs.getString(3));
                String outputDateStr = outputFormat.format(date);
                listOrderHistory.add(new Order(rs.getString(1), OrderStatus.valueOf(rs.getString(4)), outputDateStr, rs.getString(2), rs.getInt(5), rs.getInt(6)));
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

}
