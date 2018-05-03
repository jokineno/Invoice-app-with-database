package laskutusohjelma.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.dao.AsiakasDao;
import laskutusohjelma.domain.Asiakas;
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
    
    /**
     * käyttäjä voi laskunäkymästä kirjautua ulos
     * @param event
     * @throws IOException 
     */
    
    
    @FXML
    public void logoutPressed(ActionEvent event) throws IOException {
        System.out.println("user loggin out...");
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Scene scene1View = new Scene(scene1Parent);
        createScene(event, scene1View);
    }
    
    /**
     * käyttäjä voi muokata profiilin tietoja painamalla profile
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void profilePressed(ActionEvent event) throws IOException {
        System.out.println("loading profile..");
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLProfile.fxml"));
        Scene scene1View = new Scene(scene1Parent);
        createScene(event, scene1View);
        //this line get stage information
        
    }
     /**
     * käyttäjä klikkaa create pdf invoice ja uusi lasku luodaan
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void createPdfInvoicePressed(ActionEvent event) throws IOException {
        System.out.println("create pdf pressed");
        String receive = receiver.getText();
        String yNumber1 = yNumber.getText();
        String product1 = product.getText();
        CharSequence ppu = pricePerUnit.getCharacters();
        Double amount1 = Double.parseDouble(amount.getText());
        Integer vat1 = Integer.parseInt(vat.getText());
        Double final1 = Double.parseDouble(finalPrice.getText());
        CharSequence date1 = date.getCharacters();
        String message1 = message.getText();
        
        
        Product newProduct = new Product(product.getText(), vat1, final1, amount1, message1, date1);
        User user = new User("olli", "ollinfirma", "123456-7", "fi98 1234 1234 1234 12");
        Asiakas customer = new Asiakas(1, receive, yNumber1);
        
        PDFCreator creator = new PDFCreator();
        creator.runPDF(newProduct, user, customer);
        
        
    }
    
    @FXML
    public void selectCustomerPressed(ActionEvent event) {
        
    }
    
     /**
     * testataan onko käyttäjän antamat tunnukset ok
     * @param event
     * @throws IOException 
     */
    
    
    @FXML
    public boolean logInInformation() {
        return true;
    }
    
     /**
     * vältetään toisteista koodia. Luodaan uusi scene
     * @param event
     * @throws IOException 
     */
    public void createScene(ActionEvent event, Scene newScene) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
