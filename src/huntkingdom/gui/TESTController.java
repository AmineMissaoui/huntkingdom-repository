/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXTextField;
import entities.Article;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import huntkingdom.utils.Document_Creation;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class TESTController implements Initializable {

    @FXML
    private Label desc;
    @FXML
    private Label title;
 Article b = huntkingdom.gui.BesoingeneralController.B;
    @FXML
    private ImageView img;
    @FXML
    private AnchorPane anc;
    @FXML
    private Label cat;
    @FXML
    private Label gouv;
    @FXML
    private Label vi;
    @FXML
    private Label pr;
    @FXML
    private Label num;
     @FXML
    private Button pdf;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setVisible(true);
        title.setText(b.getTitre());
        cat.setVisible(true);
        cat.setText(b.getCategorie());
        gouv.setVisible(true);
        gouv.setText(b.getGouvernorat());
        vi.setVisible(true);
        vi.setText(b.getVille());
        desc.setVisible(true);
        desc.setText(b.getDescription());
        pr.setVisible(true);
       try{ 
      Float fa =b.getPrix();
      String v = fa.toString();
      pr.setText(v);
        } catch (NumberFormatException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
                        num.setVisible(true);
try{
      Integer aa =b.getNumtel();
     String bb = aa.toString();
       //  float fa = Float.parseFloat(pr.getText());
             // pr.set(b.getPrix());
      num.setText(bb);
       } catch (NumberFormatException eex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, eex);
        }
                
             
          File file= new File("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\"+ b.getImage_ev());
          //File file= new File("C:\\wamp64\\www\\img\\"+ x);
         Image imgs = new Image(file.toURI().toString());
         img.imageProperty().set(imgs);
         
     
                
         
    }  
    
    
}
