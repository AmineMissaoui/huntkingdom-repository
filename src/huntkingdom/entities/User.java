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
public class User {

    private int id;
    private String first_name;
    private String last_name;
    private String adresse;

    static Connection cnx;

    public User() {
    }

    public User(String first_name, String last_name, String adresse) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.adresse = adresse;
    }

    public User(String adresse) {
        this.adresse = adresse;
    }

    public User(int id, String first_name, String last_name, String adresse) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.adresse = adresse;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "users{" + "first_name=" + first_name + ", last_name=" + last_name + '}';
    }
}
