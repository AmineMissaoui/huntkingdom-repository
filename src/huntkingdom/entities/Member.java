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
public class Member extends User{
    
    private String pseudo;
    private int nbr_amis;
    
    public Member(){
        
    }
    public Member(String first_name, String last_name, String adress, String pseudo, int nbr_amis){
        super(first_name,last_name,adress);
        this.pseudo = pseudo;
        this.nbr_amis = nbr_amis;
    }
    
    public Member(int id, String first_name, String last_name, String adress, String pseudo, int nbr_amis){
        super(id, first_name,last_name,adress);
        this.pseudo = pseudo;
        this.nbr_amis = nbr_amis;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getNbr_amis() {
        return nbr_amis;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setNbr_amis(int nbr_amis) {
        this.nbr_amis = nbr_amis;
    }

    @Override
    public String toString() {
        return "Member{" + "pseudo=" + pseudo + ", nbr_amis=" + nbr_amis + '}';
    }
    
}
