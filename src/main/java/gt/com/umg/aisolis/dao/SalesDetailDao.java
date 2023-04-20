package gt.com.umg.aisolis.dao;

import gt.com.umg.aisolis.models.Client;
import gt.com.umg.aisolis.models.Sale;
import gt.com.umg.aisolis.models.SaleDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aisolis
 */
public class SalesDetailDao {
    
    private static final String SELECT_INVOICE = "SELECT * FROM TB_DETALLE_VENTA WHERE FACTURA = ? ORDER BY ID_DETALLE";
    private static final String MERGE = "INSERT INTO TB_DETALLE_VENTA(FACTURA, COD_PRODUCTO, CANTIDAD, PRECIO) VALUES (?,?,?,?)";

    public List<SaleDetail> findByInvoice(int invoice){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SaleDetail saleDetail = new SaleDetail();
        List<SaleDetail> details = new ArrayList<>();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_INVOICE);
            stmt.setInt(1, invoice);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                saleDetail.setDbid(rs.getInt("ID_DETALLE"));
                saleDetail.setInvoice(rs.getInt("FACTURA"));
                saleDetail.setCodProd(rs.getInt("COD_PRODUCTO"));
                saleDetail.setQuantity(rs.getInt("CANTIDAD"));
                saleDetail.setPrice(rs.getDouble("PRECIO"));
                details.add(saleDetail);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return details;
    }
    
    public int merge(SaleDetail saleDetail){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(MERGE);
            stmt.setInt(1, saleDetail.getInvoice());
            stmt.setInt(2, saleDetail.getCodProd());
            stmt.setInt(3, saleDetail.getQuantity());
            stmt.setDouble(4, saleDetail.getPrice());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    
}
