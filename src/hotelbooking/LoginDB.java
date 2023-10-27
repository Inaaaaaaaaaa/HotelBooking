/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
