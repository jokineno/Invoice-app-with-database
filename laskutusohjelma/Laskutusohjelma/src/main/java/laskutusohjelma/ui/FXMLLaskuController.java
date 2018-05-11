package laskutusohjelma.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import laskutusohjelma.domain.Customer;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.Product;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 * FXML Controller class
 * InvoiceScene
 * @author ollijokinen
 */
public class FXMLLaskuController implements Initializable {
    private InvoiceService invoiceService;
    private Paaohjelma application;
    private SQLiteDatabase database;  
    private User user;
    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField receiver;
    @FXML private TextField yNumber;
    @FXML private TextField product;
    @FXML private TextField pricePerUnit;
    @FXML private TextField amount;
    @FXML private TextField vat;
    @FXML private TextField finalPrice;
    @FXML private TextField date;
    @FXML private TextArea message;
    @FXML private ComboBox drop;
    @FXML private Label welcomeuser;
    @FXML private TextField customerName;
    @FXML private TextField customerYNumber;
    @FXML private TextField namethepdf;
    
    /**
     * sets invoice service
     * @param invoiceService user input
     */
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    /**
     * sets application
     * @param application user input
     */
    public void setApplication(Paaohjelma application) {
        this.application = application;
    }
    
    /**
     * fills the username text in left upper corner
     * @throws SQLException database error catch
     */
    public void initData() throws SQLException {
        welcomeuser.setText(invoiceService.getLoggedInUsername());
    }
    
    /**
     * fills the combobox with customers
     * @throws SQLException database error catch
     */
    public void fillComboBox() throws SQLException {
       drop.setItems(invoiceService.fillComboBox());
    }
    
    /**
     * fills the receiver and ynumber textfields based on a combobox selection
     * @throws SQLException database error catch
     */
    public void fillReceiverAndYNumber() throws SQLException {
        drop.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> receiver.setText(newValue.toString()));
      
        drop.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            try {
                yNumber.setText(invoiceService.findYNumber(newValue.toString()));
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
    
    /**
     * if user adds a new customer a combobox gets updated
     * @param event used only to build scene without main methods
     * @throws IOException connection error
     * @throws SQLException database error catch
     */
    @FXML
    public void customerSelected(ActionEvent event) throws IOException, SQLException {
        application.setInvoiceScene();
    }
    
    /**
     * user clicks logout and moves to a login scene
     * @param event used only to build scene without main methods
     * @throws IOException input output catched
     */
    @FXML
    public void logoutPressed(ActionEvent event) throws IOException {
        application.setLoginScene();
    }
    
    
    
    /**
     * user clics profile and moves to a profile scene
     * @param event used only to build scene without main methods
     * @throws IOException io error
     * @throws SQLException database exception
     */
    @FXML
    public void profilePressed(ActionEvent event) throws IOException, SQLException {
        application.setProfileScene2();
        
    }
   
    
    /**
     * user clicks create invoice and program generates a new pdf invoice based on user details and textfield inputs
     * @param event used only to build scene without main methods
     * @throws IOException input output error
     * @throws SQLException  database error
     */
    @FXML
    public void createPdfInvoicePressed(ActionEvent event) throws IOException, SQLException {
        System.out.println("create pdf pressed");
        
        if (invoiceService.checkTextFields(pricePerUnit.getText(), amount.getText(), vat.getText(), finalPrice.getText())) {
            //textfields
            String receive = receiver.getText();
            String yNumber1 = yNumber.getText();
            String product1 = product.getText();
            
            Double ppu = Double.parseDouble(pricePerUnit.getText());
            Double amount1 = Double.parseDouble(amount.getText());
            Integer vat1 = Integer.parseInt(vat.getText());
            Double final1 = Double.parseDouble(finalPrice.getText());
        
            CharSequence date1 = date.getCharacters();
            String message1 = message.getText();
            String pdfname = namethepdf.getText();
            
            Product newProduct = new Product(product1, vat1,  final1, amount1, ppu,message1, date1);
            User user = invoiceService.returnUserByUsername(invoiceService.getLoggedInUsername());
            Customer customer = new Customer(1, receive, yNumber1);
        
            invoiceService.createPDF(pdfname, newProduct, user, customer);
        }
        
        
       
        
        
        
    }
    
    /**
     * creates a new customer
     * @return Customer
     */
    public Customer addCustomer() {
       return new Customer (1,customerName.getText(), customerYNumber.getText());
    }
    
    /**
     * uploads an added customer into a combobox
     * @param event used only to build scene without main methods
     * @throws IOException input output error catched
     * @throws SQLException database error
     */
    public void addCustomerPressed(ActionEvent event) throws IOException, SQLException {
        invoiceService.addNewCustomer(addCustomer());
        application.setInvoiceScene2();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
