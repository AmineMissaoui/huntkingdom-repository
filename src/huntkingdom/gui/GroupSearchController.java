/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import huntkingdom.entities.Group;
import huntkingdom.entities.JoinGroup;
import huntkingdom.services.GroupService;
import huntkingdom.services.JoinGroupService;
import huntkingdom.utils.UserSession;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class GroupSearchController implements Initializable {


    @FXML
    private AnchorPane AnchSearchGroups;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
try {
            System.out.println("wsel");
            ArrayList<Group> groups=new GroupService().getGroup(GroupHomeController.searchKey);
           
            AnchSearchGroups.getChildren().add(ConvertToGraphic(groups));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }    
    public VBox ConvertToGraphic(ArrayList<Group> groups){
        VBox liste=new VBox();
        

        liste.setAlignment(Pos.BASELINE_CENTER);
        liste.setSpacing(20);
        liste.setPadding(new Insets(30));
        for(Group g:groups){
        HBox hb=new HBox();
        if(g.getCreator_id()==UserSession.getInstance().getId()){
        JFXButton Bjoin  = new JFXButton("My group");
        hb.getChildren().add(Bjoin);}
        else{JFXButton Bjoin  = new JFXButton("Join");
        hb.getChildren().add(Bjoin);
        Bjoin.setOnAction((event) -> {
            try {
                JoinGroupService jgs=new JoinGroupService();
                JoinGroup j=new JoinGroup();
                java.util.Date date=new java.util.Date();  
                j.setDate(date);
                j.setGroupId(g.getId());
                jgs.addJoinGroup(j);
            } catch (SQLException ex) {
                Logger.getLogger(GroupSearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
        hb.setStyle("-fx-padding: 30;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 1;" 
         + "-fx-border-color: grey;"+"-fx-background-color:white;");
        
        hb.getChildren().add(new Label(g.getNom()));
        hb.getChildren().add(new Label(g.getDescription()));
        
        
     /*  if(g.getImageFile()!=null){
            
           ImageView imv=new ImageView();
           String urlimg=g.getImageFile().getAbsolutePath();
           Image img=(Image) g.getImageFile();
           imv.setImage(img);
        hb.getChildren().add(imv);
        
        }*/
   
        liste.getChildren().add(hb);
    
        }
        return liste;
        }
}
