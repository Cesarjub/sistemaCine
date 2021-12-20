package Cine;

public class GetSetSala 
{
    private int id, numero, tipo, capacidad;
    
    public GetSetSala()
    {
        id = 0;
        numero = 0;
        tipo = 0;
        capacidad = 0;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    public int getId() 
    {
        return id;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }
    public int getNumero() 
    {
        return numero;
    }

    public void setCapacidad(int capacidad) 
    {
        this.capacidad = capacidad;
    }    
    public int getCapacidad() 
    {
        return capacidad;
    }

    public void setTipo(int tipo) 
    {
        this.tipo = tipo;
    }
    public int getTipo() 
    {
        return tipo;
    }
}
