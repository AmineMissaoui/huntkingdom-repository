/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Event;
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
public class ServiceEvent {
     private Connection cnx;
     
     public ServiceEvent() {
        cnx=MyDB.getInstance().getConnection();
    }
    
     public void addevents(Event v) throws SQLException {
        String request = v.getJour_de_retour()
                + "INSERT INTO `events` (`id`,`nom`,`adresse `)"
                + "VALUES (NULL, '" + v.getNom()+  "', '"
                + v.getAdresse_rendezvous()+"', '"
                + v.getHeure_rendezvous()+"', '"
                + v.getJour_de_depart()+"', '"
                + v.getJour_de_retour()+"', '"               
                +v.getAdresse()+ "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
     
     
     
     public ArrayList<Event> GetEvents() throws SQLException{
        ArrayList<Event> results = new ArrayList<>();
        
        String query = "SELECT * FROM `event`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            Event v = new Event();
            v.setId(rst.getInt("id"));
            v.setNom(rst.getString(2));
            v.setAdresse(rst.getString(3));
            results.add(v);
              
     }
         
      return results;  
   } 
     public void updateEvents(Event v) throws SQLException{                 
          String request= "UPDATE `Personne` SET `Nom`=?, `adresse`=?"
                + "WHERE id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        
        pst.setString(1, v.getNom());
        pst.setString(2, v.getAdresse());
        pst.setInt(3, v.getId());
        System.out.println(pst);
        
        pst.executeUpdate();
    }
     public void deleteEvents(Event v) throws SQLException {
        String request ="DELETE FROM `Events` WHERE id="+v.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
          
          
      
          
       

}        
        

        

        
    

        
    
   


