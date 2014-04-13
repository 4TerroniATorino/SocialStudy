/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oneiros
 */
@Entity
@Table(name = "MAPPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mappa.findAll", query = "SELECT m FROM Mappa m"),
    @NamedQuery(name = "Mappa.findById", query = "SELECT m FROM Mappa m WHERE m.id = :id")})
public class Mappa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Lob
    @Column(name = "LOCATION")
    private byte[] location;
    @Lob
    @Column(name = "UTENTE")
    private byte[] utente;

    public Mappa() {
    }

    public Mappa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public byte[] getUtente() {
        return utente;
    }

    public void setUtente(byte[] utente) {
        this.utente = utente;
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
        if (!(object instanceof Mappa)) {
            return false;
        }
        Mappa other = (Mappa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mappa[ id=" + id + " ]";
    }
    
}
