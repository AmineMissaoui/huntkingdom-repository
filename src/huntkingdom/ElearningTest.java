package huntkingdom;

import huntkingdom.entities.Elearning;
import huntkingdom.services.ServicesElearning;

/**
 *
 * @author Akkari
 */
public class ElearningTest {
      public static void main(String[] args) {
          Elearning elearining = new Elearning("hunt", "Cours hunt", "C:/Users/Akkari/Desktop/Akkari_Ferdaous-_cv.pdf");
          ServicesElearning servicesElearning  = new ServicesElearning();     
          
          //ADD
       /*  if (servicesElearning.addLesson(elearining))
              System.out.println("Add succesful");
          else 
              System.out.println("Error while adding lesson");
         */
         
          //Update
          elearining.setId(1);
          elearining.setDescription("new Description for lesson");
        
           if (servicesElearning.updateLesson(elearining))
              System.out.println("update succesful");
          else 
              System.out.println("Error while updating lesson");
/* 
            //getAll
                
           for (Elearning e : servicesElearning.getlessons()){
              System.out.println(e);
           }
           
           // delete 
            if (servicesElearning.deleteLesson(elearining))
              System.out.println("delete succesful");
            else 
              System.out.println("Error while deleteting lesson");*/
    }
}