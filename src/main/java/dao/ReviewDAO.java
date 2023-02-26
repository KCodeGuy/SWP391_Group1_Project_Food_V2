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
import model.Review;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class ReviewDAO {

    Connection con = null;       // connect to SQL server.
    PreparedStatement ps = null; // move query from Netbeen to SQl.
    ResultSet rs = null;         // save result query.

    public ArrayList<Review> getListReviewByProductID(String productID) {
        try {
            String query = "SELECT R.*, A.AccountName FROM [REVIEW] R JOIN [ACCOUNT] A ON R.AccountID = A.AccountID WHERE R.ProductID = ? AND R.ReviewStatus = 'SUCCESS'"; //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, productID);
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            ArrayList<Review> list = new ArrayList<>(); //list products
            while (rs.next()) {
                list.add(new Review(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7)));
            } // end while rs.next
            return list;// return list product
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void insertReview(int rating, String review, String productID, String accountID) {
        GenerateID gi = new GenerateID();
        String reviewID = gi.generateNewID("RV", getLastIDOfReview());
        //query used to add products
        String query = "INSERT INTO [REVIEW] VALUES (?,?,?,'SUCCESS',?,?)";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);  // move query from Netbeen to SQl
            ps.setString(1, reviewID);
            ps.setInt(2, rating);
            ps.setString(3, review);
            ps.setString(4, productID);
            ps.setString(5, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReview(String reviewID) {
        //Create query update status of the product
        String query = "Update REVIEW \n"
                + "   SET ReviewStatus = 'REMOVED'\n"
                + "   WHERE ReviewID = ?";
        try {
            // Open connection to database
            con = new DBContext().getConnection();
            //Move query from Netbean to SQL
            ps = con.prepareStatement(query);
            //Set the value of the productID parameter in the SQL statement
            ps.setString(1, reviewID);
            // Excuse query
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public String getLastIDOfReview() {
        String lastID = null;
        String query = "SELECT TOP 1 ReviewID FROM [Review] ORDER BY CAST(RIGHT(ReviewID, 4) AS INT) DESC;";
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
}
