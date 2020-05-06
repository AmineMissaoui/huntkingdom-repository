/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

/**
 *
 * @author Arif Sami
 */


public class Events {
    
    private int id;
    private String nom;
    private String adresse;

    public Events(int id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }
    public Events() {
        
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    

    
   

    @Override
    public String toString() {
        return "Events{" + "nom=" + nom + ", adresse" + adresse + ",id=" +id+ ", '}" ;
    }
    
    }
        


