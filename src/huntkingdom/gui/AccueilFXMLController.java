/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entities.Article;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import huntkingdom.services.ServiceArticle;
import huntkingdom.utils.Document_Creation;
/**
 * FXML Controller class
 *
 * @author FOCUS
 */
public class AccueilFXMLController implements Initializable {

    private Button btnAfficher;
    @FXML
    private TableView<Article> table;
    @FXML
    private TableColumn<Article, Float> prix;
    @FXML
    private TableColumn<Article, String> titre;
    @FXML
    private TableColumn<Article, String> cat;
    @FXML
    private TableColumn<Article, String> gouvv;
    @FXML
    private TableColumn<Article, String> ville;
    @FXML
    private TableColumn<Article, String> desc;
    @FXML
    private TableColumn<Article, Integer> tel;
    @FXML
    private TableColumn<Article, String> image_name;
    @FXML
    private TextField input_search;
    @FXML
    private Button ajout;
    @FXML
    private Button mes_annonces;
    @FXML
    private Button btn_delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_delete.setOnAction(e->{
                ServiceArticle sa=new ServiceArticle();
                sa.deleteArticle(table.getSelectionModel().getSelectedItem().getId());
                System.out.println(table.getSelectionModel().getSelectedItem().getId());
                 Parent root;
            try {
                
                 root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/AccueilFXML.fxml"));
                 btn_delete.getScene().setRoot(root);
            }

             catch (IOException ex) {
                Logger.getLogger(FXMLArticleController.class.getName()).log(Level.SEVERE, null, ex);
                    }});
   
huntkingdom.services.ServiceArticle se=new ServiceArticle();
        //list_Article =FXCollections.observableArrayList();
        
        table.getItems().clear();
        ArrayList<Article> ff = (ArrayList<Article>) se.Display();
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
        
         ////////////search//////////////
         
         input_search.setOnKeyTyped( e->{
        ServiceArticle s = new ServiceArticle();
    ArrayList<Article> aaaaa = (ArrayList<Article>) s.Display();
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
         
         
          mes_annonces.setOnAction(e -> {
            try {
                Stage stage = (Stage) mes_annonces.getScene().getWindow();
                Parent myNewParent = FXMLLoader.load(getClass().getResource("/gui/FXMLArticle.fxml"));
                Scene myNewScene = new Scene(myNewParent);
                stage.setScene(myNewScene);
                stage.setTitle("mes_annonces");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
           ajout.setOnAction(e -> {
            try {
                Stage stage = (Stage) ajout.getScene().getWindow();
                Parent myNewParent = FXMLLoader.load(getClass().getResource("/gui/AddAnnonceAdmin.fxml"));
                Scene myNewScene = new Scene(myNewParent);
                stage.setScene(myNewScene);
                stage.setTitle("ajout");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
           
           
           
           
     
             }   
    
  

    @FXML
    private void Search(KeyEvent event) {
    }
    
    
    
   
         
    
}
