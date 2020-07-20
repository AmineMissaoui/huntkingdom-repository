/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.Annonce_admin;
import entities.Article;
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
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import huntkingdom.services.ServiceAnnonceAdmin;

/**
 * FXML Controller class
 *
 * @author FOCUS
 */
public class AddAnnonceAdminController implements Initializable {

    @FXML
    private Button btnValider;
    @FXML
    private Button parcourir1;
    @FXML
    private JFXTextField tfTitre;
    @FXML
    private JFXTextField tfAdresse;
    @FXML
    private DatePicker d;
    @FXML
    private JFXTextField tfInfos;
    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
    private Path pathfrom;
    private Path pathto;
    private Path pathtowamp;
    
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private ImageView img1;
    @FXML
    private Button btnaff;
    @FXML
    private Button btnma;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

             
        
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            

            @Override
            public void handle(ActionEvent event) {
                Annonce_admin a = new Annonce_admin();
               // try{
LocalDate value = d.getValue();
        String date_event = value.toString();

                        a.setDate_annonce(date_event);
               //}catch(NullPointerException e){
                 //  System.out.println("Erreur date ");
                //}
               ///////////*path source et path destination///////////
                try {               
                
                 pathfrom = FileSystems.getDefault().getPath(Current_file.getPath()); // System.out.println(pathfrom);
                 // pathto = FileSystems.getDefault().getPath("C:\\Users\\FOCUS\\Desktop\\PI DEV\\Nouveau dossier\\fesfes\\article\\src\\images\\" + Current_file.getName());
                 pathto = FileSystems.getDefault().getPath("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\" + Current_file.getName());  
                 // pathtowamp=FileSystems.getDefault().getPath("C:\\wamp64\\www\\img\\"+Current_file.getName());
                }catch(NullPointerException e){
                   System.out.println("IMAGE VIDE");
                }
                
                    try {
                        Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
                    } catch (NullPointerException ex) {
                       System.out.println("COPY IMAGE FAILED");
                    } catch (IOException ex) {
                        Logger.getLogger(AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
     
               a.setTitre_annonce(tfTitre.getText());
               a.setAdresse_annonce(tfAdresse.getText());
               a.setInfos_annonce(tfInfos.getText());

               
              try{
                    a.setImg_ad(pathfrom.getFileName().toString());
                 }
              catch (NullPointerException ex) {
                       System.out.println("IMAGE VIDE");
                                              } 
                     ServiceAnnonceAdmin sa = new ServiceAnnonceAdmin();
                    
              try{
                    sa.addAdmin(a);
                 } catch (SQLException ex){
                    System.out.println("Erreur base de donnees");  
                                          }
            
            
            }
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
}
        
            
        
        
               

    

 
    
  
  


