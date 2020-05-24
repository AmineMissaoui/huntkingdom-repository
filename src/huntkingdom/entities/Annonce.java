
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
    private String gouvernorat;
    private String ville;
    private String description;
    private int numtel;

    public Annonce() {
    }

    public Annonce(int id, float prix, String titre, String categorie, String gouvernorat, String ville, String description, int numtel) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
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

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    @Override
    public String toString() {
        return "annonce{" + "id=" + id + ", prix=" + prix + ", titre=" + titre + ", categorie=" + categorie + ", gouvernorat=" + gouvernorat + ", ville=" + ville + ", description=" + description + ", numtel=" + numtel + '}';
    }

}
