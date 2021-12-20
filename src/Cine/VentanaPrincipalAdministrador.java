package Cine;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class VentanaPrincipalAdministrador extends javax.swing.JFrame {
    
    public VentanaPrincipalAdministrador() 
    {
        initComponents(); 
    }

    public VentanaPrincipalAdministrador(GetSetEmpleados gse)
    {
        initComponents();
             
        this.gse = gse;
 
        this.setLocationRelativeTo(null);         
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint();         
        
        nombreEmpleado.setText("Hola, " + gse.getNombre() + " !");
        cargoEmpleado.setText(gse.getNombreCargo());
       
        botonReporte1.setVisible(false);
        botonReporte2.setVisible(false);
        botonReporte3.setVisible(false);
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        botonReporteBoletos = new javax.swing.JButton();
        botonVerVentas = new javax.swing.JButton();
        botonRegistrarEmpleados = new javax.swing.JButton();
        botonVerEmpleados = new javax.swing.JButton();
        botonReporte1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        botonRegistrarPeliculas = new javax.swing.JButton();
        botonVerPeliculas = new javax.swing.JButton();
        botonReporte2 = new javax.swing.JButton();
        botonRegistrarFunciones = new javax.swing.JButton();
        botonVerFunciones = new javax.swing.JButton();
        botonReporte3 = new javax.swing.JButton();
        botonRegistrarPrecio = new javax.swing.JButton();
        botonVerPreciosBoletos = new javax.swing.JButton();
        botonRegistrarSalas = new javax.swing.JButton();
        botonVerSalas = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cargoEmpleado = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        menuCerrarSesion = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuManualUsuario = new javax.swing.JMenuItem();
        menuManualTecnico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

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

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 370, 700, 30);

        botonReporteBoletos.setBackground(new java.awt.Color(153, 153, 153));
        botonReporteBoletos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/documento.png"))); // NOI18N
        botonReporteBoletos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReporteBoletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonReporteBoletosMouseClicked(evt);
            }
        });
        jPanel1.add(botonReporteBoletos);
        botonReporteBoletos.setBounds(170, 70, 50, 40);

        botonVerVentas.setBackground(new java.awt.Color(153, 153, 153));
        botonVerVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        botonVerVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerVentasMouseClicked(evt);
            }
        });
        jPanel1.add(botonVerVentas);
        botonVerVentas.setBounds(110, 70, 50, 40);

        botonRegistrarEmpleados.setBackground(new java.awt.Color(74, 162, 191));
        botonRegistrarEmpleados.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        botonRegistrarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        botonRegistrarEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarEmpleadosMouseClicked(evt);
            }
        });
        jPanel1.add(botonRegistrarEmpleados);
        botonRegistrarEmpleados.setBounds(50, 170, 50, 40);

        botonVerEmpleados.setBackground(new java.awt.Color(74, 162, 191));
        botonVerEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        botonVerEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerEmpleadosMouseClicked(evt);
            }
        });
        jPanel1.add(botonVerEmpleados);
        botonVerEmpleados.setBounds(110, 170, 50, 40);

        botonReporte1.setBackground(new java.awt.Color(74, 162, 191));
        botonReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/documento.png"))); // NOI18N
        botonReporte1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(botonReporte1);
        botonReporte1.setBounds(170, 170, 50, 40);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salaas.png"))); // NOI18N
        jPanel10.add(jLabel11);
        jLabel11.setBounds(0, 0, 40, 40);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Salas");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(40, 0, 120, 40);

        jPanel1.add(jPanel10);
        jPanel10.setBounds(280, 220, 180, 40);

        botonRegistrarPeliculas.setBackground(new java.awt.Color(245, 186, 99));
        botonRegistrarPeliculas.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        botonRegistrarPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        botonRegistrarPeliculas.setBorder(null);
        botonRegistrarPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarPeliculasMouseClicked(evt);
            }
        });
        jPanel1.add(botonRegistrarPeliculas);
        botonRegistrarPeliculas.setBounds(50, 270, 50, 40);

        botonVerPeliculas.setBackground(new java.awt.Color(245, 186, 99));
        botonVerPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        botonVerPeliculas.setBorder(null);
        botonVerPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerPeliculasMouseClicked(evt);
            }
        });
        jPanel1.add(botonVerPeliculas);
        botonVerPeliculas.setBounds(110, 270, 50, 40);

        botonReporte2.setBackground(new java.awt.Color(245, 186, 99));
        botonReporte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/documento.png"))); // NOI18N
        botonReporte2.setBorder(null);
        botonReporte2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(botonReporte2);
        botonReporte2.setBounds(170, 270, 50, 40);

        botonRegistrarFunciones.setBackground(new java.awt.Color(216, 74, 74));
        botonRegistrarFunciones.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        botonRegistrarFunciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        botonRegistrarFunciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarFunciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarFuncionesMouseClicked(evt);
            }
        });
        jPanel1.add(botonRegistrarFunciones);
        botonRegistrarFunciones.setBounds(280, 70, 50, 40);

        botonVerFunciones.setBackground(new java.awt.Color(216, 74, 74));
        botonVerFunciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        botonVerFunciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerFunciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerFuncionesMouseClicked(evt);
            }
        });
        jPanel1.add(botonVerFunciones);
        botonVerFunciones.setBounds(340, 70, 50, 40);

        botonReporte3.setBackground(new java.awt.Color(216, 74, 74));
        botonReporte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/documento.png"))); // NOI18N
        botonReporte3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(botonReporte3);
        botonReporte3.setBounds(400, 70, 50, 40);

        botonRegistrarPrecio.setBackground(new java.awt.Color(200, 200, 87));
        botonRegistrarPrecio.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        botonRegistrarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        botonRegistrarPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarPrecioMouseClicked(evt);
            }
        });
        jPanel1.add(botonRegistrarPrecio);
        botonRegistrarPrecio.setBounds(280, 170, 50, 40);

        botonVerPreciosBoletos.setBackground(new java.awt.Color(200, 200, 87));
        botonVerPreciosBoletos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        botonVerPreciosBoletos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerPreciosBoletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerPreciosBoletosMouseClicked(evt);
            }
        });
        jPanel1.add(botonVerPreciosBoletos);
        botonVerPreciosBoletos.setBounds(340, 170, 50, 40);

        botonRegistrarSalas.setBackground(new java.awt.Color(131, 218, 131));
        botonRegistrarSalas.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        botonRegistrarSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        botonRegistrarSalas.setToolTipText("");
        botonRegistrarSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarSalasMouseClicked(evt);
            }
        });
        jPanel1.add(botonRegistrarSalas);
        botonRegistrarSalas.setBounds(280, 270, 50, 40);

        botonVerSalas.setBackground(new java.awt.Color(131, 218, 131));
        botonVerSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        botonVerSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerSalasMouseClicked(evt);
            }
        });
        jPanel1.add(botonVerSalas);
        botonVerSalas.setBounds(340, 270, 50, 40);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(280, 160, 180, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(280, 60, 180, 10);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(50, 60, 180, 10);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(50, 160, 180, 10);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(50, 260, 180, 10);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(280, 260, 180, 10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boletos.png"))); // NOI18N
        jPanel11.add(jLabel13);
        jLabel13.setBounds(0, 0, 40, 40);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Boletos vendidos");
        jPanel11.add(jLabel14);
        jLabel14.setBounds(40, 0, 110, 40);

        jPanel1.add(jPanel11);
        jPanel11.setBounds(50, 20, 180, 40);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(null);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleadoos.png"))); // NOI18N
        jPanel12.add(jLabel15);
        jLabel15.setBounds(0, 0, 40, 40);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Empleados");
        jPanel12.add(jLabel16);
        jLabel16.setBounds(40, 0, 110, 40);

        jPanel1.add(jPanel12);
        jPanel12.setBounds(50, 120, 180, 40);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(null);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peliculaas.png"))); // NOI18N
        jPanel13.add(jLabel17);
        jLabel17.setBounds(0, 0, 40, 40);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Peliculas");
        jPanel13.add(jLabel18);
        jLabel18.setBounds(40, 0, 110, 40);

        jPanel1.add(jPanel13);
        jPanel13.setBounds(50, 220, 180, 40);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(null);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/funciiones.png"))); // NOI18N
        jPanel14.add(jLabel19);
        jLabel19.setBounds(0, 0, 40, 40);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Funciones");
        jPanel14.add(jLabel20);
        jLabel20.setBounds(40, 0, 110, 40);

        jPanel1.add(jPanel14);
        jPanel14.setBounds(280, 20, 180, 40);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(null);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/precioos.png"))); // NOI18N
        jPanel15.add(jLabel21);
        jLabel21.setBounds(0, 0, 40, 40);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Precios de boletos");
        jPanel15.add(jLabel22);
        jLabel22.setBounds(40, 0, 120, 40);

        jPanel1.add(jPanel15);
        jPanel15.setBounds(280, 120, 180, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 710, 410);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        cargoEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cargoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        cargoEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(cargoEmpleado);
        cargoEmpleado.setBounds(560, 0, 110, 40);

        nombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(nombreEmpleado);
        nombreEmpleado.setBounds(70, 0, 300, 40);

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(20, 0, 40, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 40);

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

        menuManualUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuManualUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ayuda.png"))); // NOI18N
        menuManualUsuario.setText("Manual de usuario");
        menuManualUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManualUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuManualUsuario);

        menuManualTecnico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuManualTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tecnico.png"))); // NOI18N
        menuManualTecnico.setText("Manual tecnico");
        menuManualTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManualTecnicoActionPerformed(evt);
            }
        });
        jMenu1.add(menuManualTecnico);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 705, 484);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        VentanaInicioDeSesion vis = new VentanaInicioDeSesion();
        
        this.dispose();
        vis.setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void botonRegistrarSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarSalasMouseClicked
        VentanaRegistroSalas vrs = new VentanaRegistroSalas(gse);

        this.dispose();
        vrs.setVisible(true);
    }//GEN-LAST:event_botonRegistrarSalasMouseClicked

    private void botonRegistrarPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarPrecioMouseClicked
        VentanaRegistroPrecio vrp = new VentanaRegistroPrecio(gse);

        this.dispose();
        vrp.setVisible(true);
    }//GEN-LAST:event_botonRegistrarPrecioMouseClicked

    private void botonRegistrarFuncionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarFuncionesMouseClicked
        VentanaRegistroFunciones vrf = new VentanaRegistroFunciones(gse);

        this.dispose();
        vrf.setVisible(true);
    }//GEN-LAST:event_botonRegistrarFuncionesMouseClicked

    private void botonRegistrarPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarPeliculasMouseClicked
        VentanaRegistroPeliculas vrp = new VentanaRegistroPeliculas(gse);

        this.dispose();
        vrp.setVisible(true);
    }//GEN-LAST:event_botonRegistrarPeliculasMouseClicked

    private void botonRegistrarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarEmpleadosMouseClicked
        VentanaRegistroEmpleados vre = new VentanaRegistroEmpleados(gse);

        this.dispose();
        vre.setVisible(true);
    }//GEN-LAST:event_botonRegistrarEmpleadosMouseClicked

    private void botonVerPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerPeliculasMouseClicked
        VentanaVerPeliculas vvp = new VentanaVerPeliculas(gse);
        
        this.dispose();
        vvp.setVisible(true);
    }//GEN-LAST:event_botonVerPeliculasMouseClicked

    private void botonVerEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerEmpleadosMouseClicked
        VentanaVerEmpleados vve = new VentanaVerEmpleados(gse);
        
        this.dispose();
        vve.setVisible(true);
    }//GEN-LAST:event_botonVerEmpleadosMouseClicked

    private void botonVerPreciosBoletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerPreciosBoletosMouseClicked
        VentanaVerPrecios vvps = new VentanaVerPrecios(gse);
        
        this.dispose();
        vvps.setVisible(true);
    }//GEN-LAST:event_botonVerPreciosBoletosMouseClicked

    private void botonVerSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerSalasMouseClicked
        VentanaVerSalas vvs = new VentanaVerSalas(gse);
        
        this.dispose();
        vvs.setVisible(true);
    }//GEN-LAST:event_botonVerSalasMouseClicked

    private void botonVerVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerVentasMouseClicked
        VentanaVerVentas vvv = new VentanaVerVentas(gse);
        
        this.dispose();
        vvv.setVisible(true);
    }//GEN-LAST:event_botonVerVentasMouseClicked

    private void botonVerFuncionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerFuncionesMouseClicked
        VentanaVerFunciones vvf = new VentanaVerFunciones(gse);
        
        this.dispose();
        vvf.setVisible(true);
    }//GEN-LAST:event_botonVerFuncionesMouseClicked

    private void botonReporteBoletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReporteBoletosMouseClicked
        try 
        {
           ConexionBD cnbd = new ConexionBD(); 
            
            JasperReport reporte = null;
            
            String path = "src\\Reportes\\reporteVentas.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jPrint = JasperFillManager.fillReport(path, null, cnbd.getConectar());
            
            JasperViewer view = new JasperViewer(jPrint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
        } 
        catch (JRException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Reporte generado", 2);
        }
    }//GEN-LAST:event_botonReporteBoletosMouseClicked

    private void menuManualUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManualUsuarioActionPerformed
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
    }//GEN-LAST:event_menuManualUsuarioActionPerformed

    private void menuManualTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManualTecnicoActionPerformed
        try 
        {
            String url = ("src\\Manuales\\Manual tecnico-Cesar Julio Beltran.pdf");
            
            ProcessBuilder p = new ProcessBuilder();
            
            p.command("cmd.exe", "7c", url);
            
            p.start();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Manual de usuario", 2);
        }
    }//GEN-LAST:event_menuManualTecnicoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarEmpleados;
    private javax.swing.JButton botonRegistrarFunciones;
    private javax.swing.JButton botonRegistrarPeliculas;
    private javax.swing.JButton botonRegistrarPrecio;
    private javax.swing.JButton botonRegistrarSalas;
    private javax.swing.JButton botonReporte1;
    private javax.swing.JButton botonReporte2;
    private javax.swing.JButton botonReporte3;
    private javax.swing.JButton botonReporteBoletos;
    private javax.swing.JButton botonVerEmpleados;
    private javax.swing.JButton botonVerFunciones;
    private javax.swing.JButton botonVerPeliculas;
    private javax.swing.JButton botonVerPreciosBoletos;
    private javax.swing.JButton botonVerSalas;
    private javax.swing.JButton botonVerVentas;
    private javax.swing.JLabel cargoEmpleado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JMenuItem menuManualTecnico;
    private javax.swing.JMenuItem menuManualUsuario;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel nombreEmpleado;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;
    private GetSetEmpleados gse;    

    private void ProcessBuilder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
