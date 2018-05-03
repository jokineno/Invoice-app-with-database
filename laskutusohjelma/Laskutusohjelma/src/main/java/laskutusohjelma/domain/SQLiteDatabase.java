
package laskutusohjelma.domain;

/**
 *
 * @author ollijokinen
 * Class where you create a connection to a database
 */
import java.io.File;
import java.sql.*;
public class SQLiteDatabase {
    
    private static File file1;
    private static Boolean test =false;
    private static Connection conn;
    private static Boolean hasData =false;
    
    public SQLiteDatabase() {
    }
    
    public SQLiteDatabase(File file) {
        file1 = file;
        test = true;
    }
    
    public static Connection getConnection() throws SQLException {

        if (test) {
            conn = DriverManager.getConnection("jdbc:sqlite:" + file1.getAbsolutePath());
            
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:asiakasrekisteriDB.db");

            init();
        }

        return conn;
    }
    
    /*
    Metodi lisää esimerkkikäyttäjän tietokantaan
    */
    private static void init() throws SQLException {
        if (!hasData) {
            hasData = true;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
            
            
            if(!rs.next()) {
                PreparedStatement stmt2 = conn.prepareStatement("CREATE TABLE User"
                + "(name String PRIMARY KEY, username String,"
                + " yNumber String,"
                + " accountNumber String)");
                stmt2.execute();
        
                PreparedStatement prep = conn.prepareStatement("INSERT INTO User"
                    + "(name, username, yNumber, accountNumber)"
                    + " VALUES (?,?,?,?)");
                prep.setString(1, "esimerkki");
                prep.setString(2, "esimerkkiusername");
                prep.setString(3, "1234567-8");
                prep.setString(4, "FI98 1234 1234 1234 12");
        
                prep.executeUpdate();
        
                stmt.close();
                prep.close();
                stmt2.close();
               
            }
            
            stmt.close();
        }
    }
    

   
    
    
  
}