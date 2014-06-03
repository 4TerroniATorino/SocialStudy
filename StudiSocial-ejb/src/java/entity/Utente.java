/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "UTENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.findById", query = "SELECT u FROM Utente u WHERE u.id = :id"),
    @NamedQuery(name = "Utente.findByCognome", query = "SELECT u FROM Utente u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utente.findByEmail", query = "SELECT u FROM Utente u WHERE u.email = :email"),
    @NamedQuery(name = "Utente.findByIdlog", query = "SELECT u FROM Utente u WHERE u.idlog = :idlog"),
    @NamedQuery(name = "Utente.findByNome", query = "SELECT u FROM Utente u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utente.findByUsername", query = "SELECT u FROM Utente u WHERE u.username = :username"),
    @NamedQuery(name = "Utente.findByPhoneNumber", query = "SELECT u FROM Utente u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Utente.findByPicture", query = "SELECT u FROM Utente u WHERE u.picture = :picture")})
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "COGNOME")
    private String cognome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IDLOG")
    private String idlog;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 255)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Size(max = 100)
    @Column(name = "PICTURE")
    private String picture;
    @ManyToMany(mappedBy = "utenteCollection", fetch = FetchType.EAGER)
    private Collection<Gruppo> gruppiPartecipante;
    @OneToMany(mappedBy = "fondatore", fetch = FetchType.EAGER)
    private Collection<Gruppo> gruppiFondati;

    public Utente() {
    }

    public Utente(Long id) {
        this.id = id;
    }

    public Utente(Long id, String email, String idlog) {
        this.id = id;
        this.email = email;
        this.idlog = idlog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdlog() {
        return idlog;
    }

    public void setIdlog(String idlog) {
        this.idlog = idlog;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @XmlTransient
    public Collection<Gruppo> getGruppiPartecipante() {
        return gruppiPartecipante;
    }

    public void setGruppiPartecipante(Collection<Gruppo> gruppiPartecipante) {
        this.gruppiPartecipante = gruppiPartecipante;
    }

    @XmlTransient
    public Collection<Gruppo> getGruppiFondati() {
        return gruppiFondati;
    }

    public void setGruppiFondati(Collection<Gruppo> gruppiFondati) {
        this.gruppiFondati = gruppiFondati;
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
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Utente[ id=" + id + " ]";
    }
    
}
