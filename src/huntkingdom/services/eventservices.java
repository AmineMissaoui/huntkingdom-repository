/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Events;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Arif Sami
 */
public class eventservices {
     private Connection cnx;
     
     public eventservices() {
        cnx=MyDB.getInstance().getConnection();
    }
    
     public void addevents(Events v) throws SQLException {
        String request = "INSERT INTO `events` (`id`,`nom`,`adresse `)"
                + "VALUES (NULL, '" + v.getNom()+  "', '"
                +v.getAdresse()+ "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
     
     
     
     public ArrayList<Events> GetEvents() throws SQLException{
        ArrayList<Events> results = new ArrayList<>();
        
        String query = "SELECT * FROM `events`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            Events v = new Events();
            v.setId(rst.getInt("id"));
            v.setNom(rst.getString(2));
            v.setAdresse(rst.getString(3));
            results.add(v);
              
     }
         
      return results;  
   } 
     public void updateEvents(Events v) throws SQLException{                 
          String request= "UPDATE `Personne` SET `Nom`=?, `adresse`=?"
                + "WHERE id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        
        pst.setString(1, v.getNom());
        pst.setString(2, v.getAdresse());
        pst.setInt(3, v.getId());
        System.out.println(pst);
        
        pst.executeUpdate();
    }
     public void deleteEvents(Events v) throws SQLException {
        String request ="DELETE FROM `Events` WHERE id="+v.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
          
          
      
          
       

}        
        

        

        
    

        
    
   


