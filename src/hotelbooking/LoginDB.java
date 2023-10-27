/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 *
 * @author jarrett
 */
public class LoginDB {
    DBManager dbManager;
    Connection conn;
    Statement statement;
    
    public LoginDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void closeConnection() {
        this.dbManager.closeConnections();
    }
    
    public void registerUserDB(String username, String password) {
        try {
            statement = conn.createStatement();
            String newTable = "USERS";
            
            // check if table exists before dropping
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tableResultSet = metaData.getTables(null, null, newTable, null);
            
            if(tableResultSet.next()) {
                statement.executeUpdate("DROP TABLE "+newTable);
            }
            
            String createUsersTable = "CREATE TABLE USERS (USERID VARCHAR(20), PASSWORD VARCHAR(20))";
            statement.executeUpdate(createUsersTable);
            
            String insertUserRecords = "INSERT INTO USERS VALUES ('"+username+"', '"+password+"')";
            statement.executeUpdate(insertUserRecords);
            
            System.out.println("Created USERS table, inserted records.");
        }
        catch(SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
