package huntkingdom.services;

import huntkingdom.entities.Elearning;
import huntkingdom.entities.User;
import huntkingdom.interfaces.IServicesElearning;
import huntkingdom.utils.MyDB;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.*;
import java.util.UUID;

/**
 *
 * @author Akkari
 */
public class ServicesElearning implements IServicesElearning{
   private Connection cnx;
   
   public static final String PATH_REPO = "C:/wamp/www/cours/";
   
    public ServicesElearning(){
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void addLesson(Elearning e)  throws SQLException {
        
        copyFile(e);
        String request = "INSERT INTO `ELEARNING` (id , name, description , path) VALUES (NULL, '" + e.getName()+ "' , '" + e.getDescription() + "' , '"+PATH_REPO+".pdf')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
      
    }

    @Override
    public ArrayList<Elearning> getlessons()  throws SQLException  {
        ArrayList<Elearning> results = new ArrayList<Elearning>();
     
        String request = "SELECT * FROM `ELEARNING`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Elearning u = new Elearning(rst.getInt("id"),rst.getString("name"),
                    rst.getString("description"),rst.getString("path"));
         
            results.add(u);
        }
        
        return results;  
    }
    
   

    @Override
    public void updateLesson(Elearning e) throws SQLException {
       
        String request = "UPDATE `ELEARNING` SET `name` = ?, `description` = ? , `path` = ? WHERE id=?";
        
        PreparedStatement pst = cnx.prepareStatement(request);
        
        pst.setString(1 , e.getName());
        pst.setString(2 , e.getDescription());
        pst.setString(3 , e.getPath());
        pst.setInt(4 , e.getId());
        
        pst.executeUpdate();
       
     
    }

    @Override
    public void deleteLesson(Elearning u) throws SQLException {
       
        String request = "DELETE FROM `ELEARNING` WHERE id ="+ u.getId();
        
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
     
    }
    
    public void copyFile(Elearning e){
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try{
            File infile =new File(e.getPath());
            File outfile =new File(PATH_REPO +".pdf");

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);

            byte[] buffer = new byte[1024];

            int length;
            /*copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = instream.read(buffer)) > 0){
                outstream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            instream.close();
            outstream.close();

            System.out.println("File copied successfully!!");

        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }

}
