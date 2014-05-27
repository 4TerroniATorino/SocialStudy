/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oneiros
 */
@Entity
@Table(name = "CORSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corso.findAll", query = "SELECT c FROM Corso c"),
    @NamedQuery(name = "Corso.findById", query = "SELECT c FROM Corso c WHERE c.id = :id"),
    @NamedQuery(name = "Corso.findByCorsodistudi", query = "SELECT c FROM Corso c WHERE c.corsodistudi = :corsodistudi"),
    @NamedQuery(name = "Corso.findByCrediti", query = "SELECT c FROM Corso c WHERE c.crediti = :crediti"),
    @NamedQuery(name = "Corso.findByDescrizione", query = "SELECT c FROM Corso c WHERE c.descrizione = :descrizione"),
    @NamedQuery(name = "Corso.findByDocente", query = "SELECT c FROM Corso c WHERE c.docente = :docente"),
    @NamedQuery(name = "Corso.findByMfu", query = "SELECT c FROM Corso c WHERE c.mfu = :mfu"),
    @NamedQuery(name = "Corso.findByNome", query = "SELECT c FROM Corso c WHERE c.nome = :nome"),
    @NamedQuery(name = "Corso.findByNumIscritti", query = "SELECT c FROM Corso c WHERE c.numIscritti = :numIscritti"),
    @NamedQuery(name = "Corso.findBySemestre", query = "SELECT c FROM Corso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Corso.findByLocationId", query = "SELECT c FROM Corso c WHERE c.locationId = :locationId")})
public class Corso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "CORSODISTUDI")
    private String corsodistudi;
    @Column(name = "CREDITI")
    private Integer crediti;
    @Size(max = 255)
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Size(max = 255)
    @Column(name = "DOCENTE")
    private String docente;
    @Size(max = 255)
    @Column(name = "MFU")
    private String mfu;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ISCRITTI")
    private int numIscritti;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATION_ID")
    private long locationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corso", fetch = FetchType.EAGER)
    private Collection<Voto> votoCollection;
    @OneToMany(mappedBy = "corso", fetch = FetchType.EAGER)
    private Collection<Gruppo> gruppoCollection;

    public Corso() {
    }

    public Corso(Long id) {
        this.id = id;
    }

    public Corso(Long id, int numIscritti, long locationId) {
        this.id = id;
        this.numIscritti = numIscritti;
        this.locationId = locationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorsodistudi() {
        return corsodistudi;
    }

    public void setCorsodistudi(String corsodistudi) {
        this.corsodistudi = corsodistudi;
    }

    public Integer getCrediti() {
        return crediti;
    }

    public void setCrediti(Integer crediti) {
        this.crediti = crediti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getMfu() {
        return mfu;
    }

    public void setMfu(String mfu) {
        this.mfu = mfu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumIscritti() {
        return numIscritti;
    }

    public void setNumIscritti(int numIscritti) {
        this.numIscritti = numIscritti;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    @XmlTransient
    public Collection<Voto> getVotoCollection() {
        return votoCollection;
    }

    public void setVotoCollection(Collection<Voto> votoCollection) {
        this.votoCollection = votoCollection;
    }

    @XmlTransient
    public Collection<Gruppo> getGruppoCollection() {
        return gruppoCollection;
    }

    public void setGruppoCollection(Collection<Gruppo> gruppoCollection) {
        this.gruppoCollection = gruppoCollection;
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
        if (!(object instanceof Corso)) {
            return false;
        }
        Corso other = (Corso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Corso[ id=" + id + " ]";
    }
    
}
