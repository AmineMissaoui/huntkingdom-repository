/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author AmineMissaoui
 */
public class WecomeFXMLController implements Initializable {

    @FXML
    private Pane welcomePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            welcomePane.getChildren().removeAll();
            welcomePane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(WecomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
