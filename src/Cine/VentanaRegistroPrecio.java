package Cine;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaRegistroPrecio extends javax.swing.JFrame {

    public VentanaRegistroPrecio() 
    {
        initComponents();
    }
    
    public VentanaRegistroPrecio(GetSetEmpleados gse)
    {
        initComponents();

        this.gse = gse;
        
        //
        this.setLocationRelativeTo(null);
        
        cnbd = new ConsultasBD();
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
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
    
    public void setLimpiarFormulario()
    {
        precioNino.setText(null);
        precioAdulto.setText(null);
        precioAnciano.setText(null);
        
        errorNino.setText(null);
        errorAdulto.setText(null);
        errorAnciano.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        precioNino = new javax.swing.JTextField();
        precioAdulto = new javax.swing.JTextField();
        precioAnciano = new javax.swing.JTextField();
        errorNino = new javax.swing.JLabel();
        errorAdulto = new javax.swing.JLabel();
        errorAnciano = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar precios");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro de precios");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 0, 220, 40);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(370, 0, 40, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 450, 40);

        jPanel3.setBackground(new java.awt.Color(0, 32, 86));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 300, 450, 30);

        botonGuardar.setBackground(new java.awt.Color(51, 51, 51));
        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("Guardar");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(botonGuardar);
        botonGuardar.setBounds(190, 250, 90, 23);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Niños:  $");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 80, 60, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Adultos:  $");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 130, 80, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("3era Edad:  $");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 180, 90, 30);

        precioNino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioNinoKeyTyped(evt);
            }
        });
        jPanel1.add(precioNino);
        precioNino.setBounds(180, 80, 110, 30);

        precioAdulto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioAdultoKeyTyped(evt);
            }
        });
        jPanel1.add(precioAdulto);
        precioAdulto.setBounds(180, 130, 110, 30);

        precioAnciano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioAncianoKeyTyped(evt);
            }
        });
        jPanel1.add(precioAnciano);
        precioAnciano.setBounds(180, 180, 110, 30);

        errorNino.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorNino.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorNino);
        errorNino.setBounds(180, 110, 130, 20);

        errorAdulto.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorAdulto.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorAdulto);
        errorAdulto.setBounds(180, 160, 130, 20);

        errorAnciano.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorAnciano.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorAnciano);
        errorAnciano.setBounds(180, 210, 130, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 440, 330);

        jMenu1.setText("File");

        menuLimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        menuLimpiar.setText("Limpiar");
        menuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLimpiarActionPerformed(evt);
            }
        });
        jMenu1.add(menuLimpiar);

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

        setBounds(0, 0, 439, 369);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        GetSetPrecioBoleto gspb = new GetSetPrecioBoleto();

        if (precioNino.getText().length() == 0)
            errorNino.setText("*El precio es incorrecto"); 
        else
            errorNino.setText(null);
        
        if (precioAdulto.getText().length() == 0)
            errorAdulto.setText("*El precio es incorrecto"); 
        else
            errorAdulto.setText(null); 
        
        if (precioAnciano.getText().length() == 0)
            errorAnciano.setText("*El precio es incorrecto"); 
        else
            errorAnciano.setText(null);  
        
        if(!precioNino.getText().equals("") && !precioAdulto.getText().equals("") && !precioAnciano.getText().equals(""))
        {
            String consulta = "SELECT COUNT(ID_TBLT) FROM tipo_boleto WHERE ID_TBLT = 1";
            
            if(cnbd.getBuscar(consulta) == 0)
            {            
                gspb.setPrecioNino(Float.parseFloat(precioNino.getText()));
                gspb.setPrecioAdulto(Float.parseFloat(precioAdulto.getText()));
                gspb.setPrecioAnciano(Float.parseFloat(precioAnciano.getText()));
            
                if(cnbd.getRegistrarPrecioBoleto(gspb))
                {
                    JOptionPane.showMessageDialog(null,"Los precios han sido guardado","Precios agregados", 1); 
                    setLimpiarFormulario();                
                }
                else
                    JOptionPane.showMessageDialog(null,"No se han podido guardar los datos","Registrar precios", 2); 
            }
            else
                JOptionPane.showMessageDialog(null,"Los precios ya han sido registrados","Precios ya registrados", 2);            
        }
        else
           JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos","Registrar precios", 2);  
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vpa.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        this.setLimpiarFormulario();
    }//GEN-LAST:event_menuLimpiarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void precioNinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioNinoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && precioNino.getText().contains("."))
        evt.consume();
        
        if (precioNino.getText().length() == 0)
            errorNino.setText("*El precio es incorrecto"); 
        else
            errorNino.setText(null); 
    }//GEN-LAST:event_precioNinoKeyTyped

    private void precioAdultoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioAdultoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && precioAdulto.getText().contains("."))
        evt.consume();
        
        if (precioAdulto.getText().length() == 0)
            errorAdulto.setText("*El precio es incorrecto"); 
        else
            errorAdulto.setText(null); 
    }//GEN-LAST:event_precioAdultoKeyTyped

    private void precioAncianoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioAncianoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && precioAnciano.getText().contains("."))
        evt.consume();
        
        if (precioAnciano.getText().length() == 0)
            errorAnciano.setText("*El precio es incorrecto"); 
        else
            errorAnciano.setText(null); 
    }//GEN-LAST:event_precioAncianoKeyTyped

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
            java.util.logging.Logger.getLogger(VentanaRegistroPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroPrecio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel errorAdulto;
    private javax.swing.JLabel errorAnciano;
    private javax.swing.JLabel errorNino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTextField precioAdulto;
    private javax.swing.JTextField precioAnciano;
    private javax.swing.JTextField precioNino;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;   
    private GetSetEmpleados gse;
    private ConsultasBD cnbd;
}
