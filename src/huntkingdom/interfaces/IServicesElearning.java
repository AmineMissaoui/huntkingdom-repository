/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.interfaces;

import huntkingdom.entities.Elearning;
import huntkingdom.entities.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Akkari
 */
public interface IServicesElearning {
    public boolean addLesson(Elearning e) throws SQLException;
    public ArrayList<Elearning> getlessons() throws SQLException;
    public boolean updateLesson(Elearning e) throws SQLException;
    public boolean deleteLesson(Elearning u) throws SQLException;
}
