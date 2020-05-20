/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.User;
import huntkingdom.services.ServiceUser;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sun.misc.Launcher;

/**
 * FXML Controller class
 *
 * @author AmineMissaoui
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private JFXDatePicker dpBirthdate;
    @FXML
    private JFXTextField tfUsername;
    @FXML
    private JFXPasswordField tfPassword;
    @FXML
    private JFXTextField tfFirstName;
    @FXML
    private JFXTextField tfLastname;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXTextField tfAdress;
    @FXML
    private JFXTextField tfCity;
    private JFXComboBox<String> cbState;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private JFXComboBox<?> tfState;
    @FXML
    private Pane contentAreaTwo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnRegister.setOnAction((event) -> {
            User u = new User();
            u.setUsername(tfUsername.getText());
            u.setPassword(tfPassword.getText());
            u.setFirst_name(tfFirstName.getText());
            u.setLast_name(tfLastname.getText());
            u.setEmail(tfEmail.getText());
            u.setBirthdate(dpBirthdate.getValue().toString());
            u.setAdress(tfAdress.getText());
            //u.setState(cbState.);
            u.setCity(tfCity.getText());
            ServiceUser su = new ServiceUser();
            try {
                su.addUser(u);
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getMessage());
            }
        });
    }    

    @FXML
    private void closeApp(javafx.scene.input.MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void backToPrevious(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        contentAreaTwo.getChildren().removeAll();
        contentAreaTwo.getChildren().setAll(root);
    }

}
