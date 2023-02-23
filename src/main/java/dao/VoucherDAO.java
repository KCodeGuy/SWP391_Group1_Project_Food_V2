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
     *
     * @return
     */
    public static List<Voucher> getAllVoucher() {
        Connection con = null; // connect to SQL server.
        PreparedStatement ps = null; // move query from Netbeen to SQl.
        ResultSet rs = null; // save result query.
        List<Voucher> list = new ArrayList<>();
        try {
            //Declare a SQL query string
            String query = "SELECT * FROM VOUCHER";

            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            rs = ps.executeQuery();
            //Initialize a new user object
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                list.add(new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            } //End while
            //Return the user object

        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return list;
    }

    /**
     *
     * @param voucherID
     * @return
     */
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

    /**
     * add voucher to database in  SQL
     *
     * @param dto the data voucher in SQL
     * @return result 
     * @throws SQLException
     */
    public static boolean addVoucher(Voucher dto) throws SQLException {
        boolean result = false;
        // save result query.
        Connection conn = null;
        // connect to SQL server.
        PreparedStatement stm = null;
        // move query from Netbeen to SQl.
        String INSERT //Declare a SQL query string
                = "insert into VOUCHER(VoucherID, VoucherDescription, VoucherStatus, Discount, VoucherQuantity, VoucherStartDay, VoucherEndday) values(?,?,?,?,?,?,?)";

        try {
            conn = new DBContext().getConnection(); //Open connection to SQL

            if (conn != null) {
                stm = conn.prepareStatement(INSERT); 
                //Move query to database
                stm.setString(1, dto.getVoucherID());
                //set ID voucher
                stm.setString(2, dto.getVoucherDescription());
                // set description voucher
                stm.setString(3, dto.getVoucherStatus());
                //set  status voucher
                stm.setInt(4, dto.getProductSalePercent());
                // set product sale percent
                stm.setInt(5, dto.getVoucherQuantity());
                // set quantity voucher
                stm.setString(6, dto.getVoucherStartDay());
                // set start day voucher
                stm.setString(7, dto.getVoucherEndDay());
                //set end day voucher
                result = stm.executeUpdate() > 0;
            }
        } finally {
            
        }
         //If an exception is caught, return null
        return result;
    }

    /**
     * update voucher to database in SQL
     *
     * @param dto the up data to SQL
     * @return result in formation of voucher
     * @throws SQLException
     */
    public static boolean updateVoucher(Voucher dto) throws SQLException {
        boolean result = false;
        // save result query.
        Connection conn = null;
        // connect to SQL server.
        PreparedStatement stm = null;
          // move query from Netbeen to SQl.
        String UPDATE   //Declare a SQL query string
                = "UPDATE VOUCHER SET VoucherDescription=?, VoucherStatus=?, Discount=?, VoucherQuantity=?, VoucherStartDay=?, VoucherEndday=? WHERE VoucherID=?";

        try {
            conn = new DBContext().getConnection(); 
            //Open connection to SQL
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE);
                      //Move query to database
                stm.setString(1, dto.getVoucherDescription());
                // update Description
                stm.setString(2, dto.getVoucherStatus());
                // update status 
                stm.setInt(3, dto.getProductSalePercent());
                //update sale percent
                stm.setInt(4, dto.getVoucherQuantity());
                // update quantity
                stm.setString(5, dto.getVoucherStartDay());
                // update start day
                stm.setString(6, dto.getVoucherEndDay());
                // updata end day
                stm.setString(7, dto.getVoucherID());
                // update ID voucher
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
        //If can an exception is caught, return result
        return result;
    }
}
