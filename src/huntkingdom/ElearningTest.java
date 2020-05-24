package huntkingdom;

import huntkingdom.entities.Elearning;
import huntkingdom.services.ServicesElearning;
import java.sql.SQLException;

/**
 *
 * @author Akkari
 */
public class ElearningTest {
      public static void main(String[] args) {
          Elearning elearining = new Elearning("hunt1", "Cours hunt", "C:/Users/Akkari/Desktop/Akkari_Ferdaous-_cv.pdf");
          ServicesElearning servicesElearning  = new ServicesElearning();  
          

        
        try {
           for ( Elearning e : servicesElearning.getlessons() )
           { System.out.println(e);}
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
      }
}
          
 