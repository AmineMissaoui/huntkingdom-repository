/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author amin
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private Timestamp birthdate;
    private String adress;
    private String state;
    private String city;
    private String role;
    private int active;

    static Connection cnx;

    public User() {
    }

    public User(String username, String password, String first_name, String last_name, String email, Timestamp birthdate, String adress, String state, String city, String role, int active) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.birthdate = birthdate;
        this.adress = adress;
        this.state = state;
        this.city = city;
        this.role = role;
        this.active = active;
    }

    public User(int id, String username, String password, String first_name, String last_name, String email, Timestamp birthdate, String adress, String state, String city, String role, int active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.birthdate = birthdate;
        this.adress = adress;
        this.state = state;
        this.city = city;
        this.role = role;
        this.active = active;
    }
    
    public User(String password, String email,String adress, String state, String city, String role, int active){
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.state = state;
        this.city = city;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public String getAdress() {
        return adress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getRole() {
        return role;
    }

    public int getActive() {
        return active;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", birthdate=" + birthdate + ", adress=" + adress + ", state=" + state + ", city=" + city + ", role=" + role + ", active=" + active + '}';
    }

}
