/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

import java.sql.Date;

/**
 *
 * @author FOCUS
 */
public class Annonce_admin {
    
    private int id_admin;
    private String titre_annonce;
    private String infos_annonce;
    private String date_annonce;
    private String adresse_annonce;
    private String img_ad;

    public Annonce_admin() {
    }

    public Annonce_admin(int id_admin, String titre_annonce, String infos_annonce, String adresse_annonce, String img_ad) {
        this.id_admin = id_admin;
        this.titre_annonce = titre_annonce;
        this.infos_annonce = infos_annonce;
        this.adresse_annonce = adresse_annonce;
        this.img_ad = img_ad;
    }

    public Annonce_admin(String titre_annonce, String infos_annonce, String date_annonce, String adresse_annonce) {
        this.titre_annonce = titre_annonce;
        this.infos_annonce = infos_annonce;
        this.date_annonce = date_annonce;
        this.adresse_annonce = adresse_annonce;
    }
    

    public Annonce_admin(int id_admin, String titre_annonce, String infos_annonce, String date_annonce, String adresse_annonce, String img_ad) {
        this.id_admin = id_admin;
        this.titre_annonce = titre_annonce;
        this.infos_annonce = infos_annonce;
        this.date_annonce = date_annonce;
        this.adresse_annonce = adresse_annonce;
        this.img_ad = img_ad;
    }

    public Annonce_admin(String titre_annonce, String infos_annonce, String date_annonce, String adresse_annonce, String img_ad) {
        this.titre_annonce = titre_annonce;
        this.infos_annonce = infos_annonce;
        this.date_annonce = date_annonce;
        this.adresse_annonce = adresse_annonce;
        this.img_ad = img_ad;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setTitre_annonce(String titre_annonce) {
        this.titre_annonce = titre_annonce;
    }

    public void setInfos_annonce(String infos_annonce) {
        this.infos_annonce = infos_annonce;
    }

    public void setDate_annonce(String date_annonce) {
        this.date_annonce = date_annonce;
    }

    public void setAdresse_annonce(String adresse_annonce) {
        this.adresse_annonce = adresse_annonce;
    }

    public void setImg_ad(String img_ad) {
        this.img_ad = img_ad;
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getTitre_annonce() {
        return titre_annonce;
    }

    public String getInfos_annonce() {
        return infos_annonce;
    }

    public String getDate_annonce() {
        return date_annonce;
    }

    public String getAdresse_annonce() {
        return adresse_annonce;
    }

    public String getImg_ad() {
        return img_ad;
    }

    @Override
    public String toString() {
        return "Annonce_admin{" + "id_admin=" + id_admin + ", titre_annonce=" + titre_annonce + ", infos_annonce=" + infos_annonce + ", date_annonce=" + date_annonce + ", adresse_annonce=" + adresse_annonce + ", img_ad=" + img_ad + '}';
    }
    
    
    
    
    
    
}
