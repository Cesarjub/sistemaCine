package Cine;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaPrincipalCajero extends javax.swing.JFrame {
    
    public VentanaPrincipalCajero() 
    {
        initComponents();
    }
    
    public VentanaPrincipalCajero(GetSetEmpleados gse)
    {
        initComponents();
        
        this.gse = gse; 
        fch = "";
        
        cnbd = new ConsultasBD();       
        
        //
        this.setLocationRelativeTo(null);                       
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint(); 
        
        nombreEmpleado.setText("Hola, " + gse.getNombre() + " !");
        cargoEmpleado.setText(gse.getNombreCargo());   

        setLLenarComboPeliculas();         
        
        panelPoster.setVisible(false);
        panelInformacion.setVisible(false);
        panelScroll.setVisible(false);
        fechaFuncion.setVisible(false);
                
        bienvenida.setVisible(true);
        seleccione.setVisible(true);             
        
        sinopsisPelicula.setEditable(false);

        fechaFuncion.getJCalendar().setMinSelectableDate(new Date());
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }
    
    public void setLLenarComboPeliculas()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM peliculas");
        
        comboPeliculas.addItem("Selecciona");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Nombre_PLC"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboPeliculas.addItem(lista.get(i));
    }       
    
    public void setPoster(String consulta)
    {
        ResultSet rs = cnbd.getConsultas(consulta);
        
        BufferedImage bi = null;
        
        byte [] image = null;
        
        try 
        {
            while(rs.next())
            {
                image = rs.getBytes("Poster_PLC");
                
                InputStream bs = rs.getBinaryStream(1);
                
                try 
                {
                    bi = ImageIO.read(bs);
                    
                    CargarImagen imagen = new CargarImagen(panelPoster.getHeight(), panelPoster.getWidth(), bi);
                    
                    panelPoster.add(imagen);
                    panelPoster.repaint();
                } 
                catch (IOException e) 
                {
                    JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Poster", 2);
                }
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Poster", 2);
        } 
    }
    
    public void setInformacionPeliculas(int id)
    {
        ResultSet rs = cnbd.getConsultas("SELECT p.*, c.Tipo_CFC FROM peliculas p INNER JOIN clasificacion c ON p.ID_CFC = c.ID_CFC where ID_PLC = " + id);
               
        try 
        {
            
            if(rs.next())
            {
                tituloPelicula.setText(rs.getString("Nombre_PLC"));
                clasificacionPelicula.setText(rs.getString("Tipo_CFC"));
                anoPelicula.setText(String.valueOf(rs.getInt("Ano_PLC")));
                duracionPelicula.setText(String.valueOf(rs.getInt("Duracion_PLC")) + " min.");
                sinopsisPelicula.setText(rs.getString("Sinopsis_PLC"));   
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
        } 
    }

    public void setHorarios()
    {
        int idPl = cnbd.getConsultarPeliculas(comboPeliculas.getSelectedItem().toString());
        boolean bnd = false;
        
        panelHorarios.removeAll();
        panelHorarios.repaint();   
        
        ArrayList lista = new ArrayList <String>();         

        try 
        {
            String consultaHrFn = "SELECT Hora_FNC FROM funciones WHERE Dia_FNC = '" + fch + "' AND ID_PLC = " + idPl;  
            
            ResultSet rs2 = cnbd.getLlenarComboBox(consultaHrFn);            
            
            while(rs2.next())
            {
                lista.add(rs2.getString("Hora_FNC"));
                bnd = true;
            }            
        } 
        catch (SQLException e) 
        {
            bnd = false;
        }        
        
        if(bnd)
        {
            Font fuente = new Font("Tahoma", Font.BOLD, 11);
            
            for(int i = 0; i < lista.size(); i++)
            {                    
                JButton btn = new JButton((String) lista.get(i));

                btn.setCursor(new Cursor(HAND_CURSOR));
                btn.setFont(fuente);
                btn.setBackground(new Color(0,73,112));
                btn.setForeground(Color.WHITE);

                panelHorarios.add(btn);
                
                btn.addActionListener(new ActionListener() 
                {

                    @Override
                    public void actionPerformed(ActionEvent ev) 
                    {

                        int idFn = 0;
                        
                        String consultaFn = "SELECT ID_FNC FROM funciones WHERE Dia_FNC = '" + fch + "'" + "AND Hora_FNC = '" + btn.getText().toString() + "'" + "AND ID_PLC = " + idPl;
                        
                        ResultSet rs3 = cnbd.getConsultas(consultaFn);
            
                        try 
                        {
                            if(rs3.next())
                                idFn = rs3.getInt("ID_FNC");
                        } 
                        catch (SQLException e) 
                        {
                            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Consultar funcion", 2);
                        }

                        VentanaCantidad vc = new VentanaCantidad(gse, idPl, idFn);
                        
                        dispose();
                        vc.setVisible(true);
                    }
                });
            }
            
            panelHorarios.updateUI();
        }   
        else
        {
            JLabel lb = new JLabel("No hay horarios disponibles");
            
            panelHorarios.add(lb);
            panelHorarios.updateUI();             
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JLabel();
        cargoEmpleado = new javax.swing.JLabel();
        panelPoster = new javax.swing.JPanel();
        comboPeliculas = new javax.swing.JComboBox();
        panelInformacion = new javax.swing.JPanel();
        tituloPelicula = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinopsisPelicula = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        anoPelicula = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        duracionPelicula = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        clasificacionPelicula = new javax.swing.JLabel();
        fechaFuncion = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        seleccione = new javax.swing.JLabel();
        bienvenida = new javax.swing.JLabel();
        panelScroll = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelHorarios = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        menuCerrarSesion = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuManualUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(20, 0, 40, 40);

        nombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(nombreEmpleado);
        nombreEmpleado.setBounds(70, 0, 310, 40);

        cargoEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cargoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        cargoEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(cargoEmpleado);
        cargoEmpleado.setBounds(560, 0, 120, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 40);

        panelPoster.setBackground(new java.awt.Color(255, 255, 255));
        panelPoster.setLayout(null);
        jPanel1.add(panelPoster);
        panelPoster.setBounds(20, 110, 240, 260);

        comboPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboPeliculas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPeliculasItemStateChanged(evt);
            }
        });
        jPanel1.add(comboPeliculas);
        comboPeliculas.setBounds(40, 70, 200, 20);

        panelInformacion.setBackground(new java.awt.Color(255, 255, 255));
        panelInformacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelInformacion.setLayout(null);

        tituloPelicula.setFont(new java.awt.Font("Arial Nova Light", 1, 14)); // NOI18N
        tituloPelicula.setForeground(new java.awt.Color(0, 51, 153));
        tituloPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelInformacion.add(tituloPelicula);
        tituloPelicula.setBounds(10, 30, 360, 30);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sinopsis", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova Light", 1, 12))); // NOI18N

        sinopsisPelicula.setBorder(null);
        sinopsisPelicula.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(sinopsisPelicula);

        panelInformacion.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 360, 120);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(null);

        anoPelicula.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        anoPelicula.setForeground(new java.awt.Color(255, 255, 255));
        anoPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(anoPelicula);
        anoPelicula.setBounds(0, 0, 50, 20);

        panelInformacion.add(jPanel3);
        jPanel3.setBounds(310, 10, 50, 20);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(null);

        duracionPelicula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        duracionPelicula.setForeground(new java.awt.Color(255, 255, 255));
        duracionPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(duracionPelicula);
        duracionPelicula.setBounds(0, 0, 70, 20);

        panelInformacion.add(jPanel5);
        jPanel5.setBounds(230, 10, 70, 20);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(null);

        clasificacionPelicula.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        clasificacionPelicula.setForeground(new java.awt.Color(255, 255, 255));
        clasificacionPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(clasificacionPelicula);
        clasificacionPelicula.setBounds(0, 0, 40, 20);

        panelInformacion.add(jPanel4);
        jPanel4.setBounds(180, 10, 40, 20);

        jPanel1.add(panelInformacion);
        panelInformacion.setBounds(290, 110, 380, 190);

        fechaFuncion.setDateFormatString("yyyy/MM/dd");
        fechaFuncion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaFuncionPropertyChange(evt);
            }
        });
        jPanel1.add(fechaFuncion);
        fechaFuncion.setBounds(290, 60, 150, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cartelera:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 50, 240, 15);

        jPanel6.setBackground(new java.awt.Color(0, 32, 86));
        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 410, 700, 30);

        seleccione.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        seleccione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seleccione.setText("Seleccione una pelicula para continuar");
        jPanel1.add(seleccione);
        seleccione.setBounds(0, 210, 710, 30);

        bienvenida.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bienvenida.setForeground(new java.awt.Color(0, 102, 153));
        bienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenida.setText("Bienvenido!");
        jPanel1.add(bienvenida);
        bienvenida.setBounds(0, 180, 710, 30);

        panelScroll.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        panelHorarios.setBackground(new java.awt.Color(255, 255, 255));
        panelHorarios.setLayout(new java.awt.GridBagLayout());
        jScrollPane3.setViewportView(panelHorarios);

        panelScroll.addTab("Horarios", jScrollPane3);

        jPanel1.add(panelScroll);
        panelScroll.setBounds(290, 310, 380, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 440);

        menu1.setText("File");

        menuCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarSesion.png"))); // NOI18N
        menuCerrarSesion.setText("Cerrar sesion");
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        menu1.add(menuCerrarSesion);

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

        jMenu1.setText("Help");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuManualUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuManualUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ayuda.png"))); // NOI18N
        menuManualUsuario.setText("Manual de usuario");
        jMenu1.add(menuManualUsuario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 705, 484);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        VentanaInicioDeSesion vis = new VentanaInicioDeSesion();
        
        this.dispose();
        vis.setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void comboPeliculasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPeliculasItemStateChanged
        
        Date dt1 = new Date();
        long tmp1 = dt1.getTime();
        java.sql.Date fecha1 = new java.sql.Date(tmp1);
               
        panelPoster.removeAll();
        
        fechaFuncion.setDate(fecha1);        
        
        if(comboPeliculas.getSelectedItem() != "Selecciona")
        {
            panelPoster.removeAll();
            panelPoster.setVisible(true);
            panelInformacion.setVisible(true);
            panelScroll.setVisible(true);
            fechaFuncion.setVisible(true);
            bienvenida.setVisible(false);
            seleccione.setVisible(false);
            
            int id = cnbd.getConsultarPeliculas(comboPeliculas.getSelectedItem().toString());
            
            this.setPoster("SELECT Poster_PLC FROM peliculas WHERE ID_PLC = " + id);
            
            this.setInformacionPeliculas(id);
            
            setHorarios();
        }
        else
        {
            panelPoster.removeAll();
            panelPoster.repaint();
            
            panelPoster.setVisible(false);
            panelInformacion.setVisible(false); 
            panelScroll.setVisible(false);
            fechaFuncion.setVisible(false);
            
            bienvenida.setVisible(true);
            seleccione.setVisible(true);
        }
    }//GEN-LAST:event_comboPeliculasItemStateChanged

    private void fechaFuncionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaFuncionPropertyChange
        fechaFuncion.getDateEditor().addPropertyChangeListener(new PropertyChangeListener()
        { 
            int band = 3;
            public void propertyChange(PropertyChangeEvent e) 
            {   
                if(band == 3)
                {
                    if(fechaFuncion.getDate() != null)
                    {
                        Date dt = fechaFuncion.getDate();
                        long tmp = dt.getTime();
                        java.sql.Date fecha = new java.sql.Date(tmp);
                        
                        fch = fecha.toString();
                        
                        setHorarios();
                    }
                    band = 1;
                }
                else if(band == 1)
                    band = 2;
                else if(band == 2)
                    band = 0;
            }
        }
        );        
    }//GEN-LAST:event_fechaFuncionPropertyChange

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        try 
        {
            String url = ("src\\Manuales\\Manual de usuario-Cesar Julio Beltran.pdf");
            
            ProcessBuilder p = new ProcessBuilder();
            
            p.command("cmd.exe", "7c", url);
            
            p.start();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Manual de usuario", 2);
        }
    }//GEN-LAST:event_jMenu1ActionPerformed
       
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
            java.util.logging.Logger.getLogger(VentanaPrincipalCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalCajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoPelicula;
    private javax.swing.JLabel bienvenida;
    private javax.swing.JLabel cargoEmpleado;
    private javax.swing.JLabel clasificacionPelicula;
    private javax.swing.JComboBox comboPeliculas;
    private javax.swing.JLabel duracionPelicula;
    private com.toedter.calendar.JDateChooser fechaFuncion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JMenuItem menuManualUsuario;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JPanel panelHorarios;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelPoster;
    private javax.swing.JTabbedPane panelScroll;
    private javax.swing.JLabel seleccione;
    private javax.swing.JTextPane sinopsisPelicula;
    private javax.swing.JLabel tituloPelicula;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;
    private GetSetEmpleados gse;    
    private ConsultasBD cnbd;
    private String fch;   
}
