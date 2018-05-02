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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.domain.PDFCreator;

/**
 * FXML Controller class
 *
 * @author ollijokinen
 */
public class FXMLLaskuController implements Initializable {

    /**
     * Initializes the controller class.
     */
   /* 
    @FXML
    private TextField Receiver;
    
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
    private TextField date;
    
    @FXML
    private TextField message;*/
    
    
    
    @FXML
    public void logoutPressed(ActionEvent event) throws IOException {
        System.out.println("user loggin out...");
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Scene scene1View = new Scene(scene1Parent);
        createScene(event,scene1View);
    }
    
    @FXML
    public void profilePressed(ActionEvent event) throws IOException {
        System.out.println("loading profile..");
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLProfile.fxml"));
        Scene scene1View = new Scene(scene1Parent);
        createScene(event,scene1View);
        //this line get stage information
        
    }
    
    @FXML
    public void createPdfInvoicePressed(ActionEvent event) throws IOException {
        //PDFCreator creator = new PDFCreator();
        //creator.runPDF(product, user, customer);
        
        
    }
    
    
    @FXML
    public boolean logInInformation() {
        return true;
    }
    
    public void createScene(ActionEvent event, Scene newScene) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
