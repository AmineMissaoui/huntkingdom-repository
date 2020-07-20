/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Article;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
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
import huntkingdom.services.ServiceArticle;
import huntkingdom.utils.Document_Creation;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class FXMLArticleController implements Initializable {

    @FXML
    private TableView<Article> table;
    @FXML
    private TableColumn<Article,String> gouvv;
    @FXML
    private TableColumn<Article, String> ville;
     @FXML
    private TableColumn<Article, Integer> tel;
     @FXML
    private TableColumn<Article, String> titre;
     @FXML
    private TableColumn<Article, String> desc;
     @FXML
    private TableColumn<Article, String> cat;
      @FXML
    private TableColumn<Article, Float> prix;
          @FXML
    private TableColumn<Article, String> image_name;
        
        
      @FXML
      private Button btn_delete;
       @FXML
    private JFXTextField input_prix ;
       @FXML
    private JFXTextField input_ville ;
       @FXML
    private JFXTextField intput_desc ;
       @FXML
    private JFXTextField input_gouv ;
       @FXML
    private JFXTextField input_num ;
       @FXML
    private JFXTextField input_titre;
       @FXML
      private Button edit;
        @FXML
    private ImageView c_image;
         @FXML
    private Button btn_image;
              @FXML
    private Label label_image;
         @FXML
    private TextField input_search; 
         
         
           final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private Hyperlink btn_retour;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Label tt;
    @FXML
    private Label c;
    @FXML
    private Label p;
    @FXML
    private Label d;
    @FXML
    private Label g;
    @FXML
    private Label v;
    @FXML
    private Label n;
    @FXML
    private Label labelUserName;
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
    private Button pdf;
   
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList<String> list =FXCollections.observableArrayList("Chasse","Peche");
                combo.setItems(list);
                
                
        huntkingdom.services.ServiceArticle se=new ServiceArticle();
        //list_Article =FXCollections.observableArrayList();
        
        table.getItems().clear();
        ArrayList<Article> ff = (ArrayList<Article>) se.DisplayMyarticle();
       // System.out.println(LoginFXMLController.global);
        ObservableList<Article> obs =FXCollections.observableArrayList(ff);
        table.setItems(obs);
       
      // id.setCellValueFactory(new PropertyValueFactory<>("id"));  
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));  
         titre.setCellValueFactory(new PropertyValueFactory<>("titre")); 
                   cat.setCellValueFactory(new PropertyValueFactory<>("categorie"));   

                   gouvv.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));

          ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
          desc.setCellValueFactory(new PropertyValueFactory<>("description"));
       // ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
          
        tel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
         image_name.setCellValueFactory(new PropertyValueFactory<>("image_ev"));
        
        
         
      
 
    btn_delete.setOnAction(e->{
                ServiceArticle sa=new ServiceArticle();
                sa.deleteArticle(table.getSelectionModel().getSelectedItem().getId());
                System.out.println(table.getSelectionModel().getSelectedItem().getId());
                 Parent root;
            try {
                
                 root=FXMLLoader.load(getClass().getClassLoader().getResource("huntkingdom/gui/FXMLArticle.fxml"));
                 btn_delete.getScene().setRoot(root);
            }

             catch (IOException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
                    }});
   

    table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { 
                try{
                Article SelectedEvenet = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            
                       //id1=SelectedEvenet.get_Id_Even();
                       //Id_even.setText(SelectedEvenet.get_Id_Even()));
                       Article A = new Article();
                        input_prix.setText(String.valueOf(SelectedEvenet.getPrix()));
                       input_titre.setText(String.valueOf(SelectedEvenet.getTitre()));
                      
                     combo.setValue(String.valueOf(SelectedEvenet.getCategorie()));
                     
                     input_ville.setText(String.valueOf(SelectedEvenet.getVille()));
                     
                     intput_desc.setText(String.valueOf(SelectedEvenet.getDescription()));
                   input_gouv.setText(String.valueOf(SelectedEvenet.getGouvernorat()));
                      
                     
                    
                     input_num.setText(String.valueOf(SelectedEvenet.getNumtel()));
                     label_image.setText(String.valueOf(SelectedEvenet.getImage_ev()));
                       // image_name.setText(String.valueOf(A));
                       //affiche.setText(SelectedEvenet.get_Image());
                    String x =table.getSelectionModel().getSelectedItem().getImage_ev();
         File file= new File("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\"+ x);
          //File file= new File("C:\\wamp64\\www\\img\\"+ x);
         Image img = new Image(file.toURI().toString());
         c_image.setImage(img);   
           }

             catch (NullPointerException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
    });

  
        input_search.setOnKeyTyped( e->{
        ServiceArticle s = new ServiceArticle();
    ArrayList<Article> aaaaa = (ArrayList<Article>) s.DisplayMyarticle();
    ObservableList<Article> dataliste = FXCollections.observableArrayList(aaaaa);
    FilteredList<Article> FilteredData = new FilteredList<>(dataliste , b-> true);
        input_search.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredData.setPredicate((Article) -> {
if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare titre and categorie and gouvernorat of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Article.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Article.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(Article.getGouvernorat()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		      SortedList<Article> sortedData = new SortedList<>(FilteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
               
           
    });
    

        
        
        
      edit.setOnAction(e->{
           ServiceArticle sa = new ServiceArticle();
           String tittre =input_titre.getText();
           //String catt =input_cat.getText();
           String catt = combo.getValue();
           String gouvv =input_gouv.getText();
           String villle= input_ville.getText();
           String descc=intput_desc.getText();
           
            
            int idd =table.getSelectionModel().getSelectedItem().getId();
           // String imageset=table.getSelectionModel().getSelectedItem().getImage_ev();
          // String globalimage=imageset;
         String im = table.getSelectionModel().getSelectedItem().getImage_ev();
         // try{
          try{
            String  img = Current_file.getName();
            
            if(img.isEmpty()){
                //img=table.getSelectionModel().getSelectedItem().getImage_ev();
                 System.out.println("IMAGE VIDE");
            }
              else{
                
                im=img;
                             System.out.println(im);

            }
          }
         catch (NullPointerException npe){
             System.out.println("IMAGE VIDE");
         }
          
          
        Float prix =table.getSelectionModel().getSelectedItem().getPrix();
          Float  tfprixx=prix;
          if(input_prix.getText().isEmpty()){
              System.out.println("SAISIR FLOAT");
              tfprixx=0F;
          }
             
           try{
         tfprixx = Float.parseFloat(input_prix.getText());
           }
           catch(NumberFormatException exa){
               System.out.println("JAWIK MRIGIL");
           }
           int tfnum=Integer.parseInt(input_num.getText());
           
        prix=tfprixx;
           
           Article ar = new Article(idd, tfprixx, tittre, catt, descc, gouvv, villle, tfnum,im);
            try {
                sa.updateArticle(ar);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                      System.out.println(sa);

           Parent root;
       try {
                
                 root=FXMLLoader.load(getClass().getClassLoader().getResource("huntkingdom/gui/FXMLArticle.fxml"));
                 btn_delete.getScene().setRoot(root);
            }

             catch (IOException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
                    }});
      
                      pdf.setOnAction(new EventHandler<ActionEvent>() {
                              
            @Override
            public void handle(ActionEvent event) {
                try {
                  
                                  Document_Creation dc = new Document_Creation();
            					dc.generatePDF();
            					File file = new File("my_docs.pdf");
            					if (file.exists()) {
            		                long startTime = System.currentTimeMillis();
            		                Desktop.getDesktop().open(file);
            		                long endTime = System.currentTimeMillis();
            		                System.out.println("Total time taken to open file -> "+ file.getName() +" in "+ (endTime - startTime) +" ms");              
            		            } else {
            		                System.out.println("File not exits -> "+ file.getAbsolutePath());
            		            }
            				} catch (IOException e) {
            					// TODO Auto-generated catch block
            					e.printStackTrace();
            				} catch (SQLException ex) {
                    System.out.println("erreur pdf");                                }
                
            }
        });
      
      
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

    @FXML
    private void Search(KeyEvent event) {
    }
    
    
    /*
    public Float comparerFloat(Float a,Floatb){
        if(a)
    }
    */
    
    
}
