package Cine;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

public class VentanaComprar extends javax.swing.JFrame {

    public VentanaComprar() 
    {
        initComponents();
    }

    public VentanaComprar(GetSetEmpleados gse, int idFn, int idPl, ArrayList lista, float precio, int totAsnt) 
    {
        initComponents();
        
        this.gse = gse;
        this.lista = lista;
        this.idPl = idPl;
        this.idFn = idFn;
        this.precio = precio;
        this.totAsnt = totAsnt;
        
        //
        this.setLocationRelativeTo(null);         
        
        cnbd = new ConsultasBD();
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint();      
        
        this.setAsientos();
        this.setPoster("SELECT Poster_PLC FROM peliculas WHERE ID_PLC = " + idPl);
        this.setInformacionPeliculas(idPl);
        this.setInformacionFuncion(idFn);
        
        precioTotal.setEditable(false);
        
        precioTotal.setText(String.valueOf(precio));
                
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
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
    
    public void setInformacionPeliculas(int idP)
    {
        ResultSet rs = cnbd.getConsultas("SELECT p.*, c.Tipo_CFC FROM peliculas p INNER JOIN clasificacion c ON p.ID_CFC = c.ID_CFC where ID_PLC = " + idP);
               
        try 
        {
            
            if(rs.next())
            {
                tituloPelicula.setText(rs.getString("Nombre_PLC"));
                clasificacionPelicula.setText("Clasificacion: " + rs.getString("Tipo_CFC"));
                anoPelicula.setText("Año: " + String.valueOf(rs.getInt("Ano_PLC")));
                duracionPelicula.setText("Duracion: " + String.valueOf(rs.getInt("Duracion_PLC")) + " min."); 
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
        } 
    }
    
    public void setInformacionFuncion(int idF)
    {
        int sala = 0;
        String dia = "", hora = "";
        
        ResultSet rs = cnbd.getConsultas("SELECT Dia_FNC, Hora_FNC FROM  funciones WHERE ID_FNC = " + idF);
               
        try 
        {
            
            if(rs.next())
            {
                dia = rs.getString("Dia_FNC");
                hora = rs.getString("Hora_FNC");
            }

            ResultSet rs2 = cnbd.getConsultas("SELECT sl.ID_SL, sl.Numero_SL FROM funciones fc INNER JOIN salas sl ON fc.ID_SL = sl.ID_SL WHERE fc.ID_FNC = " + idF); 
            
            if(rs2.next())
                sala = rs2.getInt("Numero_SL"); 

        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
        }  
        
        numeroSala.setText("" + sala);
        diaFuncion.setText(dia);
        horaFuncion.setText(hora);  
        cantidadPersona.setText(" " + totAsnt);
    }
    
    public void setAsientos()
    {
        String numAsn = "";
        
        for(int i = 0; i < lista.size(); i++)
            numAsn += lista.get(i) + ", ";
                    
        asientos.setText(numAsn);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelPoster = new javax.swing.JPanel();
        tituloPelicula = new javax.swing.JLabel();
        clasificacionPelicula = new javax.swing.JLabel();
        duracionPelicula = new javax.swing.JLabel();
        numeroSala = new javax.swing.JLabel();
        diaFuncion = new javax.swing.JLabel();
        horaFuncion = new javax.swing.JLabel();
        asientos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textPago = new javax.swing.JTextField();
        botonComprar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        anoPelicula = new javax.swing.JLabel();
        precioTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidadPersona = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmar compra");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        panelPoster.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPosterLayout = new javax.swing.GroupLayout(panelPoster);
        panelPoster.setLayout(panelPosterLayout);
        panelPosterLayout.setHorizontalGroup(
            panelPosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        panelPosterLayout.setVerticalGroup(
            panelPosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(panelPoster);
        panelPoster.setBounds(20, 120, 130, 140);

        tituloPelicula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tituloPelicula.setForeground(new java.awt.Color(0, 0, 102));
        tituloPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(tituloPelicula);
        tituloPelicula.setBounds(170, 120, 160, 20);

        clasificacionPelicula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(clasificacionPelicula);
        clasificacionPelicula.setBounds(170, 210, 150, 20);

        duracionPelicula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(duracionPelicula);
        duracionPelicula.setBounds(170, 180, 120, 20);

        numeroSala.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        numeroSala.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(numeroSala);
        numeroSala.setBounds(360, 30, 30, 20);

        diaFuncion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        diaFuncion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(diaFuncion);
        diaFuncion.setBounds(70, 30, 90, 20);

        horaFuncion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        horaFuncion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(horaFuncion);
        horaFuncion.setBounds(220, 30, 70, 20);

        asientos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jPanel1.add(asientos);
        asientos.setBounds(500, 30, 190, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total:  $");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(370, 160, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Pago:  $");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(370, 210, 70, 30);

        textPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPagoKeyTyped(evt);
            }
        });
        jPanel1.add(textPago);
        textPago.setBounds(450, 210, 120, 30);

        botonComprar.setBackground(new java.awt.Color(0, 51, 102));
        botonComprar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonComprar.setForeground(new java.awt.Color(255, 255, 255));
        botonComprar.setText("Comprar");
        botonComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonComprarMouseClicked(evt);
            }
        });
        jPanel1.add(botonComprar);
        botonComprar.setBounds(300, 310, 120, 23);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Nombre:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(370, 110, 70, 30);
        jPanel1.add(textNombre);
        textNombre.setBounds(450, 110, 160, 30);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salaCina.png"))); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(310, 20, 40, 40);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/asiento.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(460, 20, 40, 40);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario.png"))); // NOI18N
        jPanel1.add(jLabel15);
        jLabel15.setBounds(20, 20, 40, 40);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reloj.png"))); // NOI18N
        jPanel1.add(jLabel16);
        jLabel16.setBounds(170, 20, 40, 40);

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

        anoPelicula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        anoPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(anoPelicula);
        anoPelicula.setBounds(170, 150, 120, 20);
        jPanel1.add(precioTotal);
        precioTotal.setBounds(450, 160, 120, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cantidad.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(390, 20, 40, 40);

        cantidadPersona.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jPanel1.add(cantidadPersona);
        cantidadPersona.setBounds(430, 20, 30, 40);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 70, 670, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 700, 410);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Confirmar compra");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 0, 160, 40);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(630, 0, 40, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 40);

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

    private void textPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPagoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && textPago.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_textPagoKeyTyped

    private void botonComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComprarMouseClicked
        if(!textNombre.getText().equals("") && !textPago.getText().equals(""))
        {
            float pago = Float.parseFloat(textPago.getText());
            float total = Float.parseFloat(precioTotal.getText());
        
            int idBlt = cnbd.getGenerarId("SELECT MAX(ID_BLT) FROM boletos");
            int idCl = cnbd.getGenerarId("SELECT MAX(ID_CL) FROM clientes"); 
        
            java.util.Date fecha = new java.util.Date();
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
            if(pago >= total)
            {
                GetSetBoletos gsb = new GetSetBoletos();
                
                gsb.setIdBl(idBlt);
                gsb.setIdCl(idCl);
                gsb.setNombrePelicula(tituloPelicula.getText());
                gsb.setNombreCl(textNombre.getText().trim());
                gsb.setVendedor(gse.getNombre() + " " + gse.getApellido());
                gsb.setFechaCmp(formato.format(fecha));
                gsb.setNumSala(Integer.parseInt(numeroSala.getText().trim()));
                gsb.setCantBl(Integer.parseInt(cantidadPersona.getText().trim()));
                gsb.setAsientos(asientos.getText().trim());
                gsb.setDia(diaFuncion.getText().trim());
                gsb.setHora(horaFuncion.getText().trim());
                gsb.setTotalBl(Float.parseFloat(precioTotal.getText().trim()));
                
                if(cnbd.getRegistrarClientes(gsb))
                {
                    if(cnbd.getRegistrarBoletos(gsb))
                    {
                        GetSetAsientos gsa = new GetSetAsientos();
                        
                        boolean band = false;
                        
                        for(int i = 0; i < lista.size(); i++)
                        {
                            gsa.setIdCl(idCl);
                            gsa.setIdFuncion(idFn);                            
                            gsa.setNumAsiento(Integer.parseInt(lista.get(i).toString()));
                            
                            if(cnbd.getModificarAsientos(gsa))
                                band = true;
                            else
                                band = false;
                        }
                        
                        MetodosCine mc = new MetodosCine();

                        float cambio = mc.getObtenerCambio(pago, total);
                        
                        if(band)
                        {
                            VentanaBoletoCompra vbc = new VentanaBoletoCompra(gse, cambio, gsb.getIdBl());

                            JOptionPane.showMessageDialog(null,"Se ha realizado la compra","Boleto comprado", 1);
                            
                            this.dispose();
                                                        
                            vbc.setVisible(true);                          
                        }
                        else
                         JOptionPane.showMessageDialog(null,"No se ha podido guardar el asiento","Error en la compra", 2);     
                    }
                    else
                        JOptionPane.showMessageDialog(null,"No se ha podido realizar la compra","Error en la compra", 2);  
                }
                else
                   JOptionPane.showMessageDialog(null,"No se ha podido guardar el cliente","Error en la compra", 2);                
            }
            else
               JOptionPane.showMessageDialog(null,"La cantidad pagada es incorrecta","Pago incorrecto", 0);   
        }
        else
            JOptionPane.showMessageDialog(null,"Los campos ingresados son incorrectos","Campos incorrectos", 2);  
    }//GEN-LAST:event_botonComprarMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaComprar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoPelicula;
    private javax.swing.JLabel asientos;
    private javax.swing.JButton botonComprar;
    private javax.swing.JLabel cantidadPersona;
    private javax.swing.JLabel clasificacionPelicula;
    private javax.swing.JLabel diaFuncion;
    private javax.swing.JLabel duracionPelicula;
    private javax.swing.JLabel horaFuncion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel numeroSala;
    private javax.swing.JPanel panelPoster;
    private javax.swing.JTextField precioTotal;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPago;
    private javax.swing.JLabel tituloPelicula;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;    
    private ArrayList lista = new ArrayList <Integer>();
    private GetSetEmpleados gse;
    private ConsultasBD cnbd;
    private int idPl, idFn, totAsnt;
    private float precio;
}
