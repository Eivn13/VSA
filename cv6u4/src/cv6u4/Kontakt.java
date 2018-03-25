/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6u4;

import static cv6u4.Osoba_.id;
import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Dominik
 */

@Embeddable
public class Kontakt implements Serializable {

    private String mail;
    private String tel;

    public Kontakt() {
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "cv6u4.Kontakt[ id=" + id + " ]";
    }
    
}
