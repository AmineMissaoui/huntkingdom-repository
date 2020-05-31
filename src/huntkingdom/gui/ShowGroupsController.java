/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import huntkingdom.entities.Group;
import huntkingdom.services.GroupService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
        for(Group g:groups){
        HBox hb=new HBox();
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
