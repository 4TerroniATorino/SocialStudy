/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Incontro.findByData", query = "SELECT i FROM Incontro i WHERE i.data = :data"),
    @NamedQuery(name = "Incontro.findByArgomento", query = "SELECT i FROM Incontro i WHERE i.argomento = :argomento")})
public class Incontro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ARGOMENTO")
    private String argomento;
    @JoinColumn(name = "LOCATION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;
    @JoinColumn(name = "GRUPPO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Gruppo gruppo;

    public Incontro() {
    }

    public Incontro(Long id) {
        this.id = id;
    }

    public Incontro(Long id, String argomento) {
        this.id = id;
        this.argomento = argomento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Gruppo getGruppo() {
        return gruppo;
    }

    public void setGruppo(Gruppo gruppo) {
        this.gruppo = gruppo;
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
