/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom;

import huntkingdom.entities.Group;
import huntkingdom.services.GroupService;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Me
 */
public class MainTest {
        static Connection cnx;

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Group g1 = new Group(10, "chasse", "chasse description");

        Group g2 = new Group("peche", "peche description");
      //  Group g3=new Group("abc", "abc");

        GroupService sp = new GroupService();
        
        try {
            //sp.addGroup(g1);
                      //  sp.addGroup(g2);
            g2.setNom("ambc");
            g2.setId(19);

            sp.getGroups().forEach(g-> System.out.println(g.getId() + g.toString()));
            //p6.setId(6);
            //p6.setFirst_name("TEST FIRSTNAME");
            sp.updateGroup(g2);
            System.out.println("******************************************************");
           // sp.getGroups().forEach(g-> System.out.println(g.getId() + g.toString()));
          //  sp.deleteGroup(g2);
           // sp.deleteGroup(g1);
            System.out.println("******************************************************");
            sp.getGroups().forEach(g-> System.out.println(g.getId() + g.toString()));
            
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des personnes");
        }

    }


    
}
