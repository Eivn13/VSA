/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv4u4;

import entities.Autor;
import entities.Kniha;
import entities.Obchod;
import entities.Polozka;
import entities.Vydavatel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dominik
 */
public class Cv4u4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv4u4PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Autor> q = em.createQuery("SELECT a FROM AUTOR a WHERE a.id=2",Autor.class);
        Autor a = q.getSingleResult();
        System.out.println(a.toString());
        findObchody(a);*/
        //loading data from file
        String line;
        BufferedReader br = new BufferedReader(new FileReader("src/cv4u4/data3.csv"));
        while ((line = br.readLine()) != null){
            String s[] = line.split(";");
            String isbn = s[0];
            String nazovVydavatela = s[1].trim();
            String nazovKnihy = s[2].trim();
            String autori[] = s[3].trim().split(",");
            String nazovObchodu = s[4].trim();
            String cena = s[5].trim().replace(",", "");
            //System.out.println(isbn + "," + nazovVydavatela + "," + nazovKnihy + "," + Arrays.toString(autori) + "," + nazovObchodu + "," + cena);
            Autor a;
            Kniha k;
            Obchod o;
            Polozka p;
            Vydavatel v;
            k = new Kniha();
            v = new Vydavatel();
            o = new Obchod();
            a = new Autor();
            p = new Polozka();

            p.setCena(Float.parseFloat(cena));
            k.getAutor().add(a);
            k.setIsbn(isbn);
            k.setNazov(nazovKnihy);
            k.getPolozka().add(p);
            v.setNazov(nazovVydavatela);
            v.getDielo().add(k);
            o.setNazov(nazovObchodu);
            o.getItem().add(p);
            for(int i=0; i<autori.length; i++){
                a.setMeno(autori[i]);
            }
            a.getPublikacia().add(k);
            persist(k);
            persist(o);
            persist(v);
        }
    }

    public static void findObchody(Autor a){
        
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv4u4PU");
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
    //testovacie data
        /*Autor a = new Autor();
        Kniha k = new Kniha();
        Obchod o = new Obchod();
        Polozka p = new Polozka();
        Vydavatel v = new Vydavatel();
        
        p.setCena((float) 12.99);
        
        k.getAutor().add(a);
        k.setIsbn("23231kbq");
        k.setNazov("Marienka 2: feminizmus");
        k.getPolozka().add(p);
        
        v.setNazov("Datart");
        v.getDielo().add(k);
        
        a.setMeno("Janko z lesa");
        a.getPublikacia().add(k);
        
        o.setNazov("DreamyClub");
        o.getItem().add(p);
        persist(k);
        persist(o);
        persist(v);*/
}
