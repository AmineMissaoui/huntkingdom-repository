/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Publication;
import huntkingdom.interfaces.IServicePublication;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AmineMissaoui
 */
public class ServicePublication implements IServicePublication{
    
    private Connection cnx;

    public ServicePublication() {
        
        cnx = MyDB.getInstance().getConnection();
        
    }
    
    public void addPublication(Publication pub) throws SQLException{
        String query = "INSERT INTO `publication` (publication_id,publication_title,publication_content,publication_description) VALUES (null,'" + pub.getTitle() +"','" + pub.getContent() +"', '" + pub.getDescription()+"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(query);
    }
    
}
