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

public class VentanaRegistroEmpleados extends javax.swing.JFrame {
    
    public VentanaRegistroEmpleados()
    {
        initComponents();
    }
    
    public VentanaRegistroEmpleados(GetSetEmpleados gse) 
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
        
        this.setLLenarComboCargo();
        
        idEmpleado.setEditable(false);
        
        idEmpleado.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_EMP) FROM empleados")));
        
        errorCargo.setText(null);
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }        
    }

    public void setLLenarComboCargo()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM cargo");
        
        comboCargo.addItem("Selecciona");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Nombre_CRG"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboCargo.addItem(lista.get(i));
    }    
    
    public void setLimpiarFormulario()
    {
        nombreEmpleado.setText(null);
        apellidoEmpleado.setText(null);
        ingresoEmpleado.setDate(null);
        usuarioEmpleado.setText(null);
        claveEmpleado.setText(null);
        claveConfirmaEmpleado.setText(null);
    
        comboCargo.setSelectedIndex(0);
        
        errorNombre.setText(null);
        errorApellido.setText(null);
        errorFecha.setText(null);
        errorCargo.setText(null);
        errorUsuario.setText(null);
        errorCl1.setText(null);
        errorCl2.setText(null);
        errorCl11.setText(null);
        errorCl22.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idEmpleado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JTextField();
        ingresoEmpleado = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        apellidoEmpleado = new javax.swing.JTextField();
        claveEmpleado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        claveConfirmaEmpleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboCargo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        errorNombre = new javax.swing.JLabel();
        errorCargo = new javax.swing.JLabel();
        errorApellido = new javax.swing.JLabel();
        errorFecha = new javax.swing.JLabel();
        errorCl1 = new javax.swing.JLabel();
        errorCl2 = new javax.swing.JLabel();
        errorCl11 = new javax.swing.JLabel();
        errorCl22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        usuarioEmpleado = new javax.swing.JTextField();
        errorUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar empleados");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 130, 70, 30);
        jPanel1.add(idEmpleado);
        idEmpleado.setBounds(40, 80, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellido(s):");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 180, 80, 30);

        nombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(nombreEmpleado);
        nombreEmpleado.setBounds(100, 130, 140, 30);

        ingresoEmpleado.setDateFormatString("yyy/MM/dd");
        jPanel1.add(ingresoEmpleado);
        ingresoEmpleado.setBounds(100, 230, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 230, 80, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(290, 180, 80, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("contraseña:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 240, 80, 20);

        apellidoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(apellidoEmpleado);
        apellidoEmpleado.setBounds(100, 180, 140, 30);

        claveEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                claveEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(claveEmpleado);
        claveEmpleado.setBounds(380, 180, 110, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 60, 50, 20);

        claveConfirmaEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                claveConfirmaEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(claveConfirmaEmpleado);
        claveConfirmaEmpleado.setBounds(380, 230, 110, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cargo:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(300, 65, 60, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Repetir");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(310, 230, 60, 15);

        comboCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCargoItemStateChanged(evt);
            }
        });
        jPanel1.add(comboCargo);
        comboCargo.setBounds(300, 90, 130, 20);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Registro de empleados");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 0, 210, 40);

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(480, 0, 40, 40);
        jPanel2.add(jLabel12);
        jLabel12.setBounds(190, 10, 0, 0);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 550, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ingreso:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 240, 70, 15);

        jPanel3.setBackground(new java.awt.Color(0, 32, 86));
        jPanel3.setLayout(null);
        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 340, 550, 20);

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
        botonGuardar.setBounds(240, 300, 110, 23);

        errorNombre.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorNombre.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorNombre);
        errorNombre.setBounds(100, 160, 140, 10);

        errorCargo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorCargo.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorCargo);
        errorCargo.setBounds(300, 110, 190, 10);

        errorApellido.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorApellido.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorApellido);
        errorApellido.setBounds(100, 210, 140, 10);

        errorFecha.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorFecha.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorFecha);
        errorFecha.setBounds(100, 260, 140, 20);

        errorCl1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorCl1.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorCl1);
        errorCl1.setBounds(380, 210, 140, 10);

        errorCl2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorCl2.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorCl2);
        errorCl2.setBounds(380, 260, 140, 10);

        errorCl11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorCl11.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorCl11);
        errorCl11.setBounds(380, 210, 140, 10);

        errorCl22.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorCl22.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorCl22);
        errorCl22.setBounds(380, 260, 150, 10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Usuario:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(300, 130, 70, 30);

        usuarioEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(usuarioEmpleado);
        usuarioEmpleado.setBounds(380, 130, 110, 30);

        errorUsuario.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorUsuario.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorUsuario);
        errorUsuario.setBounds(380, 160, 140, 10);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 550, 360);

        menu1.setText("File");

        menuLimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        menuLimpiar.setText("Limpiar");
        menuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLimpiarActionPerformed(evt);
            }
        });
        menu1.add(menuLimpiar);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menu1.add(menuSalir);

        jMenuBar1.add(menu1);

        menu2.setText("View");

        menuInicio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        menuInicio.setText("Inicio");
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });
        menu2.add(menuInicio);

        jMenuBar1.add(menu2);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 555, 409);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        
        GetSetEmpleados gse = new GetSetEmpleados();
        
        String cl1 = claveEmpleado.getText();
        String cl2 = claveConfirmaEmpleado.getText();
        
        boolean bnd = false;
           
        if(nombreEmpleado.getText().equals(""))
            errorNombre.setText("*Nombre incorrecto");
        else
            errorNombre.setText(null);        
        
        if(apellidoEmpleado.getText().equals(""))
            errorApellido.setText("*Apellido incorrecto");
        else
            errorApellido.setText(null);

        try
        {        
            if(ingresoEmpleado.getDate().toString().length() > 1)
                errorFecha.setText(null);
            
            bnd = true;
        }
        catch(Exception e)
        {
            errorFecha.setText("*Fecha incorrecta");
        }

        if(comboCargo.getSelectedItem() == "Selecciona")
            errorCargo.setText("*Seleccione una opcion valida");
        else
            errorCargo.setText(null);
                
        if(usuarioEmpleado.getText().equals(""))
            errorUsuario.setText("*Usuario incorrecto");
        else
            errorUsuario.setText(null);        
        
        if(claveEmpleado.getText().equals(""))
            errorCl1.setText("*Contraseña incorrecta");
        else
            errorCl1.setText(null);         
        
        if(claveConfirmaEmpleado.getText().equals(""))
            errorCl2.setText("*Contraseña incorrecta");
        else
            errorCl2.setText(null); 
        
        if(!cl1.equals(cl2))
        {
            errorCl11.setText("*Contraseña incorrecta");
            errorCl22.setText("*Contraseña incorrecta");
        }
        else
        {
            errorCl11.setText(null);
            errorCl22.setText(null);
        }
        
        if(!cl1.equals("") && !cl2.equals("") && !usuarioEmpleado.equals("") & bnd && comboCargo.getSelectedItem() != "Selecciona"
                && !nombreEmpleado.getText().equals("") && !apellidoEmpleado.getText().equals(""))
        {
            if(cl1.equals(cl2))
            {
                if(cnbd.getComprobarUsuario(usuarioEmpleado.getText()) == 0)
                {
                
                    Date dt = ingresoEmpleado.getDate();
        
                    long tmp = dt.getTime();
        
                    java.sql.Date fecha =  new java.sql.Date(tmp);           
        
                    gse.setId(Integer.parseInt(idEmpleado.getText()));
                    gse.setNombre(nombreEmpleado.getText());
                    gse.setApellido(apellidoEmpleado.getText());
                    gse.setUsuario(usuarioEmpleado.getText());
                    gse.setClave(claveEmpleado.getText());
                    gse.setFechaIngreso(fecha.toString());
                    gse.setCargo(comboCargo.getSelectedIndex());
            
                    if(cnbd.getRegistrarUsuarios(gse))
                    {
                        JOptionPane.showMessageDialog(null,"El empleado ha sido guardado","Empleado agregado", 1);
                        setLimpiarFormulario();
                        idEmpleado.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_EMP) FROM empleados")));
                    }
                    else
                        JOptionPane.showMessageDialog(null,"No se han podido guardar los datos","Registrar empleado", 2);
                }
                else
                  JOptionPane.showMessageDialog(null,"El usuario ya esta registrado","Usuario existente", 0);  
            }
            else
                JOptionPane.showMessageDialog(null,"Las contraseñas ingresadas son diferentes","Contraseña incorrecta", 0);   
        }
        else
            JOptionPane.showMessageDialog(null,"Llene todos los campos para continuar","Datos incorrectos", 2);
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void nombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreEmpleadoKeyTyped
        if(nombreEmpleado.getText().equals(""))
            errorNombre.setText("*Nombre incorrecto");
        else
            errorNombre.setText(null);
    }//GEN-LAST:event_nombreEmpleadoKeyTyped

    private void apellidoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoEmpleadoKeyTyped
        if(apellidoEmpleado.getText().equals(""))
            errorApellido.setText("*Apellido incorrecto");
        else
            errorApellido.setText(null);        
    }//GEN-LAST:event_apellidoEmpleadoKeyTyped

    private void comboCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCargoItemStateChanged
        if(comboCargo.getSelectedItem() == "Selecciona")
            errorCargo.setText("*Seleccione una opcion valida");
        else
            errorCargo.setText(null);
    }//GEN-LAST:event_comboCargoItemStateChanged

    private void claveEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveEmpleadoKeyTyped
        if(claveEmpleado.getText().equals(""))
            errorCl1.setText("*Contraseña incorrecta");
        else
            errorCl1.setText(null);   
        
        if(claveEmpleado.getText().length() == 8)
            evt.consume();        
    }//GEN-LAST:event_claveEmpleadoKeyTyped

    private void claveConfirmaEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveConfirmaEmpleadoKeyTyped
        if(claveConfirmaEmpleado.getText().equals(""))
            errorCl2.setText("*Contraseña incorrecta");
        else
            errorCl2.setText(null);  
        
        if(claveConfirmaEmpleado.getText().length() == 8)
            evt.consume();
    }//GEN-LAST:event_claveConfirmaEmpleadoKeyTyped

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        setLimpiarFormulario();
    }//GEN-LAST:event_menuLimpiarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void usuarioEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioEmpleadoKeyTyped
        if(usuarioEmpleado.getText().equals(""))
            errorUsuario.setText("*Usuario incorrecto");
        else
            errorUsuario.setText(null);  
        
        if(usuarioEmpleado.getText().length() == 12)
            evt.consume();        
    }//GEN-LAST:event_usuarioEmpleadoKeyTyped

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vpa.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed


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
            java.util.logging.Logger.getLogger(VentanaRegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoEmpleado;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField claveConfirmaEmpleado;
    private javax.swing.JTextField claveEmpleado;
    private javax.swing.JComboBox comboCargo;
    private javax.swing.JLabel errorApellido;
    private javax.swing.JLabel errorCargo;
    private javax.swing.JLabel errorCl1;
    private javax.swing.JLabel errorCl11;
    private javax.swing.JLabel errorCl2;
    private javax.swing.JLabel errorCl22;
    private javax.swing.JLabel errorFecha;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorUsuario;
    private javax.swing.JTextField idEmpleado;
    private com.toedter.calendar.JDateChooser ingresoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenu menu2;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTextField nombreEmpleado;
    private javax.swing.JTextField usuarioEmpleado;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;
    private ConsultasBD cnbd;
    private GetSetEmpleados gse;    
}
