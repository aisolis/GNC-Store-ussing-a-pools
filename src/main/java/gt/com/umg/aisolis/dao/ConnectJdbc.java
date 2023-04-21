/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.umg.aisolis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author swords
 */
public class ConnectJdbc {
    
    //private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-LUQ77GC\\MSSQLSERVER:1433;databaseName=master;encrypt=false";
    private static final String JDBC_URL = "jdbc:sqlserver://LT5490-9X75QQ2\\MSSQLSERVER:1433;databaseName=master;encrypt=false";
    private static final String USER = "sa";
    private static final String PWD = "@lderI.28*";

    public ConnectJdbc() {
    }
    
       
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,USER,PWD);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJdbc.class.getName()).log(Level.SEVERE, null, ex);
                    
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJdbc.class.getName()).log(Level.SEVERE, null, ex);
                    
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJdbc.class.getName()).log(Level.SEVERE, null, ex);
                    
        }
    }
}
