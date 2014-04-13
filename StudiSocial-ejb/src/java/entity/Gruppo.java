/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Gruppo.findByCorsoId", query = "SELECT g FROM Gruppo g WHERE g.corsoId = :corsoId"),
    @NamedQuery(name = "Gruppo.findByFondatoreId", query = "SELECT g FROM Gruppo g WHERE g.fondatoreId = :fondatoreId")})
public class Gruppo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "ARGOMENTI")
    private String argomenti;
    @Lob
    @Column(name = "INCONTRI")
    private byte[] incontri;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @Lob
    @Column(name = "UTENTI")
    private byte[] utenti;
    @Column(name = "CORSO_ID")
    private BigInteger corsoId;
    @Size(max = 255)
    @Column(name = "FONDATORE_ID")
    private String fondatoreId;

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

    public byte[] getIncontri() {
        return incontri;
    }

    public void setIncontri(byte[] incontri) {
        this.incontri = incontri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getUtenti() {
        return utenti;
    }

    public void setUtenti(byte[] utenti) {
        this.utenti = utenti;
    }

    public BigInteger getCorsoId() {
        return corsoId;
    }

    public void setCorsoId(BigInteger corsoId) {
        this.corsoId = corsoId;
    }

    public String getFondatoreId() {
        return fondatoreId;
    }

    public void setFondatoreId(String fondatoreId) {
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
