package Cine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MostrarImagen extends javax.swing.JPanel
{
    private String ruta;     
    
    public MostrarImagen(int x, int y, String ruta)
    {
        this.ruta = ruta;
        
        this.setSize(x, y);
    }
    
    public void paint(Graphics g)
    {
        Dimension height = getSize();
        Image img = new ImageIcon(ruta).getImage();
        
        g.drawImage(img, 0, 0, height.width, height.height, null);
        
        setOpaque(false);
        
        super.paintComponent(g);
    }
}
