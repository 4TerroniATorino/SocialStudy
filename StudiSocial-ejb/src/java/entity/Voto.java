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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VOTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v"),
    @NamedQuery(name = "Voto.findById", query = "SELECT v FROM Voto v WHERE v.id = :id"),
    @NamedQuery(name = "Voto.findByIdUtente", query = "SELECT v FROM Voto v WHERE v.idUtente = :idUtente"),
    @NamedQuery(name = "Voto.findByVoti", query = "SELECT v FROM Voto v WHERE v.voti = :voti")})
public class Voto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UTENTE")
    private long idUtente;
    @Column(name = "VOTI")
    private Short voti;
    @JoinColumn(name = "CORSO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Corso corso;

    public Voto() {
    }

    public Voto(Long id) {
        this.id = id;
    }

    public Voto(Long id, long idUtente) {
        this.id = id;
        this.idUtente = idUtente;
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

    public Short getVoti() {
        return voti;
    }

    public void setVoti(Short voti) {
        this.voti = voti;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
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
        if (!(object instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Voto[ id=" + id + " ]";
    }
    
}
