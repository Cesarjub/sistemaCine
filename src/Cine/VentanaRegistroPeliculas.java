package Cine;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaRegistroPeliculas extends javax.swing.JFrame {

    public VentanaRegistroPeliculas() 
    {
        initComponents();
    }

    public VentanaRegistroPeliculas(GetSetEmpleados gse)
    {
        initComponents();
        
        this.gse = gse;
        
        //
        this.setLocationRelativeTo(null);         
        
        gsp = new GetSetPeliculas();
        cnbd = new ConsultasBD();
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint();        
        
        this.setLLenarComboClasificacion();
        
        textId.setEditable(false);
        
        textId.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_PLC) FROM peliculas"))); 
        
        errorClasificacion.setText(null);        
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }            
    }
    
    public void setLLenarComboClasificacion()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM clasificacion");
        
        comboClasificacion.addItem("Selecciona");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Tipo_CFC"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboClasificacion.addItem(lista.get(i));
    }       
    
    public void setLimpiarFormulario()
    {
        panelImagen.removeAll();
        panelImagen.repaint();
        
        comboClasificacion.setSelectedIndex(0);
        
        textTitulo.setText(null);
        
        textSinopsis.setText(null);
        
        textDuracion.setValue(0);
        
        textAno.setYear(2019);
        
        errorTitulo.setText(null);
        errorImagen.setText(null);
        errorClasificacion.setText(null);
        errorDuracion.setText(null);
        errorSinopsis.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botonSubirImagen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textAno = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        comboClasificacion = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        textDuracion = new com.toedter.components.JSpinField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSinopsis = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelImagen = new javax.swing.JPanel();
        errorTitulo = new javax.swing.JLabel();
        errorSinopsis = new javax.swing.JLabel();
        errorClasificacion = new javax.swing.JLabel();
        errorDuracion = new javax.swing.JLabel();
        errorImagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar peliculas");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 80, 30, 30);
        jPanel1.add(textId);
        textId.setBounds(130, 110, 90, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Titulo:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 190, 50, 30);

        textTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTituloKeyTyped(evt);
            }
        });
        jPanel1.add(textTitulo);
        textTitulo.setBounds(80, 190, 140, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Poster:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 240, 60, 20);

        botonSubirImagen.setText("Subir imagen");
        botonSubirImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSubirImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSubirImagenMouseClicked(evt);
            }
        });
        jPanel1.add(botonSubirImagen);
        botonSubirImagen.setBounds(80, 240, 110, 23);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Año:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 280, 50, 30);
        jPanel1.add(textAno);
        textAno.setBounds(80, 280, 80, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Clasificacion:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 85, 120, 20);

        comboClasificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboClasificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboClasificacionItemStateChanged(evt);
            }
        });
        jPanel1.add(comboClasificacion);
        comboClasificacion.setBounds(290, 110, 120, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Duracion:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(270, 160, 70, 30);
        jPanel1.add(textDuracion);
        textDuracion.setBounds(350, 160, 60, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("min.");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(420, 160, 40, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Sinopsis:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(270, 210, 70, 20);

        textSinopsis.setColumns(20);
        textSinopsis.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textSinopsis.setRows(5);
        textSinopsis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSinopsisKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textSinopsis);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(290, 230, 250, 80);

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
        botonGuardar.setBounds(240, 350, 100, 23);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Registro de peliculas");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 0, 170, 40);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(500, 0, 40, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 570, 40);

        jPanel3.setBackground(new java.awt.Color(0, 32, 86));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 390, 570, 20);

        panelImagen.setBackground(new java.awt.Color(255, 255, 255));
        panelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImagen.setToolTipText("");

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        jPanel1.add(panelImagen);
        panelImagen.setBounds(30, 60, 80, 110);

        errorTitulo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorTitulo.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorTitulo);
        errorTitulo.setBounds(80, 220, 140, 10);

        errorSinopsis.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorSinopsis.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorSinopsis);
        errorSinopsis.setBounds(290, 310, 250, 20);

        errorClasificacion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorClasificacion.setForeground(new java.awt.Color(153, 0, 0));
        errorClasificacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(errorClasificacion);
        errorClasificacion.setBounds(290, 130, 220, 20);

        errorDuracion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorDuracion.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorDuracion);
        errorDuracion.setBounds(350, 190, 140, 20);

        errorImagen.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorImagen.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(errorImagen);
        errorImagen.setBounds(80, 260, 150, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 580, 420);

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

        setBounds(0, 0, 576, 457);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSubirImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSubirImagenMouseClicked
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG", "png", "jpg");
        
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setFileFilter(filtro);
        
        int seleccion = fc.showOpenDialog(this);
        
        if(seleccion == JFileChooser.APPROVE_OPTION)
        {
            panelImagen.removeAll();
            
            File archivo = fc.getSelectedFile();
            
            String ruta = archivo.getAbsolutePath();
            
            gsp.setPoster(archivo);
            
            int x = panelImagen.getWidth();
            int y = panelImagen.getHeight();

            MostrarImagen mi = new MostrarImagen(x, y, ruta);

            panelImagen.add(mi);
            panelImagen.repaint();           
        }
        
    }//GEN-LAST:event_botonSubirImagenMouseClicked

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        
        boolean band = false;
        
        if(textTitulo.getText().equals(""))
            errorTitulo.setText("*Titulo incorrecto");
        else
            errorTitulo.setText(null);
        
        if (comboClasificacion.getSelectedItem() == "Selecciona") 
            errorClasificacion.setText("*Seleccione una opcion valida");
        else
            errorClasificacion.setText(null);
         
        if(textSinopsis.getText().equals(""))
            errorSinopsis.setText("*Sinopsis incorrecto");
        else
            errorSinopsis.setText(null);   
        
        try
        {
            if(!gsp.getPoster().equals(""))
                errorImagen.setText(null);
        }
        catch(Exception e)
        {
            errorImagen.setText("*Seleccione una imagen");
        }        
        
        if(textDuracion.getValue() > 1)
        {
            errorDuracion.setText(null);
            band = true;
        }
        else
            errorDuracion.setText("*Duracion incorrecta");  
        
        if(!textTitulo.getText().equals("") && !textSinopsis.equals("") && !comboClasificacion.equals("Selecciona") &&
               textDuracion.getValue() > 1  & band)
        {
            String consulta = "SELECT COUNT(ID_PLC) FROM peliculas WHERE Nombre_PLC = '" + textTitulo.getText() + "'";
            
            if(cnbd.getBuscar(consulta) == 0)
            {            
                gsp.setId(Integer.parseInt(textId.getText()));
                gsp.setTitulo(textTitulo.getText());
                gsp.setAno(textAno.getYear());
                gsp.setDuracion(textDuracion.getValue());
                gsp.setClasificacion(comboClasificacion.getSelectedIndex());
                gsp.setSinopsis(textSinopsis.getText());

                if(cnbd.getRegistrarPeliculas(gsp))
                {
                    JOptionPane.showMessageDialog(null,"La pelicula ha sido guardado","Registrar empleado", 1);
                    setLimpiarFormulario();
                    textId.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_PLC) FROM peliculas"))); 
                }
                else
                    JOptionPane.showMessageDialog(null,"No se han podido guardar los datos","Registrar peliculas", 2);
            }
            else
                JOptionPane.showMessageDialog(null,"La pelicula ya esta registrada","Pelicula ya registrada", 2);            
        }
        else
            JOptionPane.showMessageDialog(null,"Llene todos los campos para continuar","Datos incorrectos", 2);
        
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void comboClasificacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboClasificacionItemStateChanged
        if(comboClasificacion.getSelectedItem() == "Selecciona")
            errorClasificacion.setText("*Seleccione una opcion valida");
        else
            errorClasificacion.setText(null);
    }//GEN-LAST:event_comboClasificacionItemStateChanged

    private void textTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTituloKeyTyped
        if(textTitulo.getText().equals(""))
            errorTitulo.setText("*Titulo incorrecto");
        else
            errorTitulo.setText(null);
    }//GEN-LAST:event_textTituloKeyTyped

    private void textSinopsisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSinopsisKeyTyped
        if(textSinopsis.getText().equals(""))
            errorSinopsis.setText("*Sinopsis incorrecto");
        else
            errorSinopsis.setText(null);        
    }//GEN-LAST:event_textSinopsisKeyTyped

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        setLimpiarFormulario();
    }//GEN-LAST:event_menuLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaRegistroPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSubirImagen;
    private javax.swing.JComboBox comboClasificacion;
    private javax.swing.JLabel errorClasificacion;
    private javax.swing.JLabel errorDuracion;
    private javax.swing.JLabel errorImagen;
    private javax.swing.JLabel errorSinopsis;
    private javax.swing.JLabel errorTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelImagen;
    private com.toedter.calendar.JYearChooser textAno;
    private com.toedter.components.JSpinField textDuracion;
    private javax.swing.JTextField textId;
    private javax.swing.JTextArea textSinopsis;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;    
    private GetSetEmpleados gse;
    private GetSetPeliculas gsp;
    private ConsultasBD cnbd;
}
