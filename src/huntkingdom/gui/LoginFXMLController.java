/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.UserSession;
import huntkingdom.services.ServiceUser;
import huntkingdom.utils.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amin
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private JFXTextField tfUsername;
    @FXML
    private JFXPasswordField tfPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Pane contentArea;
    Connection cnx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnAction((event) -> {
            try {
                String username = tfUsername.getText();
                String password = tfPassword.getText();
                if (username.isEmpty()) {
                    infoBox("Please enter your email", null, "WARNIG");
                    System.out.println("email empty");
                }
                if (password.isEmpty()) {
                    infoBox("Please enter your password", null, "WARNIG");
                    System.out.println("password empty");
                } else {
                    ServiceUser se = new ServiceUser();
                    boolean flag = se.validateCredentials(username, password);
                    if (!flag) {
                        infoBox("Wrong credentials", null, "ERROR");
                        System.out.println("wrong credentials");
                    } else {
                        infoBox("welcome", null, "sccess");
                        System.out.println("good credentials");
                        UserSession.setInstance(username);
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        Parent newParent = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
                        Scene newScene = new Scene(newParent);
                        stage.setScene(newScene);
                        stage.show();
                        UserSession.setInstance(username);
                    }
                }
            } catch (IOException ex) {
                System.out.println("error" + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("error z" + ex.getMessage());
            }
        });
    }

    @FXML
    private void openRegestration(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void closeApp(MouseEvent event) {
        System.exit(0);
    }
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }


}
