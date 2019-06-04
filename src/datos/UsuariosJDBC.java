
package datos;
import java.sql.*;
import java.util.*;
import domain.Usuario;


public class UsuariosJDBC 
{
    private final String SQL_INSERT = "insert into usuario (usuario, password) values (?,?)";
    private final String SQL_UPDATE = "update usuario set  usuario=?, password=? where id_usuario=? ";
    private final String SQL_DELETE = "delete from usuario where id_usuario=? ";
    private final String SQL_SELECT = "select id_usuario, usuario, password from usuario order by id_usuario ";
    
    public int insertar (String usuario, String password)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, usuario);
            stmt.setString(index++, password);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados ="+rows);
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            Conexion.close(stmt);
            Conexion.close(conn);
        }//finally
        
        return rows;
    }//insertar
    
    public int update (int id_usuario, String usuario, String password)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;//devuelve el nùmero de registros afectados
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, usuario);
            stmt.setString(index++,password);
            stmt.setInt(index, id_usuario);
            rows = stmt.executeUpdate();
            
            System.out.println("Registros afectados ="+ rows);
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }//
        finally
        {
            Conexion.close(stmt);
            Conexion.close(conn);
        }//finllay
        
        return rows;
    }//update
    
    public int delete (int id_usuario)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_usuario);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados = "+rows);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }//catch
        finally
        {
            Conexion.close(stmt);
            Conexion.close(conn);
        }//finally
        return rows;
    }//delete
    
    public List<Usuario> select ()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //creo el array list que debo devolver
        List<Usuario> usuarios = new ArrayList<>();
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuarios.add(usuario);//agrego el obj usuario al arrya de usuarios
            }//while
            
            
            
        }//
        catch(SQLException e)
        {
            e.printStackTrace();
        }//catch
        finally
        {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }//finally
        
        return usuarios;
    }//select
    
    
}//UsuariosJDBC
