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

/**
 *
 * @author GROUP 1
 */
// Initialize class
public class StaffDAO {

    Connection con;            // connect to SQL server
    PreparedStatement ps;      // move query from Netbeen to SQl
    ResultSet rs;              // save result query
    // Initialize method
    public Staff getStaffByAccountID(int accountID) {

        try {                                       //The try-catch statement can use an external error when an exceptional error occurs
            String query = "SELECT * FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID \n"
                    + "WHERE A.AccountID = ?";      // Database query statement
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setInt(1, accountID);
            rs = ps.executeQuery();                 // Perform query in database
            Staff staff = null;                     // Assign values ​​in null
            while (rs.next()) {                     // While loops used to scan via value in the database
                staff = new Staff(rs.getString(10), // (Query to the values ​​to be accessed) store into staff
                        0,
                        rs.getString(2),
                        "",
                        AccountStatus.valueOf(rs.getString(4)),
                        rs.getString(5),
                        rs.getInt(7),
                        rs.getString(6),
                        rs.getString(8), ""
                );
            }
            return staff;                           // Return the query value
        } catch (Exception e) {
            e.getMessage();                         // Show an exception error
        }
        return null;                                // Return value null
    }//end method                           
}//end class
