package gt.com.umg.aisolis.models;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author aisolis
 */
public class Sale {
    
    private BigInteger invoice;
    private String nit;
    private Date saleDate;
    private int source;
    private String status;

    public Sale() {
    }

    public Sale(BigInteger invoice, String nit, Date saleDate, int source, String status) {
        this.invoice = invoice;
        this.nit = nit;
        this.saleDate = saleDate;
        this.source = source;
        this.status = status;
    }

    public BigInteger getInvoice() {
        return invoice;
    }

    public void setInvoice(BigInteger invoice) {
        this.invoice = invoice;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.invoice);
        hash = 37 * hash + Objects.hashCode(this.nit);
        hash = 37 * hash + Objects.hashCode(this.saleDate);
        hash = 37 * hash + this.source;
        hash = 37 * hash + Objects.hashCode(this.status);
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
        final Sale other = (Sale) obj;
        if (this.source != other.source) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.invoice, other.invoice)) {
            return false;
        }
        return Objects.equals(this.saleDate, other.saleDate);
    }

    @Override
    public String toString() {
        return "Sale{" + "invoice=" + invoice + ", nit=" + nit + ", saleDate=" + saleDate + ", source=" + source + ", status=" + status + '}';
    }
    
}
