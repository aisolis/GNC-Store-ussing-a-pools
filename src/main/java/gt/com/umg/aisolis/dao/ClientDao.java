/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.umg.aisolis.dao;

import gt.com.umg.aisolis.models.Client;
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
public class ClientDao {
    
    private static final String SELECT_ALL = "SELECT * FROM TB_CLIENTE";
    private static final String FIND_BY_NIT = "SELECT * FROM TB_CLIENTE WHERE NIT = ?";
    private static final String MERGE = "INSERT INTO TB_CLIENTE(NIT, NOMBRE, DIRECCION, TELEFONO, CORREO) VALUES(?,?,?,?,?)";
    private static final String MERGE_BY_NIT = "UPDATE TB_CLIENTE SET NIT = ?, NOMBRE = ?, DIRECCION = ?, TELEFONO = ?, CORREO = ? WHERE NIT = ?";
    private static final String DELETE = "DELETE FROM TB_CLIENTE WHERE NIT = ?";
    
    public List<Client> findAll(){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = new Client();
        List<Client> clients = new ArrayList<>();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                client.setDbid(rs.getInt("DBID"));
                client.setNit(rs.getString("NIT"));
                client.setFullName(rs.getString("NOMBRE"));
                client.setAddress(rs.getString("DIRECCION"));
                client.setCelphone(rs.getInt("TELEFONO"));
                client.setMail(rs.getString("CORREO"));
                clients.add(client);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return clients;
    }
    
    public Client findById(String nit){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = new Client();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(FIND_BY_NIT);
            stmt.setString(1, nit);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                client.setDbid(rs.getInt("DBID"));
                client.setNit(rs.getString("NIT"));
                client.setFullName(rs.getString("NOMBRE"));
                client.setAddress(rs.getString("DIRECCION"));
                client.setCelphone(rs.getInt("TELEFONO"));
                client.setMail(rs.getString("CORREO"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return client;
    }
    
    public int merge(Client client){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(MERGE);
            stmt.setString(1, client.getNit());
            stmt.setString(2, client.getFullName());
            stmt.setString(3, client.getAddress());
            stmt.setInt(4, client.getCelphone());
            stmt.setString(5, client.getMail());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    
    public int merge(Client client, String nit){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(MERGE_BY_NIT);
            stmt.setString(1, client.getNit());
            stmt.setString(2, client.getFullName());
            stmt.setString(3, client.getAddress());
            stmt.setInt(4, client.getCelphone());
            stmt.setString(5, client.getMail());
            stmt.setString(6, nit);
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    
    public int destroy(Client client){
        Connection conn = null;
        PreparedStatement stmt = null;
        int output = 0;
        
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, client.getNit());
            output = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return output;
    }

}
