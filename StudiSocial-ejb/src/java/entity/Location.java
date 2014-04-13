/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.awt.geom.Point2D;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oneiros
 */
@Entity
@Table(name = "LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id"),
    @NamedQuery(name = "Location.findByLat", query = "SELECT l FROM Location l WHERE l.lat = :lat"),
    @NamedQuery(name = "Location.findByLng", query = "SELECT l FROM Location l WHERE l.lng = :lng"),
    @NamedQuery(name = "Location.findByDescrizione", query = "SELECT l FROM Location l WHERE l.descrizione = :descrizione"),
    @NamedQuery(name = "Location.findByIndirizzo", query = "SELECT l FROM Location l WHERE l.indirizzo = :indirizzo"),
    @NamedQuery(name = "Location.findByType", query = "SELECT l FROM Location l WHERE l.type = :type")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LAT")
    private Float lat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LNG")
    private float lng;
    @Size(max = 255)
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Size(max = 255)
    @Column(name = "INDIRIZZO")
    private String indirizzo;
    @Size(max = 255)
    @Column(name = "TYPE")
    private String type;

    public Location() {
    }

    public Location(Long id) {
        this.id = id;
    }

    public Location(Long id, float lng) {
        this.id = id;
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLat() {
        return lat;
    }

    public void setCoordinate(Point2D.Float coordinata) {
        this.setLat(coordinata.x);
        this.setLng(coordinata.y);
    }

    public Point2D.Float getCoordinate() {
        return new Point2D.Float(this.lat, this.lng);
    }
    

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "entity.Location[ id=" + id + " ]";
    }
}
