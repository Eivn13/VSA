/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv9u2b;

/**
 *
 * @author Dominik
 */
public class Cv9u2b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient js = new NewJerseyClient();
        Jedlo j1 = new Jedlo("Hamburger");
        js.postMenu(j1.getNazov());
        js.putMenu(j1.getNazov(), "0");
        System.out.println(js.getAll());
    }
    
}
