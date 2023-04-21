package gt.com.umg.aisolis.dao;

import gt.com.umg.aisolis.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aisolis
 */
public class ProductDao {
    private static final String SELECT_ALL = "SELECT * FROM TB_PRODUCTO";
    private static final String SELECT_BY_ID = "SELECT * FROM TB_PRODUCTO WHERE COD_PRODUCTO = ?";
    private static final String MERGE_PRODUCT = "INSERT INTO TB_PRODUCTO(NOMBRE, STOCK, PRECIO, DESCRIPCION, QUE_ES, PARA_QUE, BENEFICIOS, FORMA_TOMAR, INGREDIENTES, PRECAUCIONES, ESTATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String MERGE_PRODUCT_BY_ID = "UPDATE TB_PRODUCTO SET NOMBRE = ?, STOCK = ?, PRECIO = ?, DESCRIPCION = ?, QUE_ES = ?, PARA_QUE = ?, BENEFICIOS = ?, FORMA_TOMAR = ?, INGREDIENTES = ?, PRECAUCIONES = ?, ESTATUS = ? WHERE COD_PRODUCTO = ?";
    private static final String DELETE = "DELETE FROM TB_PRODUCTO WHERE COD_PRODUCTO = ?";

    
    public List<Product> findAll(){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Product product = new Product();
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
    
    public Product findById(int codprod){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = new Product();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, codprod);
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
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return product;
    }
    
    public int getNextCodProd(){
        int tmp = 1;
        try {
            LinkedList<Product> products = new LinkedList<>();
            
            products.addAll(findAll());
            if(!products.isEmpty()){
                tmp = products.getLast().getCod_prod()+1;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tmp;
    }
    
    public int merge(Product product){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(MERGE_PRODUCT);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStock());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getDescription());
            stmt.setString(5, product.getWhatIs());
            stmt.setString(6, product.getForWhat());
            stmt.setString(7, product.getBenefits());
            stmt.setString(8, product.getUssageWay());
            stmt.setString(9, product.getIngredients());
            stmt.setString(10, product.getWarnings());
            stmt.setString(11, product.getStatus());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    
    public int merge(Product product, int codprod){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(MERGE_PRODUCT_BY_ID);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStock());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getDescription());
            stmt.setString(5, product.getWhatIs());
            stmt.setString(6, product.getForWhat());
            stmt.setString(7, product.getBenefits());
            stmt.setString(8, product.getUssageWay());
            stmt.setString(9, product.getIngredients());
            stmt.setString(10, product.getWarnings());
            stmt.setString(11, product.getStatus());
            stmt.setInt(12, product.getCod_prod());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    
    public int destroy(Product product){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, product.getCod_prod());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
}
