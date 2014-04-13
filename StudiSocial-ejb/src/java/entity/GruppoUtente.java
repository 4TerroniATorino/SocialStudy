/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oneiros
 */
@Entity
@Table(name = "GRUPPO_UTENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruppoUtente.findAll", query = "SELECT g FROM GruppoUtente g"),
    @NamedQuery(name = "GruppoUtente.findByGruppoID", query = "SELECT g FROM GruppoUtente g WHERE g.gruppoUtentePK.gruppoID = :gruppoID"),
    @NamedQuery(name = "GruppoUtente.findByUtentiID", query = "SELECT g FROM GruppoUtente g WHERE g.gruppoUtentePK.utentiID = :utentiID")})
public class GruppoUtente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GruppoUtentePK gruppoUtentePK;

    public GruppoUtente() {
    }

    public GruppoUtente(GruppoUtentePK gruppoUtentePK) {
        this.gruppoUtentePK = gruppoUtentePK;
    }

    public GruppoUtente(long gruppoID, long utentiID) {
        this.gruppoUtentePK = new GruppoUtentePK(gruppoID, utentiID);
    }

    public GruppoUtentePK getGruppoUtentePK() {
        return gruppoUtentePK;
    }

    public void setGruppoUtentePK(GruppoUtentePK gruppoUtentePK) {
        this.gruppoUtentePK = gruppoUtentePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruppoUtentePK != null ? gruppoUtentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruppoUtente)) {
            return false;
        }
        GruppoUtente other = (GruppoUtente) object;
        if ((this.gruppoUtentePK == null && other.gruppoUtentePK != null) || (this.gruppoUtentePK != null && !this.gruppoUtentePK.equals(other.gruppoUtentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GruppoUtente[ gruppoUtentePK=" + gruppoUtentePK + " ]";
    }
    
}
