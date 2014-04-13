/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oneiros
 */
@Entity
@Table(name = "INCONTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incontro.findAll", query = "SELECT i FROM Incontro i"),
    @NamedQuery(name = "Incontro.findById", query = "SELECT i FROM Incontro i WHERE i.id = :id"),
    @NamedQuery(name = "Incontro.findByDataincontro", query = "SELECT i FROM Incontro i WHERE i.dataincontro = :dataincontro"),
    @NamedQuery(name = "Incontro.findByGruppoId", query = "SELECT i FROM Incontro i WHERE i.gruppoId = :gruppoId"),
    @NamedQuery(name = "Incontro.findByLocationId", query = "SELECT i FROM Incontro i WHERE i.locationId = :locationId")})
public class Incontro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATAINCONTRO")
    @Temporal(TemporalType.DATE)
    private Date dataincontro;
    @Column(name = "GRUPPO_ID")
    private BigInteger gruppoId;
    @Column(name = "LOCATION_ID")
    private BigInteger locationId;

    public Incontro() {
    }

    public Incontro(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataincontro() {
        return dataincontro;
    }

    public void setDataincontro(Date dataincontro) {
        this.dataincontro = dataincontro;
    }

    public BigInteger getGruppoId() {
        return gruppoId;
    }

    public void setGruppoId(BigInteger gruppoId) {
        this.gruppoId = gruppoId;
    }

    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
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
        return "entity.Incontro[ id=" + id + " ]";
    }
    
}
