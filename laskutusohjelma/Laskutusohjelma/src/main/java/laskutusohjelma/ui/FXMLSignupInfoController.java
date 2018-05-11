
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
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 * FXML Controller class
 * sign up scene
 * @author ollijokinen
 */
public class FXMLSignupInfoController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    private InvoiceService invoiceService;
    private Paaohjelma application;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField companyname;
    
    @FXML
    private TextField accountNumber;
    
    @FXML
    private TextField yNumber;
    
    
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
     * user clicks create a new account. Program creates a new account if textfields are filled properly. 
     * username MUST BE FILLED and username have to UNIQUE
     * @param event used only to build scene without main methods
     * @throws IOException input output error catched
     * @throws SQLException database error cathed
     */
    public void createAccountPressed(ActionEvent event) throws IOException, SQLException {
        System.out.println("Creating an account and signing up...");
        
        User user = new User (companyname.getText(), username.getText(), yNumber.getText(), accountNumber.getText());
        if (username.getText().isEmpty() == false && invoiceService.loginCheck(username.getText()) == false) {
        invoiceService.createUser(user);
        invoiceService.setLoggedInUsername(username.getText());
        application.setInvoiceScene2();
        }else {
            System.out.println("empty username or username is already in use");
        }
    }
    
    /**
     * user clicks back to main and moves to a login scene
     * @param event used only to build scene without main methods
     * @throws IOException input output error catched
     */
    public void backPressed(ActionEvent event) throws IOException {
        System.out.println("back pressed...");
        application.setLoginScene();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
