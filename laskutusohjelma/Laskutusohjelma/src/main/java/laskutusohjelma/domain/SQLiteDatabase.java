
package laskutusohjelma.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class SQLiteDatabase {
    
    
    private Connection conn;
    private String databaseUrl;
    
    public SQLiteDatabase(String databaseUrl) throws SQLException, FileNotFoundException, IOException {
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
        this.databaseUrl = databaseUrl;
        
    }
    
    
    
    public void createTables() throws SQLException {
        PreparedStatement createCustomer = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Customer"
            + "(id Integer NOT NULL PRIMARY KEY, name String NOT NULL,"
            + " yNumber String)");
        
        createCustomer.execute();
        createCustomer.close();
        
        
        PreparedStatement createUser = conn.prepareStatement("CREATE TABLE IF NOT EXISTS User"
            + "(name String NOT NULL, username String NOT NULL PRIMARY KEY,"
            + " yNumber String,"
            + " accountNumber String)");
        createUser.execute();
        createCustomer.close();
    }
    
    public  Connection getConnection() throws SQLException {
        try {
            Connection conn1 = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
            return conn1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void closeConnection() throws SQLException {
        conn.close();
    }
    
} 
   

   
    
    
  
