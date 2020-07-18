/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

import java.sql.Timestamp;

/**
 *
 * @author Arif Sami
 */
public class Event {

    public static void setnbPlace(Integer nb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setDescription(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setTitre(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int id;
    private String nom;
    private String adresse;
    private String date;
    private String heure_rendezvous;
    private String adresse_rendezvous ;
    private Timestamp jour_de_depart ;
    private Timestamp jour_de_retour ;
    private int createur;

    public Event(int id, String nom, String adresse, String date, String heure_rendezvous, String adresse_rendezvous, Timestamp jour_de_depart, Timestamp jour_de_retour, int createur) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.date = date;
        this.heure_rendezvous = heure_rendezvous;
        this.adresse_rendezvous = adresse_rendezvous;
        this.jour_de_depart = jour_de_depart;
        this.jour_de_retour = jour_de_retour;
        this.createur = createur;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_rendezvous() {
        return heure_rendezvous;
    }

    public void setHeure_rendezvous(String heure_rendezvous) {
        this.heure_rendezvous = heure_rendezvous;
    }

    public String getAdresse_rendezvous() {
        return adresse_rendezvous;
    }

    public void setAdresse_rendezvous(String adresse_rendezvous) {
        this.adresse_rendezvous = adresse_rendezvous;
    }

    public Timestamp getJour_de_depart() {
        return jour_de_depart;
    }

    public void setJour_de_depart(Timestamp jour_de_depart) {
        this.jour_de_depart = jour_de_depart;
    }

    public Timestamp getJour_de_retour() {
        return jour_de_retour;
    }

    public void setJour_de_retour(Timestamp jour_de_retour) {
        this.jour_de_retour = jour_de_retour;
    }

    public int getCreateur() {
        return createur;
    }

    public void setCreateur(int createur) {
        this.createur = createur;
    }

    
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", date=" + date + ", heure_rendezvous=" + heure_rendezvous + ", adresse_rendezvous=" + adresse_rendezvous + ", jour_de_depart=" + jour_de_depart + ", jour_de_retour=" + jour_de_retour + ", createur=" + createur + '}';
    }

    
   
    }
        

