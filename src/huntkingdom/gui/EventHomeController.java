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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Arif Sami
 */
public class EventHomeController implements Initializable {

    @FXML
    private TabPane tabpane;
    @FXML
    private Tab tabEvent;
    @FXML
    private Tab tabNewEvent;
    @FXML
    private Pane events;
    @FXML
    private Pane eventnew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowEvent.fxml"));
        try {
            //Pane events = loader.load();
            events.getChildren().add(loader.load());
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        tabEvent.setContent(events);
        tabEvent.getContent();
        
        FXMLLoader l = new FXMLLoader(getClass().getResource("AddEvent.fxml"));
        try {
            //Pane eventnew = l.load();
            eventnew.getChildren().add(l.load());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        tabNewEvent.setContent(eventnew);
        tabNewEvent.getContent();
    }    
    
}
