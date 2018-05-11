
package laskutusohjelma.domain;

/**
 * defines user
 * @author ollijokinen
 */
public class User {
    private String name; 
    private String username; 
    private String yNumber;
    private String bankAccount;
    
    
    /**
     * constructor defines user parameters String, String, String, String
     * @param name name of a user
     * @param username username of a user
     * @param yNumber yNumber of a user
     * @param bankAccount bankAccount of a user
     */
    public User(String name, String username, String yNumber, String bankAccount) {
        this.name = name; 
        this.username = username; 
        this.yNumber = yNumber;
        this.bankAccount = bankAccount;
    }

    /**
     * returns name of a user
     * @return  String
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns username
     * @return String
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * returns yNumber of a user
     * @return String
     */
    public String getYtunnus() {
        return this.yNumber;
    }
    
    /**
     * returns bankAccount of a user
     * @return String
     */
    public String getTilinumero() {
        return this.bankAccount;
    }
    
     
    
    /**
     * prints a user
     * @return String
     */
    public String toString() {
        return "name: " + this.name + ", username: " + this.username + ", yTunnus: " + this.yNumber + ", tilinumero: " + this.bankAccount;
        
    }
}
