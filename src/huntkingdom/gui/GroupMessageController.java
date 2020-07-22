/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class GroupMessageController implements Initializable {

    @FXML
    private ScrollPane spDisplayMessage;
    @FXML
    private JFXTextArea tfMessage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void onSendMessage(ActionEvent event) {
        HBox hb=new HBox();
        hb.setStyle("-fx-padding: 20;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 1;" 
         + "-fx-border-color: grey;"+"-fx-background-color:white;");
        
        hb.getChildren().add(new Label(tfMessage.getText()));
        spDisplayMessage.setContent(hb);
    }
    
}
