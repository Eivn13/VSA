/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv11u1;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author xpruzinsky
 */
 @XmlRootElement(namespace="http://www.example.com/FOO", name="adresar") 
public class Adresar {
     
    private List<Osoba> osoby;

    /**
     * @return the osoby
     */
     @XmlElement(name = "osoba")
    public List<Osoba> getOsoby() {
        return osoby;
    }

    /**
     * @param osoby the osoby to set
     */
    public void setOsoby(List<Osoba> osoby) {
        this.osoby = osoby;
    }

    public Adresar() {
    }
    
    
}
