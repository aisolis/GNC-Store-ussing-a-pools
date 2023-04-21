
package gt.com.umg.aisolis.models;

/**
 *
 * @author aisolis
 */
public class User {
    private String usuario;
    private String password;

    public User() {
    }

    public User(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}
