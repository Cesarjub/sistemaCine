package Cine;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaRegistroSalas extends javax.swing.JFrame {

    public VentanaRegistroSalas() 
    {
        initComponents();
    }
    
    public VentanaRegistroSalas(GetSetEmpleados gse)
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
        
        idSala.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_SL) FROM salas")));        
        
        idSala.setEditable(false);
        
        setComboTipoSala();
        
        errorTipo.setText(null);
        errorAsientos.setText(null);
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }          
    }
    
    public void setComboTipoSala()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM tipo_sala");
        
        comboTipoSala.addItem("Selecciona");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Tipo_TSL"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboTipoSala.addItem(lista.get(i));        
    }    
    
    public void setLimpiarFormulario()
    {
        numeroSala.setValue(0);
        
        comboTipoSala.setSelectedIndex(0);
        comboAsientos.setSelectedIndex(0);
        
        errorTipo.setText(null);
        errorAsientos.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idSala = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numeroSala = new com.toedter.components.JSpinField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboTipoSala = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        comboAsientos = new javax.swing.JComboBox();
        errorTipo = new javax.swing.JLabel();
        errorAsientos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar sala");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 70, 40, 20);
        jPanel1.add(idSala);
        idSala.setBounds(40, 90, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Num. sala:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 150, 80, 20);
        jPanel1.add(numeroSala);
        numeroSala.setBounds(40, 170, 80, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Asientos:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(220, 150, 70, 20);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro de sala");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 0, 160, 40);
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

        comboTipoSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboTipoSala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoSalaItemStateChanged(evt);
            }
        });
        jPanel1.add(comboTipoSala);
        comboTipoSala.setBounds(220, 100, 120, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tipo de sala:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(220, 80, 110, 15);

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
        botonGuardar.setBounds(170, 260, 100, 23);

        comboAsientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "45", "54", "63", "72" }));
        comboAsientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboAsientos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAsientosItemStateChanged(evt);
            }
        });
        jPanel1.add(comboAsientos);
        comboAsientos.setBounds(220, 170, 120, 20);

        errorTipo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorTipo.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorTipo);
        errorTipo.setBounds(220, 120, 170, 20);

        errorAsientos.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorAsientos.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorAsientos);
        errorAsientos.setBounds(220, 190, 170, 20);

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

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vpa.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void comboTipoSalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoSalaItemStateChanged
        if(comboTipoSala.getSelectedItem() == "Selecciona")
            errorTipo.setText("*Seleccione una opcion valida");
        else
            errorTipo.setText(null);
    }//GEN-LAST:event_comboTipoSalaItemStateChanged

    private void comboAsientosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAsientosItemStateChanged
        if(comboAsientos.getSelectedItem() == "Selecciona")
            errorAsientos.setText("*Seleccione una opcion valida");
        else
            errorAsientos.setText(null);
    }//GEN-LAST:event_comboAsientosItemStateChanged

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        
        GetSetSala gss = new GetSetSala();
        
        if(comboTipoSala.getSelectedItem() == "Selecciona")
            errorTipo.setText("*Seleccione una opcion valida");
        else
            errorTipo.setText(null);
        
        if(comboAsientos.getSelectedItem() == "Selecciona")
            errorAsientos.setText("*Seleccione una opcion valida");
        else
            errorAsientos.setText(null);
        
        if(comboTipoSala.getSelectedItem() != "Selecciona" && comboAsientos.getSelectedItem() != "Selecciona")
        {
            String consulta = "SELECT COUNT(ID_SL) FROM salas WHERE Numero_SL = " + numeroSala.getValue();
            
            if(cnbd.getBuscar(consulta) == 0)
            {
                gss.setId(Integer.parseInt(idSala.getText()));
                gss.setNumero(numeroSala.getValue());
                gss.setCapacidad(Integer.parseInt(comboAsientos.getSelectedItem().toString()));
                gss.setTipo(comboTipoSala.getSelectedIndex());
            
                if(cnbd.getRegistrarSala(gss))
                {
                    JOptionPane.showMessageDialog(null,"La sala ha sido guardada","Sala agregada", 1); 
                    setLimpiarFormulario();
                    idSala.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_SL) FROM salas")));    
                }
                else
                    JOptionPane.showMessageDialog(null,"No se han podido guardar los datos","Registrar sala", 2);
            }
            else
                JOptionPane.showMessageDialog(null,"El numero de sala ya esta registrada","Sala ya registrada", 2);            
        }
        else
          JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos","Registrar sala", 2);   
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        setLimpiarFormulario();
    }//GEN-LAST:event_menuLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaRegistroSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroSalas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox comboAsientos;
    private javax.swing.JComboBox comboTipoSala;
    private javax.swing.JLabel errorAsientos;
    private javax.swing.JLabel errorTipo;
    private javax.swing.JTextField idSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuSalir;
    private com.toedter.components.JSpinField numeroSala;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;   
    private GetSetEmpleados gse;
    private ConsultasBD cnbd;
}
