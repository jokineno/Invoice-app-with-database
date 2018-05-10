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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.dao.AsiakasDao;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.dao.UserDao;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.SQLiteDatabase;

/**
 *
 * @author ollijokinen
 */
public class FXMLController implements Initializable {
    private SQLiteDatabase database;
    private InvoiceService invoiceService;
    private Paaohjelma application;
    
    @FXML
    private TextField username;
    
   
    
    /*
    When you call this method, you'll login and change the scene to scene2 where you can
    create an invoice. 
    */
    
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    public void setApplication(Paaohjelma application) {
        this.application = application;
    }

    
    /**
     * loginPressed metodia kutsutaan, kun käyttäjä painaa login etusivulla. Jos tunnus on validi, niin käyttäjä kirjautuu
     * jos käyttäjätunnus on olemassa, niin lasku-sivu tervehtii "welcome pena" tms. 
     * Se myös siirtää kirjautuneen tiedot profile näkymään. 
     * @param event
     * @throws IOException 
     */
    
    
    @FXML
    public void loginPressed(ActionEvent event) throws IOException, SQLException {
            if(invoiceService.loginCheck(username.getText())) {
                invoiceService.setLoggedInUsername(username.getText());
                application.setInvoiceScene2();
            }else {
                System.out.println("NOT GONNA HAPPEN!!");
            }
            
            
            
           
    }
    
    /**
     * kun käyttäjä painaa signup niin kirjaudutaan signup sivula
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void signUpPressed(ActionEvent event) throws IOException {
        System.out.println("Signup pressed...");
        application.setSignUpScene();
    }
    
    /**
     * createscene luo uuden scenen - vältetään copypaste koodia
     * @param event
     * @throws IOException 
     */
    
    /*public void createScene(ActionEvent event, Scene newScene) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }*/
    
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Loading user data....");
        System.out.println("Creating database for users and customers");
        
    }    
    
}
