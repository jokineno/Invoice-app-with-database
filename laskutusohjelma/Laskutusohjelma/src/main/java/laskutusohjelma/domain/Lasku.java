/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.domain;

import laskutusohjelma.domain.User;

/**
 *
 * @author ollijokinen
 */
// tämän luokan this.lähetetty ei ole vielä modattu testeihin tai mihinkään
public class Lasku {
    private User lahettaja;
    private Asiakas vastaanottaja;
    private double summa;
    private int alv;
    private boolean lahetetty;
    
    public Lasku (User lahettaja, Asiakas vastaanottaja, double summa, int alv) {
        this.lahettaja = lahettaja;
        this.vastaanottaja = vastaanottaja;
        this.summa = summa;
        this.alv = alv;
        this.lahetetty = false;
        
    }
    
    public boolean onkoLahetetty() {
        return this.lahetetty;
    }
    
    public void asetaLahetetyksi() {
        this.lahetetty = true;
    }
    
    //tässä voisi olla myös, että onko maksettu -> voisi tehdä tilastoja
    
    public String toString() {
        return "Lähettäjä: " + this.lahettaja.getName() + ", Vastaanottaja: " + this.vastaanottaja.getName() + ", Summa: " + this.summa + ", ALV: " + this.alv; 
    }
}
