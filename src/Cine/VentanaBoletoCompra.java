package Cine;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class VentanaBoletoCompra extends javax.swing.JFrame {

    public VentanaBoletoCompra() 
    {
        initComponents();
    }    
    
    public VentanaBoletoCompra(GetSetEmpleados gse, float cambio, int idBl) 
    {
        this.gse = gse;
        this.idBl = idBl;
        
        initComponents();
        
        //
        this.setLocationRelativeTo(null);         

        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint();              
        
        cambioCompra.setText("Su cambio es $ " + cambio);
        
        this.setPanel();
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }              
    }

    
    public void setPanel()
    {
        try 
        {
            ConexionBD cnbd = new ConexionBD(); 
    
            //archivo jasper
            JasperReport reporte = null;
            
            String path = "src\\Reportes\\CompraBoleto.jasper";
            
            Map parametro = new HashMap();
            
            parametro.put("idBoleto", idBl);
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
   
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, parametro, cnbd.getConectar());
   
            //se crea el visor con el reporte
            JRViewer jRViewer = new JRViewer(jasperPrint);  
   
            //se elimina elementos del contenedor JPanel
            visualizarReporte.removeAll();
   
            //para el tamaño de l reporte se agrega un BorderLayout
            visualizarReporte.setLayout(new BorderLayout());        
            visualizarReporte.add(jRViewer, BorderLayout.CENTER);

//            jRViewer.setFitWidthZoomRatio();
   
            jRViewer.setVisible(true);
   
            visualizarReporte.repaint();
            visualizarReporte.revalidate();
        } 
        catch (JRException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Reporte en ventana", 2);
        }       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        visualizarReporte = new javax.swing.JPanel();
        botonGenerarBoleto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cambioCompra = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abrir boleto");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ticket");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 0, 160, 40);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(630, 0, 40, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        visualizarReporte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout visualizarReporteLayout = new javax.swing.GroupLayout(visualizarReporte);
        visualizarReporte.setLayout(visualizarReporteLayout);
        visualizarReporteLayout.setHorizontalGroup(
            visualizarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        visualizarReporteLayout.setVerticalGroup(
            visualizarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jPanel1.add(visualizarReporte);
        visualizarReporte.setBounds(20, 20, 330, 330);

        botonGenerarBoleto.setBackground(new java.awt.Color(51, 51, 51));
        botonGenerarBoleto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonGenerarBoleto.setForeground(new java.awt.Color(255, 255, 255));
        botonGenerarBoleto.setText("Ver boleto");
        botonGenerarBoleto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGenerarBoleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGenerarBoletoMouseClicked(evt);
            }
        });
        jPanel1.add(botonGenerarBoleto);
        botonGenerarBoleto.setBounds(380, 240, 120, 23);

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Inicio");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(540, 240, 120, 23);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Se ha realizado la compra!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(370, 100, 300, 30);

        jPanel4.setBackground(new java.awt.Color(0, 32, 86));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(-10, 370, 710, 40);

        cambioCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cambioCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(cambioCompra);
        cambioCompra.setBounds(400, 140, 240, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 710, 400);

        jMenu1.setText("File");

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        menuInicio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        menuInicio.setText("Inicio");
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });
        jMenu2.add(menuInicio);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 705, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarBoletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarBoletoMouseClicked
        try 
        {
           ConexionBD cnbd = new ConexionBD(); 
            
            JasperReport reporte = null;
            
            String path = "src\\Reportes\\CompraBoleto.jasper";
            
            Map parametro = new HashMap();
            
            parametro.put("idBoleto", idBl);
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jPrint = JasperFillManager.fillReport(path, parametro, cnbd.getConectar());
            
            JasperViewer view = new JasperViewer(jPrint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
        } 
        catch (JRException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Reporte generado", 2);
        }
    }//GEN-LAST:event_botonGenerarBoletoMouseClicked

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalCajero vpc = new VentanaPrincipalCajero(gse);
        
        vpc.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_menuInicioActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        VentanaPrincipalCajero vpc = new VentanaPrincipalCajero(gse);
        
        vpc.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked


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
            java.util.logging.Logger.getLogger(VentanaBoletoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBoletoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBoletoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBoletoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBoletoCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerarBoleto;
    private javax.swing.JLabel cambioCompra;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel visualizarReporte;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn; 
    private GetSetEmpleados gse;
    private int idBl;
}
