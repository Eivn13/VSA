/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv4u2d;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author a642038
 */
public class Cv4u2d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kniha k1 = new Kniha();
        Kniha k2 = new Kniha();
        Vydavatelstvo v = new Vydavatelstvo();
        
        k1.setNazov("Alibaba");
        k2.setNazov("Three roses");
        v.setAdresa("Lomcova 20");
        v.setPublikacia(new ArrayList());
        v.getPublikacia().add(k1);
        v.getPublikacia().add(k2);
        persist(k1);
        persist(k2);
        persist(v);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv4u2dPU");
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
