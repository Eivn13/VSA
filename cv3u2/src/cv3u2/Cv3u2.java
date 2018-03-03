/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv3u2;

import entities.Osoba;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author Dominik
 */
public class Cv3u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //nezabudnut na import java DB driver-u
        EntityManagerFactory emf = createEntityManagerFactory("cv3u2PU");
        EntityManager em = emf.createEntityManager();
        /*Osoba o1 = new Osoba();
        o1.setId(Long.parseLong("1"));
        o1.setMeno("Centri");
        o1.setVaha(Double.parseDouble("25.3"));
        Osoba o2 = new Osoba();
        o2.setId(Long.parseLong("1"));
        o2.setMeno("Fuga");
        o2.setVaha(Double.parseDouble("22"));
        em.getTransaction().begin();
        em.persist(o1);
        em.persist(o2);
        em.detach(o2);
        em.getTransaction().commit();*/
        /*
        Osoba o1 = new Osoba();
        Osoba o2 = new Osoba();
        o1 = em.find(Osoba.class, 1l);
        o2 = em.find(Osoba.class, 1l);
        System.out.println(o1.equals(o2));
        System.out.println(o1.toString());
        */
        Osoba o1 = new Osoba();
        Osoba o2 = new Osoba();
        o1 = em.find(Osoba.class, 1l);
        em.detach(o1);
        o2 = em.find(Osoba.class, 1l);
        System.out.println(o1.equals(o2));
        System.out.println(o1.toString());
        em.close();
        emf.close();
    }
    
}
