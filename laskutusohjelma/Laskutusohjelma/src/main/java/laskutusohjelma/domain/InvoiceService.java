/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.domain;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import laskutusohjelma.dao.AsiakasDao;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.dao.UserDao;

/**
 *
 * @author ollijokinen
 */
public class InvoiceService  {
    private FileUserDao userDao;
    private FileAsiakasDao asiakasDao;
    private SQLiteDatabase database;
    private PDFCreator pdfcreator;
    private String username;
    
       
    public InvoiceService (FileUserDao userDao, FileAsiakasDao asiakasDao) {
        this.userDao = userDao;
        this.asiakasDao = asiakasDao;
        this.database = new SQLiteDatabase();
        this.username = username;
    }
    
    
    public  void initializeDatabase() throws SQLException {
        this.database.getConnection();
    }
    
   
    public boolean loginCheck(String username) throws SQLException {
        if (userDao.findByUsername(username)) {
            return true;
        }else {
            return false;
        }
    }
   
    
    public String getLoggedInUsername() {
        return this.username;
    }
    public void setLoggedInUsername(String username) {
        this.username = username;
    }
    
    public String returnNameByUsername(String username) throws SQLException {
        return this.userDao.returnNameByUsername(username);
    }
    
    public void createUser(User user) throws SQLException {
        this.userDao.create(user);
    }
    
    public void addNewCustomer(Asiakas customer) throws SQLException {
        this.asiakasDao.createCustomer(customer);
    }
    
    public String bankAccount(String username) throws SQLException {
        return this.userDao.returnBankAccount(username);
    }
    
    public String returnYNumber (String username) throws SQLException {
        return this.userDao.returnYNumber(username);
    }
    
    public ObservableList<Asiakas> fillComboBox() throws SQLException {
        return this.asiakasDao.findAll();
    }
    
    public String findYNumber(String name) throws SQLException {
        return this.asiakasDao.findYNumber(name).toString();
    }
    
    public void saveChanges(User user) throws SQLException {
        this.userDao.save(user);
    }
    
    
        
        
        

    
}
