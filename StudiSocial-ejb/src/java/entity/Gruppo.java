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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oneiros
 */
@Entity
@Table(name = "GRUPPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruppo.findAll", query = "SELECT g FROM Gruppo g"),
    @NamedQuery(name = "Gruppo.findById", query = "SELECT g FROM Gruppo g WHERE g.id = :id"),
    @NamedQuery(name = "Gruppo.findByArgomenti", query = "SELECT g FROM Gruppo g WHERE g.argomenti = :argomenti"),
    @NamedQuery(name = "Gruppo.findByNome", query = "SELECT g FROM Gruppo g WHERE g.nome = :nome"),
    @NamedQuery(name = "Gruppo.findByFondatore", query = "SELECT g FROM Gruppo g WHERE g.fondatore = :fondatore")})
public class Gruppo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "ARGOMENTI")
    private String argomenti;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @JoinTable(name = "GRUPPO_ISCRITTI", joinColumns = {
        @JoinColumn(name = "gruppo", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "utente", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Utente> utenteCollection;
    @JoinColumn(name = "FONDATORE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Utente fondatore;
    @JoinColumn(name = "CORSO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Corso corso;
    @OneToMany(mappedBy = "gruppo", fetch = FetchType.EAGER)
    private Collection<Incontro> incontroCollection;

    public Gruppo() {
    }

    public Gruppo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArgomenti() {
        return argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Utente> getUtenteCollection() {
        return utenteCollection;
    }

    public void setUtenteCollection(Collection<Utente> utenteCollection) {
        this.utenteCollection = utenteCollection;
    }

    public Utente getFondatore() {
        return fondatore;
    }

    public void setFondatore(Utente fondatore) {
        this.fondatore = fondatore;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    @XmlTransient
    public Collection<Incontro> getIncontroCollection() {
        return incontroCollection;
    }

    public void setIncontroCollection(Collection<Incontro> incontroCollection) {
        this.incontroCollection = incontroCollection;
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
        if (!(object instanceof Gruppo)) {
            return false;
        }
        Gruppo other = (Gruppo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gruppo[ id=" + id + " ]";
    }
    
}
