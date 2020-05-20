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
public class Entreprise extends User{
    private String raison_sociale;
    private String matricule_fiscale;

    public Entreprise(){
        
    }
    
    public Entreprise(String raison_sociale, String matricule_fiscale, String email,String adress, String state, String city, String role, boolean active) {
        super(email,adress,state,city,role,active);
        this.raison_sociale = raison_sociale;
        this.matricule_fiscale = matricule_fiscale;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public String getMatricule_fiscale() {
        return matricule_fiscale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    public void setMatricule_fiscale(String matricule_fiscale) {
        this.matricule_fiscale = matricule_fiscale;
    }
    
}
