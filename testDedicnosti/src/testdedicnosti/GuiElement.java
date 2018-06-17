/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdedicnosti;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Dominik
 */
@Entity(name = "GUI_ELEMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class GuiElement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int xCoord;
    private int yCoord;

    // pre pohodlny vypis
    @Override
    public String toString() {
        return "" + getId() + ":" + getName();
    }

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the xCoord
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     * @param xCoord the xCoord to set
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * @return the yCoord
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     * @param yCoord the yCoord to set
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
