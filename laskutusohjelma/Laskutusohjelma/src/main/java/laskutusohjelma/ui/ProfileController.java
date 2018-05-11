
package laskutusohjelma.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
 * profile scene
 * @author ollijokinen
 */
public class ProfileController implements Initializable {
    private FileUserDao userDao;
    private SQLiteDatabase database;
    private InvoiceService invoiceService;
    private Paaohjelma application;

    @FXML private TextField accountNumber;
    @FXML private TextField yNumber;
    @FXML private TextField name;
    @FXML private Label username;
    
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
     * fills the textfields based on user details
     * @throws SQLException database error catch
     */
    public void initDataToProfile1() throws SQLException {
        name.setText(invoiceService.returnNameByUsername(invoiceService.getLoggedInUsername()));
        accountNumber.setText(invoiceService.bankAccount(invoiceService.getLoggedInUsername()));
        yNumber.setText(invoiceService.returnYNumber(invoiceService.getLoggedInUsername()));
    }
    
    /**
     * fills the username to a upper left corner
     */
    public void initUserName() {
        username.setText(invoiceService.getLoggedInUsername());
    }
    
    /**
     * user clicks save changes and program saves textfield changes for a username
     * @param event used only to build scene without main methods
     * @throws IOException input output error catch
     * @throws SQLException database error catch
     */
    @FXML
    public void saveChangesPressed(ActionEvent event) throws IOException, SQLException {
        
        String newAccountNumber = accountNumber.getText();
        String newYNumber = yNumber.getText();
        String newCompanyname = name.getText();
        User user = new User (newCompanyname, invoiceService.getLoggedInUsername(), newYNumber, newAccountNumber);
        
        invoiceService.saveChanges(user);
        application.setProfileScene2();
        
    }
    
    /**
     * user clicks back and moves to a invoice scene
     * @param event used only to build scene without main methods
     * @throws IOException input output error
     * @throws SQLException database error
     */
    @FXML
    public void backPressed(ActionEvent event) throws IOException, SQLException {
        application.setInvoiceScene();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
