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
import model.Product;
import model.ProductStatus;
import model.Staff;

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
     * For all actors of system login an account to system. 
     * This function will check whether passed email and password is exist in system or not. 
     * If return null then login failed, and login successfully otherwise.
     * @param email entered email from user(String).
     * @param password entered password from user(String).
     * @return Account if email and password is matched and null otherwise.
     */
    public Account loginAccount(String email, String password) {
        // query to check whether passed email and password is exist or not.
        String query = "select AccountEmail, AccountPassword, AccountName, RoleID, AccountID\n"
                + "from ACCOUNT \n"
                + "where AccountEmail = ? and AccountPassword = ?;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setString(1, email);                // pass entered email to the first ?.
            ps.setString(2, password);             // pass entered password to the second ?.
            rs = ps.executeQuery();                // excute query and return result to rs.
            while (rs.next()) {
                // return an account
                return new Account(rs.getInt(5), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            } // end while loop of table result.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
        return null;
    }

    /**
     * To check an account is exist in system or not by passed email for login function.
     * @param email entered email from user(String).
     * @return status of check - account is exist(true) and false otherwise.
     */
    public boolean checkAccountIsExist(String email) {
        // query to check whether passed email is exist or not.
        String query = "select AccountEmail, AccountPassword, AccountName, RoleID, AccountID\n"
                + "from ACCOUNT \n"
                + "where AccountEmail = ?;";
        Account acc = null; // initilize an account.
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, email);                  // pass entered email to the first ?.
            rs = ps.executeQuery();                  // excute query and return result to rs.
            while (rs.next()) {
                acc = new Account(rs.getInt(5), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
     * To create a new account by user(register account). 
     * This function will insert to database some of parameters as below:
     * @param name entered name of user(String).
     * @param email entered email of user(String).
     * @param password entered password of user(String).
     * @param phone entered phone of user(String).
     * @param address entered address of user(String).
     */
    public void registerAccount(String name, String email, String password, String phone, String address) {
        // query to insert a new account of user to database. With status is ACTIVED and role's id is USER default.
        String query = "INSERT INTO ACCOUNT VALUES(?, ?, 'ACTIVED', ?, ?, ?, 'USER');INSERT INTO [USER] VALUES ('1/1/1997',(SELECT TOP 1 AccountID FROM ACCOUNT ORDER BY AccountID DESC))";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, email);                  // pass entered email to the first ?. 
            ps.setString(2, password);               // pass entered password to the second ?.
            ps.setString(3, name);                   // pass entered name to the third ?.
            ps.setString(4, address);                // pass entered address to the four ?.
            ps.setString(5, phone);                  // pass entered phone to the filth ?.
            ps.executeUpdate();                      // insert a new account of user to database.
        } catch (Exception e) {
            e.getMessage();
        } // end try-catch.
    }
    
    /**
     * To update a new password of an specified account by email.
     * @param email entered email to checking update(String).
     * @param newPassword entered password from user to update a new password(String).
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
     * This function use to take Account
     * to upload to the home page
     *
     * @return List<Account> list of Account
     */
    public List<Account> getListAccount() {
        try {
            String query = "SELECT A.AccountID, A.AccountEmail, A.AccountName, R.RoleDescription FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID"
                    + " JOIN ROLE R ON R.RoleID = A.RoleID WHERE A.AccountStatus = 'PENDING'";
                    //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<Account> list = new ArrayList<>(); //list Account
            while (rs.next()) {
                list.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4))); // add new item in list
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
    public Integer getCountListAccount() {
        Integer count = null;
        try {
            String query = "SELECT * FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID "; //query select product orther than REMOVED
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

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
