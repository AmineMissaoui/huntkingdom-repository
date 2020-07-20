/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Entreprise;
import huntkingdom.entities.User;
import huntkingdom.interfaces.IServiceUser;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amin
 */
public class ServiceUser implements IServiceUser{

    private Connection cnx;
    
    
    public ServiceUser(){
        cnx = MyDB.getInstance().getConnection();
    }
    public boolean validateCredentials(String username, String password) {
        String request = "SELECT * FROM `USERS` WHERE users_username = ? and users_password = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(request);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
        
        if(resultSet.next()){
            System.out.println("one user");
            return true;
        }else{
            System.out.println("no user");
            return false;
        }
        } catch (SQLException ex) {
            System.out.println("db-error" + ex.getMessage());
        }   
            return false;
            
    }
    public void addUser(User u) throws SQLException {
        String request = "INSERT INTO `USERS` (users_id, users_first_name, users_last_name,users_username,users_password,users_email,users_birthdate,users_adress,users_state,users_city,users_role,users_active) VALUES (NULL, "
                + "'" + u.getFirst_name() + "' , "
                + "'" + u.getLast_name() + "',"
                + "'" + u.getUsername() + "',"
                + "'" + u.getPassword() + "',"
                + "'" + u.getEmail() + "',"
                + "'" + u.getBirthdate() + "',"
                + "'" + u.getAdress() + "',"
                + "'" + u.getState() + "',"
                + "'" + u.getCity() + "',"
                + "'" + u.getRole() + "',"
                + "0 )";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    public void addEntreprise(Entreprise e) throws SQLException {
        String request = "INSERT INTO `USERS` (users_id, users_username,users_password,users_email,users_adress,users_state,users_city,users_role,users_active,users_raison_sociale,users_matricule_fiscale) VALUES (NULL, '" + e.getUsername()+"' , '" + e.getPassword() +"' ,'" + e.getEmail() +"', '" + e.getAdress() +"', '" + e.getState() +"' ,'" + e.getCity() +"', '" + e.getRole() +"',0,'" + e.getRaison_sociale() +"', '" + e.getMatricule_fiscale() +"' )";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> results = new ArrayList<User>();
        String request = "SELECT * FROM `USERS` WHERE users_role = 'A hobbyist'";
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
    
    public ArrayList<Entreprise> getEntreprise() throws SQLException {
        ArrayList<Entreprise> results = new ArrayList<Entreprise>();
        String request = "SELECT * FROM `USERS` WHERE users_role = 'An entreprise'";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Entreprise e = new Entreprise();
            e.setId(rst.getInt(1));
            e.setRaisonSociale(rst.getString(13));
            e.setMatriculeFiscale(rst.getString(14));
            results.add(e);
        }
        return results;
    }

    public void updateUser(User u) throws SQLException {
        String request = "UPDATE `users` SET `users_first_name` = ?, `users_first_name` = ? WHERE users_id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, u.getFirst_name());
        pst.setString(2, u.getLast_name());
        pst.setInt(3, u.getId());
        pst.executeUpdate();
    }
    
    public void updateUserState(User u) throws SQLException {
        String request = "UPDATE `users` SET `users_active` = ? WHERE users_id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        System.out.println(u.getId());
        pst.setInt(1, u.getActive());
        pst.setInt(2, u.getId());
        System.out.println(pst);
        pst.executeUpdate();
    }
    
    public int getCurrentUserState(User u) throws SQLException{
        String request = "SELECT `users_active` FROM `users` WHERE users_id=" + u.getId();
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        rst.next();
        int state = rst.getInt("users_active");
        System.out.println(state);
        return state;
    }
    
    public void deleteUser(User u) throws SQLException{
        String request = "DELETE FROM `USERS` WHERE users_id ="+ u.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    public User getByUsername(String username) throws SQLException{
        User u = new User();
        System.out.println(username + "the user requested");
        String request = "SELECT * FROM `USERS` WHERE users_username = '"+username+"'";
        System.out.println(request);
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        //System.out.println(rst);
        if(rst.next()){
            u.setId(rst.getInt(1));
            u.setFirst_name(rst.getString(2));
            u.setLast_name(rst.getString(3));
            u.setUsername(rst.getString(4));
            u.setPassword(rst.getString(5));
            u.setEmail(rst.getString(6));
            u.setBirthdate(rst.getTimestamp(7));
            u.setAdress(rst.getString(8));
            u.setState(rst.getString(9));
            u.setCity(rst.getString(10));
            u.setRole(rst.getString(11));
            u.setActive(rst.getInt(12));
            //if(u instanceof User){
            //    ((Entreprise) u).setRaisonSociale(rst.getString(13));
            //    ((Entreprise) u).setRaisonSociale(rst.getString(14));
            //}
        }
        System.out.println(u.getId());
        return u;
    }
}
