/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.interfaces;

import huntkingdom.entities.Article;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FOCUS
 */
public interface IServiceArticle {
    
     public void addArticle(Article A) throws SQLException;
        
    public ArrayList<Article> getArticle() throws SQLException;
    
    public void updateArticle(Article A) throws SQLException;
    
    public void deleteArticle(Article A) throws SQLException;
}
