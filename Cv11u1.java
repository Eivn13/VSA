/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package cv11u1;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author xpruzinsky
 */
public class Cv11u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        File file = new File("src\\cv11u1\\adresar.xml");
    
        Adresar a = new Adresar();
        ArrayList<Osoba> osoby = new ArrayList<Osoba>();
        Osoba o = new Osoba();
        o.setBydlisko("bydlisko");
        o.setEmail("email");
        o.setMeno("meno");
        o.setPohlavie("muz");
                
        osoby.add(o);
        Osoba o2 = new Osoba();
        o2.setBydlisko("bydlisko");
        o2.setEmail("email");
        o2.setMeno("meno");
        o2.setPohlavie("muz");
        osoby.add(o2);
        
        a.setOsoby(osoby);
        JAXBContext context = JAXBContext.newInstance(Adresar.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);      
        m.marshal(a, System.out);
/*
        JAXBContext context = JAXBContext.newInstance(Adresar.class);
        Unmarshaller m = context.createUnmarshaller();
        Adresar adresar = (Adresar) m.unmarshal(file);
        System.out.println(adresar);
*/
    }
    
}
