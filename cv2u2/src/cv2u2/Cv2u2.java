/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2u2;

import entities.Osoba;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author Dominik
 */
public class Cv2u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        EntityManagerFactory emf = createEntityManagerFactory("cv2u2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Osoba osoba = em.find(Osoba.class, 201l);
        try {
            System.out.println(osoba.toString());
        } catch (Exception e) {
            System.out.println("Osoba nenajdena");
        }
        finally {
            em.close();
            emf.close();
        }
        
        /*
        if(em.find(Osoba.class, 1L)){
            System.out.println("Osoba existuje");
        }
        else{
            System.out.println("Osoba neexistuje");
        }*/
    }
    
}
