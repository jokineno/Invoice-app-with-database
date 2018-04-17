/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import laskutusohjelma.Asiakas;
import laskutusohjelma.Lasku;
import laskutusohjelma.User;
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
public class LaskuTest {
    
    public LaskuTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void konstruktoriToimii() {
        User user = new User ("Olli Jokinen", "Olli", "1234567-8");
        Asiakas asiakas = new Asiakas (1, "pena", "1234567-8");
        
        Lasku lasku = new Lasku (user, asiakas, 12.5, 24);
        
        assertEquals("Lähettäjä: Olli Jokinen, Vastaanottaja: pena, Summa: 12.5, ALV: 24",lasku.toString());
    }
}
