/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2u3;

import cv2u3.entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Dominik
 */
public class Cv2u3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = createEntityManagerFactory("cv2u3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q =  em.createNativeQuery("SELECT * FROM OSOBA p", Person.class);
        
       // Query q = em.createNamedQuery("Person.findAll");
        List resultList = q.getResultList();
        for(Object o : resultList){
            Person p = (Person) o;
            System.out.println(p);
        }
        em.close();
        emf.close();
    }
}