/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import huntkingdom.entities.Entreprise;
import huntkingdom.entities.User;
import huntkingdom.entities.UserSession;
import huntkingdom.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author AmineMissaoui
 */
public class HomeFXMLController implements Initializable {

    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnCalendar;
    @FXML
    private JFXButton btnEvent;
    @FXML
    private JFXButton btnElearning;
    @FXML
    private JFXButton btnShop;
    @FXML
    private Label labelUserName;
    
    UserSession session;
    @FXML
    private Pane homeCenterPane;

    public HomeFXMLController() {
        session = UserSession.getInstance();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        labelUserName.setText(session.getUsername());
        
                Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("AdminValidationFXML.fxml"));
            homeCenterPane.getChildren().removeAll();
            homeCenterPane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }


    
}
