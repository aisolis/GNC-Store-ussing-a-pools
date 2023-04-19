package gt.com.umg.aisolis.dao;

import gt.com.umg.aisolis.models.Product;
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
public class ProductDao {
    private static final String SELECT_ALL = "SELECT * FROM TB_PRODUCTO";
    
    public List<Product> findAll(){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = new Product();
        List<Product> products = new ArrayList<>();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                product.setCod_prod(rs.getInt("COD_PRODUCTO"));
                product.setName(rs.getString("NOMBRE"));
                product.setStock(rs.getInt("STOCK"));
                product.setPrice(rs.getDouble("PRECIO"));
                product.setDescription(rs.getString("DESCRIPCION"));
                product.setWhatIs(rs.getString("QUE_ES"));
                product.setForWhat(rs.getString("PARA_QUE"));
                product.setBenefits(rs.getString("BENEFICIOS"));
                product.setUssageWay(rs.getString("FORMA_TOMAR"));
                product.setIngredients(rs.getString("INGREDIENTES"));
                product.setWarnings(rs.getString("PRECAUCIONES"));
                product.setStatus(rs.getString("ESTATUS"));
                products.add(product);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return products;
    }
}
