/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv9u4servis;


/**
 *
 * @author Dominik
 */
public class Cv9u4servis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getHtml());
        Slova slova = new Slova("Wireless", "Bezdrotovy");
        client.putWord(slova.getWord(), slova.getWord(), slova.getSlovo());
        System.out.println(client.getWord("Wireless"));
        System.out.println(client.getHtml());
        client.deleteWord("Wireless");
        System.out.println(client.getHtml());
        Slova slova2 = new Slova("Hello", "Cau");
        client.putWord(slova2.getWord(), slova2.getWord(), slova2.getSlovo());
        System.out.println(client.getHtml());
    }
    
}
