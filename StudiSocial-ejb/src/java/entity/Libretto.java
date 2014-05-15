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
    @NamedQuery(name = "Libretto.findById", query = "SELECT l FROM Libretto l WHERE l.id = :id"),
    @NamedQuery(name = "Libretto.findByIdUtente", query = "SELECT l FROM Libretto l WHERE l.idUtente = :idUtente"),
    @NamedQuery(name = "Libretto.findByCorsi", query = "SELECT l FROM Libretto l WHERE l.corsi = :corsi"),
    @NamedQuery(name = "Libretto.findByVoti", query = "SELECT l FROM Libretto l WHERE l.voti = :voti")})
public class Libretto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UTENTE")
    private long idUtente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORSI")
    private long corsi;
    @Column(name = "VOTI")
    private Short voti;

    public Libretto() {
    }

    public Libretto(Long id) {
        this.id = id;
    }

    public Libretto(Long id, long idUtente, long corsi) {
        this.id = id;
        this.idUtente = idUtente;
        this.corsi = corsi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
    }

    public long getCorsi() {
        return corsi;
    }

    public void setCorsi(long corsi) {
        this.corsi = corsi;
    }

    public Short getVoti() {
        return voti;
    }

    public void setVoti(Short voti) {
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
