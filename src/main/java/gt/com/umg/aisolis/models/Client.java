package gt.com.umg.aisolis.models;

import java.math.BigInteger;
import java.util.Objects;

/**
 *
 * @author aisolis
 */
public class Client {
    
    private BigInteger dbid;
    private String nit;
    private String fullName;
    private String address;
    private String celphone;
    private String mail;

    public Client() {
    }

    public Client(BigInteger dbid, String nit, String fullName, String address, String celphone, String mail) {
        this.dbid = dbid;
        this.nit = nit;
        this.fullName = fullName;
        this.address = address;
        this.celphone = celphone;
        this.mail = mail;
    }

    public BigInteger getDbid() {
        return dbid;
    }

    public void setDbid(BigInteger dbid) {
        this.dbid = dbid;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCelphone() {
        return celphone;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.dbid);
        hash = 31 * hash + Objects.hashCode(this.nit);
        hash = 31 * hash + Objects.hashCode(this.fullName);
        hash = 31 * hash + Objects.hashCode(this.address);
        hash = 31 * hash + Objects.hashCode(this.celphone);
        hash = 31 * hash + Objects.hashCode(this.mail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.celphone, other.celphone)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.dbid, other.dbid);
    }

    @Override
    public String toString() {
        return "Client{" + "dbid=" + dbid + ", nit=" + nit + ", fullName=" + fullName + ", address=" + address + ", celphone=" + celphone + ", mail=" + mail + '}';
    }
    
}
