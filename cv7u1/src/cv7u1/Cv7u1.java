/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv7u1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Dominik
 */
public class Cv7u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vymazBudovy();
    }

    public static void vsetkyNemocnice() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv7u1PU");
        EntityManager em = emf.createEntityManager();
        /*  //pre single table 
        Query q = em.createNativeQuery("SELECT * FROM GEOOBJECT WHERE DTYPE ='Nemocnica'");
            //pre table per class*/
        //Query q = em.createNativeQuery("SELECT * FROM NEMOCNICA");
        //pre joined
        Query q = em.createNativeQuery("SELECT * FROM GEOOBJECT JOIN NEMOCNICA ON GEOOBJECT.id=NEMOCNICA.id");
        List<Object[]> res = q.getResultList();
        for (Object[] to : res) {
            System.out.println(to[0].toString() + " " + to[1].toString() + " " + to[2].toString()
                    + " " + to[3].toString() + " " + to[4].toString() + " " + to[5].toString() );
        }
    }

    public static void vsetkyNazvy() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv7u1PU");
        EntityManager em = emf.createEntityManager();
        //pre single table
        //Query q = em.createNativeQuery("SELECT * FROM GEOOBJECT");
        //pre table per class
        //Query q = em.createNativeQuery("SELECT id, nazov FROM GEOOBJECT "
        //                            + "UNION (select id, nazov FROM KOPEC)");
        //pre joined
        Query q = em.createNativeQuery("SELECT * FROM GEOOBJECT");
        List<Object[]> res = q.getResultList();
        for (Object[] to : res) {
            System.out.println(to[1].toString());
        }
    }
    
    public static void vymazBudovy(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv7u1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        int i = em.createQuery("DELETE FROM Budova").executeUpdate();
        System.out.println(i);
        em.getTransaction().commit();
    }
    
    public static void naplnit() {
        GeoObject geo = new GeoObject();
        geo.setNazov("debilina");

        Cesta c = new Cesta();
        c.setKategoria(1);
        c.setNazov("A");

        Kopec k = new Kopec();
        k.setNazov("Gerlach");
        k.setVyska(1993);

        Budova b = new Budova();
        b.setCislo("13");
        b.setNazov("Londzorno");
        b.setObec("Lozorno");
        b.setUlica("Kukucinova");

        Muzeum m = new Muzeum();
        m.setCislo("1");
        m.setNazov("Muzeum kolibrikov");
        m.setObec("Lozorno");
        m.setOtvorene("10:00 - 18:00");
        m.setUlica("Makaresska");
        m.setVstupne((float) 13.35);

        Nemocnica n = new Nemocnica();
        n.setCislo("2");
        n.setLekaren(Boolean.FALSE);
        n.setPohotovost(Boolean.TRUE);
        n.setNazov("Na okraji mesta");
        n.setObec("Lozorno");
        n.setUlica("Ladislavova");

        Obchod o = new Obchod();
        o.setCislo("2");
        o.setNazov("Hovado");
        o.setObec("Lozorno");
        o.setOtvorene("Od nevidim do nevidim");
        o.setUlica("Zvoncinska");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv7u1PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(geo);
        em.persist(b);
        em.persist(c);
        em.persist(k);
        em.persist(n);
        em.persist(o);
        em.persist(m);

        em.getTransaction().commit();
    }

}
