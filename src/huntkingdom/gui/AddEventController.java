/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.Event;
import huntkingdom.services.ServiceEvent;
import huntkingdom.services.ServiceUser;
import huntkingdom.entities.User;
import huntkingdom.utils.UserSession;
import java.io.IOException;
        
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * 
 */
public class AddEventController  implements Initializable {
    
    @FXML
    private JFXButton btn_valider;
    @FXML
    private JFXButton btn_annuler;
    @FXML
    private JFXTextField TextTitre;
    @FXML
    private JFXTextArea TextDescription;
    @FXML
    private JFXDatePicker DatePickerDepart;
    @FXML
    private JFXDatePicker DatePickerArrivee;
    private JFXComboBox<String> ComboLieuDepart;
    private JFXComboBox<String> ComboLieuArrivee;
    @FXML
    private JFXTextField lieu_depart;
    @FXML
    private JFXTextField lieu_arrivee;
    @FXML
    private JFXTextField nb_place;

    UserSession session;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ComboLieuDepart = new JFXComboBox<>();
        ComboLieuArrivee = new JFXComboBox<>();
        ComboLieuDepart.setEditable(true);
        ComboLieuArrivee.setEditable(true);
        
        btn_annuler.setOnAction((ActionEvent event) -> {
            
            try {
                Parent pagePieChart = FXMLLoader.load(getClass().getResource("/huntkingdom.gui/AjoutEvent.fxml"));
                Scene scene = new Scene(pagePieChart);
                Stage stage = (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.close();
                
            } catch (IOException ex) {
                System.out.println("error");
                //Logger.getLogger(NoterViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_valider.setOnAction((ActionEvent event) -> {
            
            Event evenement = new Event();
            evenement.setCreateur(session.getId());//connected user ? 
            evenement.setTitre(String.valueOf(TextTitre.getText()));
            evenement.setDescription(String.valueOf(TextDescription.getText()));
            evenement.setnbPlace(Integer.valueOf(nb_place.getText()));
            //date_depart mnin jebneha
            java.util.Date date_depart = java.sql.Date.valueOf(DatePickerDepart.getValue());
            evenement.setJour_de_depart((java.sql.Timestamp) date_depart);
            
            java.util.Date date_arrive = java.sql.Date.valueOf(DatePickerArrivee.getValue());
            evenement.setJour_de_retour((java.sql.Timestamp) date_arrive);
            
            ServiceEvent es = new ServiceEvent();
            try {
                es.addevents(evenement);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("event added");
            
            try {
                Parent pagePieChart = FXMLLoader.load(getClass().getResource("/gestionrandonnee/views/AjoutRandonneeView.fxml"));
                Scene scene = new Scene(pagePieChart);
                Stage stage = (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.close();

                // creer notification
                /*Notifications notificationBuilder = Notifications.create()
                        .title("Evennement ajouté avec success")
                        .text("Merci!!!")
                        .graphic(null)
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.darkStyle();
                notificationBuilder.showConfirm();*/

                //fin creation notification
            } catch (IOException ex) {
                System.out.println("error");
                //Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
}
