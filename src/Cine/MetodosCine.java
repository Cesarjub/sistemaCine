package Cine;

public class MetodosCine 
{
    public MetodosCine()
    {}
    
    public int getObtenerMenos(String text)
    {
        return (Integer.parseInt(text) - 1);
    }
    
    public int getObtenerMas(String text)
    {
        return (Integer.parseInt(text) + 1);    
    }
    
    public int getTotalAsientos(int nino, int adulto, int anciano)
    {
        return (nino + adulto + anciano);
    }
    
    public float getObtenerTotalNinos(String precio, String cantidad)
    {
        return (Float.parseFloat(precio) * Integer.parseInt(cantidad));
    }
    
    public float getObtenerTotalAdultos(String precio, String cantidad)
    {
        return (Float.parseFloat(precio) * Integer.parseInt(cantidad));
    }
    
    public float getObtenerTotalAnciano(String precio, String cantidad)
    {
        return (Float.parseFloat(precio) * Integer.parseInt(cantidad));
    }    
    
    public float getObtenerTotal(float nino, float adulto, float anciano)
    {
        return (nino + adulto + anciano);
    }
    
    public float getObtenerCambio(float pago, float cambio)
    {
        return (pago - cambio);
    }
}
