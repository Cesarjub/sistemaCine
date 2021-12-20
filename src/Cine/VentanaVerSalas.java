package Cine;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class VentanaVerSalas extends javax.swing.JFrame {

    public VentanaVerSalas() 
    {
        initComponents();
    }
    
    public VentanaVerSalas(GetSetEmpleados gse) 
    {
        initComponents();
        
        this.gse = gse;
        
        cnbd = new ConsultasBD();
        
        //
        this.setLocationRelativeTo(null);
        
        comboSalas.addItem("Selecciona");        
        
        setLLenarComboSalas();
        
        panelMostrarSala.setVisible(false);
        
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        editNumSala.setVisible(false);
        editCapacidadSala.setVisible(false);
        editTipoSala.setVisible(false);
        
       //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }    
    
    public void setLLenarComboSalas()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM salas");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Numero_SL").toLowerCase());
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboSalas.addItem(lista.get(i));
    }    
    
    public void setInfoSala(int numSl)
    {
        ResultSet rs = cnbd.getConsultas("SELECT s.*, t.Tipo_TSL FROM salas s INNER JOIN tipo_sala t ON s.ID_TSL = t.ID_TSL WHERE Numero_SL = " + numSl);
               
        try 
        {
            
            if(rs.next())
            {
                idSala.setText(String.valueOf(rs.getInt("ID_SL")));
                numSala.setText(String.valueOf(rs.getInt("Numero_SL")));
                capacidadSala.setText(String.valueOf(rs.getInt("Capacidad_SL")));
                tipoSala.setText(rs.getString("Tipo_TSL"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
        }         
    }
    
    public void setComboTipoSala()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM tipo_sala");

        editTipoSala.removeAllItems();
        
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
            editTipoSala.addItem(lista.get(i));        
    }   
    
    public void setOcultarComponentes()
    {
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        editNumSala.setVisible(false);
        editCapacidadSala.setVisible(false);
        editTipoSala.setVisible(false);
        
        numSala.setVisible(true);
        capacidadSala.setVisible(true);
        tipoSala.setVisible(true);           
    }
    
    public void setRemoverItems()
    {
        for(int i = 0; i < comboSalas.getItemCount(); i++)
        {
            if(!comboSalas.getItemAt(i).equals("Selecciona"))
                comboSalas.removeItemAt(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboSalas = new javax.swing.JComboBox();
        textSalas = new javax.swing.JTextField();
        botonBuscarSalas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelMostrarSala = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        numSala = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        capacidadSala = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tipoSala = new javax.swing.JLabel();
        editarSalas = new javax.swing.JLabel();
        eliminarSalas = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        idSala = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        editNumSala = new javax.swing.JTextField();
        editCapacidadSala = new javax.swing.JComboBox();
        editTipoSala = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ver salas de cine");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Salas");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 450, 22);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        comboSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSalas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSalasItemStateChanged(evt);
            }
        });
        jPanel2.add(comboSalas);
        comboSalas.setBounds(20, 30, 160, 20);

        textSalas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSalasKeyTyped(evt);
            }
        });
        jPanel2.add(textSalas);
        textSalas.setBounds(250, 20, 120, 30);

        botonBuscarSalas.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscaar.png"))); // NOI18N
        botonBuscarSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarSalasMouseClicked(evt);
            }
        });
        jPanel2.add(botonBuscarSalas);
        botonBuscarSalas.setBounds(370, 20, 40, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Num. de sala:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 0, 160, 29);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 40, 430, 70);

        panelMostrarSala.setBackground(new java.awt.Color(255, 255, 255));
        panelMostrarSala.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelMostrarSala.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Num. sala:");
        panelMostrarSala.add(jLabel2);
        jLabel2.setBounds(150, 40, 90, 30);

        numSala.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        panelMostrarSala.add(numSala);
        numSala.setBounds(250, 40, 80, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Capacidad:");
        panelMostrarSala.add(jLabel5);
        jLabel5.setBounds(150, 90, 90, 30);

        capacidadSala.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        panelMostrarSala.add(capacidadSala);
        capacidadSala.setBounds(250, 90, 80, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tipo de sala:");
        panelMostrarSala.add(jLabel7);
        jLabel7.setBounds(130, 140, 110, 30);

        tipoSala.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        panelMostrarSala.add(tipoSala);
        tipoSala.setBounds(250, 140, 130, 30);

        editarSalas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pencil.png"))); // NOI18N
        editarSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarSalasMouseClicked(evt);
            }
        });
        panelMostrarSala.add(editarSalas);
        editarSalas.setBounds(340, 10, 30, 40);

        eliminarSalas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminarSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarSalasMouseClicked(evt);
            }
        });
        panelMostrarSala.add(eliminarSalas);
        eliminarSalas.setBounds(380, 10, 30, 40);

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
        panelMostrarSala.add(botonGuardar);
        botonGuardar.setBounds(270, 190, 90, 23);

        idSala.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        idSala.setForeground(new java.awt.Color(255, 255, 255));
        idSala.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idSala.setText("1");
        panelMostrarSala.add(idSala);
        idSala.setBounds(10, 10, 30, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/asientoCine.png"))); // NOI18N
        panelMostrarSala.add(jLabel4);
        jLabel4.setBounds(30, 70, 90, 80);

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
        panelMostrarSala.add(botonCancelar);
        botonCancelar.setBounds(80, 190, 90, 23);

        editNumSala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editNumSalaKeyTyped(evt);
            }
        });
        panelMostrarSala.add(editNumSala);
        editNumSala.setBounds(249, 40, 60, 30);

        editCapacidadSala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "45", "54", "63", "72" }));
        panelMostrarSala.add(editCapacidadSala);
        editCapacidadSala.setBounds(250, 90, 100, 30);
        panelMostrarSala.add(editTipoSala);
        editTipoSala.setBounds(250, 140, 140, 30);

        jPanel1.add(panelMostrarSala);
        panelMostrarSala.setBounds(10, 120, 430, 230);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 460, 370);

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

        setBounds(0, 0, 458, 419);
    }// </editor-fold>//GEN-END:initComponents

    private void comboSalasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSalasItemStateChanged
        textSalas.setText(null);

        this.setOcultarComponentes();
        
        if(comboSalas.getSelectedItem() == "Selecciona")
            panelMostrarSala.setVisible(false);
        else
        {
            this.setInfoSala(Integer.parseInt(comboSalas.getSelectedItem().toString()));
            panelMostrarSala.setVisible(true);
        }
    }//GEN-LAST:event_comboSalasItemStateChanged

    private void botonBuscarSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarSalasMouseClicked
        String consulta = "SELECT COUNT(ID_SL) FROM salas WHERE Numero_SL = '" + textSalas.getText() + "'";

        if(cnbd.getBuscar(consulta) == 1)
            comboSalas.setSelectedItem(textSalas.getText());
        else
            JOptionPane.showMessageDialog(null,"Esta sala no se encuentra registrada","Busqueda", 0);
    }//GEN-LAST:event_botonBuscarSalasMouseClicked

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vps = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vps.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void editarSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarSalasMouseClicked
        
        botonGuardar.setVisible(true);
        botonCancelar.setVisible(true);
        
        numSala.setVisible(false);
        capacidadSala.setVisible(false);
        tipoSala.setVisible(false);
        
        editNumSala.setVisible(true);
        editCapacidadSala.setVisible(true);
        editTipoSala.setVisible(true);
        
        editNumSala.setText(numSala.getText());
        editCapacidadSala.setSelectedItem(capacidadSala.getText());
        
        editCapacidadSala.setEnabled(false);
        
        setComboTipoSala();
        
        editTipoSala.setSelectedItem(tipoSala.getText());
    }//GEN-LAST:event_editarSalasMouseClicked

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        this.setOcultarComponentes();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void textSalasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSalasKeyTyped
        char car = evt.getKeyChar();
        
        if((car<'0' || car>'9')) 
            evt.consume();
    }//GEN-LAST:event_textSalasKeyTyped

    private void editNumSalaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editNumSalaKeyTyped
        char car = evt.getKeyChar();
        
        if((car<'0' || car>'9')) 
            evt.consume();
    }//GEN-LAST:event_editNumSalaKeyTyped

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        
        if(!editNumSala.getText().equals(""))
        {
            String consulta = "SELECT COUNT(ID_SL) FROM salas WHERE Numero_SL = " + editNumSala.getText() + " AND ID_SL != " + idSala.getText();
            
            if(cnbd.getBuscar(consulta) == 0)
            {            
                GetSetSala gss = new GetSetSala();
        
                int tSl = editTipoSala.getSelectedIndex() + 1;
            
                gss.setId(Integer.parseInt(idSala.getText()));
                gss.setNumero(Integer.parseInt(editNumSala.getText()));
                gss.setTipo(tSl);
            
                if(cnbd.getModificarSalas(gss))
                {
                    this.setOcultarComponentes();
                
                    comboSalas.setSelectedItem("Selecciona");            
                    
                    this.setRemoverItems();

                    if(comboSalas.getItemCount() == 1 || comboSalas.getItemCount() > 1)
                        this.setRemoverItems();

                    if(comboSalas.getItemCount() == 1 || comboSalas.getItemCount() > 1)
                        this.setRemoverItems();

                    if(comboSalas.getItemCount() == 1 || comboSalas.getItemCount() > 1)
                        this.setRemoverItems();
                
                    this.setLLenarComboSalas();      
                    
                    JOptionPane.showMessageDialog(null,"La sala ha sido modificada","Sala modificada", 1);   
                }
                else
                    JOptionPane.showMessageDialog(null,"No se han podido modificar los datos","Modificar salas", 2); 
            }
            else
                JOptionPane.showMessageDialog(null,"Esta sala ya esta registrada","Sala ya registrada", 2);            
        }
        else
           JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos","Modificar sala", 2); 
        
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void eliminarSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarSalasMouseClicked
        int op = 0; 
       
        op = JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar la sala " + numSala.getText() + "?", "Eliminar", JOptionPane.YES_NO_OPTION);
           
        if(op == JOptionPane.YES_OPTION)
        {
            if(cnbd.getEliminar("DELETE FROM asientos WHERE ID_SL = " + idSala.getText().trim()))
            {
                if(cnbd.getEliminar("DELETE FROM funciones WHERE ID_SL = " + idSala.getText().trim()))
                {
                    if(cnbd.getEliminar("DELETE FROM salas WHERE ID_SL = " + idSala.getText().trim()))
                    {
                        this.setOcultarComponentes();

                        comboSalas.setSelectedItem("Selecciona");

                        this.setRemoverItems();

                        if (comboSalas.getItemCount() == 1 || comboSalas.getItemCount() > 1)
                            this.setRemoverItems();

                        if (comboSalas.getItemCount() == 1 || comboSalas.getItemCount() > 1)
                            this.setRemoverItems();

                        if (comboSalas.getItemCount() == 1 || comboSalas.getItemCount() > 1)
                            this.setRemoverItems();

                        this.setLLenarComboSalas();       
                
                        JOptionPane.showMessageDialog(null,"La sala " + numSala.getText() + " ha sido eliminada","Sala eliminada", 1);                 
                    }
                    else
                        JOptionPane.showMessageDialog(null,"No se ha podido eliminar la sala","Eliminar sala", 2);                     
                }
                else
                    JOptionPane.showMessageDialog(null,"No se ha podido eliminar la funcion","Eliminar sala", 2);               
            }
            else
                JOptionPane.showMessageDialog(null,"No se han podido eliminar los asientos","Eliminar sala", 2); 
        }
    }//GEN-LAST:event_eliminarSalasMouseClicked


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
            java.util.logging.Logger.getLogger(VentanaVerSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVerSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVerSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVerSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVerSalas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarSalas;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel capacidadSala;
    private javax.swing.JComboBox comboSalas;
    private javax.swing.JComboBox editCapacidadSala;
    private javax.swing.JTextField editNumSala;
    private javax.swing.JComboBox editTipoSala;
    private javax.swing.JLabel editarSalas;
    private javax.swing.JLabel eliminarSalas;
    private javax.swing.JLabel idSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel numSala;
    private javax.swing.JPanel panelMostrarSala;
    private javax.swing.JTextField textSalas;
    private javax.swing.JLabel tipoSala;
    // End of variables declaration//GEN-END:variables
    private GetSetEmpleados gse;    
    private ConsultasBD cnbd;
}
