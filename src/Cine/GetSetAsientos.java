package Cine;

public class GetSetAsientos 
{
    private int idFuncion, numAsiento, idCl;
    
    public GetSetAsientos()
    {
        numAsiento = 0;
        idFuncion = 0;
        idCl = 0;
    }

    public void setNumAsiento(int numAsiento) 
    {
        this.numAsiento = numAsiento;
    }
    public int getNumAsiento() 
    {
        return numAsiento;
    }

    public void setIdCl(int idCl) 
    {
        this.idCl = idCl;
    }
    public int getIdCl() 
    {
        return idCl;
    }
   
    public void setIdFuncion(int idFuncion) 
    {
        this.idFuncion = idFuncion;
    }
    public int getIdFuncion() 
    {
        return idFuncion;
    } 
}
