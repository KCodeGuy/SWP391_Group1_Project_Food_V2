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

  public static boolean addVoucher(Voucher dto) throws SQLException {
    boolean result = false;
    Connection conn = null;
    PreparedStatement stm = null;
    String INSERT =
      "insert into VOUCHER(VoucherID, VoucherDescription, VoucherStatus, ProductSalePercent, VoucherQuantity, VoucherStartDay, VoucherEndday) values(?,?,?,?,?,?,?)";

    try {
      conn = new DBContext().getConnection();
      if (conn != null) {
        stm = conn.prepareStatement(INSERT);
        stm.setString(1, dto.getVoucherID());
        stm.setString(2, dto.getVoucherDescription());
        stm.setString(3, dto.getVoucherStatus());
        stm.setInt(4, dto.getProductSalePercent());
        stm.setInt(5, dto.getVoucherQuantity());
        stm.setString(6, dto.getVoucherStartDay());
        stm.setString(7, dto.getVoucherEndDay());
        result = stm.executeUpdate() > 0;
      }
    } finally {}
    return result;
  }

  public static boolean updateVoucher(Voucher dto) throws SQLException {
    boolean result = false;
    Connection conn = null;
    PreparedStatement stm = null;

    String UPDATE =
      "UPDATE VOUCHER SET VoucherDescription=?, VoucherStatus=?, ProductSalePercent=?, VoucherQuantity=?, VoucherStartDay=?, VoucherEndday=? WHERE VoucherID=?";

    try {
      conn = new DBContext().getConnection();
      if (conn != null) {
        stm = conn.prepareStatement(UPDATE);

        stm.setString(1, dto.getVoucherDescription());
        stm.setString(2, dto.getVoucherStatus());
        stm.setInt(3, dto.getProductSalePercent());
        stm.setInt(4, dto.getVoucherQuantity());
        stm.setString(5, dto.getVoucherStartDay());
        stm.setString(6, dto.getVoucherEndDay());
        stm.setString(7, dto.getVoucherID());
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
