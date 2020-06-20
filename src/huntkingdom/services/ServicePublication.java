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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public ArrayList<Publication> getPublications() throws SQLException{
        ArrayList<Publication> publications = new ArrayList<>();
        String query = "SELECT * FROM `publication`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(query);
        while(rst.next()){
            Publication pub = new Publication();
            pub.setId(rst.getInt(1));
            pub.setTitle(rst.getString(2));
            pub.setContent(rst.getString(3));
            pub.setDescription(rst.getString(4));
            publications.add(pub);
        }
        return publications;
    }
}
