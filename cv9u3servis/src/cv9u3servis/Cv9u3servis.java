/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv9u3servis;

import proxy.NewJerseyClient;

/**
 *
 * @author Dominik
 */
public class Cv9u3servis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getAll());
        client.deleteMenu("2");
        System.out.println(client.getAll());
    }
    
}
