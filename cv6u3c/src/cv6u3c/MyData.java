/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u3c;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author a642038
 */
@Entity
public class MyData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int myValue;
    private String myText;

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
        if (!(object instanceof MyData)) {
            return false;
        }
        MyData other = (MyData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv6u3.MyData[ id=" + id + " ]";
    }

    /**
     * @return the myValue
     */
    public int getMyValue() {
        return myValue;
    }

    /**
     * @param myValue the myValue to set
     */
    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }

    /**
     * @return the myText
     */
    public String getMyText() {
        return myText;
    }

    /**
     * @param myText the myText to set
     */
    public void setMyText(String myText) {
        this.myText = myText;
    }
    
}
