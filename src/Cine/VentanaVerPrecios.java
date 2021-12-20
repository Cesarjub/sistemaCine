package Cine;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class VentanaVerPrecios extends javax.swing.JFrame {

    public VentanaVerPrecios() 
    {
        initComponents();
    }
    
    public VentanaVerPrecios(GetSetEmpleados gse) 
    {
        initComponents();

        this.gse = gse;
        
        cnbd = new ConsultasBD();
        
        //
        this.setLocationRelativeTo(null); 

        setPreciosBoletos();
        
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        editNino.setVisible(false);
        editAdulto.setVisible(false);
        editAnciano.setVisible(false);
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }
    
    public void setPreciosBoletos()
    {
        ArrayList<String> lista = new ArrayList <String>();  
        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM TIPO_BOLETO");
               
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Precio_TBLT"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Precios", 2);
        }    
        
        precioNino.setText(lista.get(0));
        precioAdulto.setText(lista.get(1));
        precioAnciano.setText(lista.get(2));
    }
    
    public void setOcultarComponentes()
    {
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        precioNino.setVisible(true);
        precioAdulto.setVisible(true);
        precioAnciano.setVisible(true);
        
        editNino.setVisible(false);
        editAdulto.setVisible(false);
        editAnciano.setVisible(false);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelMostrarPrecios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        precioNino = new javax.swing.JLabel();
        precioAdulto = new javax.swing.JLabel();
        precioAnciano = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        editarPrecio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idNino = new javax.swing.JLabel();
        idAdulto = new javax.swing.JLabel();
        idAnciano = new javax.swing.JLabel();
        editNino = new javax.swing.JTextField();
        editAdulto = new javax.swing.JTextField();
        editAnciano = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ver precios de boletos");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precios de boletos");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 380, 22);

        panelMostrarPrecios.setBackground(new java.awt.Color(255, 255, 255));
        panelMostrarPrecios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelMostrarPrecios.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Niños:  $");
        panelMostrarPrecios.add(jLabel1);
        jLabel1.setBounds(120, 50, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Adultos:  $");
        panelMostrarPrecios.add(jLabel2);
        jLabel2.setBounds(120, 100, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("3era Edad:  $");
        panelMostrarPrecios.add(jLabel4);
        jLabel4.setBounds(100, 150, 110, 30);

        precioNino.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        panelMostrarPrecios.add(precioNino);
        precioNino.setBounds(230, 50, 60, 30);

        precioAdulto.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        panelMostrarPrecios.add(precioAdulto);
        precioAdulto.setBounds(230, 100, 60, 30);

        precioAnciano.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        panelMostrarPrecios.add(precioAnciano);
        precioAnciano.setBounds(230, 150, 60, 30);

        botonGuardar.setBackground(new java.awt.Color(0, 102, 51));
        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("Guardar");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });
        panelMostrarPrecios.add(botonGuardar);
        botonGuardar.setBounds(230, 210, 90, 23);

        editarPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pencil.png"))); // NOI18N
        editarPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarPrecioMouseClicked(evt);
            }
        });
        panelMostrarPrecios.add(editarPrecio);
        editarPrecio.setBounds(330, 10, 30, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tickets.png"))); // NOI18N
        panelMostrarPrecios.add(jLabel5);
        jLabel5.setBounds(30, 70, 70, 70);

        idNino.setForeground(new java.awt.Color(255, 255, 255));
        idNino.setText("1");
        panelMostrarPrecios.add(idNino);
        idNino.setBounds(20, 20, 20, 30);

        idAdulto.setForeground(new java.awt.Color(255, 255, 255));
        idAdulto.setText("2");
        panelMostrarPrecios.add(idAdulto);
        idAdulto.setBounds(40, 20, 20, 30);

        idAnciano.setForeground(new java.awt.Color(255, 255, 255));
        idAnciano.setText("3");
        panelMostrarPrecios.add(idAnciano);
        idAnciano.setBounds(60, 20, 20, 30);

        editNino.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        editNino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editNinoKeyTyped(evt);
            }
        });
        panelMostrarPrecios.add(editNino);
        editNino.setBounds(230, 50, 60, 30);

        editAdulto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editAdultoKeyTyped(evt);
            }
        });
        panelMostrarPrecios.add(editAdulto);
        editAdulto.setBounds(230, 100, 60, 30);

        editAnciano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editAncianoKeyTyped(evt);
            }
        });
        panelMostrarPrecios.add(editAnciano);
        editAnciano.setBounds(230, 150, 60, 30);

        botonCancelar.setBackground(new java.awt.Color(153, 0, 0));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });
        panelMostrarPrecios.add(botonCancelar);
        botonCancelar.setBounds(70, 210, 90, 23);

        jPanel1.add(panelMostrarPrecios);
        panelMostrarPrecios.setBounds(10, 40, 380, 250);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 320);

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

        setBounds(0, 0, 407, 358);
    }// </editor-fold>//GEN-END:initComponents

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vpa.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void editarPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarPrecioMouseClicked
        
        botonGuardar.setVisible(true);
        botonCancelar.setVisible(true);
        
        precioNino.setVisible(false);
        precioAdulto.setVisible(false);
        precioAnciano.setVisible(false);
        
        editNino.setVisible(true);
        editAdulto.setVisible(true);
        editAnciano.setVisible(true);
        
        editNino.setText(precioNino.getText());
        editAdulto.setText(precioAdulto.getText());
        editAnciano.setText(precioAnciano.getText());
    }//GEN-LAST:event_editarPrecioMouseClicked

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        this.setOcultarComponentes();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void editNinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editNinoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && editNino.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_editNinoKeyTyped

    private void editAdultoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editAdultoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && editAdulto.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_editAdultoKeyTyped

    private void editAncianoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editAncianoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && editAnciano.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_editAncianoKeyTyped

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked

        if(!editNino.getText().equals("") && !editAdulto.getText().equals("") && !editAnciano.getText().equals(""))
        {      
            GetSetPrecioBoleto gspb = new GetSetPrecioBoleto();
            
            gspb.setPrecioNino(Float.parseFloat(editNino.getText()));
            gspb.setPrecioAdulto(Float.parseFloat(editAdulto.getText()));
            gspb.setPrecioAnciano(Float.parseFloat(editAnciano.getText()));
            
            if(cnbd.getModificarPrecios(gspb))
            {
                this.setOcultarComponentes();
        
                this.setPreciosBoletos();
                
                JOptionPane.showMessageDialog(null,"Los precios han sido modificados","Precios modificados", 1); 
            }     
            else
              JOptionPane.showMessageDialog(null,"No se han podido modificar los datos","Modificar precios", 2);   
        }
        else
           JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos","Modificar precios", 2); 
    }//GEN-LAST:event_botonGuardarMouseClicked


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
            java.util.logging.Logger.getLogger(VentanaVerPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVerPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVerPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVerPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVerPrecios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField editAdulto;
    private javax.swing.JTextField editAnciano;
    private javax.swing.JTextField editNino;
    private javax.swing.JLabel editarPrecio;
    private javax.swing.JLabel idAdulto;
    private javax.swing.JLabel idAnciano;
    private javax.swing.JLabel idNino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelMostrarPrecios;
    private javax.swing.JLabel precioAdulto;
    private javax.swing.JLabel precioAnciano;
    private javax.swing.JLabel precioNino;
    // End of variables declaration//GEN-END:variables
    private GetSetEmpleados gse;    
    private ConsultasBD cnbd;
}
