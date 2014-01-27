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
public class Corso implements Serializable {
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

    private String descrizione;

    /**
     * Get the value of descrizione
     *
     * @return the value of descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Set the value of descrizione
     *
     * @param descrizione new value of descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    private String mfu;

    /**
     * Get the value of mfu
     *
     * @return the value of mfu
     */
    public String getMfu() {
        return mfu;
    }

    /**
     * Set the value of mfu
     *
     * @param mfu new value of mfu
     */
    public void setMfu(String mfu) {
        this.mfu = mfu;
    }

    private String docente;

    /**
     * Get the value of docente
     *
     * @return the value of docente
     */
    public String getDocente() {
        return docente;
    }

    /**
     * Set the value of docente
     *
     * @param docente new value of docente
     */
    public void setDocente(String docente) {
        this.docente = docente;
    }

    private int crediti;

    /**
     * Get the value of crediti
     *
     * @return the value of crediti
     */
    public int getCrediti() {
        return crediti;
    }

    /**
     * Set the value of crediti
     *
     * @param crediti new value of crediti
     */
    public void setCrediti(int crediti) {
        this.crediti = crediti;
    }

    private int num_iscritti;

    /**
     * Get the value of num_iscritti
     *
     * @return the value of num_iscritti
     */
    public int getNum_iscritti() {
        return num_iscritti;
    }

    /**
     * Set the value of num_iscritti
     *
     * @param num_iscritti new value of num_iscritti
     */
    public void setNum_iscritti(int num_iscritti) {
        this.num_iscritti = num_iscritti;
    }

    private int semestre;

    /**
     * Get the value of semestre
     *
     * @return the value of semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Set the value of semestre
     *
     * @param semestre new value of semestre
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    private String corsoDiStudi;

    /**
     * Get the value of corsoDiStudi
     *
     * @return the value of corsoDiStudi
     */
    public String getCorsoDiStudi() {
        return corsoDiStudi;
    }

    /**
     * Set the value of corsoDiStudi
     *
     * @param corsoDiStudi new value of corsoDiStudi
     */
    public void setCorsoDiStudi(String corsoDiStudi) {
        this.corsoDiStudi = corsoDiStudi;
    }

    private Location location;

    /**
     * Get the value of location
     *
     * @return the value of location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the value of location
     *
     * @param location new value of location
     */
    public void setLocation(Location location) {
        this.location = location;
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
        return "ejb.Corso[ id=" + id + " ]";
    }
    
}
