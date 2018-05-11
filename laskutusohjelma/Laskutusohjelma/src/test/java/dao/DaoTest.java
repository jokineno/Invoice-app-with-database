/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import laskutusohjelma.dao.AsiakasDao;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.Customer;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author ollijokinen
 */
public class DaoTest {
    private FileAsiakasDao asiakasDao;
    private FileUserDao userDao;
    private Connection conn;
    private SQLiteDatabase database;
    private Customer customer;
    private User user;
    
    public DaoTest() {
        
    }
  
    
    @Before
    public void setUp() throws SQLException, IOException {
        //create database for tests
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String databaseFile = properties.getProperty("testDatabaseFile");
        SQLiteDatabase database = new SQLiteDatabase(databaseFile);
        userDao = new FileUserDao(database);
        asiakasDao = new FileAsiakasDao(database);
        database.createTables();
        customer = new Customer (1, "testi", "123-4");
        user = new User ("testi", "testiUser", "1234-5", "fi1234");
        asiakasDao.createCustomer(customer);
        userDao.create(user);
    }
    
    @After
    public void tearDown() throws SQLException {
        asiakasDao.deleteAll();
    }
    
    
    @Test
    public void yNumberTest() throws SQLException {
        assertEquals("123-4", asiakasDao.findYNumber(customer.getName()));
    }
    
    @Test
    public void customerTest() throws SQLException {
       assertTrue(1 == asiakasDao.findAll().size());
       assertEquals(0, asiakasDao.findAll().size());
    }
    
   
    
    @Test
    public void findBank() throws SQLException {
        assertEquals("fi1234", userDao.returnBankAccount("testiUser"));
    }
    
    @Test
    public void userYNumber() throws SQLException {
        assertEquals("1234-5", userDao.returnYNumber("testiUser"));
    }
    
    @Test
    public void username() throws SQLException {
        assertEquals("testiUser", userDao.returnUsernameByName("testi"));
    }
    
    
    @Test 
    public void findUsername() throws SQLException {
        assertEquals(true, userDao.findByUsername("testiUser"));
        assertEquals(false, userDao.findByUsername("fdasljk"));
    }
    
    
    
    @Test 
    public void deleteAll() throws SQLException {
        userDao.deleteAll();
        assertEquals(false, userDao.findByUsername("testiUser"));
    }
    
    @Test
    public void userTest1() throws SQLException {
        User newUser = new User("a", "b", "c", "d");
        userDao.create(newUser);
        assertEquals(true, userDao.findByUsername("b"));
        User newUser2 = new User("1", "b", "2", "3");
        userDao.save(newUser2);
        assertEquals(true, userDao.findByUsername("b"));
        assertEquals("1", userDao.returnNameByUsername("b"));
    }
    
    
    
    
    
    
    
     
    
    

    
    
    
}
