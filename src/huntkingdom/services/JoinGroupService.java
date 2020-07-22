/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.JoinGroup;
import huntkingdom.entities.Message;
import huntkingdom.utils.MyDB;
import huntkingdom.utils.UserSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Me
 */
public class JoinGroupService {
            private UserSession session ;

           private Connection cnx;

    public JoinGroupService() {
        cnx=MyDB.getInstance().getConnection();
                session=UserSession.getInstance();

    }
    
    
    
    public void addJoinGroup(JoinGroup j) throws SQLException {
        String request = "INSERT INTO `join_group` (`users_id`,`group_id`) VALUES ('" +session.getId()+"','"+j.getGroupId()+"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<JoinGroup> getJoinGroup() throws SQLException{
        ArrayList<JoinGroup> results = new ArrayList<>();
        
        String query = "SELECT * FROM `joinGroup`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            JoinGroup j = new JoinGroup();
            j.setDate(rst.getDate(1));
            j.setUserId(rst.getInt(2));
            j.setGroupId(rst.getInt(3));
            results.add(j);
        }
        
        return results; 
    }
    

    public void deleteJoinGroup(JoinGroup j) throws SQLException {
        String request ="DELETE FROM `JoinGroup` WHERE userId="+j.getUserId()+" and groupId ="+j.getGroupId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    
    
}
