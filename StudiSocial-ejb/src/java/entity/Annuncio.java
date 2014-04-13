/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ANNUNCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annuncio.findAll", query = "SELECT a FROM Annuncio a"),
    @NamedQuery(name = "Annuncio.findById", query = "SELECT a FROM Annuncio a WHERE a.id = :id"),
    @NamedQuery(name = "Annuncio.findByTesto", query = "SELECT a FROM Annuncio a WHERE a.testo = :testo"),
    @NamedQuery(name = "Annuncio.findByLocationId", query = "SELECT a FROM Annuncio a WHERE a.locationId = :locationId"),
    @NamedQuery(name = "Annuncio.findByUserId", query = "SELECT a FROM Annuncio a WHERE a.userId = :userId")})
public class Annuncio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "TESTO")
    private String testo;
    @Column(name = "LOCATION_ID")
    private BigInteger locationId;
    @Size(max = 255)
    @Column(name = "USER_ID")
    private String userId;

    public Annuncio() {
    }

    public Annuncio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "entity.Annuncio[ id=" + id + " ]";
    }
    
}
