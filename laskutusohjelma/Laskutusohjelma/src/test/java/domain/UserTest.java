package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class UserTest {
    private User user;
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new User ("Olli", "Ollero", "1234567-8", "FI98 1234 1234 1234 12");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test 
    public void constructrorTest() {
        assertEquals("name: Olli, username: Ollero, yTunnus: 1234567-8, tilinumero: FI98 1234 1234 1234 12", user.toString());
    }
    
    @Test 
    public void getNameTest() {
        assertEquals("Olli", user.getName());
    }
    
    @Test 
    public void getUsernameTest() {
        assertEquals("Ollero", user.getUsername());
    }
    
    @Test 
    public void getYNumber() {
        assertEquals("1234567-8", user.getYtunnus());
    }
    
    @Test 
    public void getBank() {
        assertEquals("FI98 1234 1234 1234 12", user.getTilinumero());
    }
    
    
}
