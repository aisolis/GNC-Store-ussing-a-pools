/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.umg.aisolis.dao;

import gt.com.umg.aisolis.models.Sale;
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
public class SalesDao {
    
    private static final String SELECT_ALL = "SELECT * FROM TB_VENTA";
    private static final String SELECT_BY_FAC = "SELECT * FROM TB_VENTA WHERE FACTURA = ?";
    private static final String MERGE = "INSERT INTO TB_VENTA(NIT, FECHA, MEDIO, ESTATUS) VALUES (?,?,?,?)";
    
    public List<Sale> findAll(){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sale sale = new Sale();
        List<Sale> sales = new ArrayList<>();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                sale.setInvoice(rs.getInt("FACTURA"));
                sale.setNit(rs.getString("NIT"));
                sale.setSaleDate(rs.getDate("FECHA"));
                sale.setSource(rs.getInt("MEDIO"));
                sale.setStatus(rs.getString("ESTATUS"));
                sales.add(sale);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return sales;
    }
    
    public Sale findByInvoice(int invoice){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sale sale = new Sale();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_FAC);
            stmt.setInt(1, invoice);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                sale.setInvoice(rs.getInt("FACTURA"));
                sale.setNit(rs.getString("NIT"));
                sale.setSaleDate(rs.getDate("FECHA"));
                sale.setSource(rs.getInt("MEDIO"));
                sale.setStatus(rs.getString("ESTATUS"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return sale;
    }
    
    public int merge(Sale sale){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(MERGE);
            stmt.setString(1, sale.getNit());
            stmt.setDate(2, new java.sql.Date(sale.getSaleDate().getTime()));
            stmt.setInt(3, sale.getSource());
            stmt.setString(4, sale.getStatus());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    
    public int getInvoice(){
        int tmp = 1;
        try {
            LinkedList<Sale> products = new LinkedList<>();
            
            products.addAll(findAll());
            if(!products.isEmpty()){
                tmp = products.getLast().getInvoice();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tmp;
    }
    
}
