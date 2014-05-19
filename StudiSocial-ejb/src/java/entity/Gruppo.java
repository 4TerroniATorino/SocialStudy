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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniele
 */
@Entity
@Table(name = "GRUPPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruppo.findAll", query = "SELECT g FROM Gruppo g"),
    @NamedQuery(name = "Gruppo.findById", query = "SELECT g FROM Gruppo g WHERE g.id = :id"),
    @NamedQuery(name = "Gruppo.findByArgomenti", query = "SELECT g FROM Gruppo g WHERE g.argomenti = :argomenti"),
    @NamedQuery(name = "Gruppo.findByNome", query = "SELECT g FROM Gruppo g WHERE g.nome = :nome"),
    @NamedQuery(name = "Gruppo.findByCorsoId", query = "SELECT g FROM Gruppo g WHERE g.corsoId = :corsoId"),
    @NamedQuery(name = "Gruppo.findByFondatoreId", query = "SELECT g FROM Gruppo g WHERE g.fondatoreId = :fondatoreId")})
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
    @Column(name = "CORSO_ID")
    private long corsoId;
    @Column(name = "FONDATORE_ID")
    private long fondatoreId;

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

    public long getCorsoId() {
        return corsoId;
    }

    public void setCorsoId(long corsoId) {
        this.corsoId = corsoId;
    }

    public long getFondatoreId() {
        return fondatoreId;
    }

    public void setFondatoreId(long fondatoreId) {
        this.fondatoreId = fondatoreId;
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
