/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXTextField;
import huntkingdom.entities.Annonce_admin;
import entities.Article;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import huntkingdom.services.ServiceAnnonceAdmin;

/**
 * FXML Controller class
 *
 * @author FOCUS
 */
public class DisplayAnnonceAdminController implements Initializable {

    @FXML
    private AnchorPane tfi;
    @FXML
    private TableView<Annonce_admin> table;
    @FXML
    private TableColumn<Annonce_admin, String> titre;
    @FXML
    private TableColumn<Annonce_admin, String> info;
    @FXML
    private TableColumn<Annonce_admin, String> date;
    @FXML
    private TableColumn<Annonce_admin, String> adresse;
    @FXML
    private TableColumn<Annonce_admin, String> image;
    @FXML
    private JFXTextField tft;
    @FXML
    private JFXTextField tfa;
    @FXML
    private DatePicker dp;
    @FXML
    private Button edit;
    @FXML
    private Button btn_delete;
    @FXML
    private TextField input_search;
    @FXML
    private Button btn_image;
    @FXML
    private JFXTextField tfii;
               final FileChooser fileChooser = new FileChooser();
    private String file_image;
        private FileInputStream fis;


     private Path pathfrom;
    private Path pathto;
    private File Current_file;
    @FXML
    private ImageView c_image;
    @FXML
    private Label label_image;
    @FXML
    private Button btnaff;
    private Button btnma;
    @FXML
    private Button btnajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    
 ServiceAnnonceAdmin se=new ServiceAnnonceAdmin();
   
        
        table.getItems().clear();
        ArrayList<Annonce_admin> ff = (ArrayList<Annonce_admin>) se.Displayadmin();
        ObservableList<Annonce_admin> obs =FXCollections.observableArrayList(ff);
        table.setItems(obs);
       
     
        titre.setCellValueFactory(new PropertyValueFactory<>("titre_annonce"));  
         info.setCellValueFactory(new PropertyValueFactory<>("infos_annonce")); 
                   date.setCellValueFactory(new PropertyValueFactory<>("date_annonce"));   

                   adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_annonce"));

         image.setCellValueFactory(new PropertyValueFactory<>("img_ad"));
        
         ////////////search//////////////
         
         input_search.setOnKeyTyped( e->{
        ServiceAnnonceAdmin s = new ServiceAnnonceAdmin();
    ArrayList<Annonce_admin> aaaaa = (ArrayList<Annonce_admin>) s.Displayadmin();
    ObservableList<Annonce_admin> dataliste = FXCollections.observableArrayList(aaaaa);
    FilteredList<Annonce_admin> FilteredData = new FilteredList<>(dataliste , b-> true);
 
        input_search.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredData.setPredicate((Annonce_admin) -> {
if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare titre and categorie and gouvernorat of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Annonce_admin.getTitre_annonce().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Annonce_admin.getDate_annonce().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		      SortedList<Annonce_admin> sortedData = new SortedList<>(FilteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
               
           
    });
         edit.setOnAction(e->{
           ServiceAnnonceAdmin sa = new ServiceAnnonceAdmin();
           String tit =tft.getText();
           String inf =tfii.getText();
          LocalDate dd= dp.getValue();
           //String nn= mm.toString();
           //String jj = nn.getText;
            

 //String vale = DisplayEventVetController.an.getDateEvent();
        
      //  dp.setValue(LocalDate.parse(vale));
           String adr=tfa.getText();
            
            int idd =table.getSelectionModel().getSelectedItem().getId_admin();
         String im = table.getSelectionModel().getSelectedItem().getImg_ad();
     
          try{
            String  img = Current_file.getName();
            
          
          }
         catch (NullPointerException npe){
             System.out.println("IMAGE VIDE");
         }
          
        
             
        
           
           
           Annonce_admin ar = new Annonce_admin(idd, tit, inf,dd.toString(), adr, im);
            try {
                sa.updateAdmin(ar);
            } catch (SQLException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                      System.out.println(sa);

           Parent root;
       try {
                
                 root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/DisplayAnnonceAdmin.fxml"));
                 btn_delete.getScene().setRoot(root);
            }

             catch (IOException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }}); 
           btn_delete.setOnAction(e->{
                ServiceAnnonceAdmin sa=new ServiceAnnonceAdmin();
                sa.deleteAnnonceAdmin(table.getSelectionModel().getSelectedItem().getId_admin());
                System.out.println(table.getSelectionModel().getSelectedItem().getId_admin());
                 Parent root;
            try {
                
                 root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/DisplayAnnonceAdmin.fxml"));
                 btn_delete.getScene().setRoot(root);
            }

             catch (IOException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }});
   
          table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { 
                try{
                Annonce_admin SelectedEvenet = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            
                       //id1=SelectedEvenet.get_Id_Even();
                       //Id_even.setText(SelectedEvenet.get_Id_Even()));
                       ServiceAnnonceAdmin A = new ServiceAnnonceAdmin();
                        tft.setText(String.valueOf(SelectedEvenet.getTitre_annonce()));
                       tfii.setText(String.valueOf(SelectedEvenet.getInfos_annonce()));
                       
                    
                String testdate = SelectedEvenet.getDate_annonce();
               /// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
              //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd")
                         //   .withLocale(Locale.FRANCE);
                
                 
                  LocalDate loc= LocalDate.parse(testdate);
                    // System.out.println(loc);
                         dp.setValue(loc);
       // String date_event = value.toString();

                  //     dp.toString().setText(String.valueOf(SelectedEvenet.getDate_annonce()));
                     
                        
                     tfa.setText(String.valueOf(SelectedEvenet.getAdresse_annonce()));
                      
                     
                    
                    
                     label_image.setText(String.valueOf(SelectedEvenet.getImg_ad()));
                       
                    String x =table.getSelectionModel().getSelectedItem().getImg_ad();
         File file= new File("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\"+ x);
          //File file= new File("C:\\wamp64\\www\\img\\"+ x);
         Image img = new Image(file.toURI().toString());
         c_image.setImage(img);   
           }

             catch (NullPointerException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }           
        });
    btn_image.setOnAction(e->{
          FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
             label_image.setText(Current_file.getName());
           // img1.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{       
pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
          pathto = FileSystems.getDefault().getPath("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\" + Current_file.getName());
         //pathto = FileSystems.getDefault().getPath("C:\\Users\\FOCUS\\Desktop\\PI DEV\\Nouveau dossier\\fesfes\\article\\src\\images\\" + Current_file.getName());
         //Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\SAIFOUN\\Desktop\\article\\src\\gui");
         //Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
        }catch(NullPointerException ex){
                   System.out.println("IMAGE VIDE");
                }
         try {
                Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
              //    System.out.println("PATHFORM");
                //System.out.println(pathfrom.toString());
                 //System.out.println("pathto");
                //System.out.println(pathto.toString());
                
            } catch (IOException ex) {
                Logger.getLogger(DisplayAnnonceAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
    });
    }  

    @FXML
    private void Search(KeyEvent event) {
    }
          
           
           
}
