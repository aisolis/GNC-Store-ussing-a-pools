package gt.com.umg.aisolis.models;

import java.math.BigInteger;
import java.util.Objects;

/**
 *
 * @author aisolis
 */
public class SaleDetail {
    
   private BigInteger dbid;
   private BigInteger invoice;
   private BigInteger codProd;
   private int quantity;
   private double price;

    public SaleDetail() {
    }

    public SaleDetail(BigInteger dbid, BigInteger invoice, BigInteger codProd, int quantity, double price) {
        this.dbid = dbid;
        this.invoice = invoice;
        this.codProd = codProd;
        this.quantity = quantity;
        this.price = price;
    }

    public BigInteger getDbid() {
        return dbid;
    }

    public void setDbid(BigInteger dbid) {
        this.dbid = dbid;
    }

    public BigInteger getInvoice() {
        return invoice;
    }

    public void setInvoice(BigInteger invoice) {
        this.invoice = invoice;
    }

    public BigInteger getCodProd() {
        return codProd;
    }

    public void setCodProd(BigInteger codProd) {
        this.codProd = codProd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.dbid);
        hash = 97 * hash + Objects.hashCode(this.invoice);
        hash = 97 * hash + Objects.hashCode(this.codProd);
        hash = 97 * hash + this.quantity;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final SaleDetail other = (SaleDetail) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.dbid, other.dbid)) {
            return false;
        }
        if (!Objects.equals(this.invoice, other.invoice)) {
            return false;
        }
        return Objects.equals(this.codProd, other.codProd);
    }

    @Override
    public String toString() {
        return "SaleDetail{" + "dbid=" + dbid + ", invoice=" + invoice + ", codProd=" + codProd + ", quantity=" + quantity + ", price=" + price + '}';
    }
   
}
