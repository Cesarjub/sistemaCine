package Cine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CargarImagen extends javax.swing.JPanel
{
    private BufferedImage ruta;     
    
    public CargarImagen(int x, int y, BufferedImage ruta)
    {
        this.ruta = ruta;
        
        this.setSize(x, y);
    }
    
    public void paint(Graphics g)
    {
        Dimension height = getSize();
        BufferedImage bi = ruta;
        
        g.drawImage(bi, 0, 0, height.width, height.height, null);
        
        setOpaque(false);
        
        super.paintComponent(g);
    }
}
