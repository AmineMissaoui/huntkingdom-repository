/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.utils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Me
 */
public class JavaFTP {
    String url = "ftp://127.0.0.1";
    int port = 21;

    String login ="huntkingdom";
    String password ="huntkingdom";
    FTPClient ftpClient = new FTPClient();
    static JavaFTP instanceClientFTP;
    private JavaFTP(){
        try {
            
            
            ftpClient.connect(url, port);
            ftpClient.login(login, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException ex) {
ex.printStackTrace();        }
}
    public FTPClient getFTPClient(){
    return ftpClient;
    }
        public static JavaFTP getInstance(){
        if(instanceClientFTP == null)
            instanceClientFTP = new JavaFTP();
        return instanceClientFTP;
    }
 
    
}
