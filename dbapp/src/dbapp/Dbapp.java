/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbapp;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dominik
 */
public class Dbapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(pocetFaktur("Mario"));
        pridajPolozku(24, "Blbost", 99.50);
    }
    
    public static int pocetFaktur(String zakaznik){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Faktura> faktury = em.createNamedQuery("Faktura.findByZakaznik", Faktura.class);
        faktury.setParameter("zakaznik", zakaznik);
        return faktury.getResultList().size();
    }
    
    public static void pridajPolozku(int id, String produkt, double cena){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Faktura> faktura = em.createNamedQuery("Faktura.findById", Faktura.class);
        faktura.setParameter("id", id);
        if(!faktura.getResultList().isEmpty()){
            em.getTransaction().begin();
            Faktura f = faktura.getSingleResult();
            Polozka p = new Polozka();
            p.setProdukt(produkt);
            p.setCena(cena);
            p.setFaktura(f);
            f.setAktualizacia(new Date());
            em.persist(p);
            em.getTransaction().commit();
        }
    }
}
