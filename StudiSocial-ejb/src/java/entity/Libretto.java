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
@Table(name = "LIBRETTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libretto.findAll", query = "SELECT l FROM Libretto l"),
    @NamedQuery(name = "Libretto.findById", query = "SELECT l FROM Libretto l WHERE l.id = :id")})
public class Libretto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Lob
    @Column(name = "CORSI")
    private byte[] corsi;
    @Lob
    @Column(name = "VOTI")
    private byte[] voti;

    public Libretto() {
    }

    public Libretto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getCorsi() {
        return corsi;
    }

    public void setCorsi(byte[] corsi) {
        this.corsi = corsi;
    }

    public byte[] getVoti() {
        return voti;
    }

    public void setVoti(byte[] voti) {
        this.voti = voti;
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
        if (!(object instanceof Libretto)) {
            return false;
        }
        Libretto other = (Libretto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Libretto[ id=" + id + " ]";
    }
    
}
