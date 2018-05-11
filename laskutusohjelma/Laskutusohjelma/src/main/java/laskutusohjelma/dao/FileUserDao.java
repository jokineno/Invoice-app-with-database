
package laskutusohjelma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 * FileUserDao Class provides methods for searching and saving data from a user database.
 * @author ollijokinen
 */
public class FileUserDao implements UserDao<User, String> {
    private SQLiteDatabase database;
    
    /**
     * Constructor sets up a database
     * @param database sqlite database
     */
    public FileUserDao(SQLiteDatabase database) {
        this.database = database;
    }
    
    /**
     * create(User user) creates new user into database. 
     * @param user user's input
     * @throws SQLException database error catched
     */
    @Override
    public void create(User user) throws SQLException {
        
        Connection conn = this.database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO User"
            + " (name, username, yNumber, accountNumber)"
            + " VALUES (?, ?, ?, ?)");

        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getYtunnus());
        stmt.setString(4, user.getTilinumero());
        stmt.executeUpdate();
            
        stmt.close();
        conn.close();
        
    }
    
    /**
     * searches user by its username from a database
     * @param username user's input
     * @return true if user exists, false if user is not in a database
     * @throws SQLException database error catched
     */
    @Override
    public boolean findByUsername(String username) throws SQLException {
        
        try {
            Connection conn = this.database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
            stmt.setObject(1, username);
            ResultSet rs = stmt.executeQuery();
            boolean hasOne = rs.next();
            if (!hasOne) {
                rs.close();
                stmt.close();
                conn.close();
                return false;
            }
        
            rs.close();
            stmt.close();
            conn.close();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
       
    }
    
   
   
    
    /**
     * returns user's name by searching username
     * @param name user input
     * @return String name1 or null
     * @throws SQLException database error catch
     */
    @Override
    public String returnNameByUsername(String name) throws SQLException {
       
        Connection conn = this.database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT name FROM User WHERE username = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();
        String name1 = rs.getString("name");
        
        
        rs.close();
        stmt.close();
        conn.close();
        return name1;
        
        
    }
    
    /**
     * returns user's ynumber by searching username
     * @param username user input
     * @return String yNumber or null (in not exist)
     * @throws SQLException database error catch
     */
    @Override
    public String returnYNumber(String username) throws SQLException {
       
        Connection conn = this.database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT yNumber FROM User WHERE username = ?");
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        String yNumber1 = rs.getString("yNumber");
        
        rs.close();
        stmt.close();
        conn.close();
           
        return yNumber1;
        
    }
    
    /**
     * returns bankaccountnumber by searching username
     * @param username user input
     * @return String accountNumber or null (if not exist)
     * @throws SQLException database error catch
     */
    @Override
    public String returnBankAccount(String username) throws SQLException {
       
        Connection conn = this.database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT accountNumber FROM User WHERE username = ?");
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        String accountNumber1 = rs.getString("accountNumber");
        
        
        rs.close();
        stmt.close();
        conn.close();
        return accountNumber1;
        
       
    }
    
    /**
     * returns username by searching name
     * @param name user input
     * @return String username or null
     * @throws SQLException database error catch
     */
    @Override
    public String returnUsernameByName(String name) throws SQLException {
       
        Connection conn = this.database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT username FROM User WHERE name = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();
        String username = rs.getString("username");
        
        
        rs.close();
        stmt.close();
        conn.close();
        return username;
            
    }
    
    /**
     * saves user in database. 
     * @param user User dives input String user
     * @throws SQLException database error catched
     */
    @Override
    public void save(User user) throws SQLException {
       
        Connection conn = this.database.getConnection();
        String updateByUsername = user.getUsername();
        String sql = "UPDATE User SET name = ?, yNumber = ?, accountNumber =? WHERE username = '" + updateByUsername + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setObject(1, user.getName());
        stmt.setObject(2, user.getYtunnus());
        stmt.setObject(3, user.getTilinumero());
        
        stmt.executeUpdate();
        
        stmt.close();
        conn.close();
    }
    
    /**
     * returns User by searching name
     * @param name user input
     * @return User user
     * @throws SQLException database error catched
     */
    @Override
    public User returnUserByName(String name) throws SQLException {
        String name1 = name;
        String usName = returnUsernameByName(name);
        String yNumber = returnYNumber(name);
        String bank = returnBankAccount(name);
        User user = new User(name, usName, yNumber, bank);
        
        return user;
    }
}
