/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import laskutusohjelma.domain.Customer;
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
public class CustomerTest {
    private Customer customer;
    
    public CustomerTest() {
        customer = new Customer (1, "test", "12356-7");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructor() {
        assertEquals("test", customer.toString());
    }
    
    @Test
    public void yNumberTest() {
        assertEquals("12356-7", customer.getyTunnus());
    }
    
    @Test
    public void nameTest() {
        assertEquals("test", customer.getName());
    }
}
