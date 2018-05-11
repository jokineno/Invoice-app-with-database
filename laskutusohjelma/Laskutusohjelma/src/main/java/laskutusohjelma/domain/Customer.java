
package laskutusohjelma.domain;

/**
 * Customer class defines customer
 * @author ollijokinen
 */
public class Customer {
    private Integer id;
    private String name; 
    private String yNumber;
    
    /**
     * Customer is created with three parameters integer, string, string
     * @param id Integer
     * @param name String
     * @param yNumber String
     */
    public Customer(Integer id, String name, String yNumber) {
        this.id = id;
        this.name = name;
        this.yNumber = yNumber;
    }

    /**
     * get name of a customer
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * get yNumber of a Customer
     * @return String
     */
    public String getyTunnus() {
        return this.yNumber;
    }
    
    /**
     * returns just name of a customer, not id or yNumber
     * @return String
     */
    @Override
    public String toString() {
        return "" + this.name;
    }
}
