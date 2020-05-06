/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Annonce;
import huntkingdom.interfaces.IServiceAnnonce;
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
public class ServiceAnnonce{
    
    
        private Connection cnx;

    public ServiceAnnonce() {
        cnx=MyDB.getInstance().getConnection();
    
    }
    public void addAnnonce(Annonce a) throws SQLException {
        String request = "INSERT INTO `annonce` (`prix`,`titre`,`categorie`,`description` )"
                + "VALUES ( '" 
                +a.getPrix() + "', '"
                +a.getTitre()+"', '"
                +a.getCategorie()+"', '"
                +a.getDescription()+ "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    public ArrayList<Annonce> getAnnonce() throws SQLException, FileNotFoundException{
        ArrayList<Annonce> results = new ArrayList<>();
        String query = "SELECT * FROM `annonce`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            
            Annonce a = new Annonce();
            
            a.setId(rst.getInt(1));
            a.setPrix(rst.getFloat(2));
            a.setTitre(rst.getString(3));
            a.setCategorie(rst.getString(4));
            a.setDescription(rst.getString(5));
            results.add(a);
        }
        
        return results; 
    }
    
    public void updateAnnonce(Annonce a) throws SQLException, FileNotFoundException{
        String request= "UPDATE `annonce` SET `prix`=?,`titre`=?,`categorie`=?,`description`=? "+" where id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setFloat(1, a.getPrix());
        pst.setString(2, a.getTitre());
        pst.setString(3, a.getCategorie());
        pst.setString(4, a.getDescription());
        pst.setInt(5, a.getId());
       

        System.out.println(pst);
        
        pst.executeUpdate();
    }
    
    public void deleteAnnonce(int id) throws SQLException {
        String request ="DELETE FROM `annonce` WHERE id="+id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

}
