/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.Customer;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollijokinen
 */
public class InvoiceServiceDao {
    private FileAsiakasDao asiakasDao;
    private FileUserDao userDao;
    private Connection conn;
    private SQLiteDatabase database;
    private Customer customer;
    private User user;
    private InvoiceService invoiceService;
    private String username;
    
    public InvoiceServiceDao() {
        this.username = username;
    }
    
    
    @Before
    public void setUp() throws IOException, SQLException {
        //create database for tests
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String databaseFile = properties.getProperty("testDatabaseFile2");
        SQLiteDatabase database = new SQLiteDatabase(databaseFile);
        userDao = new FileUserDao(database);
        asiakasDao = new FileAsiakasDao(database);
        
        invoiceService = new InvoiceService(userDao, asiakasDao, database);
        
        invoiceService.createTables();
        user = new User("testi", "testiUser", "123-4", "fi123");
        customer = new Customer (1, "testi", "123");
        invoiceService.createUser(user);
        invoiceService.addNewCustomer(customer);
        
        
    }
    
    @After
    public void tearDown() throws SQLException {
        //invoiceService.deleteAll();
    }
    
    @Test
    public void createUser() throws SQLException {
        assertEquals(true, invoiceService.loginCheck("testiUser"));
    }
    
    @Test
    public void loggedIn() throws SQLException {
        invoiceService.setLoggedInUsername("123");
        assertEquals("123", invoiceService.getLoggedInUsername());
    }
    
    @Test
    public void userInfo() throws SQLException {
        assertEquals("123-4", invoiceService.bankAccount("testiUser"));
        assertEquals("fi123", invoiceService.returnYNumber("testiUser"));
        assertEquals("testi", invoiceService.returnNameByUsername("testiUser"));
    }
    
    @Test
    public void customerInfo() throws SQLException {
        assertEquals("123", invoiceService.findYNumber("testi"));
        
    }
    
  

    
}
