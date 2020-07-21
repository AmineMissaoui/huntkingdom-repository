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
        String request =  "INSERT INTO events (event_id,event_title,event_description,event_start_date,event_end_date,event_meeting_place,event_destination,event_max_number )"
                + "VALUES (NULL, '" + v.getEvent_title()+  "', '"
                + v.getEvent_description()+"', '"
                + v.getEvent_start_date()+"', '"
                + v.getEvent_end_date()+"', '"
                + v.getEvent_meeting_place()+"', '"               
                +v.getEvent_destination()+"', '"  
                +v.getEvent_max_number()+"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
     
     
     
     public ArrayList<Event> GetEvents() throws SQLException{
        ArrayList<Event> results = new ArrayList<>();
        
        String query = "SELECT * FROM `events`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            Event v = new Event();
            v.setId(rst.getInt(1));
            v.setEvent_title(rst.getString(2));
            v.setEvent_description(rst.getString(3));
            v.setEvent_start_date(rst.getTimestamp(4));
            v.setEvent_end_date(rst.getTimestamp(5));
            v.setEvent_meeting_place(rst.getString(6));
            
            v.setEvent_destination(rst.getString(7));
            v.setEvent_max_number(rst.getInt(8));
            
            results.add(v);
              
     }
         
      return results;  
   } 
     public void updateEvents(Event v) throws SQLException{                 
          String request= "UPDATE `Personne` SET `Nom`=?, `adresse`=?"
                + "WHERE id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        
        pst.setString(1, v.getEvent_title());
        pst.setString(2, v.getEvent_description());
        pst.setInt(3, v.getId());
        System.out.println(pst);
        
        pst.executeUpdate();
    }
     public void deleteEvents(Event v) throws SQLException {
        String request ="DELETE FROM `Events` WHERE event_id="+v.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
          
          
      
          
       

}        
        

        

        
    

        
    
   


