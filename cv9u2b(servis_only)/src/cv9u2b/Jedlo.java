/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv9u2b;

/**
 *
 * @author Dominik
 */
public class Jedlo {
    private String nazov;

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

    public Jedlo(String nazov) {
        this.nazov = nazov;
    }
    
    
}
