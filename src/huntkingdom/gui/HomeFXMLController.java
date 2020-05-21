/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import huntkingdom.entities.Entreprise;
import huntkingdom.entities.User;
import huntkingdom.services.ServiceUser;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Pane homePane;
    @FXML
    private Pane homePaneEntreprise;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ArrayList<User> users = new ServiceUser().getUsers();
            ArrayList<Entreprise> entreprises = new ServiceUser().getEntreprise();
            homePane.getChildren().add(showUsers(users));
            homePaneEntreprise.getChildren().add(showEntreprises(entreprises));
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    public VBox showUsers(ArrayList<User> users){
        VBox liste = new VBox();
        for(User u : users){
            HBox graphicUser = new HBox();
            graphicUser.getChildren().add(new Label(u.getUsername()));
            graphicUser.getChildren().add(new Label(u.getFirst_name()));
            graphicUser.getChildren().add(new Label(u.getLast_name()));
            if(u instanceof Entreprise){
                graphicUser.getChildren().add(new Label(((Entreprise)u).getMatricule_fiscale()));
            }
            
            liste.getChildren().add(graphicUser);
        }
        //liste.prefHeightProperty().bind(homePane.heightProperty().multiply(0.5));
        return liste;
    }
    public VBox showEntreprises(ArrayList<Entreprise> entreprises){
        VBox liste = new VBox();
        for(Entreprise e : entreprises){
            HBox graphicUser = new HBox();
            graphicUser.getChildren().add(new Label(e.getUsername()));
            graphicUser.getChildren().add(new Label(e.getRaison_sociale()));
            graphicUser.getChildren().add(new Label(e.getMatricule_fiscale()));
            liste.getChildren().add(graphicUser);
        }
        //liste.prefHeightProperty().bind(homePane.heightProperty().multiply(0.5));
        return liste;
    }
    
}