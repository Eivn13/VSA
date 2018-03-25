/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author a642038
 */@Entity
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String meno;
    
    @ManyToMany
    @JoinTable( name = "AUTORKNIHA",
                joinColumns = @JoinColumn(name = "autor_fk"),
                inverseJoinColumns = @JoinColumn(name = "kniha_fk"))
    private List<Kniha> dielo;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the dielo
     */
    public List<Kniha> getDielo() {
        return dielo;
    }

    /**
     * @param dielo the dielo to set
     */
    public void setDielo(List<Kniha> dielo) {
        this.dielo = dielo;
    }

    @Override
    public String toString() {
        return "Osoba{" + "id=" + id + ", meno=" + meno + ", dielo=" + dielo + '}';
    }
    
}
