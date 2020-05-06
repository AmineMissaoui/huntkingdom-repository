/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom;

import huntkingdom.entities.Events;
import huntkingdom.entities.Events;
import huntkingdom.services.eventservices;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author AmineMissaoui
 */
public class HuntKingdom_event_test {
    

    static Connection cnx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Events v1 = new Events(10, "benzart", "vacances");
        Events v2 = new Events(10, "benzart", "vacances");
        Events v3 = new Events(10, "benzart", "vacances");

      

        eventservices es = new eventservices();
        
        try {
            /**es.addevents(v3);**/
            es.GetEvents().forEach(v-> System.out.println(v.getId() + v.toString()));
            v3.setId(3);
            v3.setNom("TEST NOM");
            es.updateEvents(v3);
            System.out.println("******************************************************");
            es.GetEvents().forEach(v-> System.out.println(v.getId() + v.toString()));
            es.deleteEvents(v3);
            System.out.println("******************************************************");
            es.GetEvents().forEach(v-> System.out.println(v.getId() + v.toString()));
            
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des evenements");
        }

    }

        
        
        // TOMyDB()DO code application logic here
  }
   
