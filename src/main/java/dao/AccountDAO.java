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
 * @author thanh
 */
public class AccountDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

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
