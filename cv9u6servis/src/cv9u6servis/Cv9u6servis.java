/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv9u6servis;

/**
 *
 * @author Dominik
 */
public class Cv9u6servis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getHtml());
        client.deleteWord("RU", "Sloth");
        client.deleteLang("RU");
        System.out.println(client.getHtml());
        System.out.println(client.getWord("RU", "Sloth"));
    }
    
}
