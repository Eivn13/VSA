/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv3u1;

import entities.Osoba;
import static java.sql.JDBCType.NULL;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dominik
 */
public class Cv3u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //nezabudnut na import java DB driver-u
        EntityManagerFactory emf = createEntityManagerFactory("cv3u1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        /*
        //A
        TypedQuery<Osoba> all = em.createNamedQuery("Osoba.findAll", Osoba.class);
        for(Osoba o : all.getResultList()){
            System.out.println(o.toString()); //vygeneroval som si novu metodu toString po vygenerovani z databasy
        }
        
        //B
        TypedQuery<Osoba> q = em.createNamedQuery("Osoba.findByMeno", Osoba.class);
        q.setParameter("meno", "KamIdesCierny");
        for(Osoba o : q.getResultList()){
            System.out.println(o.toString());
        }
        */
        //C
        TypedQuery<Osoba> q = em.createNamedQuery("Osoba.findByMissingVaha", Osoba.class);
        for(Osoba o : q.getResultList()){
            o.setVaha(Double.parseDouble("80.0"));
            em.persist(o);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
