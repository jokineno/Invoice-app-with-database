
package laskutusohjelma.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * SQLiteDatabase provides database connection and creates database tables
 * @author ollijokinen
 */
public class SQLiteDatabase {
    
    
    private Connection conn;
    private String databaseUrl;
    
    /**
     * 
     * @param databaseUrl is the address of a database which is defined in config.properties
     * @throws SQLException database error catched
     * @throws FileNotFoundException if file is not founded
     * @throws IOException connection error
     */
    public SQLiteDatabase(String databaseUrl) throws SQLException, FileNotFoundException, IOException {
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
        this.databaseUrl = databaseUrl;
        
    }
    
    
    /**
     * creates User and Customer tables into database if not existing. 
     * @throws SQLException database error catched
     */
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
    
    /**
     * deletes all data from database
     * @throws SQLException database connection catch
     */
    public void deleteAll() throws SQLException {
        PreparedStatement getTables = conn.prepareStatement("SELECT name FROM sqlite_master WHERE type='table'");
        ResultSet tablesRs = getTables.executeQuery();

        List<String> tables = new ArrayList<>();

        while (tablesRs.next()) {
            tables.add(tablesRs.getString("name"));
        }

        for (String table : tables) {
            PreparedStatement dropTable = conn.prepareStatement("DROP TABLE IF EXISTS " + table);
            dropTable.execute();
            dropTable.close();
        }

        tablesRs.close();
        //conn.close();
        createTables();
    
    }
    
    /**
     * Connects to a database
     * @return a connection or null
     * @throws SQLException database error catched
     */
    public  Connection getConnection() throws SQLException {
        try {
            Connection conn1 = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
            return conn1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    /**
     * Closes a connection to a database
     * @throws SQLException database error catched
     */
    public void closeConnection() throws SQLException {
        conn.close();
    }
    
} 
   

   
    
    
  
