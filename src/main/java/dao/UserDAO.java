/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;
import model.AccountStatus;
import model.User;

/**
 *
 * @author Tran Thi Ngoc Hieu CE161025
 */
public class UserDAO {

    Connection con; //connect to SQL server
    PreparedStatement ps; //Move query from Netbeen to SQl
    ResultSet rs; //Save result query
    //Method to get a user by their account ID

    /**
     * Returns the user associated with a given account ID.
     *
     * @param accountID the ID of the account associated with the user
     * @return the User object associated with the given account ID, or null if
     * the account ID is invalid
     */
    public User getUserByAccountID(int accountID) {

        try {
            //Declare a SQL query string
            String query = "SELECT A.AccountName, U.UserBirthDay, A.AccountPhone, A.AccountEmail, A.AccountAddress\n"
                    + "FROM [ACCOUNT] A \n"
                    + "JOIN [USER] U  ON A.AccountID = U.AccountID \n" // Specify the tables to join and the join condition
                    + "WHERE A.AccountID = ?"; // Specify the condition for selecting a specific account ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setInt(1, accountID); //Set accountID
            //Execute the query and get the result set
            rs = ps.executeQuery();
            //Initialize a new user object
            User user = null;
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                user = new User(
                        rs.getString(2), //The user's birthday
                        rs.getString(4), //The user's email
                        rs.getString(1), //The user's name
                        rs.getInt(3), //The user's phone number
                        rs.getString(5) //The user's address

                );
            } //End while
            //Return the user object
            return user;
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return null;
    }
    
    /**
     * This function get information user for paying
     *
     * @param accountID the ID of the account associated with the user
     * @return the User object associated with the given account ID, or null if
     * the account ID is invalid
     */
    public User getUserPayingByAccountID(int accountID) {

        try {
            //Declare a SQL query string
            String query = "SELECT A.AccountID, A.AccountEmail, A.AccountName, A.AccountPhone,  A.AccountAddress\n"
                    + "FROM [ACCOUNT] A \n"
                    + "JOIN [USER] U  ON A.AccountID = U.AccountID \n" // Specify the tables to join and the join condition
                    + "WHERE A.AccountID = ?"; // Specify the condition for selecting a specific account ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setInt(1, accountID); //Set accountID
            //Execute the query and get the result set
            rs = ps.executeQuery();
            //Initialize a new user object
            User user = null;
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            } //End while
            //Return the user object
            return user;
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught, return null
        return null;
    }
}
