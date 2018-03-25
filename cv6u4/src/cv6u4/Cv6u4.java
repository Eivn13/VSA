/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dominik
 */
public class Cv6u4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv6u4PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Osoba o = new Osoba();
        Kontakt k = new Kontakt();
        k.setMail("blabla@gmail.com");
        k.setTel("0123456789");
        o.setId(1l);
        o.setMeno("Dominik");
        o.setPriezvisko("Pruzinsky");
        o.kontaktneUdaje = k;
        em.persist(o);
        em.getTransaction().commit();
        //hadze to do jednej tabulky, cize tabulka osoba musi mat 5 columnov
    }
    
}
