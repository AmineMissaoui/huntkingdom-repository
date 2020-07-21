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
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arif Sami
 */
public class MAPController implements Initializable {

    @FXML
    private Pane map;

    
    MyBrowser myBrowser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        myBrowser = new MyBrowser();
            map.getChildren().add(myBrowser);
    }    
    

    class MyBrowser extends Region{

        HBox toolbar;

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MyBrowser(){

            webEngine.load("file:///C:/googlemaps/gmaps.html");

            getChildren().add(webView);

        }

    }
}
