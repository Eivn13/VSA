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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a642038
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findTail", query = "SELECT i FROM Item i WHERE i.nextItem is NULL")
    , @NamedQuery(name = "Item.findItemWithoutContainer", query = "SELECT i FROM Item i WHERE i.dataContainer is NULL")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private MyData dataContainer;
    private Item nextItem;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv6u3.Item[ id=" + id + " ]";
    }

    /**
     * @return the dataContainer
     */
    public MyData getDataContainer() {
        return dataContainer;
    }

    /**
     * @param dataContainer the dataContainer to set
     */
    public void setDataContainer(MyData dataContainer) {
        this.dataContainer = dataContainer;
    }

    /**
     * @return the nextItem
     */
    public Item getNextItem() {
        return nextItem;
    }

    /**
     * @param nextItem the nextItem to set
     */
    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }
    
}
