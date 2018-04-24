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
import laskutusohjelma.domain.Asiakas;
import laskutusohjelma.domain.SQLiteDatabase;

public class AsiakasDao implements Dao<Asiakas, Integer> {
    
    final SQLiteDatabase database; 
    
    public AsiakasDao(SQLiteDatabase database) {
        this.database = database;
    }
    
    @Override
    public Asiakas findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Asiakas WHERE id = ?");
        stmt.setInt(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Asiakas a = new Asiakas(rs.getInt("id"), rs.getString("name"),
            rs.getString("ytunnus"));
  
        stmt.close();
        rs.close();

        conn.close();

        return a;
        
    }

    @Override
    public List<Asiakas> findAll() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ASIAKAS");
        
        ResultSet resultSet = stmt.executeQuery();
        
        List<Asiakas> asiakkaat = new ArrayList<>();
        
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String ytunnus = resultSet.getString("ytunnus");
            Asiakas a = new Asiakas(id, name, ytunnus);
            asiakkaat.add(a);
            
        }
        if (asiakkaat.isEmpty()) {
            return null;
        }
        return asiakkaat;
    }

    @Override
    //ensiksi vain tallennetaan myöhemmin voidaan myös muokata
    public Asiakas save(Asiakas asiakas) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Asiakas" + " (id, name, ytunnus)" +  "VALUES (?,?,?)");
        
        stmt.setInt(1, asiakas.getId());
        stmt.setString(2, asiakas.getName());
        stmt.setString(3, asiakas.getyTunnus());
        
        Asiakas a = new Asiakas(asiakas.getId(), asiakas.getName(), asiakas.getyTunnus());
        return a;
    }
  
    @Override
    public void delete(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Asiakas WHERE id = ?");

        stmt.setInt(1, key);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
    
}
