/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv7u2;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dominik
 */
@Entity
public class Budova extends GeoObject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String obec;
    private String ulica;
    private String cislo;
    
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
        if (!(object instanceof Budova)) {
            return false;
        }
        Budova other = (Budova) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv7u1.Budova[ id=" + id + " ]";
    }

    /**
     * @return the obec
     */
    public String getObec() {
        return obec;
    }

    /**
     * @param obec the obec to set
     */
    public void setObec(String obec) {
        this.obec = obec;
    }

    /**
     * @return the ulica
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * @param ulica the ulica to set
     */
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    /**
     * @return the cislo
     */
    public String getCislo() {
        return cislo;
    }

    /**
     * @param cislo the cislo to set
     */
    public void setCislo(String cislo) {
        this.cislo = cislo;
    }
    
}
