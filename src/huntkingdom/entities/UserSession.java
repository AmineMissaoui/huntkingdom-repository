/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

/**
 *
 * @author AmineMissaoui
 */
public final class UserSession {

    private static UserSession instance;

    private String username;

    private UserSession(String username) {
        this.username = username;
    }

    public static UserSession getInstance(String username) {
        if (instance == null) {
            instance = new UserSession(username);
        }
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
