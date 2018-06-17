/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restappservis;

/**
 *
 * @author Dominik
 */
public class RestappServis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        Osoba o = new Osoba();
        o.setMeno("Janko Mrkvicka");
        o.setVek(13);
        client.postZmluva(o, "u1111");
        Zmluva z = client.getZmluva(Zmluva.class, "u1111");
        for (Osoba o1 : z.getOsoby()){
            System.out.println(o1.toString());
        }
    }
    
}
