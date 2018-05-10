
package laskutusohjelma.domain;


public class Product {
    private String pname;
    private int vat; 
    private double price;
    private double ppu;
    private double amount;
    private CharSequence message;
    private CharSequence date;
    
    public Product(String pname, int vat, double price, double amount, double ppu, CharSequence message, CharSequence date) {
        this.pname = pname;
        this.amount = amount;
        this.vat = vat;
        this.price = price;
        this.message = message;
        this.date = date;
        this.ppu = ppu;
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
    
    public double getPpu() {
        return this.ppu;
    }
    
    
}
