/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Group;
import huntkingdom.entities.Message;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Me
 */
public class MessageService {
           private Connection cnx;

    public MessageService() {
        cnx=MyDB.getInstance().getConnection();
    }
    
    
    
    public void addMessage(Message m) throws SQLException {
        String request = "INSERT INTO `message` (`id`,`content`) VALUES (NULL, '" + m.getContent()+"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Message> getMessages() throws SQLException{
        ArrayList<Message> results = new ArrayList<>();
        
        String query = "SELECT * FROM `message`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            Message m = new Message();
            m.setId(rst.getInt("id"));
            m.setContent(rst.getString(2));
            results.add(m);
        }
        
        return results; 
    }
    
    public void updateMessage(Message m) throws SQLException{
        String request= "UPDATE `message` SET `content`='"+m.getContent()+"' WHERE id="+m.getId();
        Statement pst = cnx.createStatement();
        
//        System.out.println(pst);
        
        pst.executeUpdate(request);
    }

    public void deleteMessage(Message m) throws SQLException {
        String request ="DELETE FROM `Message` WHERE id="+m.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    
    
}
