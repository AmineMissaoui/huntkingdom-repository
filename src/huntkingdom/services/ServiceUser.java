/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.User;
import huntkingdom.interfaces.IServiceUser;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amin
 */
public class ServiceUser implements IServiceUser{

    private Connection cnx;
    
    public ServiceUser(){
        cnx = MyDB.getInstance().getConnection();
    }

    public void addUser(User u) throws SQLException {
        String request = "INSERT INTO `USERS` (users_id, users_first_name, users_last_name,user_adresse) VALUES (NULL, '" + u.getFirst_name() + "' , '" + u.getLast_name() + "' , '"+u.getAdresse()+"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> results = new ArrayList<User>();
        String request = "SELECT * FROM `USERS`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            User u = new User();
            u.setId(rst.getInt(1));
            u.setFirst_name(rst.getString(2));
            u.setLast_name(rst.getString(3));
            results.add(u);
        }
        return results;
    }

    public void updateUser(User u) throws SQLException {
        String request = "UPDATE `users` SET `users_first_name` = ?, `users_first_name` = ?, `users_adresse`=? WHERE users_id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, u.getFirst_name());
        pst.setString(2, u.getLast_name());
        pst.setString(3, u.getAdresse());
        pst.setInt(4, u.getId());
    }
    
    public void deleteUser(User u) throws SQLException{
        String request = "DELETE FROM `USERS` WHERE users_id ="+ u.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}
