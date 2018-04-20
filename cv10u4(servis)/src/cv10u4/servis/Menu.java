/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv10u4.servis;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dominik
 */
@XmlRootElement
public class Menu {

    @Override
    public String toString() {
        return "Menu{" + "den=" + den + ", ponuka=" + ponuka + '}';
    }
    private String den;
    private Map<Integer, Jedlo> ponuka;
    
    public Menu(){
        ponuka = new HashMap();
    }

    /**
     * @return the den
     */
    public String getDen() {
        return den;
    }

    /**
     * @param den the den to set
     */
    public void setDen(String den) {
        this.den = den;
    }

    /**
     * @return the ponuka
     */
    public Map<Integer, Jedlo> getPonuka() {
        return ponuka;
    }

    /**
     * @param ponuka the ponuka to set
     */
    public void setPonuka(Map<Integer, Jedlo> ponuka) {
        this.ponuka = ponuka;
    }
}
