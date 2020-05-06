/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.services;

import huntkingdom.entities.Publication;
import huntkingdom.interfaces.IServicePublication;
import huntkingdom.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amin
 */
public class ServicePublication implements IServicePublication {

    private Connection cnx;

    public ServicePublication() {
        cnx = MyDB.getInstance().getConnection();
    }

    public void addPublication(Publication p) throws SQLException {
        String request = "INSERT INTO `publication (publication_title,publication_description,publication_content) VALUES (NULL, '" +p.getTitle()+ "', '"+p.getDescription()+"', '"+p.getContent()+"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Publication> getPublication() throws SQLException {
        ArrayList<Publication> result = new ArrayList<>();
        String request = "SELECT * FROM `publication";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while(rst.next()){
            Publication p = new Publication();
            p.setId(rst.getInt(1));
            p.setTitle(rst.getString(2));
            p.setDescription(rst.getString(3));
            p.setContent(rst.getString(4));
            result.add(p);
        }
        return result;
    }

    public void updatePublication(Publication p) throws SQLException {
        String request = "UPDATE TABLE `publication` SET `publication_title` = ?, `publication_description` = ?, `publication_content`=? WHERE publication_id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, p.getTitle());
        pst.setString(2, p.getDescription());
        pst.setString(3, p.getContent());
        pst.setInt(4, p.getId());
    }

    public void deletePublication(Publication p) throws SQLException {
        String request = "DELETE FROM `PUBLICATION` WHERE users_id ="+ p.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

}
