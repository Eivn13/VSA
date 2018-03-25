/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv4u2b;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author a642038
 */
public class Cv4u2b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kniha k1 = new Kniha();
        Kniha k2 = new Kniha();
        Osoba o1 = new Osoba();
        Osoba o2 = new Osoba();
        k1.setNazov("Prva Kniha");
        k2.setNazov("Druha Kniha");
        o1.setId(19999l);
        o2.setId(20000l);
        o1.setMeno("Jano");
        o2.setMeno("Fero");
        List l1 = new ArrayList();
        List l2 = new ArrayList();
        l1.add(o1);
        l1.add(o2);
        l2.add(o2);
        k1.setAutor(l1);
        k2.setAutor(l2);
        persist(k1);
        persist(k2);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv4u2bPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
