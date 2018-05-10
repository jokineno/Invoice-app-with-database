
package laskutusohjelma.domain;

import java.io.File;
import java.sql.*;
public class SQLiteDatabase {
    
    private static File file1;
    private static Boolean test =false;
    private static Connection conn;
    private static Boolean hasData = false;
    private static Boolean hasData2 = false;
    public SQLiteDatabase() {
    }
    
    public SQLiteDatabase(File file) {
        file1 = file;
    }
  
    public static Connection getConnection() throws SQLException {

        if (test) {
            conn = DriverManager.getConnection("jdbc:sqlite:" + file1.getAbsolutePath());
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:asiakasrekisteriDB.db");
           
            initCustomer();
            initUser();
            
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:asiakasrekisteriDB.db");
            
            initCustomer();
            initUser();
            
        }

        return conn;
    }
    
    /*
    Method creates user table into database. 
    */
    private static void initUser() throws SQLException {
            if(!hasData) {
                hasData = true;
            
                Statement stmt = conn.createStatement();
                PreparedStatement stmt2 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS User"
                    + "(name String NOT NULL, username String NOT NULL PRIMARY KEY,"
                    + " yNumber String,"
                    + " accountNumber String)");
                stmt2.execute();
                stmt.close();
                stmt2.close();
                stmt.close();
         
            }
   
    }
    
    /*
    Method creates Customer table to database. 
    */
    private static void initCustomer() throws SQLException {
            if(!hasData2) {
                hasData2 = true;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
                
                if(!rs.next()) {
                    PreparedStatement stmt2 = conn.prepareStatement("CREATE TABLE Customer"
                        + "(id Integer NOT NULL PRIMARY KEY, name String NOT NULL,"
                        + " yNumber String)");
                    stmt2.execute();
        
                    PreparedStatement prep = conn.prepareStatement("INSERT INTO Customer"
                        + "(id, name, yNumber)"
                        + " VALUES (?,?,?)");
                    prep.setInt(1, 1);
                    prep.setString(2, "exampleCustomer");
                    prep.setString(3, "1234567-8");
        
                    prep.executeUpdate();
    
                    stmt.close();
                    prep.close();
                    stmt2.close();
                }
            
            
                stmt.close();
            
            }
    }
}
    

   
    
    
  
