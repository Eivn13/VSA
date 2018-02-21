/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dominik
 */
@Entity
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String meno;
    @Temporal(TemporalType.DATE)
    private Date narodena;
    private Float vyska;
    private Float vaha;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Osoba[ id=" + id + " ]";
    }

    /**
     * @return the meno
     */
    public String getMeno() {
        return meno;
    }

    /**
     * @param meno the meno to set
     */
    public void setMeno(String meno) {
        this.meno = meno;
    }

    /**
     * @return the narodena
     */
    public Date getNarodena() {
        return narodena;
    }

    /**
     * @param narodena the narodena to set
     */
    public void setNarodena(Date narodena) {
        this.narodena = narodena;
    }

    /**
     * @return the vyska
     */
    public Float getVyska() {
        return vyska;
    }

    /**
     * @param vyska the vyska to set
     */
    public void setVyska(Float vyska) {
        this.vyska = vyska;
    }

    /**
     * @return the vaha
     */
    public Float getVaha() {
        return vaha;
    }

    /**
     * @param vaha the vaha to set
     */
    public void setVaha(Float vaha) {
        this.vaha = vaha;
    }
    
}
