/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

/**
 *
 * @author FOCUS
 */
public class Annonce {
    private int id;
    private float prix;
    private String titre;
    private String categorie;
    private String description ;

    public Annonce() {
    }

    public Annonce(int id, float prix, String titre, String categorie, String description) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
    }

    public Annonce(float prix, String titre, String categorie, String description) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", prix=" + prix + ", titre=" + titre + ", categorie=" + categorie + ", description=" + description + '}';
    }
    
   

   
   

    

   
    

   

    
    
}
