/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.awt.geom.Point2D;
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
public class Location implements Serializable {
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

    private String type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }

    private Point2D.Double coordinate;

    /**
     * Get the value of coordinate
     *
     * @return the value of coordinate
     */
    public Point2D getCoordinate() {
        return coordinate;
    }

    /**
     * Set the value of coordinate
     *
     * @param coordinate new value of coordinate
     */
    public void setCoordinate(Point2D.Double coordinate) {
        this.coordinate = coordinate;
    }

    private String indirizzo;

    /**
     * Get the value of indirizzo
     *
     * @return the value of indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Set the value of indirizzo
     *
     * @param indirizzo new value of indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    private String descrizione;

    /**
     * Get the value of descrizione
     *
     * @return the value of descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Set the value of descrizione
     *
     * @param descrizione new value of descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Location[ id=" + id + " ]";
    }
    
}
