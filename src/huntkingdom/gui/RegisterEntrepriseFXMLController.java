/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.Entreprise;
import huntkingdom.entities.User;
import huntkingdom.services.ServiceUser;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author amin
 */
public class RegisterEntrepriseFXMLController implements Initializable {

    @FXML
    private JFXRadioButton rbMemeber;
    @FXML
    private ToggleGroup user_role;
    @FXML
    private JFXRadioButton rbEntreprise;
    @FXML
    private JFXTextField tfUsername;
    @FXML
    private JFXTextField tfEntrepriseName;
    @FXML
    private JFXTextField tfTaxNumber;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXTextField tfAdress;
    @FXML
    private JFXTextField tfCity;
    @FXML
    private JFXPasswordField tfPassword;
    @FXML
    private JFXComboBox<String> cbState;
    ObservableList<String> list = FXCollections.observableArrayList("Tunis", "Ben Arous");
    @FXML
    private JFXButton btnRegister;
    @FXML
    private Pane contentArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbState.setItems(list);
        btnRegister.setOnAction((event) -> {
            Entreprise e = new Entreprise();
            e.setUsername(tfUsername.getText());
            e.setPassword(tfPassword.getText());
            e.setEmail(tfEmail.getText());
            e.setRaisonSociale(tfEntrepriseName.getText());
            e.setMatriculeFiscale(tfTaxNumber.getText());
            e.setAdress(tfAdress.getText());
            e.setState(cbState.getValue());
            e.setCity(tfCity.getText());
            e.setRole(rbEntreprise.getText());
            
            ServiceUser se = new ServiceUser();
            try {
                se.addEntreprise(e);
                tfUsername.setText("");
                tfPassword.setText("");
                tfEmail.setText("");
                tfEntrepriseName.setText("");
                tfTaxNumber.setText("");
                tfAdress.setText("");
                cbState.setValue("");
                tfCity.setText("");
                
            } catch (SQLException ex) {
                System.out.println("error" + ex.getMessage());
            }
            
        });
    }    

    @FXML
    private void closeApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void backToPrevious(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void selectRadio(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    
}
