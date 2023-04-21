package gt.com.umg.aisolis.models;

import java.util.Objects;

/**
 *
 * @author aisolis
 */
public class Client {
    
    private int dbid;
    private String nit;
    private String fullName;
    private String address;
    private int celphone;
    private String mail;

    public Client() {
    }

    public Client(int dbid, String nit, String fullName, String address, int celphone, String mail) {
        this.dbid = dbid;
        this.nit = nit;
        this.fullName = fullName;
        this.address = address;
        this.celphone = celphone;
        this.mail = mail;
    }

    public Client(String nit, String fullName, String address, int celphone, String mail) {
        this.nit = nit;
        this.fullName = fullName;
        this.address = address;
        this.celphone = celphone;
        this.mail = mail;
    }

    public int getDbid() {
        return dbid;
    }

    public void setDbid(int dbid) {
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

    public int getCelphone() {
        return celphone;
    }

    public void setCelphone(int celphone) {
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
