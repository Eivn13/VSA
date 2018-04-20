/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv10u4.servis;

/**
 *
 * @author xpruzinsky
 */
public class Cv10u4Servis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        Jedlo jedlo = client.getJedlo(Jedlo.class, "PON", "1");     //get day/index
        System.out.println(jedlo.toString());
        client.deleteJedlo("PON", "1");                             //delete jedlo
        Menu menu = client.getDen(Menu.class, "PON");               //get day
        System.out.println(menu.toString());
        jedlo.setCena((double) 4.56);
        jedlo.setNazov("Makareny");
        client.putJedlo(jedlo, "PON", "1");                         //put day/index
        menu = client.getDen(Menu.class, "PON");
        System.out.println(menu.toString());
    }
    
}
