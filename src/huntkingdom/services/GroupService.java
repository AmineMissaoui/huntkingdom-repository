/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Group;
import huntkingdom.utils.JavaFTP;
import huntkingdom.utils.MyDB;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
/**
 *
 * @author Me
 */
public class GroupService {
        private Connection cnx;
        private FTPClient ftpC;


    public GroupService() {
        cnx=MyDB.getInstance().getConnection();
       // ftpC=JavaFTP.getInstance().getFTPClient();
    }
    

    
    public void addGroup(Group g) throws SQLException {
        FileInputStream fis = null;
        boolean Store=false;
        
        String request1 = "INSERT INTO `groupe` (`id`,`nom`,`description`,`image`)"
                + "VALUES (NULL, ?,?,?)";
        
               String request2 = "INSERT INTO `groupe` (`id`,`nom`,`description`)"
                + "VALUES (NULL,`"+g.getNom()+"`,`"+g.getDescription()+"`)";

        if(g.getImageFile()!=null){
               // String path = ftpC.printWorkingDirectory();
                String urlImageFileFTP = "img"+g.getNom()+".jpg";
                String imageLocalPath=g.getImageFile().getAbsolutePath();
                try{
                    
                    fis= new FileInputStream(g.getImageFile());
                    
                    Store=ftpC.storeFile(urlImageFileFTP, fis);
                    fis.close();
                    ftpC.logout();
                    System.out.println(Store);
                    String request3 = "INSERT INTO `groupe` (`nom`,`description`,`image`)"
                            + "VALUES (?,?,?)";
                    
                    
                    PreparedStatement stm = cnx.prepareStatement(request3);
                    stm.setString(1, g.getNom());
                    stm.setString(2, g.getDescription());
                    stm.setString(3, urlImageFileFTP);
                    stm.executeUpdate();
                } catch (FileNotFoundException ex) {
                    System.out.println("error no image attached ");;
                }
                catch (IOException ex) {
                    Logger.getLogger(GroupService.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
            

          
        
        }
       else     {    
                             PreparedStatement stm = cnx.prepareStatement(request2);
                    stm.setString(1, g.getNom());
                    stm.setString(2, g.getDescription());

            stm.executeUpdate();
        }
        
        }

    public ArrayList<Group> getGroups() throws SQLException{
        ArrayList<Group> results = new ArrayList<>();
            try {
                   String query = "SELECT * FROM `groupe`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        int i=0;
        while (rst.next()){

            Group g = new Group();
            g.setId(rst.getInt("id"));
            g.setNom(rst.getString(2));
            g.setDescription(rst.getString(3));
if(rst.getBinaryStream("image")!=null){

            File imgFile=new File("temp"+i+".jpg");
            i++;
            FileOutputStream output = new FileOutputStream(imgFile);

            InputStream input = rst.getBinaryStream("image");
            byte[] buffer=new byte[600];
         
                while(input.read(buffer)>0){
                    output.write(buffer);
                    
                }
                g.setImageFile(imgFile);}
else g.setImageFile(null);
                         results.add(g);

        }
            } catch (IOException ex) {
                System.out.println("erreur d'affichage service group");;
            }
        return results; 
    }
    
    public void updateGroup(Group g) throws SQLException{
        String request= "UPDATE `groupe` SET `nom`='"+g.getNom()+"', `description`='"+g.getDescription()+"' WHERE id="+g.getId();
        Statement pst = cnx.createStatement();
        
//        System.out.println(pst);
        
        pst.executeUpdate(request);
    }

    public void deleteGroup(Group g) throws SQLException {
        String request ="DELETE FROM `groupe` WHERE id="+g.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    
}
