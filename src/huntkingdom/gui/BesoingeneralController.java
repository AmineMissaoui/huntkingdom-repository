/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;


import com.jfoenix.controls.JFXButton;
import entities.Article;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.time.temporal.TemporalAdjusters.next;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import huntkingdom.services.ServiceArticle;
import huntkingdom.utils.Document_Creation;

        /**
 * FXML Controller class
 *
 * @author amrii
 */
public class BesoingeneralController implements Initializable {

    @FXML
    private Label label03;
    @FXML
    private Label label02;
    @FXML
    private Label label01;
    @FXML
    private Button PREVIEW;
    @FXML
    private Button NEXT;
    @FXML
    private ImageView imageview01;
    @FXML
    private ImageView imageview02;
    @FXML
    private ImageView imageview03;
    @FXML
    private ImageView imageview04;
    @FXML
    private Label label04;
    @FXML
    private AnchorPane holderPane1;
    public static Article B=new Article();
    ServiceArticle CB=new ServiceArticle();
    private List<Article> list_Besoin ;
    int next=0;    
    AnchorPane holderPanel1;
    @FXML
    private AnchorPane BASE;
    Alert alert=new Alert(Alert.AlertType.WARNING);
    @FXML
    private HBox hbox1;
    @FXML
    private Button ajout;
    @FXML
    private Button mes_annonces;
    @FXML
    private Button pdf;
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
    private TextField Chercher;
    @FXML
    private Button chercher;
   
    @FXML
    private CheckBox recherchetitre;
    @FXML
    private CheckBox cherchecategorie;
    @FXML
    private CheckBox recherchegouv;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
           
        hbox1.disableProperty();
        NEXT.setVisible(false);
        PREVIEW.setVisible(false);
        list_Besoin=CB.Display();
       clean();
        affbe();
        
