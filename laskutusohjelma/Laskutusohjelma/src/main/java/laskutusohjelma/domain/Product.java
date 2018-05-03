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
    private double amount;
    private CharSequence message;
    private CharSequence date;
    
    public Product(String pname, int vat, double price, double amount, CharSequence message, CharSequence date) {
        this.pname = pname;
        this.amount = amount;
        this.vat = vat;
        this.price = price;
        this.message = message;
        this.date = date;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public CharSequence getMessage() {
        return this.message;
    }
    
    public void setMessage(CharSequence message) {
        this.message = message;
    }
    
    public CharSequence getDate() {
        return this.date;
    }
    
    
}
