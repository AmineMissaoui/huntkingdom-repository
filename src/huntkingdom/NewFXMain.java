/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import huntkingdom.utils.JavaFTP;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.commons.net.ftp.FTPClient;
import com.cloudinary.Api;
import com.cloudinary.Api.HttpMethod;
import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.api.exceptions.GeneralError;
import com.cloudinary.http44.api.Response;
import com.cloudinary.utils.Base64Coder;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.utils.StringUtils;
import java.io.File;
import java.util.Map;
//import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
//import org.apache.http.HttpHost;
//import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpRequest;
import org.apache.http.impl.client.HttpClients;
import org.cloudinary.json.JSONException;
import org.cloudinary.json.JSONObject;

/**
 *

 * @author AmineMissaoui

 */
public class NewFXMain extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
"cloud_name", "dn1smnelu",
"api_key", "743929825926496",
"api_secret", "cFdZ3OmxiYiHrDzT3RmggEb4ikE"));
            
cloudinary.uploader().upload("C:\\Users\\Me\\Desktop\\images\\dog.jpg", 
  ObjectUtils.emptyMap());

Parent root = FXMLLoader.load(getClass().getResource("/huntkingdom/gui/WecomeFXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
