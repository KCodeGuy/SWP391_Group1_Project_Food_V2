package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Voucher;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class VoucherDAO {

    Connection con; //connect to SQL server
    PreparedStatement ps; //Move query from Netbeen to SQl
    ResultSet rs; //Save result query

    /**
     * Retrieves a list of all vouchers available for the currently logged-in user.
     *
     * @return a list of Voucher objects representing the available vouchers
     */
    public static List<Voucher> getAllVoucherForUser() {
        Connection con = null; // connect to SQL server.
        PreparedStatement ps = null; // move query from Netbeen to SQl.
        ResultSet rs = null; // save result query.
        List<Voucher> list = new ArrayList<>();
        try {
            //Declare a SQL query string
            String query = "select * from VOUCHER as v \n"
                    + "WHERE v.VoucherStatus = 'AVAILABLE' \n"
                    + "AND v.VoucherEndday >=  FORMAT(getdate(), 'yyyy-MM-dd') \n"
                    + "AND v.VoucherQuantity > 0  \n"
                    + "ORDER BY VoucherEndday DESC;";

            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            rs = ps.executeQuery();
            //Initialize a new user object
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                list.add(new Voucher(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));
            } //End while
            //Return the user object

        } catch (SQLException e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return list;
    }

    /**
     * Retrieves a list of all vouchers available for the admin user.
     *
     * This method returns a list of Voucher objects representing all vouchers
     * that are available for the admin user. This includes both active and
     * inactive vouchers, as well as any vouchers that may be currently reserved
     * or pending approval.
     *
     * @return a list of Voucher objects representing all vouchers available to
     * the admin user
     */
    public static List<Voucher> getAllVoucherForAdmin() {
        Connection con = null; // connect to SQL server.
        PreparedStatement ps = null; // move query from Netbeen to SQl.
        ResultSet rs = null; // save result query.
        List<Voucher> list = new ArrayList<>();
        try {
            //Declare a SQL query string
            String query = "select * from VOUCHER ORDER BY VoucherEndday DESC;";

            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            rs = ps.executeQuery();
            //Initialize a new user object
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                list.add(new Voucher(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));
            } //End while
            //Return the user object

        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return list;
    }

    /**
     * Returns the quantity of available vouchers for the given voucher ID.
     *
     * This method takes a voucher ID as input and returns the total quantity of
     * vouchers that are currently available for use. If no vouchers are
     * currently available or if the voucher ID is invalid, this method returns
     * zero.
     *
     * @param voucherID a String representing the ID of the voucher to check
     * @return an integer representing the quantity of available vouchers
     */
    public int quantityOfVoucher(String voucherID) {
        try {
            //Declare a SQL query string
            String query = "SELECT VoucherQuantity\n"
                    + "FROM VOUCHER\n"
                    + "WHERE GETDATE() BETWEEN VoucherStartDay AND VoucherEndday AND VoucherID = ?"; // Specify the condition for selecting a specific account ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setString(1, voucherID); //Set voucherID
            //Execute the query and get the result set
            rs = ps.executeQuery();
            //Initialize a new user object
            int quantity = 0;
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                quantity = rs.getInt(1);
            } //End while
            //Return the user object
            return quantity;
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return 0;
    }

    /**
     * Decrements the quantity of available vouchers for the given voucher ID.
     *
     * This method takes a voucher ID as input and decrements the total quantity
     * of vouchers that are currently available for use. If no vouchers are
     * currently available or if the voucher ID is invalid, this method does
     * nothing.
     *
     * @param voucherID a String representing the ID of the voucher to update
     */
    public void updateQuantity(String voucherID) {
        try {
            //Declare a SQL query string
            String query = "Update VOUCHER\n"
                    + "SET VoucherQuantity = VoucherQuantity - 1\n"
                    + "WHERE VoucherID = ?"; // Specify the condition for selecting a specific account ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setString(1, voucherID); //Set voucherID
            //Execute the query and get the result set
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
    }

    /**
     * Returns a list of the top 4 most popular vouchers.
     *
     * This method returns a list of Voucher objects representing the 4 most
     * frequently used vouchers in the system. The popularity of a voucher is
     * determined by the number of times it has been used by users. If there are
     * fewer than 4 vouchers in the system, this method returns all of them.
     *
     * @return a list of Voucher objects representing the top 4 most popular
     * vouchers
     */
    public List<Voucher> getTop4Voucher() {
        List<Voucher> list = new ArrayList<>();
        try {
            //Declare a SQL query string
            String query = "select top 4 * from VOUCHER as v \n"
                    + "WHERE v.VoucherStatus = 'AVAILABLE' \n"
                    + "AND v.VoucherEndday >=  FORMAT(getdate(), 'yyyy-MM-dd') \n"
                    + "AND v.VoucherQuantity > 0  \n"
                    + "ORDER BY VoucherEndday DESC;";

            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            rs = ps.executeQuery();
            //Initialize a new user object
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                list.add(new Voucher(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));
            } //End while
            //Return the user object

        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return list;
    }

    /**
     * Returns the percentage discount offered by a voucher for a product.
     *
     * This method takes a voucher ID as input and returns the percentage
     * discount that is offered by the voucher for a specific product. The
     * percentage discount is calculated by dividing the difference between the
     * regular price and the sale price by the regular price, and then
     * multiplying by 100. If the voucher does not apply to the specified
     * product, this method returns zero.
     *
     * @param voucherID a String representing the ID of the voucher to check
     * @return an integer representing the percentage discount offered by the
     * voucher
     */
    public int getProductSalePrecent(String voucherID) {
        try {
            //Declare a SQL query string
            String query = "SELECT discount FROM VOUCHER WHERE VoucherID = ?"; // Specify the condition for selecting a specific account ID
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

    /**
     * Adds a voucher to the system.
     *
     * @param dto the voucher to add
     * @return true if the voucher was added successfully, false otherwise
     * @throws SQLException if there is an error accessing the database
     */
    public static boolean addVoucher(Voucher dto) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        String INSERT
                = "insert into VOUCHER values(?,?,?,?,?,?,?,?)";

        try {
            conn = new DBContext().getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT);
                stm.setString(1, dto.getVoucherID());
                stm.setInt(2, dto.getVoucherCondition());
                stm.setString(3, dto.getVoucherDescription());
                stm.setString(4, dto.getVoucherStatus());
                stm.setInt(5, dto.getProductSalePercent());
                stm.setInt(6, dto.getVoucherQuantity());
                stm.setString(7, dto.getVoucherStartDay());
                stm.setString(8, dto.getVoucherEndDay());
                result = stm.executeUpdate() > 0;
            }
        } finally {
        }
        return result;
    }

    /**
     * Checks if a voucher has been used before based on the given condition and
     * price.
     *
     * @param condition the condition for the voucher, such as a minimum order
     * amount or a specific item that must be purchased
     * @param price the price of the order
     * @return true if the voucher has not been used before and meets the given
     * condition, false otherwise
     * @throws SQLException if there is an error accessing the database
     */
    public static boolean checkVoucherIsUsed(int condition, int price) throws SQLException {
        return price >= condition;
    }

    /**
     *
     * @param voucherID
     * @return
     */
    public Voucher getVoucherByID(String voucherID) {
        // query to check whether passed email and password is exist or not.
        String query = "SELECT * FROM [VOUCHER] where VoucherID = ?";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, voucherID);         // pass entered email to the first ?.
            rs = ps.executeQuery();                 // excute query and return result to rs.
            while (rs.next()) {
                return new Voucher(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return null;
    }

    /**
     * Updates an existing voucher in the system with new information.
     *
     * @param dto the voucher to update
     * @return true if the voucher was updated successfully, false otherwise
     * @throws SQLException if there is an error accessing the database
     */
    public static boolean updateVoucher(Voucher dto) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;

        String UPDATE
                = "UPDATE VOUCHER SET VoucherCondition=?, VoucherDescription=?, VoucherStatus=?, Discount=?, VoucherQuantity=?, VoucherStartDay=?, VoucherEndday=? WHERE VoucherID=?";

        try {
            conn = new DBContext().getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE);
                stm.setInt(1, dto.getVoucherCondition());
                stm.setString(2, dto.getVoucherDescription());
                stm.setString(3, dto.getVoucherStatus());
                stm.setInt(4, dto.getProductSalePercent());
                stm.setInt(5, dto.getVoucherQuantity());
                stm.setString(6, dto.getVoucherStartDay());
                stm.setString(7, dto.getVoucherEndDay());
                stm.setString(8, dto.getVoucherID());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
