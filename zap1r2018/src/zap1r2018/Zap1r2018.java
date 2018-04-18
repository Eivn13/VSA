/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zap1r2018;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dominik
 */
public class Zap1r2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {EntityManagerFactory emf = Persistence.createEntityManagerFactory("zap1r2018PU");
        EntityManager em = emf.createEntityManager();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Book b1 = new Book();
        Book b2 = new Book();
        
        p1.setName("Adam");
        p1.getPublications().add(b1);
        p2.setName("Ivana");
        p2.getPublications().add(b2);
        p3.setName("Dominik");
        p2.getPublications().add(b2);
        b1.setTitle("Mein Kampf");
        b1.getTags().add("Fantasy");
        b1.getTags().add("Comedy");
        b1.getTags().add("nazi");
        b1.getAuthors().add(p1);
        b2.setTitle("Ako hodnotit zeny");
        b2.getTags().add("Bestseller");
        b2.getTags().add("Ero");
        b2.getAuthors().add(p2);
        b2.getAuthors().add(p3);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(b1);
        em.persist(b2);
        em.getTransaction().commit();
        books("Mein Kampf");
        hastag("Fantasy", "Adam");
    }

    static int books(String title) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zap1r2018PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
        q.setParameter("title", title);
        System.out.println(q.getSingleResult());
        return 0;
    }

    static boolean hastag(String tag, String author) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zap1r2018PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> q1 = em.createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class);
        q1.setParameter("name", author);
        TypedQuery<Book> q2 = em.createQuery("SELECT b FROM Book b WHERE b.authors = :authors", Book.class);
        q2.setParameter("authors", q1.getSingleResult());
        System.out.println(q2.getSingleResult().getTags().get(0));
        return false;
    }
    /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zap1r2018PU");
        EntityManager em = emf.createEntityManager();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Book b1 = new Book();
        Book b2 = new Book();
        
        p1.setName("Adam");
        p1.getPublications().add(b1);
        p2.setName("Ivana");
        p2.getPublications().add(b2);
        p3.setName("Dominik");
        p2.getPublications().add(b2);
        b1.setTitle("Mein Kampf");
        b1.getTags().add("Fantasy");
        b1.getTags().add("Comedy");
        b1.getTags().add("nazi");
        b1.getAuthors().add(p1);
        b2.setTitle("Ako hodnotit zeny");
        b2.getTags().add("Bestseller");
        b2.getTags().add("Ero");
        b2.getAuthors().add(p2);
        b2.getAuthors().add(p3);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(b1);
        em.persist(b2);
        em.getTransaction().commit();*/
}
