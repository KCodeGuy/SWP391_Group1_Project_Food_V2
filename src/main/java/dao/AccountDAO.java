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
import model.Account;
import model.AccountStatus;
import model.Product;
import model.ProductStatus;

/**
 *
 *
 * @author 84832
 */
public class AccountDAO {

    Connection con = null;       // connect to SQL server.
    PreparedStatement ps = null; // move query from Netbeen to SQl.
    ResultSet rs = null;         // save result query.

    /**
     * For all actors of system login an account to system. This function will
     * check whether passed email and password is exist in system or not. If
     * return null then login failed, and login successfully otherwise.
     *
     * @param email entered email from user(String).
     * @param password entered password from user(String).
     * @return Account if email and password is matched and null otherwise.
     * @author Trần Đăng Khoa - CE160367
     */
    public Account loginAccount(String email, String password) {
        // query to check whether passed email and password is exist or not.
        String query = "SELECT AccountEmail, AccountPassword, AccountName, AccountID FROM ACCOUNT WHERE AccountEmail=? AND AccountPassword=? AND AccountStatus = 'ACTIVED'";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, email);         // pass entered email to the first ?.
            ps.setString(2, password);      // pass entered password to the second ?.
            rs = ps.executeQuery();                 // excute query and return result to rs.
            while (rs.next()) {
                // return an account
                return new Account(rs.getString(4), rs.getString(1), rs.getString(2), AccountStatus.ACTIVED, rs.getString(3), "", "", "", "", "");
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return null;
    }

