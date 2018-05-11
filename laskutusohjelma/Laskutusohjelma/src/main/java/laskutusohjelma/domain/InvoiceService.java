
package laskutusohjelma.domain;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import laskutusohjelma.dao.AsiakasDao;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.dao.UserDao;

/**
 * Invoice Service provides logical methods for a program
 * @author ollijokinen
 */
public class InvoiceService  {
    private FileUserDao userDao;
    private FileAsiakasDao asiakasDao;
    private SQLiteDatabase database;
    private PDFCreator pdfcreator;
    private String username;
    
       /**
        * 
        * @param userDao Methods for searching and saving users
        * @param asiakasDao Methods for searching and saving customers
        * @param database Connection to a database
        */
    public InvoiceService(FileUserDao userDao, FileAsiakasDao asiakasDao, SQLiteDatabase database) {
        this.userDao = userDao;
        this.asiakasDao = asiakasDao;
        this.database = database;
        this.username = username;
        this.pdfcreator = new PDFCreator();
    }
    
    
    /**
     * creates database tables user and customer
     * @throws SQLException database error catched
     */
    public void createTables() throws SQLException {
        this.database.createTables();
    }
    
    /**
     * checks if username exists. This is used in login page.
     * @param username user input
     * @return true or false. If true user logs in. If false user have try another username
     * @throws SQLException database error catched
     */
    public boolean loginCheck(String username) throws SQLException {
        return userDao.findByUsername(username);
    }
    
    /**
     * return username of a user logged in
     * This is used to get data from user table. When username is available, user can search yNumber and bankaccount.
     * @return String username
     */
    public String getLoggedInUsername() {
        return this.username;
    }
    
    /**
     * sets logged in username into a invoiceService constructor.
     * User can get is by using getLoggedInUsername() method
     * @param username user input
     */
    public void setLoggedInUsername(String username) {
        this.username = username;
    }
    
    /**
     * Returns name by username. Searches a given name from a database.
     * @param username user's input
     * @return username
     * @throws SQLException database error catched
     */
    public String returnNameByUsername(String username) throws SQLException {
        return this.userDao.returnNameByUsername(username);
    }
    
    /**
     * Creates user into a database
     * @param user user's input
     * @throws SQLException database error catched
     */
    public void createUser(User user) throws SQLException {
        this.userDao.create(user);
    }
    
    /**
     * Adds a new customer into a ComboBox in Invoice Scene
     * @param customer user's input. Its parameters are streamed from textfields. Id is generated. 
     * @throws SQLException database error catched
     */
    public void addNewCustomer(Customer customer) throws SQLException {
        this.asiakasDao.createCustomer(customer);
    }
    
    /**
     * Searching bankaccount by a username. This is used in profile view. With this method the pdf file gets bankaccount without filling a form
     * @param username user input
     * @return bankaccountnumber String
     * @throws SQLException database error catched
     */
    public String bankAccount(String username) throws SQLException {
        return this.userDao.returnBankAccount(username);
    }
    
    /**
     * Searches yNumber by Username
     * @param username user input
     * @return String yNumber or just null
     * @throws SQLException database error catch
     */
    public String returnYNumber(String username) throws SQLException {
        return this.userDao.returnYNumber(username);
    }
    
    /**
     * Lists all the Customers into a combobox. 
     * @return ObservableList 
     * @throws SQLException database error catched
     */
    public ObservableList<Customer> fillComboBox() throws SQLException {
        return this.asiakasDao.findAll();
    }
    
    /**
     * Searches yNumber by a name from a database
     * @param name user input
     * @return yNumber or null
     * @throws SQLException database error catched
     */
    public String findYNumber(String name) throws SQLException {
        return this.asiakasDao.findYNumber(name);
    }
    
    /**
     * saves changes based on user input in a profile view 
     * @param user user input formed from profile view's textfields
     * @throws SQLException database error catched
     */
    public void saveChanges(User user) throws SQLException {
        this.userDao.save(user);
        
    }
    
    /**
     * Returns user by username. Searches all user parameters by username. 
     * @param username1 user input
     * @return User
     * @throws SQLException database error catched
     */
    public User returnUserByUsername(String username1) throws SQLException {
        String name = this.userDao.returnNameByUsername(username1);
        String yNumber = this.userDao.returnYNumber(username1);
        String accountNumber = this.userDao.returnBankAccount(username1);
        return new User(name, username1, yNumber, accountNumber);
                
    }
    
    /**
     * Creates pdf file. Used in order to create an invoice
     * @param pdfName user input - textfield
     * @param productName user input - textfield
     * @param user user input
     * @param customer user input
     * @throws IOException database error catched
     */
    public void createPDF(String pdfName, Product productName, User user, Customer customer) throws IOException {
        
        if (pdfName.equals("")) {
            this.pdfcreator.runPDF("newInvoice" + productName.getDate(), productName, user, customer);
        } else {
            this.pdfcreator.runPDF(pdfName, productName, user, customer);
        }
    }
    
    /**
     * Checks if Textfields have a right formatting. Price per unit - double, Amount - Double, Vat - Integer, FinalPrice - double
     * @param ppu user input in double format
     * @param amount user input in double format
     * @param vat user input in integer format
     * @param finalPrice user input in double format
     * @return true if text fields are ok. false if not
     */
    public boolean checkTextFields(String ppu, String amount, String vat, String finalPrice) {
        
        try {
            Double.parseDouble(ppu);
            Double.parseDouble(amount);
            Integer.parseInt(vat);
            Double.parseDouble(finalPrice);
        } catch (NumberFormatException e) {
            System.out.println("CHECK YOU NUMBER FORMATTING!");
            return false;
        }
        return true;
    }
    
    
        
        
        

    
}
