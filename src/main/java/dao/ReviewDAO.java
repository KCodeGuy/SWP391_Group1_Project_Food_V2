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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * Get the list of reviews for a given product ID.
     *
     * @param productID The ID of the product to get reviews for.
     * @return The list of reviews for the product with the given ID.
     */
    public ArrayList<Review> getListReviewByProductID(String productID) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        try {
            // Create the SQL query to get the reviews for the given product ID
            String query = "SELECT R.*, A.AccountName FROM [REVIEW] R JOIN [ACCOUNT] A ON R.AccountID = A.AccountID WHERE R.ProductID = ? AND R.ReplyID is null AND R.ReviewStatus = 'SUCCESS'";
            con = new DBContext().getConnection(); // Open a connection to the SQL database
            ps = con.prepareStatement(query); // Create a PreparedStatement object and pass in the query
            ps.setString(1, productID); // Replace the parameter '?' in the query with the productID passed to the method
            rs = ps.executeQuery(); // Execute the query and store the result in a ResultSet object
            ArrayList<Review> list = new ArrayList<>(); // Create an ArrayList to store the reviews
            while (rs.next()) {
                Date date = inputFormat.parse(rs.getString(5));
                String outputDateStr = outputFormat.format(date);
                // Add each review returned by the query to the ArrayList
                list.add(new Review(rs.getString(1), rs.getInt(2), rs.getString(3), outputDateStr, rs.getString(6), rs.getString(7), rs.getString(9)));
            }
            return list; // Return the ArrayList of reviews
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Insert a new review into the database.
     *
     * @param rating The rating of the review.
     * @param review The text of the review.
     * @param productID The ID of the product being reviewed.
     * @param accountID The ID of the account that wrote the review.
     */
    public void insertReview(int rating, String review, String productID, String accountID) {
        GenerateID gi = new GenerateID();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = now.format(formatter);
        String reviewID = gi.generateNewID("RV", getLastIDOfReview()); // Generate a new ID for the review
        String query = "INSERT INTO [REVIEW] VALUES (?,?,?,'SUCCESS',?,?,?,null)"; // Create the SQL query to insert the new review
        try {
            con = new DBContext().getConnection(); // Open a connection to the SQL database
            ps = con.prepareStatement(query); // Create a PreparedStatement object and pass in the query
            ps.setString(1, reviewID); // Replace the first parameter '?' in the query with the generated review ID
            ps.setInt(2, rating); // Replace the second parameter '?' in the query with the review's rating
            ps.setString(3, review); // Replace the third parameter '?' in the query with the review's text
            ps.setString(4, formattedDateTime); // Replace the fourth parameter '?' in the query with the product ID being reviewed
            ps.setString(5, productID); // Replace the fifth parameter '?' in the query with the account ID of the reviewer
            ps.setString(6, accountID); // Replace the sixth parameter '?' in the query with the account ID of the reviewer
            ps.executeUpdate(); // Execute the query to insert the new review into the database
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur during the insertion process
        }
    }

    /**
     * Delete a review from the database.
     *
     * @param reviewID The ID of the review to delete.
     */
    public void deleteReview(String reviewID) {
        // Create a SQL query to update the review's status to 'REMOVED'
        String query = "UPDATE REVIEW\n"
                + "SET ReviewStatus = 'REMOVED'\n"
                + "WHERE ReviewID = ?";
        try {
            con = new DBContext().getConnection(); // Open a connection to the database
            ps = con.prepareStatement(query); // Create a PreparedStatement object and pass in the query
            ps.setString(1, reviewID); // Replace the first parameter '?' in the query with the review ID to delete
            ps.executeUpdate(); // Execute the query to update the review's status to 'REMOVED'
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Print any exceptions that occur during the deletion process
        }
    }

    /**
     * This method retrieves the last Review ID from the REVIEW table in the
     * database.
     *
     * @return String The last Review ID from the REVIEW table.
     */
    public String getLastIDOfReview() {
        String lastID = null; // initialize variable to hold last Review ID
        String query = "SELECT TOP 1 ReviewID FROM [Review] ORDER BY CAST(RIGHT(ReviewID, 4) AS INT) DESC;"; // SQL query to get last Review ID
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeans to SQL
            rs = ps.executeQuery(); // execute query and return result to rs.
            while (rs.next()) {
                lastID = rs.getString(1); // get last Review ID from result set
            }
        } catch (Exception e) {
            e.getMessage(); // handle exceptions
        }
        return lastID; // return last Review ID
    }

}
