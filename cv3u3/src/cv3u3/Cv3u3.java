/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv3u3;

import entities.Osoba;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author Dominik
 */
public class Cv3u3 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception { //nezabudnut na import java DB driver-u
        EntityManagerFactory emf = createEntityManagerFactory("cv3u3PU");
        OsobaJpaController dao = new OsobaJpaController(emf);
        
        Osoba o = new Osoba(3L, "Pipi");
        dao.create(o);
    }
    
}
