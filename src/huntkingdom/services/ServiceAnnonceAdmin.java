/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Annonce_admin;
import entities.Article;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import huntkingdom.utils.MyDB;

/**
 *
 * @author FOCUS
 */
public class ServiceAnnonceAdmin {
     private Connection cnx; 
     
     private Connection cnx1;
    private Statement ste;
    private ResultSet rs;

    public ServiceAnnonceAdmin() {
    cnx=MyDB.getInstance().getConnection();
    
    }

    /**
     *
     * @param A
     * @throws SQLException
     */
    
    public void addAdmin(Annonce_admin A) throws SQLException {
        String request = "INSERT INTO `annonceadmin` (`titre_annonce`,`infos_annonce`,`date_annonce`,`adresse_annonce`,`img_ad` )"
                + "VALUES ( '" 
                +A.getTitre_annonce()+"', '"
                +A.getInfos_annonce()+"', '"
                +A.getDate_annonce()+"', '"
                +A.getAdresse_annonce()+"', '"
                +A.getImg_ad()+
                "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
public List<Annonce_admin> Displayadmin(){
        String req="select * from annonceadmin";
        List<Annonce_admin> list= new ArrayList<>();
       try {
           
           
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              list.add(new Annonce_admin(
 
                     rs.getInt("id_admin"),
                     rs.getString("titre_annonce"),
                     rs.getString("infos_annonce"),
                     rs.getString("date_annonce"),
                      rs.getString("adresse_annonce"),

                  
                      rs.getString("img_ad")
              ));
                      }
             } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }

public void updateAdmin(Annonce_admin A) throws SQLException, FileNotFoundException{
        String request= "UPDATE `annonceadmin` SET `titre_annonce`=?,`infos_annonce`=?,`date_annonce`=?,`adresse_annonce`=?,`img_ad`=? "+" where id_admin=?";
        PreparedStatement pst = cnx.prepareStatement(request);
       pst.setString(1, A.getTitre_annonce());
        pst.setString(2, A.getInfos_annonce());
        pst.setString(3, A.getDate_annonce());
        pst.setString(4, A.getAdresse_annonce());
         pst.setString(5, A.getImg_ad());
        pst.setInt(6, A.getId_admin());
       
 
 System.out.println(pst);
        
        pst.executeUpdate();
        }

 public void deleteAnnonceAdmin(int id){
        String request ="DELETE FROM `annonceadmin` WHERE id="+id;
        try {
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
        }
         catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
