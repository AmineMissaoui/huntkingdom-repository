/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    private JFXTextField tfPassword;
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
    private JFXComboBox<String> cbState;
    @FXML
    private JFXButton btnRegister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbState.getItems().add("Tunis");
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
            
        });
    }    
    
}
