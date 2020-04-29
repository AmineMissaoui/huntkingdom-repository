/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amin
 */
public class MyDB {
    String url = "jdbc:mysql://127.0.0.1:3306/huntkingdom";
    String login ="huntkingdom";
    String password ="huntkingdom";
    
    Connection cnx;
    
    static MyDB instance;

    private MyDB() {
        try {
            this.cnx = DriverManager.getConnection(url, login, password);
            System.out.println("connected");
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
    public static MyDB getInstance(){
        if(instance == null)
            instance = new MyDB();
        return instance;
    }
    
    public Connection getConnection (){
        return cnx;
    }
}
