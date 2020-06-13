/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import huntkingdom.HuntKingdom;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class GroupHomeController implements Initializable {

    @FXML
    private JFXButton btnAddGroup;
    @FXML
    private BorderPane paneHomeGroupe;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //Scene myscene= btnGroups.getScene();
        
        
    paneHomeGroupe.setRight(getPage("showGroups"));
        // TODO
    }    

    @FXML
    private void OnAddGroup(ActionEvent event) {
        try {
            Stage  stage= new Stage();
            
            Parent newParent = FXMLLoader.load(getClass().getResource("addGroup.fxml"));
            Scene newScene = new Scene(newParent);
            stage.setScene(newScene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GroupHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Pane getPage(String fileName){
        Pane view=null;
    URL fileURL =HuntKingdom.class.getResource("/huntkingdom/gui/"+fileName+".fxml");
        try {
            view=FXMLLoader.load(fileURL);
                 //   Parent newScene=new Parent(view);

        } catch (IOException ex) {
            System.out.println("erreur de chargement");
        }
        return view;
}

}
