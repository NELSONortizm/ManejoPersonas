
package udemy3_manejopersonas2;
import datos.Conexion;
import datos.UsuariosJDBC;
import domain.Usuario;
import java.sql.*;
import java.util.*;

public class ManejoUsuarios
{
    public static void main (String arg [])
    {
        UsuariosJDBC usuariosjdbc = new UsuariosJDBC();
        //insertar
        usuariosjdbc.insertar("USUARIO 5", "owiewoewioewi");
        //update
        //usuariosjdbc.update(2, "NELSON geovanny", "KARO");
        //delete
       // usuariosjdbc.delete(1);
       List<Usuario> usuarios = new ArrayList<>();
       usuarios = usuariosjdbc.select();
       
       for (Usuario usuario : usuarios)
       {
           System.out.println(usuario);
       }//for
        
    }//main
}//ManejoPersonas
