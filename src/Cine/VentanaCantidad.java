package Cine;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaCantidad extends javax.swing.JFrame {

    public VentanaCantidad() 
    {
        initComponents();
    }
    
    public VentanaCantidad(GetSetEmpleados gse, int idPl, int idFn)
    {
        initComponents();
        
        this.gse = gse;
        this.idPl = idPl;
        this.idFn = idFn;
        
        lista = new ArrayList <String>();   
        
        cnbd = new ConsultasBD();
        
        //
        this.setLocationRelativeTo(null);          
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint();        
        
        mc = new MetodosCine();
        
        cantidadNino.setEditable(false);
        cantidadAdulto.setEditable(false);
        cantidadAnciano.setEditable(false);
        
        this.setInfoClasificacion();
        this.setPrecioBoletos();
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }

    public void setInfoClasificacion()
    {
        String info = "";
        int idCfc = 0;
        
        ResultSet rs = cnbd.getConsultas("SELECT cl.ID_CFC, cl.Descripcion_CFC FROM clasificacion cl INNER JOIN peliculas pl ON cl.ID_CFC = pl.ID_CFC WHERE pl.ID_PLC = " + idPl);
               
        try 
        {
            
            if(rs.next())
            {
                idCfc = rs.getInt("ID_CFC");
                info = rs.getString("Descripcion_CFC");   
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion clasificacion", 2);
        }
        
        infoClasificacion.setText(info);        
        
        if(idCfc == 4 || idCfc == 5)
        {
            botonMasNino.setEnabled(false);
            botonMenosNino.setEnabled(false);
        }
        else
        {
            botonMasNino.setEnabled(true);
            botonMenosNino.setEnabled(true);
        }
    }

    public void setPrecioBoletos()
    {        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT Precio_TBLT FROM TIPO_BOLETO");
               
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
        
        precioNino.setText("$ " + lista.get(0));
        precioAdulto.setText("$ " + lista.get(1));
        precioAnciano.setText("$ " + lista.get(2));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        botonMenosAdulto = new javax.swing.JButton();
        botonMasAdulto = new javax.swing.JButton();
        cantidadAdulto = new javax.swing.JTextField();
        botonMenosNino = new javax.swing.JButton();
        cantidadNino = new javax.swing.JTextField();
        botonMasNino = new javax.swing.JButton();
        botonMenosMayor = new javax.swing.JButton();
        cantidadAnciano = new javax.swing.JTextField();
        botonMasMayor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        botonSig = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        infoClasificacion = new javax.swing.JLabel();
        precioAnciano = new javax.swing.JLabel();
        precioNino = new javax.swing.JLabel();
        precioAdulto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cantidad de asientos");
        setResizable(false);
        setSize(new java.awt.Dimension(489, 445));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        botonMenosAdulto.setBackground(new java.awt.Color(0, 77, 104));
        botonMenosAdulto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonMenosAdulto.setForeground(new java.awt.Color(255, 255, 255));
        botonMenosAdulto.setText("-");
        botonMenosAdulto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMenosAdulto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMenosAdultoMouseClicked(evt);
            }
        });
        jPanel2.add(botonMenosAdulto);
        botonMenosAdulto.setBounds(250, 180, 50, 30);

        botonMasAdulto.setBackground(new java.awt.Color(0, 77, 104));
        botonMasAdulto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonMasAdulto.setForeground(new java.awt.Color(255, 255, 255));
        botonMasAdulto.setText("+");
        botonMasAdulto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMasAdulto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMasAdultoMouseClicked(evt);
            }
        });
        jPanel2.add(botonMasAdulto);
        botonMasAdulto.setBounds(400, 180, 50, 30);

        cantidadAdulto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cantidadAdulto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAdulto.setText("0");
        jPanel2.add(cantidadAdulto);
        cantidadAdulto.setBounds(320, 180, 59, 30);

        botonMenosNino.setBackground(new java.awt.Color(0, 77, 104));
        botonMenosNino.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonMenosNino.setForeground(new java.awt.Color(255, 255, 255));
        botonMenosNino.setText("-");
        botonMenosNino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMenosNino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMenosNinoMouseClicked(evt);
            }
        });
        jPanel2.add(botonMenosNino);
        botonMenosNino.setBounds(250, 100, 50, 30);

        cantidadNino.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cantidadNino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadNino.setText("0");
        jPanel2.add(cantidadNino);
        cantidadNino.setBounds(320, 100, 60, 30);

        botonMasNino.setBackground(new java.awt.Color(0, 77, 104));
        botonMasNino.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonMasNino.setForeground(new java.awt.Color(255, 255, 255));
        botonMasNino.setText("+");
        botonMasNino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMasNino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMasNinoMouseClicked(evt);
            }
        });
        jPanel2.add(botonMasNino);
        botonMasNino.setBounds(400, 100, 50, 30);

        botonMenosMayor.setBackground(new java.awt.Color(0, 77, 104));
        botonMenosMayor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonMenosMayor.setForeground(new java.awt.Color(255, 255, 255));
        botonMenosMayor.setText("-");
        botonMenosMayor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMenosMayor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMenosMayorMouseClicked(evt);
            }
        });
        jPanel2.add(botonMenosMayor);
        botonMenosMayor.setBounds(250, 260, 50, 30);

        cantidadAnciano.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cantidadAnciano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAnciano.setText("0");
        jPanel2.add(cantidadAnciano);
        cantidadAnciano.setBounds(320, 260, 60, 30);

        botonMasMayor.setBackground(new java.awt.Color(0, 77, 104));
        botonMasMayor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonMasMayor.setForeground(new java.awt.Color(255, 255, 255));
        botonMasMayor.setText("+");
        botonMasMayor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMasMayor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMasMayorMouseClicked(evt);
            }
        });
        jPanel2.add(botonMasMayor);
        botonMasMayor.setBounds(400, 260, 50, 30);

        jPanel3.setBackground(new java.awt.Color(0, 32, 86));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 410, 700, 30);

        botonSig.setBackground(new java.awt.Color(51, 51, 51));
        botonSig.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonSig.setForeground(new java.awt.Color(255, 255, 255));
        botonSig.setText("Siguiente");
        botonSig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSigMouseClicked(evt);
            }
        });
        jPanel2.add(botonSig);
        botonSig.setBounds(550, 360, 100, 23);

        jPanel1.setBackground(new java.awt.Color(0, 32, 86));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad de asientos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 0, 250, 40);
        jPanel1.add(labelLogo);
        labelLogo.setBounds(630, 0, 40, 40);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/children.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(190, 90, 40, 50);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/parents.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(190, 170, 40, 50);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grandparents.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(190, 250, 40, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/info.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 354, 30, 30);
        jPanel2.add(infoClasificacion);
        infoClasificacion.setBounds(70, 360, 460, 20);

        precioAnciano.setFont(new java.awt.Font("Arial Nova Light", 1, 12)); // NOI18N
        jPanel2.add(precioAnciano);
        precioAnciano.setBounds(470, 260, 70, 30);

        precioNino.setFont(new java.awt.Font("Arial Nova Light", 1, 12)); // NOI18N
        jPanel2.add(precioNino);
        precioNino.setBounds(470, 100, 100, 30);

        precioAdulto.setFont(new java.awt.Font("Arial Nova Light", 1, 12)); // NOI18N
        jPanel2.add(precioAdulto);
        precioAdulto.setBounds(470, 180, 70, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 440);

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

        setBounds(0, 0, 705, 484);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSigMouseClicked
        
        if(!cantidadNino.getText().equals("0") || !cantidadAdulto.getText().equals("0") || !cantidadAnciano.getText().equals("0"))
        {
            float precio = mc.getObtenerTotal(mc.getObtenerTotalNinos(lista.get(0), cantidadNino.getText()), mc.getObtenerTotalAdultos(lista.get(1), cantidadAdulto.getText()), mc.getObtenerTotalAnciano(lista.get(2), cantidadAnciano.getText()));
            
            int totAsn = mc.getTotalAsientos(Integer.parseInt(cantidadNino.getText()), Integer.parseInt(cantidadAdulto.getText()), Integer.parseInt(cantidadAnciano.getText()));
            
            VentanaSeleccionarAsientos vsa = new VentanaSeleccionarAsientos(gse, idPl, idFn, precio, totAsn);
                        
            dispose();
            vsa.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null,"Agregue al menos un boleto para continuar","Cantidad de boletos", 2);
    }//GEN-LAST:event_botonSigMouseClicked

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalCajero vpb = new VentanaPrincipalCajero(gse);
        
       int op = 0; 
       
        op = JOptionPane.showConfirmDialog(null,"Se perdera la compra ¿Seguro desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
           
        if(op == JOptionPane.YES_OPTION)
        {        
            this.dispose();
            vpb.setVisible(true);
        }
    }//GEN-LAST:event_menuInicioActionPerformed

    private void botonMenosNinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosNinoMouseClicked
        if(!cantidadNino.getText().equals("0"))
            cantidadNino.setText(String.valueOf(mc.getObtenerMenos(cantidadNino.getText())));
    }//GEN-LAST:event_botonMenosNinoMouseClicked

    private void botonMasNinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasNinoMouseClicked
        cantidadNino.setText(String.valueOf(mc.getObtenerMas(cantidadNino.getText())));
    }//GEN-LAST:event_botonMasNinoMouseClicked

    private void botonMenosAdultoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosAdultoMouseClicked
        if(!cantidadAdulto.getText().equals("0"))
            cantidadAdulto.setText(String.valueOf(mc.getObtenerMenos(cantidadAdulto.getText())));
    }//GEN-LAST:event_botonMenosAdultoMouseClicked

    private void botonMasAdultoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasAdultoMouseClicked
        cantidadAdulto.setText(String.valueOf(mc.getObtenerMas(cantidadAdulto.getText())));
    }//GEN-LAST:event_botonMasAdultoMouseClicked

    private void botonMenosMayorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMayorMouseClicked
        if(!cantidadAnciano.getText().equals("0"))
            cantidadAnciano.setText(String.valueOf(mc.getObtenerMenos(cantidadAnciano.getText())));
    }//GEN-LAST:event_botonMenosMayorMouseClicked

    private void botonMasMayorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMayorMouseClicked
        cantidadAnciano.setText(String.valueOf(mc.getObtenerMas(cantidadAnciano.getText())));
    }//GEN-LAST:event_botonMasMayorMouseClicked


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
            java.util.logging.Logger.getLogger(VentanaCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCantidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMasAdulto;
    private javax.swing.JButton botonMasMayor;
    private javax.swing.JButton botonMasNino;
    private javax.swing.JButton botonMenosAdulto;
    private javax.swing.JButton botonMenosMayor;
    private javax.swing.JButton botonMenosNino;
    private javax.swing.JButton botonSig;
    private javax.swing.JTextField cantidadAdulto;
    private javax.swing.JTextField cantidadAnciano;
    private javax.swing.JTextField cantidadNino;
    private javax.swing.JLabel infoClasificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel precioAdulto;
    private javax.swing.JLabel precioAnciano;
    private javax.swing.JLabel precioNino;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;      
    private GetSetEmpleados gse;
    private MetodosCine mc;
    private ConsultasBD cnbd;
    ArrayList<String> lista;     
    private int idFn, idPl;
}
