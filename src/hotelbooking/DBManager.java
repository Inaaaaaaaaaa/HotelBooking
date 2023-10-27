/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jarrett
 */
public class DBManager {
    private static final String USER_NAME = "admin"; //your DB username
    private static final String PASSWORD = "123"; //your DB password
    private static final String URL = "jdbc:derby:LoginDB; create=true";  //url of the DB host

    Connection conn;

    public DBManager() {
        establishConnection();
    }

    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        //Establish a connection to Database
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL+" connected...");
        }
        catch(SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
