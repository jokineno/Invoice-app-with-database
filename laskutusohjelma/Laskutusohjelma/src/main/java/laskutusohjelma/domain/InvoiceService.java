
package laskutusohjelma.domain;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import laskutusohjelma.dao.AsiakasDao;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.dao.UserDao;


public class InvoiceService  {
    private FileUserDao userDao;
    private FileAsiakasDao asiakasDao;
    private SQLiteDatabase database;
    private PDFCreator pdfcreator;
    private String username;
    
       
    public InvoiceService(FileUserDao userDao, FileAsiakasDao asiakasDao) {
        this.userDao = userDao;
        this.asiakasDao = asiakasDao;
        this.database = new SQLiteDatabase();
        this.username = username;
        this.pdfcreator = new PDFCreator();
    }
    
    public  void initializeDatabase() throws SQLException {
        try {
            this.database.getConn();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean loginCheck(String username) throws SQLException {
        if (userDao.findByUsername(username)) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getLoggedInUsername() {
        return this.username;
    }
    
    public void setLoggedInUsername(String username) {
        this.username = username;
    }
    
    public String returnNameByUsername(String username) throws SQLException {
        return this.userDao.returnNameByUsername(username);
    }
    
    public void createUser(User user) throws SQLException {
        this.userDao.create(user);
    }
    
    public void addNewCustomer(Customer customer) throws SQLException {
        this.asiakasDao.createCustomer(customer);
    }
    
    public String bankAccount(String username) throws SQLException {
        return this.userDao.returnBankAccount(username);
    }
    
    public String returnYNumber(String username) throws SQLException {
        return this.userDao.returnYNumber(username);
    }
    
    public ObservableList<Customer> fillComboBox() throws SQLException {
        return this.asiakasDao.findAll();
    }
    
    public String findYNumber(String name) throws SQLException {
        return this.asiakasDao.findYNumber(name).toString();
    }
    
    public void saveChanges(User user) throws SQLException {
        this.userDao.save(user);
    }
    
    public User returnUserByUsername(String username1) throws SQLException {
        String name = this.userDao.returnNameByUsername(username1);
        String yNumber = this.userDao.returnYNumber(username1);
        String accountNumber = this.userDao.returnBankAccount(username1);
        return new User(name, username1, yNumber, accountNumber);
                
    }
    
    public void createPDF(String pdfName, Product productName, User user, Customer customer) throws IOException {
        
        if (pdfName.equals("")) {
            this.pdfcreator.runPDF("newInvoice" + productName.getDate(), productName, user, customer);
        } else {
            this.pdfcreator.runPDF(pdfName, productName, user, customer);
        }
    }
    
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
