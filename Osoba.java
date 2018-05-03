/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv11u1;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace="http://www.example.com/FOO") 
@XmlType(propOrder = { "meno", "bydlisko", "email"})
public class Osoba {
    private String meno;
    private String Bydlisko;
    private String email;
    
    private String pohlavie;

    /**
     * @return the pohlavie
     */
    
        @XmlAttribute(name = "gen")

    public String getPohlavie() {
        return pohlavie;
    }

    /**
     * @param pohlavie the pohlavie to set
     */
    public void setPohlavie(String pohlavie) {
        this.pohlavie = pohlavie;
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
     * @return the Bydlisko
     */
    public String getBydlisko() {
        return Bydlisko;
    }

    /**
     * @param Bydlisko the Bydlisko to set
     */
    public void setBydlisko(String Bydlisko) {
        this.Bydlisko = Bydlisko;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
