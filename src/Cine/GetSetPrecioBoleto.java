package Cine;

public class GetSetPrecioBoleto 
{
    private float precioNino, precioAdulto, precioAnciano;
    
    public GetSetPrecioBoleto()
    {
        precioNino = 0.0f;
        precioAdulto = 0.0f;
        precioAnciano = 0.0f;
    }

    public void setPrecioNino(float precioNino) 
    {
        this.precioNino = precioNino;
    }
    public float getPrecioNino() 
    {
        return precioNino;
    }

    public void setPrecioAdulto(float precioAdulto) 
    {
        this.precioAdulto = precioAdulto;
    }
    public float getPrecioAdulto() 
    {
        return precioAdulto;
    }

    public void setPrecioAnciano(float precioAnciano) 
    {
        this.precioAnciano = precioAnciano;
    }
    public float getPrecioAnciano() 
    {
        return precioAnciano;
    }    
}
