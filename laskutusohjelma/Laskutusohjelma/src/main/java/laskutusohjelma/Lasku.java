/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma;

/**
 *
 * @author ollijokinen
 */
public class Lasku {
    public User lahettaja;
    public User vastaanottaja;
    public double summa;
    public int alv;
    
    public Lasku (User lahettaja, User vastaanottaja, double summa, int alv) {
        this.lahettaja = lahettaja;
        this.vastaanottaja = vastaanottaja;
        this.summa = summa;
        this.alv = alv;
    }
}
