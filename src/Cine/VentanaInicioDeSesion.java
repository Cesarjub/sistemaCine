package Cine;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaInicioDeSesion extends javax.swing.JFrame {

    public VentanaInicioDeSesion() 
    {
        initComponents();
        
        //
        this.setLocationRelativeTo(null);
        
        //
        AWTUtilities.setWindowOpaque(this, false);       
        
        cnbd = new ConsultasBD();
        
        ic = new ImageIcon("src/Imagenes/fondoAzul2.jpg");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelImg1.getWidth(), labelImg1.getHeight(), Image.SCALE_DEFAULT));        
          
        labelImg1.setIcon(icn);
        
        labelImg1.repaint();
        
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

        usuarioLogin = new javax.swing.JTextField();
        botonEntrar = new javax.swing.JButton();
        claveLogin = new javax.swing.JPasswordField();
        labelImagen = new javax.swing.JLabel();
        BotonSalir = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        labelCandado = new javax.swing.JLabel();
        labelImg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(usuarioLogin);
        usuarioLogin.setBounds(110, 110, 190, 30);

        botonEntrar.setBackground(new java.awt.Color(0, 102, 0));
        botonEntrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        botonEntrar.setText("Entrar");
        botonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEntrarMouseClicked(evt);
            }
        });
        getContentPane().add(botonEntrar);
        botonEntrar.setBounds(130, 210, 70, 23);
        getContentPane().add(claveLogin);
        claveLogin.setBounds(110, 160, 190, 30);

        labelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/idCard.png"))); // NOI18N
        getContentPane().add(labelImagen);
        labelImagen.setBounds(0, 10, 390, 80);

        BotonSalir.setBackground(new java.awt.Color(102, 0, 0));
        BotonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalir.setText("Salir");
        BotonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonSalirMouseClicked(evt);
            }
        });
        getContentPane().add(BotonSalir);
        BotonSalir.setBounds(210, 210, 70, 23);

        labelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        getContentPane().add(labelUsuario);
        labelUsuario.setBounds(80, 110, 24, 30);

        labelCandado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/candado.png"))); // NOI18N
        getContentPane().add(labelCandado);
        labelCandado.setBounds(80, 160, 20, 24);
        getContentPane().add(labelImg1);
        labelImg1.setBounds(0, 0, 400, 270);

        setBounds(0, 0, 393, 262);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BotonSalirMouseClicked

    private void botonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseClicked
        
        GetSetEmpleados gse = new GetSetEmpleados();
        
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String clave = new String(claveLogin.getPassword());
        
        if(!usuarioLogin.getText().equals("") && !clave.equals(""))
        {
            gse.setUsuario(usuarioLogin.getText());
            gse.setClave(clave);
            gse.setUltimoAcceso(formato.format(fecha));
            
            if(cnbd.getComprobarLogin(gse))
            {
                VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
                VentanaPrincipalCajero vpb = new VentanaPrincipalCajero(gse);
                
                if(gse.getCargo() == 1)
                {
                    this.dispose();
                    vpa.setVisible(true);   
                }
                else if(gse.getCargo() == 2)
                {
                    this.dispose();
                    vpb.setVisible(true);
                }
            }
            else
                JOptionPane.showMessageDialog(null,"Los datos son incorrectos","Inciar sesion", 0);
        }
        else
            JOptionPane.showMessageDialog(null,"Los campos estan vacios","Inciar sesion", 2);
        
    }//GEN-LAST:event_botonEntrarMouseClicked


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
            java.util.logging.Logger.getLogger(VentanaInicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicioDeSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton botonEntrar;
    private javax.swing.JPasswordField claveLogin;
    private javax.swing.JLabel labelCandado;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelImg1;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField usuarioLogin;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;
    private ConsultasBD cnbd;
}
