/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ollijokinen
 */

package laskutusohjelma.dao;
import java.util.*;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import laskutusohjelma.domain.Asiakas;
import laskutusohjelma.domain.SQLiteDatabase;

public class FileAsiakasDao implements AsiakasDao<Asiakas, String> {
    
    final SQLiteDatabase database; 
    
    public FileAsiakasDao(SQLiteDatabase database) {
        this.database = database;
    }
    
     /**
     * etsitään asiakas tietokannasta
     * @param event
     * @throws IOException 
     */
    
    public Integer tableSize() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM Customer");
        ResultSet rs = stmt.executeQuery();
        Integer tableSize = null;
        
        while(rs.next()) {
            tableSize = rs.getInt(1);
        }
        
        
        return tableSize;
    }
    
    public void createCustomer(Asiakas customer) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Customer" + " (id, name, yNumber)" +  "VALUES (?,?,?)");
        
        
        stmt.setInt(1, tableSize()+1);
        stmt.setString(2, customer.getName());
        stmt.setString(3, customer.getyTunnus());
        stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        
    }
    
    @Override
    public Asiakas findOne(String name) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Asiakas WHERE name = ?");
        stmt.setString(1, name);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Asiakas a = new Asiakas(rs.getInt("id"), rs.getString("name"),
            rs.getString("yNumber"));
  
        stmt.close();
        rs.close();
        conn.close();

        return a;
        
    }
    
    public String findYNumber(String name) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT yNumber FROM Customer WHERE name = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();
        String yNumber = rs.getString("yNumber");
       
     
        stmt.close();
        rs.close();
        conn.close();
        
        return yNumber;
        
    }
  /**
     * etsitään kaikki käyttäjät tietokannasta
     * @param event
     * @throws IOException 
     */
    @Override
    public ObservableList<Asiakas> findAll() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Customer");
        
        ResultSet resultSet = stmt.executeQuery();
        
        ObservableList<Asiakas> asiakkaat = FXCollections.observableArrayList();
        
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String ytunnus = resultSet.getString("yNumber");
            Asiakas a = new Asiakas(id, name, ytunnus);
            asiakkaat.add(a);
            
        }
        if (asiakkaat.isEmpty()) {
            return null;
        }
        
        stmt.close();
        resultSet.close();
        conn.close();
        return asiakkaat;
    }
     /**
     * tallennetaan asiakas
     * @param event
     * @throws IOException 
     */

    @Override
    //ensiksi vain tallennetaan myöhemmin voidaan myös muokata
    public Asiakas save(Asiakas asiakas) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Customer" + " (id, name, yNumber)" +  "VALUES (?,?,?)");
        
        stmt.setInt(1, asiakas.getId());
        stmt.setString(2, asiakas.getName());
        stmt.setString(3, asiakas.getyTunnus());
        
        Asiakas a = new Asiakas(asiakas.getId(), asiakas.getName(), asiakas.getyTunnus());
        return a;
    }   
    
     /**
     * poistetaan asiakas
     * @param event
     * @throws IOException 
     */
  
    @Override
    public void delete(String name) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Customer WHERE name = ?");

        stmt.setString(1, name);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
    
}
