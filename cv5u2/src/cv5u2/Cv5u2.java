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
        
        Predmet pred = new Predmet();
        pred.setCviciaci(new ArrayList<>());
        
        Osoba p = new Osoba();
        p.setMeno("Juliec");
        pred.setPrednasajuci(p);
        
        Osoba c1 = new Osoba();
        c1.setMeno("Martin");
        c1.setPredmet(new ArrayList<>());
        c1.getPredmet().add(pred);
        pred.getCviciaci().add(c1);
        
        Osoba c2 = new Osoba();
        c2.setMeno("Jaro");
        c2.setPredmet(new ArrayList<>());
        c2.getPredmet().add(pred);
        pred.getCviciaci().add(c2);
        
        em.getTransaction().begin();
        em.persist(pred);
        em.persist(p);
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
    }
    
}
