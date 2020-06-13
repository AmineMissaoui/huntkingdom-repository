/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.Publication;
import huntkingdom.services.ServicePublication;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author AmineMissaoui
 */
public class UserHomeFXMLController implements Initializable {


    @FXML
    private JFXTextField tfPostTitle;
    @FXML
    private JFXButton btnShare;
    @FXML
    private JFXTextArea taPostDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnShare.setOnAction((event) -> {
            ServicePublication Servicepub = new ServicePublication();
            Publication pub = new Publication();
            pub.setTitle(tfPostTitle.getText());
            pub.setDescription(taPostDescription.getText());
            try {
                Servicepub.addPublication(pub);
            } catch (SQLException ex) {
                System.out.println("error publication" + ex.getMessage());
            }
        });
        // TODO
    }    
    
}
