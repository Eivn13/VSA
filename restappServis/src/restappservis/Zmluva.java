/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restappservis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dominik
 */
@XmlRootElement
public class Zmluva {
    private String cislo_zmluvy;
    private String druh;
    private List<Osoba> osoby = new ArrayList();

    @Override
    public String toString() {
        return "Zmluva{" + "cislo_zmluvy=" + cislo_zmluvy + ", druh=" + druh + ", osoby=" + osoby + '}';
    }

    /**
     * @return the cislo_zmluvy
     */
    public String getCislo_zmluvy() {
        return cislo_zmluvy;
    }

    /**
     * @param cislo_zmluvy the cislo_zmluvy to set
     */
    public void setCislo_zmluvy(String cislo_zmluvy) {
        this.cislo_zmluvy = cislo_zmluvy;
    }

    /**
     * @return the druh
     */
    public String getDruh() {
        return druh;
    }

    /**
     * @param druh the druh to set
     */
    public void setDruh(String druh) {
        this.druh = druh;
    }

    /**
     * @return the osoby
     */
    public List<Osoba> getOsoby() {
        return osoby;
    }
    /**
     * @param osoby the osoby to set
     */
    public void setOsoby(List<Osoba> osoby) {
        this.osoby = osoby;
    }
}
