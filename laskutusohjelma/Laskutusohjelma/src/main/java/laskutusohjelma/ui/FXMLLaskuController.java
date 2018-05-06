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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
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
    private FileUserDao userDao;
    private FileAsiakasDao asiakasDao;
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
    
    @FXML TextField customerYNumber;
    
    
    /**
     * käyttäjä voi laskunäkymästä kirjautua ulos
     * @param event
     * @throws IOException 
     */
    
    public void initData(String user) {
        welcomeuser.setText(user);
    }
    
    public void fillComboBox() throws SQLException {
        asiakasDao = new FileAsiakasDao(database);
        drop.setItems(asiakasDao.findAll());
        
    }
    
    //fill form according to a name selected.
   
    
    @FXML
    public void customerSelected(ActionEvent event) throws IOException, SQLException {
        
        asiakasDao = new FileAsiakasDao(database);
        String welcomeText = welcomeuser.getText();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Parent scene2Parent = loader.load();
        Scene scene2View = new Scene(scene2Parent);
        FXMLLaskuController controller = loader.getController();
        controller.initData(welcomeText);
        controller.fillComboBox();
        controller.receiver.setText(drop.getValue().toString());
        controller.yNumber.setText(asiakasDao.findYNumber(drop.getValue().toString()));
        createScene(event,scene2View);
        
    }
    
    
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
    public void profilePressed(ActionEvent event) throws IOException, SQLException {
        System.out.println("loading profile..");
        
        
        userDao = new FileUserDao(database);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Profile.fxml"));
        Parent scene1Parent = loader.load();
        Scene scene1View = new Scene(scene1Parent);
        
        ProfileController controller = loader.getController();
        
        String companyForProfile = userDao.returnUsername(welcomeuser.getText());
        String bankAccountForProfile = userDao.returnBankAccount(welcomeuser.getText());
        String yNumberForProfile = userDao.returnYNumber(welcomeuser.getText());
        
        
        
        
        controller.initDataToProfile(companyForProfile, bankAccountForProfile, yNumberForProfile);
        controller.initUserName(welcomeuser.getText());
        
        
        createScene(event, scene1View);
       
        
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
        
        
        Product newProduct = new Product(product1   , vat1, final1, amount1, message1, date1);
        User user = new User("olli", "ollinfirma", "123456-7", "fi98 1234 1234 1234 12");
        Asiakas customer = new Asiakas(1, receive, yNumber1);
        
        PDFCreator creator = new PDFCreator();
        creator.runPDF(newProduct, user, customer);
        
    }
    
    public void addCustomerPressed(ActionEvent event) throws IOException, SQLException {
        asiakasDao = new FileAsiakasDao(database);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Parent scene1Parent = loader.load();
        Scene scene1View = new Scene(scene1Parent);
        
        FXMLLaskuController controller = loader.getController();
        
        //id is 1 but it's calculated by the size of customer table in fileasiakasdao
        Asiakas customer = new Asiakas (1,customerName.getText(), customerYNumber.getText());
        asiakasDao.createCustomer(customer);
        controller.fillComboBox();
        controller.welcomeuser.setText(welcomeuser.getText());
        
        //receiver and ynumber dont get updated
        controller.receiver.setText(receiver.getText());
        controller.yNumber.setText(yNumber.getText());
        
        
        createScene(event,scene1View);
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
