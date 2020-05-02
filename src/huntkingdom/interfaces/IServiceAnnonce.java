/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.interfaces;

import huntkingdom.entities.Annonce;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FOCUS
 */
public interface IServiceAnnonce {
    
    
    public void addAnnonce(Annonce a) throws SQLException;
    
    public ArrayList<Annonce> getPersons() throws SQLException;
    
    public void updatePerson(Annonce a) throws SQLException;
    
    public void deletePerson(Annonce a) throws SQLException;
}
