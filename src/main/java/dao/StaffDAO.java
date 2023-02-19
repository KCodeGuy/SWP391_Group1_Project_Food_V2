/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
// Ipmport library

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.AccountStatus;
import model.Staff;

// Initialize class
/**
 *
 * @author 84832
 */
public class StaffDAO {

    Connection con;            // connect to SQL server
    PreparedStatement ps;      // move query from Netbeen to SQl
    ResultSet rs;              // save result query
    // Initialize method, the method used to query data from the database

    /**
     * Returns the Staff associated with a given account ID.
     *
     * @param accountID the ID of the account associated with the Staff
     * @return the Staff object associated with the given account ID, or null if
     * the account ID is invalid
     */
    public Staff getStaffByAccountID(int accountID) {
        try {                                       //The try-catch statement can use an external error when an exceptional error occurs
            String query = "SELECT A.AccountName, A.AccountPhone, A.AccountEmail, A.AccountAddress, R.RoleDescription, S.StaffStartDate FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID JOIN [ROLE] R ON R.RoleID = A.RoleID\n"
                    + "WHERE A.AccountID = ?"; // Database query statement
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setInt(1, accountID);
            rs = ps.executeQuery();                 // Perform query in database
            Staff staff = null;                     // Assign values ​​in null
            while (rs.next()) {                     // While loops used to scan via value in the database
                staff = new Staff(rs.getString(1), // (Query to the values ​​to be accessed) store into staff
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
            return staff;                           // Return the query value
        } catch (Exception e) {
            e.getMessage();                         // Show an exception error
        }
        return null;                                // Return value null
    }//end method                           

    /**
     * Interact with the database to load staff information by linking account
     * ID
     *
     * @param accountID of the associated with staff
     * @return staff linked by accountID otherwise return null
     */
    public Staff getApplicationFormByAccountID(int accountID) {
        try {
            String query = "SELECT A.AccountName,A.AccountPhone,A.AccountEmail,A.AccountAddress,R.RoleDescription FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID JOIN [ROLE] R ON A.RoleID=R.RoleID\n"
                    + "WHERE A.AccountID = ?;";//statement to query data from database tables(MySqlServer
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setInt(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   
            Staff staff = null;// Initialize a new staff object
            while (rs.next()) {  // Loop through creating a new staff and retrieved data
                staff = new Staff( //Create a new Staff object using data retrieved from the database(MySqlServer)
                        rs.getString(1),//the staff name
                        rs.getInt(2), //the staff email
                        rs.getString(3),//the staff phone
                        rs.getString(4),//the staff address 
                        rs.getString(5) // the roleDescription
                );
            }//end while    
            return staff;// return the staff

        } catch (Exception e) {
            e.getMessage();
        }//end catch
        return null; //If an exception occurs, return null
        //end method
    }

    /**
     * Check the acceptance application form and update the status of the
     * account
     *
     * @param accountID of the associated with staff
     * @return staff linked by acountID otherwise return null
     */
    public Staff getAcceptApplication(int accountID) {
        try {
            String query = "UPDATE [ACCOUNT]\n" + "SET AccountStatus = 'ACTIVED'\n" + "WHERE AccountID = ?;";//statement to query data from database tables(MySqlServer
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setInt(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   
            Staff staff = null;// Initialize a new staff object
            while (rs.next()) {  // Loop through creating a new staff and retrieved data
                staff = new Staff( //Create a new Staff object using data retrieved from the database(MySqlServer)
                        rs.getString(1),//the staff name
                        rs.getInt(2), //the staff email
                        rs.getString(3),//the staff phone
                        rs.getString(4),//the staff address 
                        rs.getString(5) // the roleDescription
                );
            }//end while    
            return staff;// return the staff

        } catch (Exception e) {
            e.getMessage();
        }//end catch
        return null; //If an exception occurs, return null
        //end method
    }

    /**
     * Check the reject and update the status of the account application form
     * and update the status of the account
     *
     * @param accountID of the associated with staff
     * @return staff linked by acountID otherwise return null
     */
    public Staff getRejecttApplication(int accountID) {
        try {
            String query = "UPDATE [ACCOUNT]\n" + "SET AccountStatus = 'REMOVED'\n" + "WHERE AccountID = ?;";//statement to query data from database tables(MySqlServer
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setInt(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   
            Staff staff = null;// Initialize a new staff object
            while (rs.next()) {  // Loop through creating a new staff and retrieved data
                staff = new Staff( //Create a new Staff object using data retrieved from the database(MySqlServer)
                        rs.getString(1),//the staff name
                        rs.getInt(2), //the staff email
                        rs.getString(3),//the staff phone
                        rs.getString(4),//the staff address 
                        rs.getString(5) // the roleDescription
                );
            }//end while    
            return staff;// return the staff

        } catch (Exception e) {
            e.getMessage();
        }//end catch
        return null; //If an exception occurs, return null
        //end method
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
}
