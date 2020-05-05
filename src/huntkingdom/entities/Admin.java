/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

/**
 *
 * @author amin
 */
public class Admin extends User {

    private String matricule;

    public Admin() {

    }

    public Admin(String first_name, String last_name, String adress, String matricule) {
        super(first_name, last_name, adress);
        this.matricule = matricule;
    }

    public Admin(int id, String first_name, String last_name, String adress, String matricule) {
        super(id, first_name, last_name, adress);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Admin{" + "matricule=" + matricule + '}';
    }

}
