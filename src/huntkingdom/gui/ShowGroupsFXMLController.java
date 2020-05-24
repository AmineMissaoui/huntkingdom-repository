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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class ShowGroupsFXMLController implements Initializable {

    @FXML
    private AnchorPane apShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ArrayList<Group> groups=new GroupService().getGroups();
            apShow.getChildren().add(ConvertToGraphic(groups));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
}
            public VBox ConvertToGraphic(ArrayList<Group> groups){
        VBox liste=new VBox();
        for(Group p:groups){
        HBox hb=new HBox();
        hb.getChildren().add(new Label(p.getNom()));
        hb.getChildren().add(new Label(p.getDescription()));
        liste.getChildren().add(hb);
    
        }
        return liste;
        }

}
