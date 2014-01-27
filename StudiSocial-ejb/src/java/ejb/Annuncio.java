/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Daniele
 */
@Entity
public class Annuncio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    private String testo;

    /**
     * Get the value of testo
     *
     * @return the value of testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * Set the value of testo
     *
     * @param testo new value of testo
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    private Location location;

    /**
     * Get the value of location
     *
     * @return the value of location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the value of location
     *
     * @param location new value of location
     */
    public void setLocation(Location location) {
        this.location = location;
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
        if (!(object instanceof Annuncio)) {
            return false;
        }
        Annuncio other = (Annuncio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Annuncio[ id=" + id + " ]";
    }
    
}