    /**
     * To check an account is exist in system or not by passed email for login
     * function.
     *
     * @param email entered email from user(String).
     * @return status of check - account is exist(true) and false otherwise.
     * @author Trần Đăng Khoa - CE160367
     */
    public boolean checkAccountIsExist(String email) {
        // query to check whether passed email is exist or not.
        String query = "select AccountEmail, AccountPassword, AccountName, AccountID, AccountStatus\n"
                + "from ACCOUNT \n"
                + "where AccountEmail = ? and AccountStatus = 'ACTIVED';";
        Account acc = null; // initilize an account.
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);  // move query from Netbeen to SQl
            ps.setString(1, email);          // pass entered email to the first ?.
            rs = ps.executeQuery();                  // excute query and return result to rs.
            while (rs.next()) {
                acc = new Account(rs.getString(4), rs.getString(1), rs.getString(2), AccountStatus.valueOf(rs.getString(5)), rs.getString(3), "", "", "", "", "");
            } // end while loop of table result.
            // check whether accoutn is null or not to return.
            if (acc != null) {
                return true; // status of checking is exist account.
            } // end if condition.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return false; // status of checking is not exist account.
    }

    /**
     * To get specified status of an account by email.
     *
     * @param email passed email to get status of an account.
     * @return status of an account(String)
     * @author Trần Đăng Khoa - CE160367
     */
    public String getAccountStatusByEmail(String email) {
        // query to get account status by passed email.
        String query = "select AccountStatus from ACCOUNT where AccountEmail = ?;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);  // move query from Netbeen to SQl
            ps.setString(1, email);          // pass entered email to the first ?.
            rs = ps.executeQuery();                  // excute query and return result to rs.
            while (rs.next()) {
                // return status of an account.
                return rs.getString(1);
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return null; // status of checking statyus of account.
    }

    /**
     * To create a new account by user(register account).This function will
     * insert to database some of parameters as below:
     *
     * @param name entered name of user(String).
     * @param email entered email of user(String).
     * @param password entered password of user(String).
     * @param phone entered phone of user(String).
     * @param address entered address of user(String).
     * @param dob day of birth of user(String)
     * @param startDay current date when register(String).
     * @author Trần Đăng Khoa - CE160367
     */
    public void registerAccount(String name, String email, String password, String phone, String address, String dob, String startDay) {
        // query to insert a new account of user to database. With status is ACTIVED and role's id is USER default.
        String query = "INSERT INTO [ACCOUNT] VALUES (?,?,?,'PENDING',?,?,?,?,?)";
        String id = createNewUserID(); // get account's id of user.
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);  // move query from Netbeen to SQl
            ps.setString(1, id);             // pass entered id to the first ?. 
            ps.setString(2, email);          // pass entered email to the second ?.
            ps.setString(3, password);       // pass entered password to the third ?.
            ps.setString(4, name);           // pass entered name to the four ?.
            ps.setString(5, address);        // pass entered address to the filth ?.
            ps.setString(6, phone);          // pass entered phone to the 6th ?.
            ps.setString(7, dob);            // pass entered date of birth to the 7th ?.
            ps.setString(8, startDay);       // pass entered current date to the 8th ?.
            ps.executeUpdate();                      // insert a new account of user to database.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
    }

    /**
     * To get id of a specified account by passed email.
     *
     * @param email entered email of user(String).
     * @return account's id by passed email(String)
     * @author Trần Đăng Khoa - CE160367
     */
    public String getAccountIDByEmail(String email) {
        // query to get account id by email
        String query = "select AccountID from ACCOUNT where AccountEmail = ?; ";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, email);         // pass entered email to the first ?.
            rs = ps.executeQuery();                 // excute query and return result to rs.
            while (rs.next()) {
                // return an account
                return rs.getString(1);
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return null; // null id of account when table result is null
    }

    /**
     * This method will return a specified account by passed id.
     *
     * @param ID passed id of account(String)
     * @return a specified account by passed id(Account).
     * @author Trần Đăng Khoa - CE160367
     */
    public Account getAccountByID(String ID) {
        // query to get an accont by id.
        String query = "select * from ACCOUNT where AccountID = ?;";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, ID);            // passed secified id to the first ?.
            rs = ps.executeQuery();                 // excute query and return result to rs.
            while (rs.next()) {
                // return an account
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), AccountStatus.valueOf(rs.getString(4)), rs.getString(5), rs.getString(7), rs.getString(6), rs.getString(8), rs.getString(9), "");
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return null;
    }

    /**
     * To update account status by account's id.
     *
     * @param accountID passed id of an account to update(String).
     * @param newStatus passed new status of account to update(String).
     * @author Trần Đăng Khoa - CE160367
     */
    public void updateAccountStatus(String accountID, String newStatus) {
        // query to update new status of account by passed email.
        String query = "update ACCOUNT set AccountStatus = ? where AccountID = ?";
        try {
            con = new DBContext().getConnection();   // open connection to SQL.
            ps = con.prepareStatement(query);  // move query from Netbeen to SQl.
            ps.setString(1, newStatus);      // pass new status to the first ?. 
            ps.setString(2, accountID);      // pass id of account to the second ?. 
            ps.executeUpdate();                      // update a new password into database.                 
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
    }

    
    /**
     * Update a account's information when user re-register it(pending status).
     * @param accountID The ID of the account whose profile is being updated.
     * @param userBirthday The user's birthday.
     * @param accountName The user's name associated with the account.
     * @param accountPhone The user's phone number associated with the account.
     * @param accountAddress The user's address associated with the account.
     * @param todayDate The current date to register an account.
     * @author Trần Đăng Khoa - CE160367
     */
    public void updateAccountIsPending(String accountID, String userBirthday, String accountName, String accountPhone, String accountAddress, String todayDate) {
        //SQL query to update the account and user tables with the new profile information
        String query = "UPDATE ACCOUNT\n"
                + "SET AccountName = ?,\n"
                + "AccountPhone = ?,\n"
                + "AccountAddress = ?,\n"
                + "AccountBirthDay = ?,\n"
                + "AccountStartDate = ?\n"
                + "WHERE AccountID = ?";
        try {
            con = new DBContext().getConnection();    //Open connection to SQL
            ps = con.prepareStatement(query);   //Move query from Netbeen to SQL
            ps.setString(1, accountName);     //The user's name
            ps.setString(2, accountPhone);    //The user's address
            ps.setString(3, accountAddress);  //The user's phone number
            ps.setString(4, userBirthday);    //The user's birthday
            ps.setString(5, todayDate);       //The current date to register an account.
            ps.setString(6, accountID);       //The user's ID account
            //Execute the update query to update the user's profile
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
    }
    
    
    /**
     * Create new ID of user
     *
     * @return ID of user
     */
    public String createNewUserID() {
        GenerateID g = new GenerateID();
        String lastID = getLastIDOfAccount();

        String newID = g.generateNewID("US", lastID);
        return newID;
    }

    /**
     * Create new ID of Chef
     *
     * @return ID of Chef
     */
    public String createNewChefID() {
        GenerateID g = new GenerateID();
        String lastID = getLastIDOfAccount();

        String newID = g.generateNewID("CH", lastID);
        return newID;
    }

    /**
     * Create new ID of shipper
     *
     * @return ID of shipper
     */
    public String createNewShipperID() {
        GenerateID g = new GenerateID();
        String lastID = getLastIDOfAccount();

        String newID = g.generateNewID("SP", lastID);
        return newID;
    }

    /**
     * Get last id in table account
     *
     * @return last id
     */
    public String getLastIDOfAccount() {
        String lastID = null;
        String query = "SELECT TOP 1 AccountID FROM [ACCOUNT] ORDER BY CAST(RIGHT(AccountID, 4) AS INT) DESC;";
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
     * To update a new password of an specified account by email.
     *
     * @param email entered email to checking update(String).
     * @param newPassword entered password from user to update a new
     * password(String).
     */
    public void updatePassword(String email, String newPassword) {
        // query to update account by passed email.
        String query = "update ACCOUNT set AccountPassword = ? where AccountEmail = ?;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL.
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl.
            ps.setString(1, newPassword);            // pass entered newPassword to the first ?. 
            ps.setString(2, email);                  // pass entered email to the second ?. 
            ps.executeUpdate();                      // update a new password into database.                 
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
    }

    /**
     * Function get list Account
     *
     * This function use to take Account to upload to the home page
     *
     * @return List<Account> list of Account
     */
    public List<Account> getListAccount() {
        try {
            String query = "SELECT AccountID, AccountEmail, AccountName FROM [ACCOUNT] WHERE AccountStatus = 'PENDING' AND AccountID NOT LIKE 'CH%'";
            //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<Account> list = new ArrayList<>(); //list Account
            while (rs.next()) {
                if (rs.getString(1).substring(0, 2).equalsIgnoreCase("SP")) {
                    list.add(new Account(rs.getString(1), rs.getString(2), "", AccountStatus.PENDING, rs.getString(3), "", "", "", "", "Shipper")); // add new item in list
                } else {
                    list.add(new Account(rs.getString(1), rs.getString(2), "", AccountStatus.PENDING, rs.getString(3), "", "", "", "", "Chef")); // add new item in list
                }

            } // end while rs.next
            return list;// return list product
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Function getCountListAccount
     *
     * This function use to take Account
     *
     *
     * @return count
     */
    public int getCountListAccount() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) FROM [ACCOUNT] WHERE (AccountID LIKE 'SP%' OR AccountID LIKE 'CH%') AND AccountStatus = 'PENDING'"; //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;

            while (rs.next()) {
                count = rs.getInt(1);
            } // end while rs.next

        } catch (Exception e) {
            e.getMessage();
        }
        return count;
    }

    /**
     * Returns the Staff associated with a given account ID.
     * 
     * @param accountID the ID of the account associated with the Staff
     * @return the Staff object associated with the given account ID, or null if
     * the account ID is invalid
     */
    public Account getStaffByAccountID(String accountID) {
        try {                                       //The try-catch statement can use an external error when an exceptional error occurs
            String query = "SELECT AccountID, AccountName, AccountPhone, AccountEmail, AccountAddress, AccountStartDate, AccountBirthDay FROM ACCOUNT WHERE AccountID = ? AND AccountID NOT LIKE 'US%'"; // Database query statement
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setString(1, accountID);        
            rs = ps.executeQuery();                 // Perform query in database
            Account staff = null;                   // Assign values ​​in null
            while (rs.next()) { // Loop through creating a new staff and retrieved data
                if (rs.getString(1).substring(0, 2).equalsIgnoreCase("SP")) { //If-Else statement, if the condition is correct, go to the IF command if it is wrong, then run into the Else
                    staff = new Account(rs.getString(1), rs.getString(4), "", AccountStatus.NULL, rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(7), rs.getString(6), "Shipper"); // add new item in list
                } else { // If the condition is wrong
                    staff = new Account(rs.getString(1), rs.getString(4), "", AccountStatus.NULL, rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(7), rs.getString(6), "Chef"); // add new item in list
                }
            } // end while rs.next
            return staff;                           // Return the query value
        } catch (Exception e) {
            e.getMessage();                         // Show an exception error
        }
        return null;                                // Return value null
    }//end method      
    
    /**
     * Returns a list of all active staffs in the database.
     *
     * @return A list of Staff objects representing active staffs.
     */
    public List<Account> getListStaff() {
        try {
            //Define a SQL query to retrieve account details for all active staffs, including role information.
            String query = "SELECT AccountID, AccountName, AccountEmail FROM ACCOUNT WHERE  AccountID LIKE 'CH%' OR AccountID LIKE 'SP%'";
            con = new DBContext().getConnection(); //Open a connection to the database.
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            rs = ps.executeQuery(); //Execute the query and get the result set.
            //Create a list to hold the Staff objects that will be created from the query results.
            List<Account> list = new ArrayList<>();
            //Loop through the result set and create a new Staff object for each row.
            while (rs.next()) { // Loop through creating a new staff and retrieved data
                if (rs.getString(1).substring(0, 2).equalsIgnoreCase("SP")) {
                    list.add(new Account(rs.getString(1), rs.getString(3), "", AccountStatus.NULL, rs.getString(2), "", "", "", "", "Shipper")); // add new item in list
                } else {
                    list.add(new Account(rs.getString(1), rs.getString(3), "", AccountStatus.NULL, rs.getString(2), "", "", "", "", "Chef")); // add new item in list
                }
            } // end while rs.next
            return list;  //Return the list of Staff objects.
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught or if the list is empty, return null.
        return null;
    }
    /**
     * Update a staff's profile in the database with the provided information.
     * @param accountEmail entered email of user(String).
     * @param accountID The ID of the account whose profile is being updated.
     * @param accountName The staff's name associated with the account.
     * @param accountPhone The staff's phone number associated with the account.
     * @param accountStartDay The staff's phone number associated with the account.
     * @param roleDescription The staff's phone number associated with the account.
     * @param accountAddress The staff's address associated with the account.
     */
    public void updateStaffProfile(String accountID, String accountName, String accountPhone, String accountAddress, String accountStartDay, String roleDescription) {
        //SQL query to update the account and staff tables with the new profile information
        String query = "UPDATE ACCOUNT\n"
                + "SET AccountName = ?,\n"
                + "AccountPhone = ?,\n"
                + "AccountAddress = ?,\n"
                + "AccountStartDate = ?\n"
                + "WHERE AccountID = ?";
        try {
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            //Set the values for the parameters in the SQL query
            ps.setString(1, accountName); //The staff's name
            ps.setString(2, accountPhone); //The staff's address
            ps.setString(3, accountAddress); //The staff's birthday
            ps.setString(4, accountStartDay); //The staff's birthday
            ps.setString(5, accountID); //The staff's ID account
            //Execute the update query to update the staff's profile
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
    }
    
    /**
     * Returns a list of User objects with names that match the provided search
     * text.
     *
     * @param txtSearch the search text to match user names against
     * @return a list of User objects whose names match the provided search
     * text, or null if no match is found
     */
    public List<Account> getListStaffByName(String txtSearch) {
        try {
            //Define a SQL query to retrieve account details for all active staffs, including role information.
            String query = "SELECT AccountID, AccountName, AccountEmail FROM ACCOUNT WHERE  AccountID NOT LIKE 'US%' AND AccountName LIKE ?";
            con = new DBContext().getConnection(); //Open a connection to the database.
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery(); //Execute the query and get the result set.
            //Create a list to hold the Staff objects that will be created from the query results.
            List<Account> list = new ArrayList<>();
            //Loop through the result set and create a new Staff object for each row.
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(3), "", AccountStatus.NULL, rs.getString(2), "", "", "", "", ""));  //AccountName
            } //End while
            return list;  //Return the list of Staff objects.
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught or if the list is empty, return null.
        return null;
    }

    /**
     * Interact with the database to load staff information by linking account
     * ID
     *
     * @param accountID of the associated with staff
     * @return staff linked by accountID otherwise return null
     */
    public Account getApplicationFormByAccountID(String accountID) {
        try {
            String query = "SELECT AccountID, AccountName, AccountPhone, AccountEmail, AccountAddress FROM ACCOUNT WHERE AccountID = ? AND AccountStatus = 'PENDING'";//statement to query data from database tables(MySqlServer
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   
            Account staff = null;// Initialize a new staff object
            while (rs.next()) {  // Loop through creating a new staff and retrieved data
                if (rs.getString(1).substring(0,2).equalsIgnoreCase("SP")) {
                    staff = new Account(rs.getString(1), rs.getString(4), "", AccountStatus.PENDING, rs.getString(2), rs.getString(3), "", "", "", "Shipper"); // add new item in list
                } else {
                    staff = new Account(rs.getString(1), rs.getString(4), "", AccountStatus.PENDING, rs.getString(2), rs.getString(3), "", "", "", "Chef"); // add new item in list
                }
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
     */
    public void getAcceptApplication(String accountID) {
        try {
            String query = "UPDATE [ACCOUNT]\n" + "SET AccountStatus = 'ACTIVED'\n" + "WHERE AccountID = ?;";//statement to query data from database tables(MySqlServer
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   

        } catch (Exception e) {
            e.getMessage();
        }//end catch
        //end method
    }

    /**
     * Check the reject and update the status of the account application form
     * and update the status of the account
     *
     * @param accountID of the associated with staff
     */
    public void getRejectApplication(String accountID) {
        try {
            String query = "UPDATE [ACCOUNT]\n" + "SET AccountStatus = 'REMOVED'\n" + "WHERE AccountID = ?;";//statement to query data from database tables(MySqlServer
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   
        } catch (Exception e) {
            e.getMessage();
        }//end catch
        //end method
    }

    /**
     * Returns the user associated with a given account ID.
     *
     * @param accountID the ID of the account associated with the user
     * @return the User object associated with the given account ID, or null if
     * the account ID is invalid
     */
    public Account getUserByAccountID(String accountID) {

        try {                                       //The try-catch statement can use an external error when an exceptional error occurs
            String query = "SELECT AccountID, AccountName, AccountPhone, AccountEmail, AccountAddress, AccountStartDate, AccountBirthDay FROM ACCOUNT WHERE AccountID = ? AND AccountID LIKE 'US%'"; // Database query statement
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setString(1, accountID);
            rs = ps.executeQuery();                 // Perform query in database
            Account user = null;                     // Assign values ​​in null
            while (rs.next()) {                     // While loops used to scan via value in the database
                user = new Account(rs.getString(1), rs.getString(4), "", AccountStatus.NULL, rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(7), rs.getString(6), "");
            }
            return user;                           // Return the query value
        } catch (Exception e) {
            e.getMessage();                         // Show an exception error
        }
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
    public void updateUserProfile(String accountID, String userBirthday, String accountName, String accountPhone, String accountAddress) {
        //SQL query to update the account and user tables with the new profile information
        String query = "UPDATE ACCOUNT\n"
                + "SET AccountName = ?,\n"
                + "AccountPhone = ?,\n"
                + "AccountAddress = ?,\n"
                + "AccountBirthDay = ?\n"
                + "WHERE AccountID = ?";
        try {
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            //Set the values for the parameters in the SQL query
            ps.setString(1, accountName); //The user's name
            ps.setString(2, accountPhone); //The user's address
            ps.setString(3, accountAddress); //The user's phone number
            ps.setString(4, userBirthday); //The user's birthday
            ps.setString(5, accountID); //The user's ID account
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
    public List<Account> getListUser() {
        try {
            //Define a SQL query to retrieve account details for all active users, including role information.
            String query = "SELECT AccountID, AccountName, AccountEmail FROM ACCOUNT WHERE  AccountID LIKE 'US%'";
            con = new DBContext().getConnection(); //Open a connection to the database.
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            rs = ps.executeQuery(); //Execute the query and get the result set.
            //Create a list to hold the User objects that will be created from the query results.
            List<Account> list = new ArrayList<>();
            //Loop through the result set and create a new User object for each row.
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(3), "", AccountStatus.NULL, rs.getString(2), "", "", "", "", ""));  //AccountName
            } //End while
            return list;  //Return the list of User objects.
        } catch (Exception e) {
            e.getMessage();
        } //End trycatch
        //If an exception is caught or if the list is empty, return null.
        return null;
    }

    /**
     * Deletes a user account and sets their account status to "REMOVED" in the
     * database.
     *
     * @param accountID the ID of the user account to delete
     */
    public void deleteUser(String accountID) {
        //Define SQL query to update the account status to "REMOVED" and set the email to empty
        String query = "UPDATE [ACCOUNT]\n"
                + "SET AccountStatus = 'REMOVED',\n"
                + "AccountEmail = ''\n"
                + "WHERE AccountID = ?";
        try {
            //Establish database connection
            con = new DBContext().getConnection();
            //Prepare the SQL statement with the query
            ps = con.prepareStatement(query);
            //Set the value of the accountID parameter in the SQL statement
            ps.setString(1, accountID);
            //Execute the SQL statement to update the account status and email
            ps.executeUpdate();
        } catch (SQLException e) {
            //If an SQL error occurs, print the error message to the console
            e.getMessage();
        } //End trycatch
    }

    /**
     * Returns a list of User objects with names that match the provided search
     * text.
     *
     * @param txtSearch the search text to match user names against
     * @return a list of User objects whose names match the provided search
     * text, or null if no match is found
     */
    public List<Account> getListUserByName(String txtSearch) {
        try {
            //Define a SQL query to retrieve account details for all active users, including role information.
            String query = "SELECT AccountID, AccountName, AccountEmail FROM ACCOUNT WHERE  AccountID LIKE 'US%' AND AccountName LIKE ?";
            con = new DBContext().getConnection(); //Open a connection to the database.
            ps = con.prepareStatement(query); //Move query from Netbeen to SQL
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery(); //Execute the query and get the result set.
            //Create a list to hold the User objects that will be created from the query results.
            List<Account> list = new ArrayList<>();
            //Loop through the result set and create a new User object for each row.
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(3), "", AccountStatus.NULL, rs.getString(2), "", "", "", "", ""));  //AccountName
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
    public Account getUserPayingByAccountID(String accountID) {

        try {
            //Declare a SQL query string
            String query = "SELECT AccountID, AccountName, AccountEmail, AccountPhone, AccountAddress FROM ACCOUNT WHERE  AccountID LIKE 'US%' AND AccountID = ?"; // Specify the condition for selecting a specific account ID
            con = new DBContext().getConnection(); //Open connection to SQL
            ps = con.prepareStatement(query); //Move query to database
            ps.setString(1, accountID); //Set accountID
            //Execute the query and get the result set
            rs = ps.executeQuery();
            //Initialize a new user object
            Account user = null;
            //Loop through the result set and create a new user object with the retrieved data
            while (rs.next()) {
                //Create a new User object using data retrieved from the database
                user = new Account(rs.getString(1), rs.getString(3), "", AccountStatus.NULL, rs.getString(2), rs.getString(4), rs.getString(5), "", "", "");
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
