/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv5u2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author a642038
 */
@Entity
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int kredity;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Osoba prednasajuci;
    
    @ManyToMany
    @JoinTable( name = "PRED_CVIC",
                joinColumns = @JoinColumn(name = "predmet_fk"),
                inverseJoinColumns = @JoinColumn(name = "cviciaci_fk"))
    private List<Osoba> cviciaci;
    
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
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv5u2.Predmet[ id=" + id + " ]";
    }

    /**
     * @return the kredity
     */
    public int getKredity() {
        return kredity;
    }

    /**
     * @param kredity the kredity to set
     */
    public void setKredity(int kredity) {
        this.kredity = kredity;
    }

    /**
     * @return the prednasajuci
     */
    public Osoba getPrednasajuci() {
        return prednasajuci;
    }

    /**
     * @param prednasajuci the prednasajuci to set
     */
    public void setPrednasajuci(Osoba prednasajuci) {
        this.prednasajuci = prednasajuci;
    }

    /**
     * @return the cviciaci
     */
    public List getCviciaci() {
        return cviciaci;
    }

    /**
     * @param cviciaci the cviciaci to set
     */
    public void setCviciaci(List cviciaci) {
        this.cviciaci = cviciaci;
    }
    
}
