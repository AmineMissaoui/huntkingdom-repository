/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.interfaces;

import huntkingdom.entities.Publication;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author amin
 */
public interface IServicePublication {
    public void addPublication(Publication p) throws SQLException;
    public ArrayList<Publication> getPublication() throws SQLException;
    public void updatePublication(Publication p) throws SQLException;
    public void deletePublication(Publication p) throws SQLException;
}
