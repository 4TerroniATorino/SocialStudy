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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniele
 */
@Entity
@Table(name = "VOTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v"),
    @NamedQuery(name = "Voto.findById", query = "SELECT v FROM Voto v WHERE v.id = :id"),
    @NamedQuery(name = "Voto.findByIdUtente", query = "SELECT v FROM Voto v WHERE v.idUtente = :idUtente"),
    @NamedQuery(name = "Voto.findByCorso", query = "SELECT v FROM Voto v WHERE v.corso = :corso"),
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORSO")
    private long corso;
    @Column(name = "VOTI")
    private Short voti;

    public Voto() {
    }

    public Voto(Long id) {
        this.id = id;
    }

    public Voto(Long id, long idUtente, long corso) {
        this.id = id;
        this.idUtente = idUtente;
        this.corso = corso;
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

    public long getCorso() {
        return corso;
    }

    public void setCorso(long corso) {
        this.corso = corso;
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
