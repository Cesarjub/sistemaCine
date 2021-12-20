package Cine;

public class GetSetFunciones 
{
    private int id, pelicula, sala, audio;
    private String dia, hora;
    
    public GetSetFunciones()
    {
        id = 0;
        pelicula = 0;
        sala = 0;
        audio = 0;
        dia = "";
        hora = "";
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    public int getId() 
    {
        return id;
    }

    public void setPelicula(int pelicula) 
    {
        this.pelicula = pelicula;
    }
    public int getPelicula() 
    {
        return pelicula;
    }

    public void setAudio(int audio) 
    {
        this.audio = audio;
    }
    public int getAudio() 
    {
        return audio;
    }

    public void setSala(int sala) 
    {
        this.sala = sala;
    }
    public int getSala() 
    {
        return sala;
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
