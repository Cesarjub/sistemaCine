package Cine;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaVerPeliculas extends javax.swing.JFrame {

    public VentanaVerPeliculas()
    {
        initComponents();
    }
    
    public VentanaVerPeliculas(GetSetEmpleados gse) 
    {
        initComponents();
        
        this.gse = gse;
        
        cnbd = new ConsultasBD();
        
        //
        this.setLocationRelativeTo(null); 
                
        this.panelMostrarPeliculas.setVisible(false);
        
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        editTitulo.setVisible(false);
        editAno.setVisible(false);
        editDuracion.setVisible(false);
        editClasificacion.setVisible(false);
        
        sinopsisPelicula.setEditable(false);
        
        comboPeliculas.addItem("Selecciona");        
        
        this.setLLenarComboPeliculas();           
        
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
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Nombre_PLC").toLowerCase());
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboPeliculas.addItem(lista.get(i));
    } 
    
    public void setMostrarPeliculas(int id)
    {
        panelPoster.removeAll();
        
        this.setPoster("SELECT Poster_PLC FROM peliculas WHERE ID_PLC = " + id);  
        
        ResultSet rs = cnbd.getConsultas("SELECT p.*, c.Tipo_CFC FROM peliculas p INNER JOIN clasificacion c ON p.ID_CFC = c.ID_CFC where ID_PLC = " + id);
               
        try 
        {
            
            if(rs.next())
            {
                idPelicula.setText(String.valueOf(rs.getInt("ID_PLC")));
                tituloPelicula.setText(rs.getString("Nombre_PLC"));
                clasificacionPelicula.setText(rs.getString("Tipo_CFC"));
                anoPelicula.setText(String.valueOf(rs.getInt("Ano_PLC")));
                duracionPelicula.setText(String.valueOf(rs.getInt("Duracion_PLC")));
                sinopsisPelicula.setText(rs.getString("Sinopsis_PLC"));   
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
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
    
    public void setLLenarComboClasificacion()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM clasificacion");
        
        editClasificacion.removeAllItems();
        
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
            editClasificacion.addItem(lista.get(i));
    }      
    
    public void setOcultarComponentes()
    {
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        tituloPelicula.setVisible(true);
        anoPelicula.setVisible(true);
        duracionPelicula.setVisible(true);
        clasificacionPelicula.setVisible(true);
        
        editTitulo.setVisible(false);
        editAno.setVisible(false);
        editDuracion.setVisible(false);
        editClasificacion.setVisible(false);
        
        sinopsisPelicula.setEditable(false);   
    }
    
    public void setRemoverItems()
    {
        for(int i = 0; i < comboPeliculas.getItemCount(); i++)
        {
            if(!comboPeliculas.getItemAt(i).equals("Selecciona"))
                comboPeliculas.removeItemAt(i);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        comboPeliculas = new javax.swing.JComboBox();
        textPeliculas = new javax.swing.JTextField();
        botonBuscarPeliculas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelMostrarPeliculas = new javax.swing.JPanel();
        panelPoster = new javax.swing.JPanel();
        tituloPelicula = new javax.swing.JLabel();
        anoPelicula = new javax.swing.JLabel();
        duracionPelicula = new javax.swing.JLabel();
        clasificacionPelicula = new javax.swing.JLabel();
        idPelicula = new javax.swing.JLabel();
        modificarPelicula = new javax.swing.JLabel();
        eliminarPelicula = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinopsisPelicula = new javax.swing.JTextPane();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        editAno = new com.toedter.calendar.JYearChooser();
        editDuracion = new com.toedter.components.JSpinField();
        editClasificacion = new javax.swing.JComboBox();
        editTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ver peliculas");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        comboPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboPeliculas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPeliculasItemStateChanged(evt);
            }
        });
        jPanel2.add(comboPeliculas);
        comboPeliculas.setBounds(20, 30, 190, 20);
        jPanel2.add(textPeliculas);
        textPeliculas.setBounds(260, 20, 170, 30);

        botonBuscarPeliculas.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscaar.png"))); // NOI18N
        botonBuscarPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarPeliculasMouseClicked(evt);
            }
        });
        jPanel2.add(botonBuscarPeliculas);
        botonBuscarPeliculas.setBounds(430, 20, 40, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Peliculas:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 0, 190, 29);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 40, 490, 70);

        panelMostrarPeliculas.setBackground(new java.awt.Color(255, 255, 255));
        panelMostrarPeliculas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelMostrarPeliculas.setLayout(null);

        panelPoster.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPosterLayout = new javax.swing.GroupLayout(panelPoster);
        panelPoster.setLayout(panelPosterLayout);
        panelPosterLayout.setHorizontalGroup(
            panelPosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        panelPosterLayout.setVerticalGroup(
            panelPosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        panelMostrarPeliculas.add(panelPoster);
        panelPoster.setBounds(20, 30, 120, 130);

        tituloPelicula.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tituloPelicula.setForeground(new java.awt.Color(0, 102, 153));
        panelMostrarPeliculas.add(tituloPelicula);
        tituloPelicula.setBounds(180, 20, 200, 30);

        anoPelicula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        anoPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelMostrarPeliculas.add(anoPelicula);
        anoPelicula.setBounds(200, 60, 50, 20);

        duracionPelicula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        duracionPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelMostrarPeliculas.add(duracionPelicula);
        duracionPelicula.setBounds(230, 90, 60, 20);

        clasificacionPelicula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clasificacionPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelMostrarPeliculas.add(clasificacionPelicula);
        clasificacionPelicula.setBounds(250, 120, 60, 20);

        idPelicula.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idPelicula.setForeground(new java.awt.Color(102, 102, 102));
        idPelicula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelMostrarPeliculas.add(idPelicula);
        idPelicula.setBounds(140, 20, 30, 30);

        modificarPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modificarPelicula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pencil.png"))); // NOI18N
        modificarPelicula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificarPelicula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarPeliculaMouseClicked(evt);
            }
        });
        panelMostrarPeliculas.add(modificarPelicula);
        modificarPelicula.setBounds(400, 10, 30, 40);

        eliminarPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarPelicula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminarPelicula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarPelicula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarPeliculaMouseClicked(evt);
            }
        });
        panelMostrarPeliculas.add(eliminarPelicula);
        eliminarPelicula.setBounds(440, 10, 30, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Año:");
        panelMostrarPeliculas.add(jLabel10);
        jLabel10.setBounds(160, 60, 40, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Duracion:");
        panelMostrarPeliculas.add(jLabel11);
        jLabel11.setBounds(160, 90, 70, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Clasificacion:");
        panelMostrarPeliculas.add(jLabel12);
        jLabel12.setBounds(160, 120, 90, 17);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sinopsis", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova Light", 1, 12))); // NOI18N

        sinopsisPelicula.setBorder(null);
        sinopsisPelicula.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(sinopsisPelicula);

        panelMostrarPeliculas.add(jScrollPane1);
        jScrollPane1.setBounds(130, 150, 340, 100);

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
        panelMostrarPeliculas.add(botonGuardar);
        botonGuardar.setBounds(330, 260, 100, 23);

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
        panelMostrarPeliculas.add(botonCancelar);
        botonCancelar.setBounds(60, 260, 100, 23);
        panelMostrarPeliculas.add(editAno);
        editAno.setBounds(200, 60, 70, 20);
        panelMostrarPeliculas.add(editDuracion);
        editDuracion.setBounds(230, 90, 60, 20);
        panelMostrarPeliculas.add(editClasificacion);
        editClasificacion.setBounds(250, 120, 110, 20);
        panelMostrarPeliculas.add(editTitulo);
        editTitulo.setBounds(180, 20, 180, 30);

        jPanel1.add(panelMostrarPeliculas);
        panelMostrarPeliculas.setBounds(10, 120, 490, 290);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Peliculas");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 490, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 440);

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

        setBounds(0, 0, 528, 483);
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarPeliculasMouseClicked
        String consulta = "SELECT COUNT(ID_PLC) FROM peliculas WHERE Nombre_PLC = '" + textPeliculas.getText() + "'";

        if(cnbd.getBuscar(consulta) == 1)
            comboPeliculas.setSelectedItem(textPeliculas.getText().toLowerCase());
        else
            JOptionPane.showMessageDialog(null,"Esta pelicula no se encuentra registrada","Busqueda", 0);
    }//GEN-LAST:event_botonBuscarPeliculasMouseClicked

    private void comboPeliculasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPeliculasItemStateChanged
        textPeliculas.setText(null);
        
        this.setOcultarComponentes();
        
        if(comboPeliculas.getSelectedItem() == "Selecciona")
            panelMostrarPeliculas.setVisible(false);
        else
        {
            this.setMostrarPeliculas(cnbd.getConsultarPeliculas(comboPeliculas.getSelectedItem().toString()));
            panelMostrarPeliculas.setVisible(true);
        }
    }//GEN-LAST:event_comboPeliculasItemStateChanged

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vps = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vps.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void modificarPeliculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarPeliculaMouseClicked
        botonGuardar.setVisible(true);
        botonCancelar.setVisible(true);
        
        tituloPelicula.setVisible(false);
        anoPelicula.setVisible(false);
        duracionPelicula.setVisible(false);
        clasificacionPelicula.setVisible(false);
        
        setLLenarComboClasificacion();
        
        editTitulo.setVisible(true);
        editAno.setVisible(true);
        editDuracion.setVisible(true);
        editClasificacion.setVisible(true);

        sinopsisPelicula.setEditable(true);
        
        editTitulo.setText(tituloPelicula.getText());
        editAno.setValue(Integer.parseInt(anoPelicula.getText()));
        editDuracion.setValue(Integer.parseInt(duracionPelicula.getText()));
        editClasificacion.setSelectedItem(clasificacionPelicula.getText());
        
    }//GEN-LAST:event_modificarPeliculaMouseClicked

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        this.setOcultarComponentes();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked

        if(!editTitulo.getText().equals("") && !sinopsisPelicula.getText().equals("") && editAno.getValue() != 0 && editDuracion.getValue() != 0)
        {
            String consulta = "SELECT COUNT(ID_PLC) FROM peliculas WHERE Nombre_PLC = '" + tituloPelicula.getText() + "' AND ID_PLC != " + idPelicula.getText();
            
            if(cnbd.getBuscar(consulta) == 0)
            {  
                GetSetPeliculas gsp = new GetSetPeliculas();
                
                int cl = editClasificacion.getSelectedIndex() + 1;
                
                gsp.setId(Integer.parseInt(idPelicula.getText()));
                gsp.setTitulo(editTitulo.getText().trim());
                gsp.setAno(editAno.getValue());
                gsp.setDuracion(editDuracion.getValue());
                gsp.setSinopsis(sinopsisPelicula.getText());
                gsp.setClasificacion(cl);
                
                if(cnbd.getModificarPeliculas(gsp))
                {
                    this.setOcultarComponentes();
                    
                    comboPeliculas.setSelectedItem("Selecciona");

                    this.setRemoverItems();

                    if(comboPeliculas.getItemCount() == 1 || comboPeliculas.getItemCount() > 1)
                        this.setRemoverItems();

                    if(comboPeliculas.getItemCount() == 1 || comboPeliculas.getItemCount() > 1)
                        this.setRemoverItems();

                    if(comboPeliculas.getItemCount() == 1 || comboPeliculas.getItemCount() > 1)
                        this.setRemoverItems();
                    
                    this.setLLenarComboPeliculas();
                    
                    JOptionPane.showMessageDialog(null,"La pelicula ha sido modificada","Pelicula modificada", 1);
                }
                else
                    JOptionPane.showMessageDialog(null,"No se ha podido modificar la pelicula","Modificar peliculas", 2);
            }  
            else
                JOptionPane.showMessageDialog(null,"Esta pelicula ya esta registrada","Pelicula ya rehistrada", 2);  
        }
        else
           JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos","Modificar pelicula", 2);
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void eliminarPeliculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarPeliculaMouseClicked
        int op = 0; 
        boolean band = false;
       
        ArrayList<Integer> lista = new ArrayList <Integer>();  
        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT f.ID_FNC FROM funciones f INNER JOIN peliculas p ON f.ID_PLC = p.ID_PLC WHERE p.ID_PLC = " + idPelicula.getText().trim());
               
        try 
        {
            
            while(rs.next())
            {
                lista.add(rs.getInt("ID_FNC"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
        }                 
        
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println(lista.get(i));
            
            cnbd.getEliminar("DELETE FROM asientos where ID_FNC = " + lista.get(i));
        } 
        
        op = JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar la pelicula " + tituloPelicula.getText() + "?", "Eliminar", JOptionPane.YES_NO_OPTION);
           
        if(op == JOptionPane.YES_OPTION)
        {
            /*if(band)
            {*/
                if(cnbd.getEliminar("DELETE FROM funciones WHERE ID_PLC = " + idPelicula.getText().trim()))
                {                
                    if(cnbd.getEliminar("DELETE FROM peliculas WHERE ID_PLC = " + idPelicula.getText().trim()))
                    {
                        this.setOcultarComponentes();
                    
                        comboPeliculas.setSelectedItem("Selecciona");

                        this.setRemoverItems();

                        if(comboPeliculas.getItemCount() == 1 || comboPeliculas.getItemCount() > 1)
                            this.setRemoverItems();

                        if(comboPeliculas.getItemCount() == 1 || comboPeliculas.getItemCount() > 1)
                            this.setRemoverItems();

                        if(comboPeliculas.getItemCount() == 1 || comboPeliculas.getItemCount() > 1)
                            this.setRemoverItems();
                    
                        this.setLLenarComboPeliculas();                        
                        
                        JOptionPane.showMessageDialog(null,tituloPelicula.getText() + " ha sido eliminada","Pelicula eliminada", 1);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"No se ha podido eliminar la funcion","Eliminar funcion", 2);                
            /*}
            else
                JOptionPane.showMessageDialog(null,"No se ha podido eliminar los asientos","Eliminar funcion", 2); */
        }
    }//GEN-LAST:event_eliminarPeliculaMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaVerPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVerPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVerPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVerPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVerPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoPelicula;
    private javax.swing.JButton botonBuscarPeliculas;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel clasificacionPelicula;
    private javax.swing.JComboBox comboPeliculas;
    private javax.swing.JLabel duracionPelicula;
    private com.toedter.calendar.JYearChooser editAno;
    private javax.swing.JComboBox editClasificacion;
    private com.toedter.components.JSpinField editDuracion;
    private javax.swing.JTextField editTitulo;
    private javax.swing.JLabel eliminarPelicula;
    private javax.swing.JLabel idPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel modificarPelicula;
    private javax.swing.JPanel panelMostrarPeliculas;
    private javax.swing.JPanel panelPoster;
    private javax.swing.JTextPane sinopsisPelicula;
    private javax.swing.JTextField textPeliculas;
    private javax.swing.JLabel tituloPelicula;
    // End of variables declaration//GEN-END:variables
    private GetSetEmpleados gse;    
    private ConsultasBD cnbd;
}
