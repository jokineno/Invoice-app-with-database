
package laskutusohjelma.domain;

/**
 * Defines product class
 * @author ollijokinen
 */
public class Product {
    private String pname;
    private int vat; 
    private double price;
    private double ppu;
    private double amount;
    private CharSequence message;
    private CharSequence date;
    
    /**
     * Defines constuctor
     * @param pname name of the product
     * @param vat VAT%, for example 24% for services
     * @param price final price
     * @param amount how many, how long...
     * @param ppu price per unit
     * @param message sender's message in an invoice
     * @param date a date
     */
    public Product(String pname, int vat, double price, double amount, double ppu, CharSequence message, CharSequence date) {
        this.pname = pname;
        this.amount = amount;
        this.vat = vat;
        this.price = price;
        this.message = message;
        this.date = date;
        this.ppu = ppu;
    }
    
    /**
     * returns product name
     * @return String
     */
    public String getPname() {
        return pname;
    }

    /**
     * return VAT%
     * @return Integer
     */
    public int getVat() {
        return vat;
    }

    /**
     * return final price
     * @return double
     */
    public double getPrice() {
        return price;
    }

   /**
    * returns amount
    * @return double
    */
    public double getAmount() {
        return amount;
    }
    
    /**
     * set amount
     * @param amount user input
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /**
     * returns a message
     * @return CharSequence
     */
    public CharSequence getMessage() {
        return this.message;
    }
    
    /**
     * returns a date
     * @return CharSequence
     */
    public CharSequence getDate() {
        return this.date;
    }
    
    /**
     * return price per unit
     * @return double
     */
    public double getPpu() {
        return this.ppu;
    }
    
    /**
     * returns product name
     * @return String
     */
    @Override
    public String toString() {
        return this.pname;
    }
    
    
}
