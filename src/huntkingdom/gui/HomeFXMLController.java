/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import huntkingdom.entities.Entreprise;
import huntkingdom.entities.User;
import huntkingdom.utils.UserSession;
import huntkingdom.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private JFXButton btnGroup;
    @FXML
    private Label labelUserName;

    UserSession session;
    @FXML
    private Pane homeCenterPane;
    @FXML
    private BorderPane panelHome;
    @FXML
    private JFXButton btnShop1;
    @FXML
    private Pane homeRightPane;
    @FXML
    private FontAwesomeIcon logout;

    public HomeFXMLController() {
        session = UserSession.getInstance();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        labelUserName.setText(session.getUsername());
        try {
            if (session.getRole().equals("admin")) {
                Parent fxml = FXMLLoader.load(getClass().getResource("AdminValidationFXML.fxml"));
                homeCenterPane.getChildren().removeAll();
                homeCenterPane.getChildren().setAll(fxml);
            } else {
                Parent fxml = FXMLLoader.load(getClass().getResource("UserHomeFXML.fxml"));
                homeCenterPane.getChildren().removeAll();
                homeCenterPane.getChildren().setAll(fxml);
                Parent fxmlRight = FXMLLoader.load(getClass().getResource("UserHomeCalendarFXML.fxml"));
                homeRightPane.getChildren().removeAll();
                homeRightPane.getChildren().setAll(fxmlRight);

            }
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }

    @FXML
    public void buttonGroup(ActionEvent event) {
        Pane groupScene = null;
        try {
            groupScene = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/groupHome.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelHome.setCenter(groupScene);

    }

    @FXML
    private void buttonHome(ActionEvent event) throws IOException {
        Pane homeScene = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/UserHomeFXML.fxml"));
        panelHome.setCenter(homeScene);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        session.clearUserSession();
        Parent root = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/WecomeFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    private void buttonannonce(ActionEvent event) {
         Pane groupScene = null;
        try {
            groupScene = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/Besoingeneral.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
                panelHome.setCenter(groupScene);
    }

}
