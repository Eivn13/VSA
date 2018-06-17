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
@Entity(name = "GUI_TEXT")
public class TextElement extends GuiElement implements Serializable {

    private static final long serialVersionUID = 1L;
    // private Long id;

    private String text;
    private int fontSize;
    private String fontFamily;

    // pre pohodlny vypis
    @Override
    public String toString() {
        return super.toString() + " TEXT=" + getText();
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @return the fontFamily
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * @param fontFamily the fontFamily to set
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }
}
