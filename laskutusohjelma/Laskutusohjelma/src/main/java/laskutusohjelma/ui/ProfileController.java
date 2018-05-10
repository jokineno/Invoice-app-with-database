/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 * FXML Controller class
 *
 * @author ollijokinen
 */
public class ProfileController implements Initializable {
    private FileUserDao userDao;
    private SQLiteDatabase database;
    private InvoiceService invoiceService;
    private Paaohjelma application;

    @FXML
    private TextField accountNumber;
    
    @FXML
    private TextField yNumber;
    
    @FXML
    private TextField name;
    
    @FXML
    private Label username;
    
  
    
    
    
    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    public void setApplication(Paaohjelma application) {
        this.application = application;
    }
    
     /**
     * käyttäjä voi palata laskuihin
     * @param companyname
     * @param event
     * @throws IOException 
     */
    
   
    public void initDataToProfile1() throws SQLException {
        name.setText(invoiceService.returnNameByUsername(invoiceService.getLoggedInUsername()));
        accountNumber.setText(invoiceService.bankAccount(invoiceService.getLoggedInUsername()));
        yNumber.setText(invoiceService.returnYNumber(invoiceService.getLoggedInUsername()));
    }
    
    public void initUserName() {
        username.setText(invoiceService.getLoggedInUsername());
    }
    
    @FXML
    public void saveChangesPressed(ActionEvent event) throws IOException, SQLException {
        
        String newAccountNumber = accountNumber.getText();
        String newYNumber = yNumber.getText();
        String newCompanyname = name.getText();
        User user = new User (newCompanyname, invoiceService.getLoggedInUsername(), newYNumber, newAccountNumber);
        
        invoiceService.saveChanges(user);
        application.setProfileScene2();
        
        /*System.out.println("saving changes...");
        
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Profile.fxml"));
        Parent scene1Parent = loader.load();
        Scene scene1View = new Scene(scene1Parent);
        
        ProfileController controller = loader.getController();
        //userDao = new FileUserDao(database);
        String usernameStaysTheSame = userDao.returnUsernameByname(username.getText());
        String newAccountNumber = accountNumber.getText();
        String newYNumber = yNumber.getText();
        String newCompanyname = name.getText();
        
        User user = new User (newCompanyname, usernameStaysTheSame, newYNumber, newAccountNumber);
        userDao.save(user);
        
        
        //set textfields
        controller.accountNumber.setText(newAccountNumber);
        controller.yNumber.setText(newYNumber);
        controller.name.setText(newCompanyname);
        
        //set left Upper corner name
        controller.username.setText(newCompanyname);
        
        createScene(event, scene1View);*/
    }
    
    
    @FXML
    public void backPressed(ActionEvent event) throws IOException, SQLException {
        //String welcomeNameForInvoiceView = userDao.returnUsername(username);
        application.setInvoiceScene();
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Parent scene1Parent = loader.load();
        Scene scene1View = new Scene(scene1Parent);
        
        FXMLLaskuController controller = loader.getController();
        //controller.initData(username.getText());
        //controller.fillComboBox();
        
        createScene(event, scene1View);*/
    }
    
     /**
     * vältetään toisteista koodia. luodaan uusi scene
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
        //accountNumber.setText("FI12341234123");
        //initData();
    }    
    
}
