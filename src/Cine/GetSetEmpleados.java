package Cine;

public class GetSetEmpleados 
{
    private int id, cargo;
    private String nombre, apellido, usuario, clave, fechaIngreso, ultimoAcceso, nombreCargo;
    
    public GetSetEmpleados()
    {
        id = 0;
        nombre = "";
        apellido = "";
        cargo = 0;
        usuario = "";
        clave = "";
        fechaIngreso = "";
        ultimoAcceso = "";
        nombreCargo = "";
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    public int getId() 
    {
        return id;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    public String getNombre() 
    {
        return nombre;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }
    public String getApellido() 
    {
        return apellido;
    }

    public void setCargo(int cargo) 
    {
        this.cargo = cargo;
    }
    public int getCargo() 
    {
        return cargo;
    }    

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }    
    public String getUsuario() 
    {
        return usuario;
    }
    
    public void setClave(String clave) 
    {
        this.clave = clave;
    }
    public String getClave() 
    {
        return clave;
    }

    public void setFechaIngreso(String fechaIngreso) 
    {
        this.fechaIngreso = fechaIngreso;
    }
    public String getFechaIngreso() 
    {
        return fechaIngreso;
    }

    public void setUltimoAcceso(String ultimoAcceso) 
    {
        this.ultimoAcceso = ultimoAcceso;
    }
    public String getUltimoAcceso() 
    {
        return ultimoAcceso;
    } 

    public void setNombreCargo(String nombreCargo) 
    {
        this.nombreCargo = nombreCargo;
    }    
    public String getNombreCargo() 
    {
        return nombreCargo;
    }  
}
