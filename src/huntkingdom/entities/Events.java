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
import java.sql.Timestamp;


public class Events {
    
    private int id;
    private String nom;
    private String adresse;
    private float adresse_longitude;
    private float adresse_altitude;
    private String date;
    private String heure;
    private float point_derendezvous_longitude ;
    private float point_derendezvous_altitude ;
    private Timestamp jour_de_depart ;
    private Timestamp jour_de_retour ;

    public Events(int id, String nom, String adresse, float adresse_longitude, float adresse_altitude, String date, String heure, float point_derendezvous_longitude, float point_derendezvous_altitude, Timestamp jour_de_depart, Timestamp jour_de_retour) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.adresse_longitude = adresse_longitude;
        this.adresse_altitude = adresse_altitude;
        this.date = date;
        this.heure = heure;
        this.point_derendezvous_longitude = point_derendezvous_longitude;
        this.point_derendezvous_altitude = point_derendezvous_altitude;
        this.jour_de_depart = jour_de_depart;
        this.jour_de_retour = jour_de_retour;
    }

    public Events(String nom, String adresse, float adresse_longitude, float adresse_altitude, String date, String heure, float point_derendezvous_longitude, float point_derendezvous_altitude, Timestamp jour_de_depart, Timestamp jour_de_retour) {
        this.nom = nom;
        this.adresse = adresse;
        this.adresse_longitude = adresse_longitude;
        this.adresse_altitude = adresse_altitude;
        this.date = date;
        this.heure = heure;
        this.point_derendezvous_longitude = point_derendezvous_longitude;
        this.point_derendezvous_altitude = point_derendezvous_altitude;
        this.jour_de_depart = jour_de_depart;
        this.jour_de_retour = jour_de_retour;
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

    public float getAdresse_longitude() {
        return adresse_longitude;
    }

    public float getAdresse_altitude() {
        return adresse_altitude;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public float getPoint_derendezvous_longitude() {
        return point_derendezvous_longitude;
    }

    public float getPoint_derendezvous_altitude() {
        return point_derendezvous_altitude;
    }

    public Timestamp getJour_de_depart() {
        return jour_de_depart;
    }

    public Timestamp getJour_de_retour() {
        return jour_de_retour;
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

    public void setAdresse_longitude(float adresse_longitude) {
        this.adresse_longitude = adresse_longitude;
    }

    public void setAdresse_altitude(float adresse_altitude) {
        this.adresse_altitude = adresse_altitude;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setPoint_derendezvous_longitude(float point_derendezvous_longitude) {
        this.point_derendezvous_longitude = point_derendezvous_longitude;
    }

    public void setPoint_derendezvous_altitude(float point_derendezvous_altitude) {
        this.point_derendezvous_altitude = point_derendezvous_altitude;
    }

    public void setJour_de_depart(Timestamp jour_de_depart) {
        this.jour_de_depart = jour_de_depart;
    }

    public void setJour_de_retour(Timestamp jour_de_retour) {
        this.jour_de_retour = jour_de_retour;
    }

   

    @Override
    public String toString() {
        return "events{" + "nom=" + nom + ", adresse" + adresse + ",jour_de_depart=" +jour_de_depart+ ",jour_de_retour=" +jour_de_retour+ '}';
    }
    
    }
        


