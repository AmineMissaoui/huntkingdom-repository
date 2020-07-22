/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import huntkingdom.HuntKingdom;
import huntkingdom.entities.Group;
import huntkingdom.services.GroupService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import huntkingdom.gui.RootFXMLController;

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
    @FXML
    private Button btnImage;
    @FXML
    private ListView listeView;
    @FXML
    private BorderPane groupBP;

    private File selectedFile;

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
                            if(selectedFile !=null){
             g.setImageFile(selectedFile.getAbsolutePath());
                            }
            try {

                gs.addGroup(g);
            } catch (SQLException ex) {
                System.out.println( ex.getMessage())  ;
            } 
            
            
        });
    }    
        @FXML
    private void showGroups(MouseEvent event) {
        Scene myscene= btnGroups.getScene();
        
        
    groupBP.setRight(getPage("showGroups"));
    }

    
    public void buttonImage(ActionEvent event ){
                FileChooser fc=new FileChooser();
            selectedFile=fc.showOpenDialog(null);
            if(selectedFile !=null){
            listeView.getItems().add(selectedFile.getAbsolutePath());
            }
            else
                System.out.println("invalid");
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
