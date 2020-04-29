/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

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
public class Users {
    private int id;
    private String first_name;
    private String last_name;
    
    static Connection cnx;

    public Users() {
    }

    public Users(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    public Users(int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "users{" + "first_name=" + first_name + ", last_name=" + last_name + '}';
    }
    
    public static void addUser(Users u) throws SQLException{
        String request = "INSERT INTO `USERS` (users_id, users_first_name, users_first_name) VALUES (NULL, '"+ u.getFirst_name() +"' , '"+u.getLast_name()+"' )";
        Statement stm  = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    public static ArrayList<Users> getUsers() throws SQLException{
        ArrayList<Users> results = new ArrayList<>();
        String request = "SELECT * FROM users";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while(rst.next()){
            Users u = new Users();
            u.setId(rst.getInt("users_id"));
            u.setFirst_name(rst.getString("users_first_name"));
            u.setLast_name(rst.getString("users_first_name"));
            results.add(u);
        }
            return results;
    }
    
    public static void updateUsers(Users u) throws SQLException{
        String request = "UPDATE `users` SET `users_first_name` = ?, `users_first_name` = ? WHERE users_id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, u.getFirst_name());
        pst.setString(2, u.getLast_name());
        pst.setInt(3, u.getId());
    }
}
