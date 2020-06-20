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
import java.util.ArrayList;
import java.util.ResourceBundle;
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
public class UserHomeFXMLController implements Initializable {

    @FXML
    private JFXTextArea taPostDescription;
    @FXML
    private JFXTextField tfPostTitle;
    @FXML
    private JFXButton btnShare;
    @FXML
    private Pane feedPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ArrayList<Publication> publications = new ServicePublication().getPublications();
            feedPane.getChildren().add(showPublication(publications));
        } catch (SQLException ex) {
            System.out.println("getting the publications failed" + ex.getMessage());
        }
        
        btnShare.setOnAction((event) -> {
            ServicePublication Servicepub = new ServicePublication();
            Publication pub = new Publication();
            pub.setTitle(tfPostTitle.getText());
            pub.setDescription(taPostDescription.getText());
            tfPostTitle.setText("");
            taPostDescription.setText("");
            try {
                Servicepub.addPublication(pub);
            } catch (SQLException ex) {
                System.out.println("error publication" + ex.getMessage());
            }
        });

    }
    public VBox showPublication(ArrayList<Publication> publications) {
        VBox liste = new VBox();
        System.out.println(publications);
        for (Publication pub : publications) {
            System.out.println("..");
            HBox graphicUser = new HBox();
            graphicUser.getChildren().add(new Label(pub.getTitle()));
            liste.getChildren().add(graphicUser);
        }
        return liste;
    }
}
