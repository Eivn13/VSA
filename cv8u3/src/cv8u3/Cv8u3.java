/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv8u3;

import proxy.NewJerseyClient;

/**
 *
 * @author Dominik
 */
public class Cv8u3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient js = new NewJerseyClient(); 
        System.out.println(js.getText());
        js.putText(" Cojeee");
        System.out.println(js.getText());
    }
    
}
