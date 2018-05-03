/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 *
 * @author ollijokinen
 */
public class FileUserDao implements UserDao<User, String> {
    private SQLiteDatabase database;
    
    public FileUserDao (SQLiteDatabase database) {
        this.database = database;
    }
    
    
   
    @Override
    public void create(User user) throws SQLException {
        Connection conn = database.getConnection();

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
    
    /*
    when logging in the system checks if your username exists. if not, it wont't log in. if so it logs user in
    */

    @Override
    public boolean findByUsername(String name) throws SQLException {
        Connection conn = database.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
        stmt.setObject(1, name);
        
        ResultSet rs = stmt.executeQuery();
        
        boolean hasOne = rs.next();
        if (!hasOne) {
            return false;
        }
        
        /*String name1 = rs.getString("name");
        String username = rs.getString("username");
        String yNumber = rs.getString("yNumber");
        String accountNumber = rs.getString("accountNumber");
        
        User u = new User(name1, username, yNumber, accountNumber);
        */
        return true;
        
        
        
        
        
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
