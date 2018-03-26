/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv5u2;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author a642038
 */
public class Cv5u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv5u2PU");
        EntityManager em = emf.createEntityManager();
        
        Predmet pred1 = new Predmet();
        Predmet pred2 = new Predmet();
        Osoba p = new Osoba();
        Osoba c1 = new Osoba();
        Osoba c2 = new Osoba();
        
        pred1.setCviciaci(new ArrayList<>());
        pred2.setCviciaci(new ArrayList<>());
        p.setMeno("Juliec");
        pred1.setPrednasajuci(p);
        pred2.setPrednasajuci(p);
        
        c1.setMeno("Martin");
        c1.setPredmet(new ArrayList<>());
        c1.getPredmet().add(pred1);
        pred1.getCviciaci().add(c1);
        pred2.getCviciaci().add(c1);
        
        c2.setMeno("Jaro");
        c2.setPredmet(new ArrayList<>());
        c2.getPredmet().add(pred1);
        pred1.getCviciaci().add(c2);
        pred2.getCviciaci().add(c2);
        
        em.getTransaction().begin();
        em.persist(pred1);
        em.persist(pred2);
        em.persist(p);
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
    }
    
}
