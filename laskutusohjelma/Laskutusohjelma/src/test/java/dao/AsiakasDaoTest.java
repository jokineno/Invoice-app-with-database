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
import laskutusohjelma.domain.Customer;
import laskutusohjelma.domain.SQLiteDatabase;
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
public class AsiakasDaoTest {
    private FileAsiakasDao asiakasDao;
    private File tempFile;
    private Connection conn;
    private SQLiteDatabase database;
    
    public AsiakasDaoTest() {
        //database = new SQLiteDatabase();
        //asiakasDao = new FileAsiakasDao();
    }
    
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException, IOException {
        /*
        this.database.getConn().prepareStatement("CREATE TABLE IF NOT EXISTS User"
            + "(name String NOT NULL, username String NOT NULL PRIMARY KEY,"
            + " yNumber String,"
            + " accountNumber String)");
        
        Customer customer = new Customer(1, "testCustomer", "1235-6");
        asiakasDao.createCustomer(customer);*/
    }
    
    @After
    public void tearDown() {
        //tempFile.delete();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void yNumberTest() {
        
    }
}
