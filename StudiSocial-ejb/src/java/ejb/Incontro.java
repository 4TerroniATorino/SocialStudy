/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Daniele
 */
@Entity
public class Incontro implements Serializable {

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

    private Gruppo gruppo;

    /**
     * Get the value of gruppo
     *
     * @return the value of gruppo
     */
    public Gruppo getGruppo() {
        return gruppo;
    }

    /**
     * Set the value of gruppo
     *
     * @param gruppo new value of gruppo
     */
    public void setGruppo(Gruppo gruppo) {
        this.gruppo = gruppo;
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

    private Date dataIncontro;

    /**
     * Get the value of data
     *
     * @return the value of data
     */
    public Date getData() {
        return dataIncontro;
    }

    /**
     * Set the value of data
     *
     * @param data new value of data
     */
    public void setData(Date data) {
        this.dataIncontro = data;
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
        if (!(object instanceof Incontro)) {
            return false;
        }
        Incontro other = (Incontro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Incontro[ id=" + id + " ]";
    }

}
