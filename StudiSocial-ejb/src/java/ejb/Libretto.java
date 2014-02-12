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
public class Libretto implements Serializable {
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
    
        private String Corsodistudi;

    /**
     * Get the value of Corsodistudi
     *
     * @return the value of Corsodistudi
     */
    public String getCorsodistudi() {
        return Corsodistudi;
    }

    /**
     * Set the value of Corsodistudi
     *
     * @param Corsodistudi new value of Corsodistudi
     */
    public void setCorsodistudi(String Corsodistudi) {
        this.Corsodistudi = Corsodistudi;
    }


    private Corso[] corsi;

    /**
     * Get the value of corsi
     *
     * @return the value of corsi
     */
    public Corso[] getCorsi() {
        return corsi;
    }

    /**
     * Set the value of corsi
     *
     * @param corsi new value of corsi
     */
    public void setCorsi(Corso[] corsi) {
        this.corsi = corsi;
    }

    private int[] voti;

    /**
     * Get the value of voti
     *
     * @return the value of voti
     */
    public int[] getVoti() {
        return voti;
    }

    /**
     * Set the value of voti
     *
     * @param voti new value of voti
     */
    public void setVoti(int[] voti) {
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
        if (!(object instanceof Libretto)) {
            return false;
        }
        Libretto other = (Libretto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Libretto[ id=" + id + " ]";
    }
    
}
