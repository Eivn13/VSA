/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author a642038
 */
public class Cv6u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv6u1PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Osoba> q = em.createNamedQuery("Osoba.findAll", Osoba.class);
        for (Osoba o : q.getResultList()){
            System.out.println(o.toString());
        }
    }
}
