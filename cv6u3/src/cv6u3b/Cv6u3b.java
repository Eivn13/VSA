/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u3b;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author a642038
 */
public class Cv6u3b {

    /**
     * @param args the command line arguments
     */
    static EntityManager em;
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv6u3PU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Item> q = em.createNamedQuery("Item.findItemWithoutContainer", Item.class);
        Item i = new Item();
        i = q.getResultList().get(0);
        MyData d = new MyData();
        d.setMyText("ALLO");
        d.setMyValue(10);
        addData(d, i);
    }
    
    static void addData(MyData d, Item i){
        i.setDataContainer(d);
        em.persist(d);
        em.persist(i);
        em.getTransaction().commit();
    }
    
    static void appendData(MyData d, Item i){
        
    }
    
    void remove(Item i){
        
    }
    /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv6u3PU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    MyData d1 = new MyData();
    d1.setId(1l);
    d1.setMyText("Blabla");
    d1.setMyValue(1);
    MyData d2 = new MyData();
    d2.setId(2l);
    d2.setMyText("Blabla2");
    d2.setMyValue(2);
    Item i1 = new Item();
    i1.setId(1l);
    i1.setDataContainer(d1);
    Item i2 = new Item();
    i2.setId(2l);
    i2.setDataContainer(d2);
    i2.setNextItem(i1);

    em.persist(d1);
    em.persist(d2);
    em.persist(i1);
    em.persist(i2);
    em.getTransaction().commit();
    em.close();
    emf.close();*/
}
