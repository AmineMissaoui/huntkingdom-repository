/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXToggleButton;
import huntkingdom.entities.Entreprise;
import huntkingdom.entities.User;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author AmineMissaoui
 */
public class AdminValidationFXMLController implements Initializable {

    @FXML
    private Pane homePaneEntreprise;
    @FXML
    private Pane homePane;
    @FXML
    private Pane tabannonce;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //labelUserName.setText(session.getUsername());
        

        try {
            ArrayList<User> users = new ServiceUser().getUsers();
            ArrayList<Entreprise> entreprises = new ServiceUser().getEntreprise();
            homePane.getChildren().add(showUsers(users));
            homePaneEntreprise.getChildren().add(showEntreprises(entreprises));
              Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            tabannonce.getChildren().removeAll();
            tabannonce.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(WecomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    public ScrollPane showUsers(ArrayList<User> users) throws SQLException {
        VBox liste = new VBox();
        for (User u : users) {
            HBox graphicUser = new HBox();
            Label LabelFirstname = new Label(u.getFirst_name());
            LabelFirstname.setPadding(new Insets(5, 5, 5, 5));
            graphicUser.getChildren().add(LabelFirstname);
            Label labelLastName = new Label(u.getLast_name());
            labelLastName.setPadding(new Insets(5, 5, 5, 5));
            graphicUser.getChildren().add(labelLastName);
            JFXToggleButton toogle = new JFXToggleButton();
            graphicUser.getChildren().add(toogle);
            graphicUser.setPadding(new Insets(0, 0, 0, 0));
            graphicUser.setAlignment(Pos.BASELINE_LEFT);
            ServiceUser su = new ServiceUser();
            if (su.getCurrentUserState(u) == 1) {
                toogle.setSelected(true);
            }
            toogle.setOnAction((event) -> {
                try {
                    if (toogle.isSelected()) {
                        u.setActive(1);
                        System.out.println("user is now active " + u.getActive() + "For id : " + u.getId());
                        su.updateUserState(u);
                    } else {
                        u.setActive(0);
                        System.out.println("user is now inactive " + u.getActive() + "For id : " + u.getId());
                        su.updateUserState(u);
                    }
                } catch (SQLException ex) {
                    System.out.println("error updating state" + ex.getMessage());
                }
            });
            liste.getChildren().add(graphicUser);
        }
        liste.setPadding(new Insets(10, 10, 10, 10));
        ScrollPane scroll = new ScrollPane();
        //scroll.setBackground();
        scroll.setContent(liste); 
        liste.prefHeightProperty().bind(homePane.heightProperty().multiply(1));
        liste.prefWidthProperty().bind(homePane.widthProperty().multiply(1));
        return scroll;
    }

    public VBox showEntreprises(ArrayList<Entreprise> entreprises) {
        VBox liste = new VBox();
        for (Entreprise e : entreprises) {
            HBox graphicUser = new HBox();
            graphicUser.getChildren().add(new Label(e.getUsername()));
            graphicUser.getChildren().add(new Label(e.getRaison_sociale()));
            graphicUser.getChildren().add(new Label(e.getMatricule_fiscale()));
            liste.getChildren().add(graphicUser);
        }
        liste.prefHeightProperty().bind(homePane.heightProperty().multiply(0.5));
        return liste;
    }

}
