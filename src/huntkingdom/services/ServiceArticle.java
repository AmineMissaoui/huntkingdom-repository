/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Article;
import huntkingdom.utils.MyDB;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author FOCUS
 */
public class ServiceArticle {
     private Connection cnx; 

    public ServiceArticle() {
        cnx=MyDB.getInstance().getConnection();
    
    }

    /**
     *
     * @param A
     * @throws SQLException
     */
    public void addArticle(Article A) throws SQLException {
        String request = "INSERT INTO `Article` (`prix`,`titre`,`categorie`,`gouvernorat`,`ville`,`description`,`numtel` )"
                + "VALUES ( '" 
                +A.getPrix()+"', '"
                +A.getTitre()+"', '"
                +A.getCategorie()+"', '"
                +A.getGouvernorat()+"', '"
                +A.getVille()+"', '"
                +A.getDescription()+"', '"
                +A.getNumtel()+ 
                "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    
public ArrayList<Article> getArticle() throws SQLException{
        ArrayList<Article> results = new ArrayList<>();
String query = "SELECT * FROM `Article`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            
            Article A = new Article();
            
            A.setId(rst.getInt(1));
            A.setPrix(rst.getFloat(2));
            A.setTitre(rst.getString(3));
            A.setCategorie(rst.getString(4));
            A.setGouvernorat(rst.getString(5));
            A.setVille(rst.getString(6));
            A.setDescription(rst.getString(7));
            A.setNumtel(rst.getInt(8));
            results.add(A);
        }
        
        return results; 
    }
 public void deleteArticle(int id) throws SQLException {
        String request ="DELETE FROM `Article` WHERE id="+id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }



 public void updateArticle(Article A) throws SQLException, FileNotFoundException{
        String request= "UPDATE `article` SET `prix`=?,`titre`=?,`categorie`=?,`gouvernorat`=?,`ville`=?,`description`=?,`numtel`=? "+" where id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setFloat(1, A.getPrix());
        pst.setString(2, A.getTitre());
        pst.setString(3, A.getCategorie());
        pst.setString(4, A.getGouvernorat());
        pst.setString(5, A.getVille());
        pst.setString(6, A.getDescription());
        pst.setInt(7, A.getNumtel());
        pst.setInt(8, A.getId());
 
 System.out.println(pst);
        
        pst.executeUpdate();
        }
    
}
