
package domain;


public class Usuario
{
    private int id_usuario;
    private String usuario;
    private String password;
    
    //getters and setters
    
    private int get_Idsusuario()
    {
        return id_usuario;
    }//
    
    public void setIdusuario(int id_usuario)
    {
     this.id_usuario = id_usuario;
    }//
    
    public String getUsuario()
    {
        return usuario;
    }//
    
    public void setUsuario(String usuario)
    {
     this.usuario = usuario;
    }//
    
    public String getPassword()
    {
        return password;
    }//
    
    public void setPassword(String password)
    {
        this.password = password;
    }//
    
    @Override
    public String toString()
    {
        return "Registro Usuario , Id_usuario: "+id_usuario+" usuario: "+usuario+
                " password :"+password;
    }//toString
}//usuario
