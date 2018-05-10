package laskutusohjelma.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.domain.Asiakas;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.PDFCreator;
import laskutusohjelma.domain.Product;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 * FXML Controller class
 *
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
    
   
    @FXML
    private TextField receiver;
    
    @FXML
    private TextField yNumber;
    
   @FXML
    private TextField product;
    
    @FXML
    private TextField pricePerUnit;
    
    @FXML
    private TextField amount;
    
    @FXML
    private TextField vat;
    
    @FXML
    private TextField finalPrice;
    
    @FXML
    private TextField date;
    
    @FXML
    private TextArea message;
    
    @FXML
    private ComboBox drop;
    
    @FXML   
    private Label welcomeuser;
    
    @FXML 
    private TextField customerName;
    
    @FXML 
    private TextField customerYNumber;
    
    @FXML 
    private TextField namethepdf;
    
    
    /**
     * käyttäjä voi laskunäkymästä kirjautua ulos
     * @param event
     * @throws IOException 
     */
    
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    public void setApplication(Paaohjelma application) {
        this.application = application;
    }
    
    public void initData() throws SQLException {
        welcomeuser.setText(invoiceService.getLoggedInUsername());
    }
    
    
    public void fillComboBox() throws SQLException {
       drop.setItems(invoiceService.fillComboBox());
    }
    
    //fill receiver and ynumber textfields based on selection
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
    
   
    
    //fill form based on a selected name
    @FXML
    public void customerSelected(ActionEvent event) throws IOException, SQLException {
        application.setInvoiceScene();
    }
    
    @FXML
    public void logoutPressed(ActionEvent event) throws IOException {
        application.setLoginScene();
    }
    
    /**
     * käyttäjä voi muokata profiilin tietoja painamalla profile
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void profilePressed(ActionEvent event) throws IOException, SQLException {
        
        
       /* String nameForProfile = invoiceService.returnNameByUsername(invoiceService.getLoggedInUsername());
        String bankForProfile = invoiceService.bankAccount(invoiceService.getLoggedInUsername());
        String yForProfile = invoiceService.returnYNumber(invoiceService.getLoggedInUsername());
        */
        application.setProfileScene2();
        
        
        
        /*userDao = new FileUserDao(database);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Profile.fxml"));
        Parent scene1Parent = loader.load();
        Scene scene1View = new Scene(scene1Parent);
        
        ProfileController controller = loader.getController();
        
        String companyForProfile = userDao.returnUsernameByName(welcomeuser.getText());
        String bankAccountForProfile = userDao.returnBankAccount(welcomeuser.getText());
        String yNumberForProfile = userDao.returnYNumber(welcomeuser.getText());
        
        
        
        
        controller.initDataToProfile(companyForProfile, bankAccountForProfile, yNumberForProfile);
        controller.initUserName(welcomeuser.getText());
        
        
        createScene(event, scene1View);*/
       
        
    }
     /**
     * käyttäjä klikkaa create pdf invoice ja uusi lasku luodaan
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void createPdfInvoicePressed(ActionEvent event) throws IOException, SQLException {
        System.out.println("create pdf pressed");
        
        //userDao = new FileUserDao(database);
        String receive = receiver.getText();
        String yNumber1 = yNumber.getText();
        String product1 = product.getText();
        CharSequence ppu = pricePerUnit.getCharacters();
        Double amount1 = Double.parseDouble(amount.getText());
        Integer vat1 = Integer.parseInt(vat.getText());
        Double final1 = Double.parseDouble(finalPrice.getText());
        CharSequence date1 = date.getCharacters();
        String message1 = message.getText();
        String pdfname = namethepdf.getText();
        
        Product newProduct = new Product(product1, vat1, final1, amount1, message1, date1);
        //User user = userDao.returnUserByName(welcomeuser.getText());
        Asiakas customer = new Asiakas(1, receive, yNumber1);
        
        PDFCreator creator = new PDFCreator();
        
        if (pdfname.equals("")) {
        creator.runPDF("newInvoice", newProduct, user, customer);
        }else {
            creator.runPDF(pdfname, newProduct, user, customer);
        }
        
    }
    
    public Asiakas addCustomer() {
       return new Asiakas (1,customerName.getText(), customerYNumber.getText());
    }
    
    public void addCustomerPressed(ActionEvent event) throws IOException, SQLException {
        invoiceService.addNewCustomer(addCustomer());
        application.setInvoiceScene2();
    }
    
    
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
