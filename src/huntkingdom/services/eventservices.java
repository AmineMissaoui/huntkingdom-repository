/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Events;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arif Sami
 */
public class eventservices {
    
     public void addevents(Events v) throws SQLException {
        String request = "INSERT INTO `events` (`id`,`first_name`,`last_name`)"
                + "VALUES (NULL, '" + p.getFirst_name() + "', '"
                + p.getLast_name() + "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
}
