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
public class Article extends Annonce{
    private String gouvernorat;
    private String ville;
    private int numtel;

    public Article() {
    }

   

    public Article(int id,float prix,String titre, String categorie,String gouvernorat, String ville, String description, int numtel) {
        super(id, prix, titre, categorie, description);
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.numtel = numtel;
    }

    public Article(float prix,String titre, String categorie,String gouvernorat, String ville, String description, int numtel) {
        super(prix, titre, categorie, description);
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.numtel = numtel;
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

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

   
    @Override
    public String toString(){
        return (super.toString()+" ,gouvernorat="+gouvernorat+" ,ville="+ville+" ,numtel="+numtel);

 
    }
    
       
  



}
