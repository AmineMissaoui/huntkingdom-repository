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
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.User;
import huntkingdom.services.ServiceUser;
import huntkingdom.utils.JavaMail;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
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
    @FXML
    private JFXButton btnRegister;
    @FXML
    private ToggleGroup user_role;
    @FXML
    private JFXRadioButton rbMemeber;
    @FXML
    private JFXRadioButton rbEntreprise;
    @FXML
    private JFXComboBox<String> cbState;
    ObservableList<String> list = FXCollections.observableArrayList("Tunis", "Ben Arouss");
    @FXML
    private Pane contentArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbState.setItems(list);
        btnRegister.setOnAction((event) -> {
            User u = new User();
            u.setUsername(tfUsername.getText());
            u.setPassword(tfPassword.getText());
            u.setFirst_name(tfFirstName.getText());
            u.setLast_name(tfLastname.getText());
            u.setEmail(tfEmail.getText());
            u.setBirthdate(dpBirthdate.getValue().toString());
            u.setAdress(tfAdress.getText());
            u.setState(cbState.getValue());
            u.setCity(tfCity.getText());
            
            if(rbMemeber.isSelected()){
            u.setRole(rbMemeber.getText());
            }else if(rbEntreprise.isSelected()){
            u.setRole(rbEntreprise.getText());
            }
            try {
                JavaMail.sendMail(tfEmail.getText(),tfFirstName.getText(),tfLastname.getText(),tfUsername.getText(), tfPassword.getText());
            } catch (MessagingException ex) {
                System.out.println("error while sending the email" + ex.getMessage());
            }
            ServiceUser su = new ServiceUser();
            try {
                su.addUser(u);
                tfUsername.setText("");
                tfPassword.setText("");
                tfFirstName.setText("");
                tfLastname.setText("");
                tfEmail.setText("");
                dpBirthdate.setValue(null);
                tfAdress.setText("");
                cbState.setValue("");
                tfCity.setText("");
                
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
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void selectRadio(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("RegisterEntrepriseFXML.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

}
