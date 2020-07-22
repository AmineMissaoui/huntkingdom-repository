/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.Group;
import huntkingdom.services.GroupService;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class AddGroupController implements Initializable {

    @FXML
    private BorderPane bpAddGroup;
    @FXML
    private JFXButton btnAddImage;
    @FXML
    private JFXTextField tfImage;
    @FXML
    private JFXTextField tfName;
    @FXML
    private JFXTextArea taDescription;
    @FXML
    private JFXButton btnCreateGroup;
    
    private File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAddImage(ActionEvent event) {
                        FileChooser fc=new FileChooser();
            selectedFile=fc.showOpenDialog(null);
            if(selectedFile !=null){
            tfImage.setText(selectedFile.getAbsolutePath());
            }
            else
                System.out.println("invalid");

    }
    @FXML    
    private void createGroupAction(ActionEvent event)
    {
    Group g=new Group();
            g.setNom(tfName.getText());
            g.setDescription(taDescription.getText());
                            GroupService gs = new GroupService();
                            if(selectedFile !=null){
            g.setImageFile(selectedFile.getAbsolutePath());
                            }
            try {

                gs.addGroup(g);
                Stage addGroupWindow=(Stage)tfName.getScene().getWindow();
                
                addGroupWindow.close();
                showAlertAddGroup();
            } catch (SQLException ex) {
                System.out.println( ex.getMessage())  ;
            } 
    }
     private void showAlertAddGroup() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("System");
        alert.setHeaderText("Results:");
        alert.setContentText("Group Added Successfully!");
 
        alert.showAndWait();
    }

}
