/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Daniele
 */
@Entity
public class Gruppo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nome;

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    private Utente fondatore;

    /**
     * Get the value of fondatore
     *
     * @return the value of fondatore
     */
    public Utente getFondatore() {
        return fondatore;
    }

    /**
     * Set the value of fondatore
     *
     * @param fondatore new value of fondatore
     */
    public void setFondatore(Utente fondatore) {
        this.fondatore = fondatore;
    }

    private String argomenti;

    /**
     * Get the value of argomenti
     *
     * @return the value of argomenti
     */
    public String getArgomenti() {
        return argomenti;
    }

    /**
     * Set the value of argomenti
     *
     * @param argomenti new value of argomenti
     */
    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    private Corso corso;

    /**
     * Get the value of corso
     *
     * @return the value of corso
     */
    public Corso getCorso() {
        return corso;
    }

    /**
     * Set the value of corso
     *
     * @param corso new value of corso
     */
    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    private Utente[] utenti;

    /**
     * Get the value of utenti
     *
     * @return the value of utenti
     */
    public Utente[] getUtenti() {
        return utenti;
    }

    /**
     * Set the value of utenti
     *
     * @param utenti new value of utenti
     */
    public void setUtenti(Utente[] utenti) {
        this.utenti = utenti;
    }

    private Incontro[] incontri;

    /**
     * Get the value of incontri
     *
     * @return the value of incontri
     */
    public Incontro[] getIncontri() {
        return incontri;
    }

    /**
     * Set the value of incontri
     *
     * @param incontri new value of incontri
     */
    public void setIncontri(Incontro[] incontri) {
        this.incontri = incontri;
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
        return "ejb.Gruppo[ id=" + id + " ]";
    }
    
}
