/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Article;
import huntkingdom.entities.User;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JLabel;
import javax.swing.JTextField;
import huntkingdom.services.ServiceArticle;

/**
 * FXML Controller class
 *
 * @author FOCUS
 */
public class AddFXMLController implements Initializable {

    //@FXML
   // private JTextField tfTitre;
    @FXML
    private JFXTextField tfPrix;
    @FXML
    private JFXTextField tfGouvernorat;
    @FXML
    private JFXTextField tfVille;
    @FXML
    private JFXTextField tfDescription;
    @FXML
    private JFXTextField tfNumtel;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnAfficher;
     @FXML
    private ImageView img1;
     @FXML
    private Button parcourir1;
      final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
    private Path pathfrom;
    private Path pathto;
    private Path pathtowamp;
    
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private JFXTextField tfTitre;
    @FXML
    private Hyperlink btn_retour;
    @FXML
    private AnchorPane barre1;
    @FXML
    private AnchorPane barre2;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnCalendar;
    @FXML
    private JFXButton btnEvent;
    @FXML
    private JFXButton btnElearning;
    @FXML
    private JFXButton btnShop;
    @FXML
    private Label labelUserName;
    @FXML
    private Label k;
    @FXML
    private Label t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 

                ObservableList<String> list =FXCollections.observableArrayList("Chasse","Peche");
                combo.setItems(list);
        
    //}
btnValider.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Article A = new Article();
                
           
            ////////*Controle saisie titre////////////
             String ti = tfTitre.getText();
             if(ti.isEmpty())
                {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Titre VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR un Titre!");
           
                alert.showAndWait();  
                }
          if(ti.contains("0")||ti.contains("1")||ti.contains("2")||ti.contains("3")||ti.contains("4")||ti.contains("5")||ti.contains("6")||ti.contains("7")||ti.contains("8")||ti.contains("9") ){
                   Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Titre contient un numero");
            alert.setHeaderText(null);
            alert.setContentText("Pas de numero SVP!");
           
                alert.showAndWait(); 
             }
            ///////////*Control saisie prix///////////////////// 
             String Pr = tfPrix.getText();
             if(Pr.isEmpty())
                {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Titre VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR PRIX !");
           
                alert.showAndWait();  
                }
             ////////*Controle saisie categorie/////////
           /*  String cat = tfCatergorie.getText();
             if(cat.isEmpty())
                {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Titre VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR CATEGORIE!");
           
                alert.showAndWait();  
                }*/
             //////////*Controle saisie gouv//////////
             String go = tfGouvernorat.getText();
             if(go.isEmpty())
                {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Titre VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR GOUVERNORAT!");
           
                alert.showAndWait();  
                }
             /////////*Controle saisie ville////////////
             String vi = tfVille.getText();
             if(vi.isEmpty())
                {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Titre VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR VILLE!");
           
                alert.showAndWait();  
                }
             /////////*controle saisie description///////
             String desc = tfDescription.getText();
             if(desc.isEmpty())
                {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Titre VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR DESCRIPTION!");
           
                alert.showAndWait();  
                }
             ////////////*Controle saisie numtel//////////////     
               String nu = tfNumtel.getText();
             
             if(nu.isEmpty()){
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("NUMERO TEL VIDE");
             alert.setHeaderText(null);
             alert.setContentText("SAISIR NUM TEL!");
            // A.setNumtel(0);
             alert.showAndWait();
  
             }
             
             else{
               
                
               ///////////*path source et path destination///////////
                try {               
                
                 pathfrom = FileSystems.getDefault().getPath(Current_file.getPath()); // System.out.println(pathfrom);
                 // pathto = FileSystems.getDefault().getPath("C:\\Users\\FOCUS\\Desktop\\PI DEV\\Nouveau dossier\\fesfes\\article\\src\\images\\" + Current_file.getName());
                 pathto = FileSystems.getDefault().getPath("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\" + Current_file.getName());  
                 // pathtowamp=FileSystems.getDefault().getPath("C:\\wamp64\\www\\img\\"+Current_file.getName());
                }catch(NullPointerException e){
                   System.out.println("IMAGE VIDE");
                }
                
             /////////////*copie l'image de path source vers path destination/////////
                    try {
                        Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
                      //  Files.copy(pathfrom, pathtowamp,StandardCopyOption.REPLACE_EXISTING);
                    } catch (NullPointerException ex) {
                       // Logger.getLogger(AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                       System.out.println("COPY IMAGE FAILED");
                    } catch (IOException ex) {
                        Logger.getLogger(AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                try{
               float fa = Float.parseFloat(tfPrix.getText());
               A.setPrix(fa);
             } catch (NumberFormatException ex) {
                     System.out.println("PRIX VIDE");}
              try{
               Integer f = Integer.parseInt(tfNumtel.getText());
               A.setNumtel(f); 
            } catch (NumberFormatException ex) {
                       System.out.println("NUMTEL VIDE");}
                
               A.setTitre(tfTitre.getText());
              A.setCategorie(combo.getValue());
               //A.setCategorie(tfCatergorie.getText());
               A.setGouvernorat(tfGouvernorat.getText());
               A.setVille(tfVille.getText());
               A.setDescription(tfDescription.getText());
               
           //   ServiceArticle s = new ServiceArticle();
             //List<User> u= s.UserId(LoginFXMLController.global);
              


               //A.setUser_id(LoginFXMLController.global);
              // String vars= FileSystems.getDefault().getPath(Current_file.getPath()).toString();
              try{
                    A.setImage_ev(pathfrom.getFileName().toString());
                 }
              catch (NullPointerException ex) {
                       System.out.println("IMAGE VIDE");
                                              } 
                     ServiceArticle SA = new ServiceArticle();
                    
              try{
                    SA.addArticle(A);
                 } catch (SQLException ex){
                    System.out.println("Erreur base de donnees");  
                                          }
            }}
        });

        
   
         
    }
    
    @FXML
    private void parcourir_annonce(ActionEvent event) {
          FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            img1.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
     private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
        
    }

    @FXML
    private void Back(MouseEvent event) {
        Parent root;
       
              try {
                  root=FXMLLoader.load(getClass().getClassLoader().getResource("huntkingdom/gui/Besoingeneral.fxml"));
                  btn_retour.getScene().setRoot(root);
              } catch (IOException ex) {
                  Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
              }
        
    }
    
     
     public void affichedetails(AnchorPane p ,String BESOIN) throws IOException {
        barre1 = FXMLLoader.load(getClass().getResource(BESOIN));
        p.getChildren().clear();
        p.getChildren().add((Node) barre1);
    } 

     
}
