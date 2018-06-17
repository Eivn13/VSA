/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdedicnosti;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Dominik
 */
@Entity(name = "GUI_RECT")
public class RectElement extends GuiElement implements Serializable {

    private static final long serialVersionUID = 1L;

    private int height;
    private int width;

    // pre pohodlny vypis
    @Override
    public String toString() {
        return super.toString() + " WIDTH=" + getWidth();
    }
    
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
