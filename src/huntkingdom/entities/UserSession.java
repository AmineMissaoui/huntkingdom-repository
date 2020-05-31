/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

import huntkingdom.services.ServiceUser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AmineMissaoui
 */
public final class UserSession {

    private static UserSession instance;

    private String username;
    private String birthdate;

    private UserSession(String username) {
        ServiceUser se = new ServiceUser();
        try {
            User u = se.getByUsername(username);
            this.username = u.getUsername();
            this.birthdate = u.getBirthdate();
        } catch (SQLException ex) {
            System.out.println("error in constructor" + ex.getMessage());
        }
    }

    public static UserSession setInstance(String username) throws SQLException {
        if (instance == null) {
            instance = new UserSession(username);
        }
        return instance;
    }
    
    public static UserSession getInstance(){
        return instance;
    }

    public String getUsername() {
        return this.username;
    }
    
    public String getBirthdate() {
        return this.birthdate;
    }

    public void clearUserSession() {
        username = "";
    }

    @Override
    public String toString() {
        return "UserSession{" + "username=" + username + '}';
    }
}
