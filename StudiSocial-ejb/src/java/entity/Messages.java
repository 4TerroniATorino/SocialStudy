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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id"),
    @NamedQuery(name = "Messages.findByIsRead", query = "SELECT m FROM Messages m WHERE m.isRead = :isRead"),
    @NamedQuery(name = "Messages.findByTsSent", query = "SELECT m FROM Messages m WHERE m.tsSent = :tsSent"),
    @NamedQuery(name = "Messages.findByRecipient", query = "SELECT m FROM Messages m WHERE m.recipient = :recipient")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "isRead")
    private Boolean isRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ts_sent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsSent;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "sender", referencedColumnName = "phone_number")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PhoneNumbers sender;
    @JoinColumn(name = "recipient", referencedColumnName = "phone_number")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PhoneNumbers recipient;

    public Messages() {
    }

    public Messages(Integer id) {
        this.id = id;
    }

    public Messages(Integer id, Date tsSent, String message) {
        this.id = id;
        this.tsSent = tsSent;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Date getTsSent() {
        return tsSent;
    }

    public void setTsSent(Date tsSent) {
        this.tsSent = tsSent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PhoneNumbers getSender() {
        return sender;
    }

    public void setSender(PhoneNumbers sender) {
        this.sender = sender;
    }

    public PhoneNumbers getRecipient() {
        return recipient;
    }

    public void setRecipient(PhoneNumbers recipient) {
        this.recipient = recipient;
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
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Messages[ id=" + id + " ]";
    }
    
}
