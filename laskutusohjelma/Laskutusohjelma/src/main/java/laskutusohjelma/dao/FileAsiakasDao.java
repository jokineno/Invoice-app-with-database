
package laskutusohjelma.dao;
import java.util.*;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import laskutusohjelma.domain.Customer;
import laskutusohjelma.domain.SQLiteDatabase;

/**
 * creates methods that are defined in asiakasDao
 * @author ollijokinen
 */
public class FileAsiakasDao implements AsiakasDao<Customer, String> {
    
    final SQLiteDatabase database; 
    
    public FileAsiakasDao(SQLiteDatabase database) {
        this.database = database;
    }
    
    /**
     * Counts a tableSize of a CustomerTable. It is used to generate a new id for a customer.
     * @return Integer
     * @throws SQLException database error catched
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
            
            rs.close();
            stmt.close();
            conn.close();
        
            return tableSize;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * creates a new customer. Used
     * @param customer user input in an invoiceScene
     * @throws SQLException database error catched
     */
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
    
    /**
     * searches customer yNumber by customer name
     * @param name user input
     * @return String
     * @throws SQLException database error catch
     */
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
     * finds all the customers. Used in invoiceService in order to fill a comboBox
     * @return ObservableList
     * @throws SQLException database error catched
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
    
    /**
     * deletes all data from database
     * @throws SQLException database connection error
     */
    public void deleteAll() throws SQLException {
        PreparedStatement getTables = this.database.getConnection().prepareStatement("SELECT name FROM sqlite_master WHERE type='table'");
        ResultSet tablesRs = getTables.executeQuery();

        List<String> tables = new ArrayList<>();

        while (tablesRs.next()) {
            tables.add(tablesRs.getString("name"));
        }

        for (String table : tables) {
            PreparedStatement dropTable = this.database.getConnection().prepareStatement("DROP TABLE IF EXISTS " + table);
            dropTable.execute();
            dropTable.close();
        }
        
        tablesRs.close();
        this.database.closeConnection();
        
        
        
        
    
    }
   
}
