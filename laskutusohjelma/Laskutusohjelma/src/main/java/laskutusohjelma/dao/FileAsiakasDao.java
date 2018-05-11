
package laskutusohjelma.dao;
import java.util.*;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import laskutusohjelma.domain.Customer;
import laskutusohjelma.domain.SQLiteDatabase;

public class FileAsiakasDao implements AsiakasDao<Customer, String> {
    
    final SQLiteDatabase database; 
    
    public FileAsiakasDao(SQLiteDatabase database) {
        this.database = database;
    }
    
     /**
     * etsitään asiakas tietokannasta
     * @param event
     * @throws java.sql.SQLException
     * @throws IOException 
     */
    
    public Integer tableSize() throws SQLException {
        try {
            Connection conn = this.database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM Customer");
            ResultSet rs = stmt.executeQuery();
            Integer tableSize = null;
        
            while (rs.next()) {
                tableSize = rs.getInt(1);
            }
        
        
            return tableSize;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public void createCustomer(Customer customer) throws SQLException {
        try {
            
            Connection conn = this.database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Customer" + " (id, name, yNumber)" +  "VALUES (?,?,?)");
        
        
            stmt.setInt(1, tableSize() + 1);
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getyTunnus());
            stmt.executeUpdate();
        
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String findYNumber(String name) throws SQLException {
        try {
            Connection conn = this.database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT yNumber FROM Customer WHERE name = ?");
            stmt.setObject(1, name);
            ResultSet rs = stmt.executeQuery();
            String yNumber = rs.getString("yNumber");
       
     
            
            rs.close();
            stmt.close();
            conn.close();
        
            return yNumber;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
  /**
     * etsitään kaikki käyttäjät tietokannasta
     * @param event
     * @return 
     * @throws java.sql.SQLException
     * @throws IOException 
     */
    @Override
    public ObservableList<Customer> findAll() throws SQLException {
        try {
            
            Connection conn = this.database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Customer");
        
            ResultSet resultSet = stmt.executeQuery();
            ObservableList<Customer> asiakkaat = FXCollections.observableArrayList();
        
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String ytunnus = resultSet.getString("yNumber");
                Customer a = new Customer(id, name, ytunnus);
                asiakkaat.add(a);
            }
        
            if (asiakkaat.isEmpty()) {
                resultSet.close();
                stmt.close();
                conn.close();
                return null;
            }
            
            resultSet.close();
            stmt.close();
            conn.close();
            return asiakkaat;
            
        } catch (Exception e) {
            System.out.println("ennen");
            System.out.println(e.getMessage());
            System.out.println("jälkeen");
        }
        
        return null;
    }
   
}
