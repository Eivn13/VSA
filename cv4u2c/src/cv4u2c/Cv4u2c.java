/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv4u2c;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author a642038
 */
public class Cv4u2c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv4u2cPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Kniha k1 = new Kniha();
        Kniha k2 = new Kniha();
        Vydavatelstvo vydavatel = new Vydavatelstvo();
        vydavatel.setAdresa("Lomcova 20");
        k1.setNazov("dkms");
        k2.setNazov("kdsakdka");
        k1.setVydavatel(vydavatel);
        k2.setVydavatel(vydavatel);
        em.persist(k1);
        em.persist(k2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv4u2cPU");
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
