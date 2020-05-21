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
    private String raisonSociale;
    private String matriculeFiscale;

    public Entreprise(){
        
    }
    
    public Entreprise(String raison_sociale, String matricule_fiscale, String password, String email,String adress, String state, String city, String role, boolean active) {
        super(password,email,adress,state,city,role,active);
        this.raisonSociale = raison_sociale;
        this.matriculeFiscale = matricule_fiscale;
    }

    public String getRaison_sociale() {
        return raisonSociale;
    }

    public String getMatricule_fiscale() {
        return matriculeFiscale;
    }

    public void setRaisonSociale(String raison_sociale) {
        this.raisonSociale = raison_sociale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }
    
}
