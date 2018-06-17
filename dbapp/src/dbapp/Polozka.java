/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbapp;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Dominik
 */
@Entity
public class Polozka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Faktura faktura;
    private String produkt;
    private Double cena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polozka)) {
            return false;
        }
        Polozka other = (Polozka) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbapp.Polozka[ id=" + getId() + " ]";
    }

    /**
     * @return the produkt
     */
    public String getProdukt() {
        return produkt;
    }

    /**
     * @param produkt the produkt to set
     */
    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    /**
     * @return the cena
     */
    public Double getCena() {
        return cena;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(Double cena) {
        this.cena = cena;
    }

    /**
     * @return the faktura
     */
    public Faktura getFaktura() {
        return faktura;
    }

    /**
     * @param faktura the faktura to set
     */
    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
    
}
