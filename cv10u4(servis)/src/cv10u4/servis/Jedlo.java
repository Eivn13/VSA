/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv10u4.servis;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dominik
 */
@XmlRootElement
public class Jedlo {
    private String nazov;
    private Double cena;
    
    public Jedlo(){
        
    }
    
    /**
     * @return the nazov
     */
    public String getNazov() {
        return nazov;
    }

    /**
     * @param nazov the nazov to set
     */
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    /**
     * @return the cena
     */
    public Double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Jedlo{" + "nazov=" + nazov + ", cena=" + cena + '}';
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(Double cena) {
        this.cena = cena;
    }
}
