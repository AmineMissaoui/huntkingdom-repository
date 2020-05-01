/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.interfaces;

import huntkingdom.entities.User;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author amin
 */
public interface IServiceUser {
    
    public void addUser(User u) throws SQLException;
    public ArrayList<User> getUsers() throws SQLException;
    public void updateUser(User u) throws SQLException;
    public void deleteUser(User u) throws SQLException;
    
}
