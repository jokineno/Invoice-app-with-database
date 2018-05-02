/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.domain;

/**
 *
 * @author ollijokinen
 */
public class Product {
    private String pname;
    private int vat; 
    private double price;
    
    public Product(String pname, int vat, double price) {
        this.pname = pname;
        this.vat = vat;
        this.price = price;
    }
}