         mes_annonces.setOnAction(e -> {
            try {
                Stage stage = (Stage) mes_annonces.getScene().getWindow();
                Parent myNewParent = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/FXMLArticle.fxml"));
                Scene myNewScene = new Scene(myNewParent);
                stage.setScene(myNewScene);
                stage.setTitle("mes_annonces");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(huntkingdom.gui.AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
            ajout.setOnAction(e -> {
            try {
                Stage stage = (Stage) ajout.getScene().getWindow();
                Parent myNewParent = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/AddFXML.fxml"));
                Scene myNewScene = new Scene(myNewParent);
                stage.setScene(myNewScene);
                stage.setTitle("ajout");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(huntkingdom.gui.AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            
          
         
        
    }    

    @FXML
    private void goPREVIEW(ActionEvent event) {
        if(label02.getText()==(null))
        {next=next-5;}
        else if (label03.getText()==(null))
        {next=next-6;}
        else if(label04.getText()==(null))
        {next=next-7;}
        else
        {next=next-8;}
        clean();
        affbe();
    }

    @FXML
    private void goNEXT(ActionEvent event) {
        clean();
        affbe();
    }

    public void affbe()
    {
        int a=list_Besoin.size()-(next);
        if(a>4)
        {
        a=4;
        NEXT.setVisible(true);
        }
        for (int i=0;i<a;i++){
        B=list_Besoin.get(next);
        
          File file= new File("C:\\Users\\FOCUS\\Desktop\\fesfes\\article1\\article1\\src\\images\\"+ B.getImage_ev());
          //File file= new File("C:\\wamp64\\www\\img\\"+ x);
         Image img = new Image(file.toURI().toString());
       // Image img = new Image("C:\\Users\\SAIFOUN\\Desktop\\annonce\\article1\\article1\\src\\images\\"+B.getImage_ev());
        if(i==0){
        imageview01.imageProperty().set(img);
        label01.setText(B.getTitre());
//                lbl.setText(B.getCategorie());

        }
        else if(i==1){
        imageview02.imageProperty().set(img);
        label02.setText(B.getTitre());}
        else if(i==2){
        imageview03.imageProperty().set(img);
        label03.setText(B.getTitre());}
        else if(i==3){
        imageview04.imageProperty().set(img);
        label04.setText(B.getTitre());}
        next++;
        }
        if (next>4)
        PREVIEW.setVisible(true);

       
    }

    private void clean() {
        label01.setText(null);
        imageview01.imageProperty().set(null);
        label02.setText(null);
        imageview02.imageProperty().set(null);
        label03.setText(null);
        imageview03.imageProperty().set(null);
        label04.setText(null);
        imageview04.imageProperty().set(null);
        NEXT.setVisible(false);
        PREVIEW.setVisible(false);


    }
    

    public void affichedetails(AnchorPane p ,String BESOIN) throws IOException {
        holderPanel1 = FXMLLoader.load(getClass().getResource(BESOIN));
        p.getChildren().clear();
        p.getChildren().add((Node) holderPanel1);
    }

    @FXML
    private void affi1(MouseEvent event) throws IOException {
        int aaffi=next-4;
        if(label04.getText()==null)aaffi++;
        if(label03.getText()==null)aaffi++;
        if(label02.getText()==null)aaffi++;
        if(label01.getText()!=(null)) {B=list_Besoin.get(aaffi);
        affichedetails(holderPane1,"TEST.fxml");
        }
    }

    @FXML
    private void affi2(MouseEvent event) throws IOException {
        int aaffi=next-3;
        if(label04.getText()==null)aaffi++;
        if(label03.getText()==null)aaffi++;
        if(label02.getText()!=(null)) {B=list_Besoin.get(aaffi);
  affichedetails(holderPane1,"TEST.fxml");        }
    }

    @FXML
    private void affi3(MouseEvent event) throws IOException {
        int aaffi=next-2;
        if(label04.getText()==null)aaffi++;
     if(label03.getText()!=(null)) {B=list_Besoin.get(aaffi);
  affichedetails(holderPane1,"TEST.fxml");        }}

    @FXML
    private void affi4(MouseEvent event) throws IOException {
     if(label04.getText()!=(null)) {B=list_Besoin.get(next-1);
          affichedetails(holderPane1,"TEST.fxml");
        }}

    private void MesBesoins(ActionEvent event) throws IOException {
       affichedetails(BASE,"TEST.fxml");
      
        
    }
    
  
     @FXML
    private void chercher(ActionEvent event) {
            
            int i;
            list_Besoin.clear();
            list_Besoin=CB.Display();
            String ch=Chercher.getText();
            boolean Ti=false;
            boolean Ty=false;
            boolean De=false;
            String ch0=ch;
            clean();
            next=0;
            if(recherchetitre.isSelected())Ti=true;
            if(cherchecategorie.isSelected())Ty=true;
            if(recherchegouv.isSelected())De=true;
            if ((Chercher.getText()==null||ch0.replaceAll(" ","").equals("")||((Ti==false)&&(De==false))))//||()))
                {        
                }
            else if ((Chercher.getText()==null||((Ti==false)&&(De==false)))&&(Ty==true))//||()))
                {        
                for (i=0;i<list_Besoin.size();i++)
                {            
                    B=list_Besoin.get(i);
                            
                  
                }
                }
            else if ((Ti==true)&&(Ty==false)&&(De==false))
            {
            for (i=0;i<list_Besoin.size();i++)
                {
                   B=list_Besoin.get(i);
                   if (!B.getTitre().contains(ch)) 
                       {
                           list_Besoin.remove(B);
                           i--;
                       }
                } 
                
            }
           else if ((Ti==false)&&(Ty==true)&&(De==false))
            {
            for (i=0;i<list_Besoin.size();i++)
                {            
                    B=list_Besoin.get(i);
     
                }
            }
            else if ((Ti==false)&&(Ty==false)&&(De==true))
            {
                for (i=0;i<list_Besoin.size();i++)
                { 
                    B=list_Besoin.get(i);
                   if (!B.getGouvernorat().contains(ch))
                       {
                           list_Besoin.remove(i);
                           i--;
                       }
                }
            }
            else if ((Ti==true)&&(Ty==false)&&(De==true))
            {
                for (i=0;i<list_Besoin.size();i++)
                { 
                    B=list_Besoin.get(i);
                
                   if ((!B.getTitre().contains(ch))||!B.getGouvernorat().contains(ch))
                       {
                           list_Besoin.remove(i);
                           i--;
                       }
            }}
            else if ((Ti==false)&&(Ty==true)&&(De==true))
            {
              for (i=0;i<list_Besoin.size();i++)
                {    B=list_Besoin.get(i);
                        }
            }
            else if ((Ti==true)&&(Ty==true)&&(De==false))
            {
                for (i=0;i<list_Besoin.size();i++)
                { 
                 B=list_Besoin.get(i);
                     }
            }
            else if ((Ti==true)&&(Ty==true)&&(De==true))
            {
                 for (i=0;i<list_Besoin.size();i++)
                { B=list_Besoin.get(i);
                   }
            }
            else 
            {
                alert.setTitle("Error of search");
                alert.setContentText("UNKOWN !!");
                alert.showAndWait();
            }
            affbe();
         
    }
    
}
