/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
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
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti kortti2;
    Maksukortti kortti3;
    
    
    public KassapaateTest() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(300);
        kortti2 = new Maksukortti(200);
        kortti3 = new Maksukortti(500);
        
    }
    
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);      
    }
    
    @Test
    public void oikeaRahamaara() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test 
    public void myydytMaukkaatLounaat() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    public void myydytEdullisetLounaat() {
        kassa.syoEdullisesti(240); 
        kassa.syoEdullisesti(240); 
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoToimii() {
        kassa.syoEdullisesti(240);
        kassa.syoMaukkaasti(400);
        assertEquals(100640, kassa.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahanMaara() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahatEiRiiata() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0,kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortillaTarpeeksiRahaa() {
        kassa.syoEdullisesti(kortti);
        assertTrue(1==1);
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa() {
        kassa.syoMaukkaasti(kortti);
        assertFalse(1==2);
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(300, kortti.saldo());
    }
    
    @Test
    public void kortilleLadataanRahaa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(400, kortti.saldo());
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa2() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(200, kortti2.saldo());
    }
    
    @Test 
    public void kortillaRiittavastiRahaa() {
        kassa.syoMaukkaasti(kortti3);
        assertEquals(100, kortti3.saldo());
    }
    
    @Test
    public void lataaNegatiivinenSumma() {
        kassa.lataaRahaaKortille(kortti, -5);
        assertEquals(300, kortti.saldo());
    }
    
    
    
    
    
    
    
    
    
   /* @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }*/
    
    @Before
    public void setUp() {
    }
   /* 
    @After
    public void tearDown() {
    }*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   /* @Test
    public void hello() {}*/
}