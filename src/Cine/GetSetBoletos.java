package Cine;

public class GetSetBoletos 
{
    private int idBl, cantBl, idCl, numSala;    
    private String nombrePelicula, nombreCl, vendedor, fechaCmp, asientos, dia, hora;
    private float totalBl;
    
    public GetSetBoletos()
    {
        idBl = 0;
        idCl = 0;  
        cantBl = 0;
        numSala = 0;
        nombrePelicula = "";
        nombreCl = "";
        vendedor = "";
        fechaCmp = "";
        asientos = "";
        dia = "";
        hora = "";
        totalBl = 0.0f;
    }

    public void setIdBl(int idBl) 
    {
        this.idBl = idBl;
    }
    public int getIdBl() 
    {
        return idBl;
    }

    public void setIdCl(int idCl) 
    {
        this.idCl = idCl;
    }
    public int getIdCl() 
    {
        return idCl;
    }

    public void setNombrePelicula(String nombrePelicula) 
    {
        this.nombrePelicula = nombrePelicula;
    }
    public String getNombrePelicula() 
    {
        return nombrePelicula;
    }
    
    public void setVendedor(String vendedor) 
    {
        this.vendedor = vendedor;
    }
    public String getVendedor() 
    {
        return vendedor;
    }

    public void setNombreCl(String nombreCl) 
    {
        this.nombreCl = nombreCl;
    }
    public String getNombreCl() 
    {
        return nombreCl;
    }

    public void setFechaCmp(String fechaCmp) 
    {
        this.fechaCmp = fechaCmp;
    }
    public String getFechaCmp() 
    {
        return fechaCmp;
    }

    public void setCantBl(int cantBl) 
    {
        this.cantBl = cantBl;
    }
    public int getCantBl() 
    {
        return cantBl;
    }

    public void setAsientos(String asientos) 
    {
        this.asientos = asientos;
    }
    public String getAsientos() 
    {
        return asientos;
    }

    public void setTotalBl(float totalBl) 
    {
        this.totalBl = totalBl;
    }
    public float getTotalBl() 
    {
        return totalBl;
    }

    public void setNumSala(int numSala) 
    {
        this.numSala = numSala;
    }
    public int getNumSala() 
    {
        return numSala;
    }

    public void setDia(String dia) 
    {
        this.dia = dia;
    }
    public String getDia() 
    {
        return dia;
    }

    public void setHora(String hora) 
    {
        this.hora = hora;
    }
    public String getHora() 
    {
        return hora;
    
    }
}
