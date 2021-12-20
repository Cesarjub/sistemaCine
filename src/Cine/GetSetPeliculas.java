package Cine;

import java.io.File;

public class GetSetPeliculas 
{
    private int id, ano, duracion, clasificacion;
    private String titulo, sinopsis;
    private File poster;
    
    public GetSetPeliculas()
    {
        id = 0;
        ano = 0;
        duracion = 0;
        clasificacion = 0;        
        titulo = "";
        sinopsis = "";
        poster = null;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    public int getId() 
    {
        return id;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }
    public String getTitulo() 
    {
        return titulo;
    }

    public void setAno(int ano) 
    {
        this.ano = ano;
    }
    public int getAno() 
    {
        return ano;
    }

    public void setDuracion(int duracion) 
    {
        this.duracion = duracion;
    }
    public int getDuracion() 
    {
        return duracion;
    }

    public void setClasificacion(int clasificacion) 
    {
        this.clasificacion = clasificacion;
    }
    public int getClasificacion() 
    {
        return clasificacion;
    }

    public void setSinopsis(String sinopsis) 
    {
        this.sinopsis = sinopsis;
    }
    public String getSinopsis() 
    {
        return sinopsis;
    }   

    public void setPoster(File poster) 
    {
        this.poster = poster;
    }
    public File getPoster() 
    {
        return poster;
    } 
}
