
package laskutusohjelma.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.SQLiteDatabase;

public class FXMLController implements Initializable {
    private SQLiteDatabase database;
    private InvoiceService invoiceService;
    private Paaohjelma application;
    
    @FXML
    private TextField username;
    
    
    
    /**
     * sets invoiceService for a scene
     * @param invoiceService user input
     */
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    /**
     * sets application for a scene
     * @param application user input
     */
    public void setApplication(Paaohjelma application) {
        this.application = application;
    }

    
    /**
     * user clicks log in and logs in username exists
     * @param event used only to build scene without main methods
     * @throws IOException input output exception
     * @throws SQLException database exception
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
     * user clicks signup and moves to a new scene
     * @param event used only to build a scene without main methods
     * @throws IOException input output exception
     */
    @FXML
    public void signUpPressed(ActionEvent event) throws IOException {
        System.out.println("Signup pressed...");
        application.setSignUpScene();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Loading user data....");
        System.out.println("Creating database for users and customers");
        
    }    
    
}
