package gt.com.umg.aisolis.dao;

import gt.com.umg.aisolis.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aisolis
 */
public class UserDao {
        private static final String SELECT_BY_USER = "SELECT * FROM TB_USUARIO WHERE USUARIO = ?";
        
        public User findById(String user1){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = new User();
        try {
            conn = ConnectJdbc.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_USER);
            stmt.setString(1, user1);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                user.setUsuario(rs.getString("USUARIO"));
                user.setPassword(rs.getString("PASSWORD_USR"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            ConnectJdbc.close(rs);
            ConnectJdbc.close(stmt);
            ConnectJdbc.close(conn);
        }
        return user;
    }

}
