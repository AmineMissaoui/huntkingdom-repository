/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom;

import huntkingdom.entities.User;
import huntkingdom.services.ServiceUser;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AmineMissaoui
 */
public class HuntKingdom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Connection conection = new MyDB().getInstance().getConnection();
        ServiceUser su = new ServiceUser();
        
        User u1 = new User("Amine", "Missaoui");
        User u2 = new User("Akrem", "Amdouni");
        

        
        try {
            System.out.println(su.getUsers());
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }
    
}
