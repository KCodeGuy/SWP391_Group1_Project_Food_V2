/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class DBContext {

    // local host name 
    private static final String dbPrefix = "jdbc:sqlserver://LAPTOP-5FDEO73O";
    // set port here
    private static final String dbPort = "1433";
    // database name to connect sql
    private static final String databaseName = "G1FOOD";
    // instance to for connection
    private final String instance = "";
    // user name when seting to connect
    private static final String user = "sa";
    // password when seting to connect
    private static final String pass = "123456";

    /**
     * To connect with SQL server to process data.
     *
     * @return a connection to SQL
     */
    public Connection getConnection() {
        Connection conn = null;
        String dbURL = dbPrefix + ":" + dbPort + "\\" + instance + ";" + "databaseName=" + databaseName;
        if (instance == null || instance.trim().isEmpty()) {
            dbURL = dbPrefix + ":" + dbPort + ";" + "databaseName=" + databaseName;
        }
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            conn = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        System.out.println(conn);
    }
}
