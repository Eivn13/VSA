/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv5u2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author a642038
 */
@Entity
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String meno;
    @ManyToMany(mappedBy = "cviciaci")
    private List<Predmet> predmet;
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
        return "cv5u2.Osoba[ id=" + id + " ]";
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
     * @return the predmet
     */
    public List getPredmet() {
        return predmet;
    }

    /**
     * @param predmet the predmet to set
     */
    public void setPredmet(List predmet) {
        this.predmet = predmet;
    }
    
}
