/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2u4;

import entities.Kniha;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author Dominik
 */
public class Cv2u4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Set hs = new HashSet();
        String line;
        BufferedReader br = new BufferedReader(new FileReader("src/cv2u4/data1.csv"));
        while ((line = br.readLine()) != null) {
            String s[] = line.split(";");
            if (s.length < 3) {
                System.out.println("Prilis kratky riadok.");
                return;
            }
            String nazov = s[0].trim();
            String autor = s[1].trim();
            int pocet;
            if ("".equals(s[2].trim())) {
                pocet = 0;
            } else {
                pocet = Integer.parseInt(s[2].trim());
            }
            Kniha k = new Kniha();
            k.setNazov(nazov);
            k.setAutor(autor);
            k.setPocet(pocet);
            hs.add(k);
        }
        EntityManagerFactory emf = createEntityManagerFactory("cv2u4PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Object o : hs) {
            em.persist(o);
        }
        em.getTransaction().commit();
    }

}
