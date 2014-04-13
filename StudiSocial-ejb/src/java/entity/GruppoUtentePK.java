/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author oneiros
 */
@Embeddable
public class GruppoUtentePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gruppo_ID")
    private long gruppoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "utenti_ID")
    private long utentiID;

    public GruppoUtentePK() {
    }

    public GruppoUtentePK(long gruppoID, long utentiID) {
        this.gruppoID = gruppoID;
        this.utentiID = utentiID;
    }

    public long getGruppoID() {
        return gruppoID;
    }

    public void setGruppoID(long gruppoID) {
        this.gruppoID = gruppoID;
    }

    public long getUtentiID() {
        return utentiID;
    }

    public void setUtentiID(long utentiID) {
        this.utentiID = utentiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gruppoID;
        hash += (int) utentiID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruppoUtentePK)) {
            return false;
        }
        GruppoUtentePK other = (GruppoUtentePK) object;
        if (this.gruppoID != other.gruppoID) {
            return false;
        }
        if (this.utentiID != other.utentiID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GruppoUtentePK[ gruppoID=" + gruppoID + ", utentiID=" + utentiID + " ]";
    }
    
}
