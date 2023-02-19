/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.AccountStatus;
import model.Staff;
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
     * Update a user's profile in the database with the provided information.
     *
     * @param accountID The ID of the account whose profile is being updated.
     * @param userBirthday The user's birthday.
     * @param accountName The user's name associated with the account.
     * @param accountPhone The user's phone number associated with the account.
     * @param accountAddress The user's address associated with the account.
     */
    public void updateUserProfile(int accountID, String userBirthday, String accountName, int accountPhone, String accountAddress) {
        //SQL query to update the account and user tables with the new profile information
        String query = "UPDATE [ACCOUNT]\n"
                + "SET \n"
                + "AccountName = ?,\n"
                + "AccountAddress = ?,\n"
                + "AccountPhone = ?\n"
                + "WHERE AccountID = ?\n"
                + "UPDATE [USER]\n"
                + "SET UserBirthDay = ?\n"
                + "WHERE AccountID = ?";
        try {
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            //Set the values for the parameters in the SQL query
            ps.setString(1, accountName); //The user's name
            ps.setString(2, accountAddress); //The user's address
            ps.setInt(3, accountPhone); //The user's phone number
            ps.setInt(4, accountID); //The user's ID account
            ps.setString(5, userBirthday); //The user's birthday
            ps.setInt(6, accountID); //The user's ID account
            //Execute the update query to update the user's profile
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
    }

    /**
     * Returns a list of all active users in the database.
     *
     * @return A list of User objects representing active users.
     */
    public List<User> getListUser() {
        try {
            //Define a SQL query to retrieve account details for all active users, including role information.
            String query = "SELECT A.AccountID, A.AccountEmail, A.AccountName, R.RoleDescription FROM [ACCOUNT] A JOIN [USER] S ON A.AccountID = S.AccountID\n"
                    + "JOIN [ROLE] R ON R.RoleID = A.RoleID WHERE A.AccountStatus = 'ACTIVED'";
            con = new DBContext().getConnection(); //Open a connection to the database.
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            rs = ps.executeQuery(); //Execute the query and get the result set.
            //Create a list to hold the User objects that will be created from the query results.
            List<User> list = new ArrayList<>();
            //Loop through the result set and create a new User object for each row.
            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),       //AccountID
                        rs.getString(2),    //AccountEmail
                        rs.getString(3)));  //AccountName
            } //End while
            return list;  //Return the list of User objects.
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught or if the list is empty, return null.
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
