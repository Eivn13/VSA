/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u4;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dominik
 */
@Entity
@Table(name = "OSOBA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o"),
    @NamedQuery(name = "Osoba.findById", query = "SELECT o FROM Osoba o WHERE o.id = :id"),
    @NamedQuery(name = "Osoba.findByMeno", query = "SELECT o FROM Osoba o WHERE o.meno = :meno"),
    @NamedQuery(name = "Osoba.findByPriezvisko", query = "SELECT o FROM Osoba o WHERE o.priezvisko = :priezvisko")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String meno;
    private String priezvisko;
    @Embedded
    Kontakt kontaktneUdaje;

    public Osoba() {
    }

    public Osoba(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
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
        return "cv6u4.Osoba[ id=" + id + " ]";
    }

    /**
     * @return the kontaktneUdaje
     */
    public Kontakt getKontaktneUdaje() {
        return kontaktneUdaje;
    }

    /**
     * @param kontaktneUdaje the kontaktneUdaje to set
     */
    public void setKontaktneUdaje(Kontakt kontaktneUdaje) {
        this.kontaktneUdaje = kontaktneUdaje;
    }
    
}
