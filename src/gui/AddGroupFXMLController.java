/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import huntkingdom.entities.Group;
import huntkingdom.services.GroupService;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class AddGroupFXMLController implements Initializable {

    @FXML
    private TextField tfGroupName;
    @FXML
    private TextArea taDescription;
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnGroups;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCreate.setOnAction((event) -> {
            Group g=new Group();
            g.setNom(tfGroupName.getText());
            g.setDescription(taDescription.getText());
                            GroupService gs = new GroupService();
            try {
                gs.addGroup(g);
            } catch (SQLException ex) {
                System.out.println( ex.getMessage())  ;
            }

            
            
        });
        btnGroups.setOnAction((event) -> {
            Stage stage=(Stage) btnCreate.getScene().getWindow();
            try {
                Parent MyNewParent=FXMLLoader.load(getClass().getResource("./ShowGroupsFXML.fxml"));
                Scene newScene=new Scene(MyNewParent);
                stage.setScene(newScene);
                stage.setTitle("Groups");
                stage.show();
                        } catch (IOException ex) {
                System.out.println(ex.getMessage());;
            }
        });
    }    
    
}
