/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv5u1;

import entities.Kniha;
import entities.Osoba;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author a642038
 */
public class Cv5u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        create();
        //read();
    }
    
    public static void create() {
        Osoba o1 = new Osoba();
        o1.setMeno("Hopcroft");

        Osoba o2 = new Osoba();
        o2.setMeno("Ullman");

        Osoba o3 = new Osoba();
        o3.setMeno("Aho");

        Kniha k1 = new Kniha();
        k1.setId(333L);
        k1.setNazov("Uvod do teorie automatov");

        Kniha k2 = new Kniha();
        k2.setNazov("Algoritmy a datove struktury");

        o1.setDielo(new ArrayList<>());
        o1.getDielo().add(k1);
        o1.getDielo().add(k2);

        o2.setDielo(new ArrayList<>());
        o2.getDielo().add(k1);
        o2.getDielo().add(k2);

        o3.setDielo(new ArrayList<>());
        o3.getDielo().add(k2);
        //u1c1
        /*Osoba o4 = new Osoba(); //Osoba existuje, nie je v prepojovacej pretoze ta
        o4.setMeno("Chybovy autor");    //je mapovana columnom dielo a tam nie je, cize sa nezobrazi ani v prepo
        
        k2.setAutor(new ArrayList<>());//chybove
        k2.getAutor().add(o4);*/
        //u1c2
        Kniha k3 = new Kniha();
        k3.setNazov("Maxipes");
        k3.setAutor(new ArrayList<>());
        k3.getAutor().add(o1);  //toto sa neulozi, pretoze  mappedBy je slabsia strana
        o3.getDielo().add(k3);  //ulozi sa toto
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv5u1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            em.persist(k1);
            em.persist(k2);
            em.persist(k3);
            em.persist(o1);
            em.persist(o2);
            em.persist(o3);
            //em.persist(o4);

            em.getTransaction().commit();
            em.clear();

            System.out.println(k1.getAutor().size());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public static void read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv5u1PU");
        EntityManager em = emf.createEntityManager();
        Kniha k = em.find(Kniha.class, 333L);
        System.out.println(k.getNazov());
        System.out.println(k.getAutor().size());
    }
}
