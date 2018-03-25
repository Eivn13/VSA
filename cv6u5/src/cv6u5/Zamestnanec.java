/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u5;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dominik
 */
@Entity
@Table(name = "ZAMESTNANEC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zamestnanec.findAll", query = "SELECT z FROM Zamestnanec z"),
    @NamedQuery(name = "Zamestnanec.findById", query = "SELECT z FROM Zamestnanec z WHERE z.id = :id"),
    @NamedQuery(name = "Zamestnanec.findByOd", query = "SELECT z FROM Zamestnanec z WHERE z.od = :od"),
    @NamedQuery(name = "Zamestnanec.findByMeno", query = "SELECT z FROM Zamestnanec z WHERE z.meno = :meno"),
    @NamedQuery(name = "Zamestnanec.findByZariadenie", query = "SELECT z FROM Zamestnanec z WHERE z.zariadenie = :zariadenie"),
    @NamedQuery(name = "Zamestnanec.findByPlat", query = "SELECT z FROM Zamestnanec z WHERE z.plat = :plat")})
public class Zamestnanec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date od;
    @Column(name = "MENO")
    private String meno;
    @Column(name = "ZARIADENIE")
    private String zariadenie;
    @Column(name = "PLAT")
    private String plat;

    public Zamestnanec() {
    }

    public Zamestnanec(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOd() {
        return od;
    }

    public void setOd(Date od) {
        this.od = od;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getZariadenie() {
        return zariadenie;
    }

    public void setZariadenie(String zariadenie) {
        this.zariadenie = zariadenie;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
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
        if (!(object instanceof Zamestnanec)) {
            return false;
        }
        Zamestnanec other = (Zamestnanec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv6u5.Zamestnanec[ id=" + id + " ]";
    }
    
}
