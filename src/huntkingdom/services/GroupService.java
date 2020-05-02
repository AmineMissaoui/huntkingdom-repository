/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Group;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Me
 */
public class GroupService {
        private Connection cnx;

    public GroupService() {
        cnx=MyDB.getInstance().getConnection();
    }
    
    
    
    public void addGroup(Group g) throws SQLException {
        String request = "INSERT INTO `groupe` (`id`,`nom`,`description`)"
                + "VALUES (NULL, '" + g.getNom() + "', '"
                + g.getDescription() + "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Group> getGroups() throws SQLException{
        ArrayList<Group> results = new ArrayList<>();
        
        String query = "SELECT * FROM `groupe`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            Group g = new Group();
            g.setId(rst.getInt("id"));
            g.setNom(rst.getString(2));
            g.setDescription(rst.getString(3));
            results.add(g);
        }
        
        return results; 
    }
    
    public void updateGroup(Group g) throws SQLException{
        String request= "UPDATE `groupe` SET `nom`='"+g.getNom()+"', `description`='"+g.getDescription()+"' WHERE id="+g.getId();
        Statement pst = cnx.createStatement();
        
//        System.out.println(pst);
        
        pst.executeUpdate(request);
    }

    public void deleteGroup(Group g) throws SQLException {
        String request ="DELETE FROM `groupe` WHERE id="+g.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    
}
