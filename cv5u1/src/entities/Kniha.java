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
import javax.persistence.ManyToMany;

/**
 *
 * @author a642038
 */
@Entity
public class Kniha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazov;
    
    @ManyToMany(mappedBy = "dielo")
    private List<Osoba> autor;

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

    /**
     * @return the autor
     */
    public List<Osoba> getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(List<Osoba> autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Kniha{" + "id=" + id + ", nazov=" + nazov + ", autor=" + autor + '}';
    }
    
}
