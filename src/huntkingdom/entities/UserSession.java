/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

import huntkingdom.services.ServiceUser;
import java.sql.SQLException;

/**
 *
 * @author AmineMissaoui
 */
public final class UserSession {

    private static UserSession instance;

    private String username;

    private UserSession() {
        //this.username = username;
    }

    public static UserSession setInstance(String username) throws SQLException {
        if (instance == null) {
            ServiceUser se = new ServiceUser();
            System.out.println(username + " yes");
            se.getByUsername(username);
            User u = new User();
            instance = new UserSession();
        }
        return instance;
    }
    
    public static UserSession getInstance(){
        return instance;
    }

    public String getUsername() {
        return this.username;
    }

    public void clearUserSession() {
        username = "";
    }

    @Override
    public String toString() {
        return "UserSession{" + "username=" + username + '}';
    }
}
