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
    
    public ArrayList<Entreprise> getEntreprise() throws SQLException {
        ArrayList<Entreprise> results = new ArrayList<Entreprise>();
        String request = "SELECT * FROM `USERS`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Entreprise e = new Entreprise();
            e.setId(rst.getInt(1));
            e.setRaisonSociale(rst.getString(12));
            e.setMatriculeFiscale(rst.getString(13));
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
    }
    
    public void deleteUser(User u) throws SQLException{
        String request = "DELETE FROM `USERS` WHERE users_id ="+ u.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}
