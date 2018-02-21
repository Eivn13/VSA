/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2u1;

import entities.Osoba;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author Dominik
 */
public class Cv2u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = createEntityManagerFactory("cv2u1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Osoba o = new Osoba();
        o.setMeno("KamIdesCierny");
        String string = "September 11, 2001";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        o.setNarodena(date);
        o.setVaha((float) 69);
        o.setVyska((float) 399);
        em.persist(o);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
