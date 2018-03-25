/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u3c;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author a642038
 */
public class Cv6u3c {

    /**
     * @param args the command line arguments
     */
    static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv6u3PU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //b
        /*TypedQuery<Item> q = em.createNamedQuery("Item.findItemWithoutContainer", Item.class);
        Item i = new Item();
        i = q.getResultList().get(0);
        MyData d = new MyData();
        d.setMyText("ALLO");
        d.setMyValue(10);
        addData(d, i);*/
        //c
        /*TypedQuery<Item> q = em.createNamedQuery("Item.findTail", Item.class);
        Item tail = q.getSingleResult();
        MyData d = new MyData();
        d.setMyText("Alohaa");
        d.setMyValue(2);
        Item i = new Item();
        i.setId(tail.getId()+1l);
        i.setDataContainer(d);
        i.setPrevItem(tail);
        tail.setNextItem(i);
        appendData(d, i, tail);*/
        //e
        TypedQuery<Item> q = em.createQuery("SELECT i FROM Item i where i.id = 2", Item.class);
        Item i = (Item) q.getSingleResult();
        remove(i);
    }

    static void addData(MyData d, Item i) {
        i.setDataContainer(d);
        em.persist(d);
        em.persist(i);
        em.getTransaction().commit();
    }

    static void appendData(MyData d, Item i, Item tail) {
        em.persist(d);
        em.persist(i);
        em.persist(tail);
        em.getTransaction().commit();
    }

    static void remove(Item i) {
        Item pI = em.find(Item.class, i.getId()-1l);
        Item nI = em.find(Item.class, i.getId()+1l);
        MyData d = em.find(MyData.class, i.getDataContainer().getId());
        em.remove(d);
        em.remove(i);
        pI.setNextItem(nI);
        nI.setPrevItem(pI);
        em.persist(nI);
        em.persist(pI);
        em.getTransaction().commit();
    }

    /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv6u3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MyData d1 = new MyData();
        MyData d2 = new MyData();
        Item i1 = new Item();
        Item i2 = new Item();
        
        d1.setId(1l);
        d1.setMyText("Blabla");
        d1.setMyValue(1);
        
        d2.setId(2l);
        d2.setMyText("Blabla2");
        d2.setMyValue(2);
        
        i1.setId(1l);
        i1.setDataContainer(d1);
        i1.setNextItem(i2);
        
        i2.setId(2l);
        i2.setDataContainer(d2);
        i2.setPrevItem(i1);

        em.persist(d1);
        em.persist(d2);
        em.persist(i1);
        em.persist(i2);
        em.getTransaction().commit();
        em.close();
        emf.close();*/
}
