/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv4u2c;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author a642038
 */
@Entity
public class Kniha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "NAZOV")
    private String nazov;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Vydavatelstvo vydavatel;
    

    public Kniha() {
    }

    public Kniha(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazov != null ? nazov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kniha)) {
            return false;
        }
        Kniha other = (Kniha) object;
        if ((this.nazov == null && other.nazov != null) || (this.nazov != null && !this.nazov.equals(other.nazov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv4u2c.Kniha[ nazov=" + nazov + " ]";
    }

    /**
     * @return the vydavatel
     */
    public Vydavatelstvo getVydavatel() {
        return vydavatel;
    }

    /**
     * @param vydavatel the vydavatel to set
     */
    public void setVydavatel(Vydavatelstvo vydavatel) {
        this.vydavatel = vydavatel;
    }
    
}
