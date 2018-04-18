/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv9u4servis;

/**
 *
 * @author Dominik
 */
public class Slova {
    private String slovo;
    private String word;

    public Slova(String word, String slovo) {
        this.slovo = slovo;
        this.word = word;
    }

    /**
     * @return the slovo
     */
    public String getSlovo() {
        return slovo;
    }

    /**
     * @param slovo the slovo to set
     */
    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }
}
