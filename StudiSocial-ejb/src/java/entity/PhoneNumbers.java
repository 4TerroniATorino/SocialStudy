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
@Table(name = "phone_numbers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneNumbers.findAll", query = "SELECT p FROM PhoneNumbers p"),
    @NamedQuery(name = "PhoneNumbers.findByPhoneNumber", query = "SELECT p FROM PhoneNumbers p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "PhoneNumbers.findByDeviceType", query = "SELECT p FROM PhoneNumbers p WHERE p.deviceType = :deviceType"),
    @NamedQuery(name = "PhoneNumbers.findByDeviceId", query = "SELECT p FROM PhoneNumbers p WHERE p.deviceId = :deviceId"),
    @NamedQuery(name = "PhoneNumbers.findByPrivateKey", query = "SELECT p FROM PhoneNumbers p WHERE p.privateKey = :privateKey")})
public class PhoneNumbers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "device_type")
    private String deviceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "device_id")
    private String deviceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "private_key")
    private String privateKey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender", fetch = FetchType.EAGER)
    private Collection<Messages> messagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipient", fetch = FetchType.EAGER)
    private Collection<Messages> messagesCollection1;

    public PhoneNumbers() {
    }

    public PhoneNumbers(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumbers(String phoneNumber, String deviceType, String deviceId, String privateKey) {
        this.phoneNumber = phoneNumber;
        this.deviceType = deviceType;
        this.deviceId = deviceId;
        this.privateKey = privateKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection1() {
        return messagesCollection1;
    }

    public void setMessagesCollection1(Collection<Messages> messagesCollection1) {
        this.messagesCollection1 = messagesCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhoneNumbers)) {
            return false;
        }
        PhoneNumbers other = (PhoneNumbers) object;
        if ((this.phoneNumber == null && other.phoneNumber != null) || (this.phoneNumber != null && !this.phoneNumber.equals(other.phoneNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PhoneNumbers[ phoneNumber=" + phoneNumber + " ]";
    }
    
}
