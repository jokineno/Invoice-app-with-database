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
import java.util.ArrayList;
import java.util.List;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 *
 * @author ollijokinen
 */
public class FileUserDao implements UserDao<User, String> {
    private SQLiteDatabase database;
    
    public FileUserDao () {
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
    public boolean findByUsername(String username) throws SQLException {
        Connection conn = database.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
        stmt.setObject(1, username);
        
        ResultSet rs = stmt.executeQuery();
        
        boolean hasOne = rs.next();
        if (!hasOne) {
            return false;
        }
        
       
        stmt.close();
        rs.close();
        conn.close();
        return true;
        
    }
    
    @Override
    public String returnUsernameByName(String name) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE name = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();
        String name1 = rs.getString("name");
        
        stmt.close();
        rs.close();
        conn.close();
        
        
        return name1;
    }
    
    @Override
    public String returnNameByUsername(String name) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT name FROM User WHERE username = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();
        String name1 = rs.getString("name");
        
        stmt.close();
        rs.close();
        conn.close();
       
        return name1;
    }
    
    @Override
    public String returnYNumber(String username) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT yNumber FROM User WHERE username = ?");
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        String yNumber1 = rs.getString("yNumber");
        
        stmt.close();
        rs.close();
        conn.close();
        
        
        return yNumber1;
    }
    
    @Override
    public String returnBankAccount(String username) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT accountNumber FROM User WHERE username = ?");
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        String accountNumber1 = rs.getString("accountNumber");
        
        stmt.close();
        rs.close();
        conn.close();
        
        
        return accountNumber1;
    }
    
    
    public String returnUsernameByname(String name) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT username FROM User WHERE name = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();
        String username = rs.getString("username");
        
        stmt.close();
        rs.close();
        conn.close();
        
        
        return username;
    
    }
    
    
    @Override
    public void save(User user) throws SQLException {
       
        Connection conn = this.database.getConnection();
        String updateByUsername = user.getUsername();
        String sql = "UPDATE User SET name =?, yNumber =?, accountNumber =? WHERE username ='"+updateByUsername+"'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setObject(1, user.getName());
        stmt.setObject(2, user.getYtunnus());
        stmt.setObject(3, user.getTilinumero());
        
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    
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
