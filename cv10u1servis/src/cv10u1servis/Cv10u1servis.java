/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv10u1servis;

/**
 *
 * @author Dominik
 */
public class Cv10u1servis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getMenu());
        Jedlo jedlo = new Jedlo();
        jedlo.setCena(6.66);
        jedlo.setNazov("Hamburger");
        client.postJedlo(jedlo);
        System.out.println(client.getMenu());
    }
    
}
