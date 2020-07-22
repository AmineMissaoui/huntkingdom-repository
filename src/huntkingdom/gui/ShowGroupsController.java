/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import huntkingdom.entities.Group;
import huntkingdom.services.GroupService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class ShowGroupsController implements Initializable {

    @FXML
    private AnchorPane apShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            System.out.println("wsel");
            ArrayList<Group> groups=new GroupService().getGroups();
           
            apShow.getChildren().add(ConvertToGraphic(groups));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }    
      public VBox ConvertToGraphic(ArrayList<Group> groups){
        VBox liste=new VBox();
        liste.setAlignment(Pos.BASELINE_CENTER);
        liste.setSpacing(20);
        liste.setPadding(new Insets(30));
        for(Group g:groups){
        HBox hb=new HBox();
        hb.setStyle("-fx-padding: 20;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 1;" 
         + "-fx-border-color: grey;"+"-fx-background-color:white;");
        
        hb.getChildren().add(new Label(g.getNom()));
        hb.getChildren().add(new Label(g.getDescription()));
                               System.out.println(g.getImageFile());

       if(g.getImageFile()!=null){
            
           
           String urlimg=g.getImageFile();
           Image img=new Image(g.getImageFile());
            ImageView imv=new ImageView();
                       imv.setFitHeight(20);
                       imv.setFitWidth(20);
                       imv.setImage(img);
            hb.getChildren().add(imv);
        
        }
       hb.setOnMouseClicked((event) -> {
           try {
            Stage  stage= new Stage();
            
            Parent newParent = FXMLLoader.load(getClass().getResource("GroupMessage.fxml"));
            Scene newScene = new Scene(newParent);
            stage.setScene(newScene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GroupHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     });
        liste.getChildren().add(hb);
    
        }
        return liste;
        }
    
    
}
