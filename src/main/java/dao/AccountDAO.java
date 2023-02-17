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

/**
 *
 * @author Thanh
 */
public class AccountDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

     /**
     * Function get list Account
     *
     * This function use to take all Account
     *
     * @return List<Account> list of Account
     */
    public List<Account> getListAccount() {
        try {
            String query = "SELECT * FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID \n"
                    + "WHERE A.AccountStatus = 'PENDING'"; //query select Account orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<Account> list = new ArrayList<>(); //list product
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("AccountID"),
                        rs.getString("AccountEmail"),
                        rs.getString("AccountPassword"),
                        AccountStatus.PENDING,
                        "description"
                )); // add new item in list
            } // end while rs.next
            return list;// return list Account
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
