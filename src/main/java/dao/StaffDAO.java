/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Staff;
/**
 *
 * @author CE160438_Le Trung Uol
 */
public class StaffDAO {

    Connection conn = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs =null; // save result query
    // Method to get infomation of staff by their account ID

    public Staff getStaffByAccountID(int accountID) {
        try {
            String query = "SELECT A.AccountName,A.AccountPhone,A.AccountEmail,A.AccountAddress,R.RoleDescription FROM [ACCOUNT] A JOIN [STAFF] S ON A.AccountID = S.AccountID JOIN [ROLE] R ON A.RoleID=R.RoleID\n" +
"WHERE A.AccountID = ?;";//statement to query data from database tables(MySqlServer
            conn = new DBContext().getConnection(); // open connection to SQL
            ps = conn.prepareStatement(query); // move query from Netbeen to SQl
            ps.setInt(1, accountID); //set data according to the first '?'
            rs = ps.executeQuery(); // Execute the query and get the result set   
            Staff staff = null;// Initialize a new staff object
            while (rs.next()) {  // Loop through creating a new staff and retrieved data
                staff = new Staff( //Create a new Staff object using data retrieved from the database(MySqlServer)
                        rs.getString(1),//the staff name
                        rs.getInt(2),   //the staff email
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
    }
}
