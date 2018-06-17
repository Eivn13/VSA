/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdedicnosti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Dominik
 */
public class TestDedicnosti {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testDedicnostiPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("\n-- All Gui elements - Native query -------------------");
//        String sql = "select id, name from GUI_ELEMENT ";
        String sql = "select id, name from GUI_ELEMENT "
                + "UNION (select id, name from GUI_TEXT) "
                + "UNION (select id, name from GUI_RECT) ";
        Query q1 = em.createNativeQuery(sql);
        List<Object[]> res = q1.getResultList();
        for (Object[] to : res) {
            System.out.println(to[0].toString() + ":" + to[1].toString());
        }

        System.out.println("\n-- Text elements - Native query -------------------");
//        Query query = em.createNativeQuery("select * from GUI_ELEMENT e where e.dtype='GUI_TEXT'", TextElement.class);
//        Query query = em.createNativeQuery("select * from GUI_ELEMENT e, GUI_TEXT t where e.id=t.id", TextElement.class);
        Query query = em.createNativeQuery("select * from GUI_TEXT", TextElement.class);
        List<TextElement> list = query.getResultList();
        for (TextElement e : list) {
            System.out.println(e);
        }

        // kolko vysledkov dostaneme?
        System.out.println("\n-- All Gui elements JPQL --------------------------");
        Query q3 = em.createQuery("select e from GUI_ELEMENT e"); // JPQL"
        List<GuiElement> textelementlist = q3.getResultList();
        for (GuiElement e : textelementlist) {
            System.out.println(e);
        }

        System.out.println("\n-- Text elements JPQL --------------------------");
        Query q2 = em.createQuery("select e from GUI_TEXT e"); // JPQL"
        List<TextElement> elementlist = q2.getResultList();
        for (TextElement e : elementlist) {
            System.out.println(e);
        }

        System.out.println("\n-- find ------------------------");
        GuiElement e = em.find(TextElement.class, 352L);
        // GuiElement e = em.find(GuiElement.class, 352L);
        System.out.println(e);

        em.close();
        emf.close();
    }*/

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testDedicnostiPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        GuiElement ge = new GuiElement();
        ge.setName("A gui element");

        TextElement te = new TextElement();
        te.setName("A text element");
        te.setText("hello");
        te.setFontFamily("Times New Roman");
        te.setFontSize(16);

        RectElement re = new RectElement();
        re.setName("A rectangle element");
        re.setHeight(100);
        re.setWidth(200);

        em.persist(ge);
        em.persist(re);
        em.persist(te);

        tx.commit();
        em.close();
        emf.close();
    }
}
