/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;


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
import huntkingdom.entities.User;
import huntkingdom.utils.UserSession;

/**
 *
 * @author FOCUS
 */
public class ServiceArticle {
     private Connection cnx; 
     private Connection cnx1;
    private Statement ste;
    private ResultSet rs;
private UserSession instance;
    public ServiceArticle() {
        cnx=MyDB.getInstance().getConnection();
    instance = UserSession.getInstance();
    }

    /**
     *
     * @param A
     * @throws SQLException
     */
    
    ////////////////ajout article////////////////////////////////
    public void addArticle(Article A) throws SQLException {
        String request = "INSERT INTO `Article` (`prix`,`titre`,`categorie`,`gouvernorat`,`ville`,`description`,`numtel`,`image_ev`,`user_id`  )"
                + "VALUES ( '" 
                +A.getPrix()+"', '"
                +A.getTitre()+"', '"
                +A.getCategorie()+"', '"
                +A.getGouvernorat()+"', '"
                +A.getVille()+"', '"
                +A.getDescription()+"', '"
                +A.getNumtel()+ "', '"
                +A.getImage_ev()+ "', '"
                +instance.getId()+
                "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
//////////////////////////////////////////////////////////////////
    ////////////////////////affichage article///////////////////////////
    /*public ArrayList<Article> displayAllArticle() throws SQLException{
        String requete="SELECT * FROM `annonce`" ;
        ste=cnx.createStatement() ;
        rs=ste.executeQuery(requete);
        ArrayList<Article> list =new ArrayList<>();
          while(rs.next()){
                list.add(new Article(
                        rs.getInt("id"),
                        rs.getFloat("prix"),
                        rs.getString("titre"),
                        rs.getString("categorie"),
                        rs.getString("gouvernorat"),
                        rs.getString("ville"),
                        rs.getString("description"),
                        rs.getInt("Numtel")

                ));
                
            }
        return list ;
    } */
    //////////////////////////////////////////////////////////////////
  //////////////////  affichage article 2eme methode///////////////////
/*public ArrayList<Article> getArticle() throws SQLException{
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
            System.out.println(A);
        }
        
        return results; 
    }*/
//////////////////////////////////////////////////////////////

//////////////////supprimer article par id/////////////////////////
 public void deleteArticle(int id){
        String request ="DELETE FROM `Article` WHERE id="+id;
        try {
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
        }
         catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
///////////////////////////////////////////////////////////
public void deleteArticle(String titre) throws SQLException {
      try {
        String request ="DELETE FROM `Article` WHERE titre="+titre;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
     catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
}
/////////////////////////////modifier article///////////////////////////
 public void updateArticle(Article A) throws SQLException, FileNotFoundException{
        String request= "UPDATE `article` SET `prix`=?,`titre`=?,`categorie`=?,`gouvernorat`=?,`ville`=?,`description`=?,`numtel`=?,`image_ev`=? "+" where id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
       pst.setFloat(1, A.getPrix());
        pst.setString(2, A.getTitre());
        pst.setString(3, A.getCategorie());
        pst.setString(4, A.getGouvernorat());
        pst.setString(5, A.getVille());
        pst.setString(6, A.getDescription());
        pst.setInt(7, A.getNumtel());
         pst.setString(8, A.getImage_ev());
        pst.setInt(9, A.getId());
       
 
 System.out.println(pst);
        
        pst.executeUpdate();
        }
 //////////////////////////////////////////////////////////////////
      public List<Article> Display(){
        String req="select * from article";
        List<Article> list= new ArrayList<>();
       try {
           
           
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              list.add(new Article(
 
                     rs.getInt("id"),
                     rs.getFloat("prix"),
                     rs.getString("titre"),
                     rs.getString("categorie"),
                      rs.getString("gouvernorat"),

                       rs.getString("ville"),
                       rs.getString("description"),
                     rs.getInt("numtel"),
                      rs.getString("image_ev")
              ));
                      }
             } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }
  /*public void updateArticlecatandtitre(Article A){
        String request= "UPDATE `article` SET `titre`=?,`categorie`=?"+" where id=?";
        try{
        PreparedStatement pst = cnx.prepareStatement(request);
      
        pst.setString(1, A.getTitre());
        pst.setString(2, A.getCategorie());
        pst.setInt(3, A.getId());
   pst.executeUpdate();
 System.out.println(pst);
        }
         catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }*/
    
   /*  public List<Article> SearchTitle(String title){
           List<Article> list = new ArrayList<>() ; 
        String req="SELECT * FROM article where titre LIKE'%"+title+"%'" ;
         try{
       ste=cnx.createStatement();
            rs=ste.executeQuery(req);
        while(rs.next()){
        
        Article a = new Article(
                       rs.getInt("id"),
                     rs.getFloat("prix"),
                     rs.getString("titre"),
                     rs.getString("categorie"),
                     rs.getString("gouvernorat"),
                     rs.getString("ville"),
                     rs.getString("description"),
                     rs.getInt("numtel"),
                      rs.getString("image_ev"));
            
        
        list.add(a) ;
        }
        
    }
          catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list ;
     }*/
      
       public List<Article> DisplayMyarticle(){
        String req="select * from article WHERE user_id="+instance.getId();
             //   + " WHERE id="+id;
        List<Article> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              list.add(new Article(
 
                     rs.getInt("id"),
                     rs.getFloat("prix"),
                     rs.getString("titre"),
                     rs.getString("categorie"),
                      rs.getString("gouvernorat"),

                       rs.getString("ville"),
                       rs.getString("description"),
                     rs.getInt("numtel"),
                      rs.getString("image_ev"),
                      rs.getInt("user_id")
              ));
                      }
             } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }
       
       
       
     /*  public List<Article> login(String name){
       // String req="select * from user WHERE first_name="+name +"AND last_name="+lastname;
         String req="select * from user WHERE first_name="+"''"+name;
             //   + " WHERE id="+id;
        List<Article> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              list.add(new Article(
 
                     rs.getInt("id"),
                     rs.getString("first_name"),
                      rs.getString("last_name")
              ));
                      }
             } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }*/
public  List<User> dologin(String name,String lastname) {
      List<User> list= new ArrayList<>();
    try(PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM users WHERE users_username = ? AND users_password = ?" );) {
        pstmt.setString(1, name);
         pstmt.setString(2, lastname);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
             list.add(new User(
                     rs.getInt("users_id"),
                     rs.getString("users_username"),
                      rs.getString("users_password")
              ));
                     
           //System.out.println(rs.getString("first_name") + ", " + rs.getString("last_name"));
        }
    }
    // Handle any errors that may have occurred.
    catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

public  List<User>  UserId(Integer id) {
      List<User> list= new ArrayList<>();
    String req="SELECT * FROM users WHERE users_id="+id;
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
             list.add(new User(
                     rs.getInt("id"),
                     rs.getString("username"),
                      rs.getString("password")
              ));
            }}
            
         
        catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
}
}
