package Cine;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class VentanaDeCarga extends javax.swing.JFrame {

    public VentanaDeCarga() 
    {
        initComponents();
        
        //
        this.setLocationRelativeTo(null); 
        
        //
        AWTUtilities.setWindowOpaque(this, false);        
        
        al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                x += 1;
                
                //
                barraDeProgreso.setValue(x);   
                
                //
                if(barraDeProgreso.getValue() == 1)
                {
                    mostrarCarga.setText("Iniciando componentes");
                    ConexionBD a = new ConexionBD();
                }                    
                if(barraDeProgreso.getValue() == 20)
                {
                    mostrarCarga.setText("Conectando");
                }
                if(barraDeProgreso.getValue() == 45)
                {
                    mostrarCarga.setText("Cargando recursos");
                }                
                if(barraDeProgreso.getValue() == 65)
                {
                    mostrarCarga.setText("Inciando proyecto");
                }                    
                if(barraDeProgreso.getValue() == 80)
                {
                    mostrarCarga.setText("Abriendo proyecto");
                }                                 
                if(barraDeProgreso.getValue() == 100)
                {
                    dispose();
                    VentanaInicioDeSesion vis = new VentanaInicioDeSesion();
                    vis.setVisible(true);
                    tm.stop();
                }
            }
        };
        
        //
        tm = new Timer(10, al); //80
        
        // 
        tm.start();        
        
        ic = new ImageIcon("src/Imagenes/palomita.png");
        ic2 = new ImageIcon("src/Imagenes/fondoAzul1.png");    
        ic3 = new ImageIcon("src/Imagenes/claquetaDeCinePrincipal.png");           
        
        icn1 = new ImageIcon(ic.getImage().getScaledInstance(labelImg1.getWidth(), labelImg1.getHeight(), Image.SCALE_DEFAULT));
        icn2 = new ImageIcon(ic.getImage().getScaledInstance(labelImg2.getWidth(), labelImg2.getHeight(), Image.SCALE_DEFAULT));        
        icn3 = new ImageIcon(ic.getImage().getScaledInstance(labelImg3.getWidth(), labelImg3.getHeight(), Image.SCALE_DEFAULT));      
        icn4 = new ImageIcon(ic.getImage().getScaledInstance(labelImg4.getWidth(), labelImg4.getHeight(), Image.SCALE_DEFAULT));         
        icn5 = new ImageIcon(ic.getImage().getScaledInstance(labelImg5.getWidth(), labelImg5.getHeight(), Image.SCALE_DEFAULT)); 
        icn6 = new ImageIcon(ic2.getImage().getScaledInstance(labelImg6.getWidth(), labelImg6.getHeight(), Image.SCALE_DEFAULT));    
        icn7 = new ImageIcon(ic3.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));  
        
        labelImg1.setIcon(icn1);
        labelImg2.setIcon(icn2);
        labelImg3.setIcon(icn3);        
        labelImg4.setIcon(icn4);  
        labelImg5.setIcon(icn5);   
        labelImg6.setIcon(icn6);
        labelLogo.setIcon(icn7);        
        
        labelImg1.repaint();
        labelImg2.repaint();
        labelImg3.repaint(); 
        labelImg4.repaint(); 
        labelImg5.repaint();
        labelImg6.repaint();
        labelLogo.repaint();        
    
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImg1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        barraDeProgreso = new javax.swing.JProgressBar();
        mostrarCarga = new javax.swing.JLabel();
        labelImg4 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelImg6 = new javax.swing.JLabel();
        labelImg3 = new javax.swing.JLabel();
        labelImg2 = new javax.swing.JLabel();
        labelImg5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(labelImg1);
        labelImg1.setBounds(110, 260, 50, 50);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jPanel1.setLayout(null);

        barraDeProgreso.setBorderPainted(false);
        jPanel1.add(barraDeProgreso);
        barraDeProgreso.setBounds(0, 150, 390, 14);

        mostrarCarga.setFont(new java.awt.Font("Arial Nova Light", 1, 12)); // NOI18N
        mostrarCarga.setForeground(new java.awt.Color(255, 255, 255));
        mostrarCarga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(mostrarCarga);
        mostrarCarga.setBounds(70, 170, 240, 20);
        jPanel1.add(labelImg4);
        labelImg4.setBounds(30, 200, 30, 30);

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelLogo);
        labelLogo.setBounds(140, 30, 90, 100);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cesar JB");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 200, 60, 20);
        jPanel1.add(labelImg6);
        labelImg6.setBounds(0, 0, 370, 220);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(120, 80, 370, 220);
        getContentPane().add(labelImg3);
        labelImg3.setBounds(80, 280, 50, 50);
        getContentPane().add(labelImg2);
        labelImg2.setBounds(120, 290, 40, 40);
        getContentPane().add(labelImg5);
        labelImg5.setBounds(140, 280, 50, 50);

        setBounds(0, 0, 611, 350);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDeCarga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeProgreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImg1;
    private javax.swing.JLabel labelImg2;
    private javax.swing.JLabel labelImg3;
    private javax.swing.JLabel labelImg4;
    private javax.swing.JLabel labelImg5;
    private javax.swing.JLabel labelImg6;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel mostrarCarga;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic, ic2, ic3;
    private Icon icn1, icn2, icn3, icn4, icn5, icn6, icn7;
    private Timer tm;
    private ActionListener al;
    private int x;    
}
