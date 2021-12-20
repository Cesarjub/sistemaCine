package Cine;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class VentanaVerEmpleados extends javax.swing.JFrame {

    public VentanaVerEmpleados()
    {
        initComponents();
    }
    
    public VentanaVerEmpleados(GetSetEmpleados gse) 
    {
        initComponents();
        
        this.gse = gse;

        cnbd = new ConsultasBD();
        
        //
        this.setLocationRelativeTo(null); 
                
        this.panelMostrarEmpleado.setVisible(false);
        
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        editNombre.setVisible(false);
        editApellido.setVisible(false);
        editCargo.setVisible(false);
        editUsuario.setVisible(false);
        editClave.setVisible(false);        
        
        comboEmpleados.addItem("Selecciona");        
        
        this.setLLenarComboEmpleados();   
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }            
    }

    public void setLLenarComboEmpleados()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM empleados");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getInt("ID_EMP") + " - " + rs.getString("Nombre_EMP") + " " + rs.getString("Apellido_EMP"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboEmpleados.addItem(lista.get(i));
    }      
    
    public void setMostrarEmpleados(char id)
    {
        ResultSet rs = cnbd.getConsultas("SELECT e.*, c.Nombre_CRG FROM empleados e INNER JOIN cargo c ON e.ID_CRG = c.ID_CRG WHERE e.ID_EMP = " + id);

        try 
        {            
            if(rs.next())
            {
                idEmpleado.setText(String.valueOf(rs.getInt("ID_EMP")));
                nombreEmpleado.setText(rs.getString("Nombre_EMP"));
                apellidoEmpleado.setText(" " + rs.getString("Apellido_EMP"));
                cargoEmpleado.setText(rs.getString("Nombre_CRG"));
                ingresoEmpleado.setText(rs.getString("FechaIngreso_EMP"));
                usuarioEmpleado.setText(rs.getString("Usuario_EMP"));
                accesoEmpleado.setText(rs.getString("UltimoAcceso_EMP"));
                claveEmpleado.setText(rs.getString("Clave_EMP"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Informacion", 2);
        }          
    }
    
    public void setLLenarComboCargo()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM cargo");
        
        editCargo.removeAllItems();
        
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
            editCargo.addItem(lista.get(i));
    }     
    
    public void setOcultarComponentes()
    {
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        nombreEmpleado.setVisible(true);
        apellidoEmpleado.setVisible(true);
        cargoEmpleado.setVisible(true);
        usuarioEmpleado.setVisible(true);
        claveEmpleado.setVisible(true);
        
        editNombre.setVisible(false);
        editApellido.setVisible(false);        
        editCargo.setVisible(false);
        editUsuario.setVisible(false);
        editClave.setVisible(false);           
    }
    
    public void setRemoverItems()
    {
        for(int i = 0; i < comboEmpleados.getItemCount(); i++)
        {
            if(!comboEmpleados.getItemAt(i).equals("Selecciona"))
                comboEmpleados.removeItemAt(i);
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboEmpleados = new javax.swing.JComboBox();
        textEmpleados = new javax.swing.JTextField();
        botonBuscarEmpleados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelMostrarEmpleado = new javax.swing.JPanel();
        nombreEmpleado = new javax.swing.JLabel();
        idEmpleado = new javax.swing.JLabel();
        usuarioEmpleado = new javax.swing.JLabel();
        ingresoEmpleado = new javax.swing.JLabel();
        accesoEmpleado = new javax.swing.JLabel();
        cargoEmpleado = new javax.swing.JLabel();
        apellidoEmpleado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        editarEmpleado = new javax.swing.JLabel();
        eliminarEmpleado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        editCargo = new javax.swing.JComboBox();
        editUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        claveEmpleado = new javax.swing.JLabel();
        editClave = new javax.swing.JTextField();
        editApellido = new javax.swing.JTextField();
        editNombre = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ver empleados");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Empleados");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 490, 22);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        comboEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboEmpleados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEmpleadosItemStateChanged(evt);
            }
        });
        jPanel2.add(comboEmpleados);
        comboEmpleados.setBounds(20, 30, 210, 20);

        textEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEmpleadosKeyTyped(evt);
            }
        });
        jPanel2.add(textEmpleados);
        textEmpleados.setBounds(300, 20, 130, 30);

        botonBuscarEmpleados.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscaar.png"))); // NOI18N
        botonBuscarEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarEmpleadosMouseClicked(evt);
            }
        });
        jPanel2.add(botonBuscarEmpleados);
        botonBuscarEmpleados.setBounds(430, 20, 40, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Empleados:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 0, 210, 29);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 40, 490, 70);

        panelMostrarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        panelMostrarEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelMostrarEmpleado.setLayout(null);

        nombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(0, 51, 102));
        nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelMostrarEmpleado.add(nombreEmpleado);
        nombreEmpleado.setBounds(80, 10, 90, 40);

        idEmpleado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        idEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelMostrarEmpleado.add(idEmpleado);
        idEmpleado.setBounds(30, 20, 50, 40);

        usuarioEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelMostrarEmpleado.add(usuarioEmpleado);
        usuarioEmpleado.setBounds(240, 140, 140, 30);

        ingresoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelMostrarEmpleado.add(ingresoEmpleado);
        ingresoEmpleado.setBounds(240, 100, 130, 30);

        accesoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelMostrarEmpleado.add(accesoEmpleado);
        accesoEmpleado.setBounds(240, 220, 210, 20);

        cargoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelMostrarEmpleado.add(cargoEmpleado);
        cargoEmpleado.setBounds(240, 60, 100, 30);

        apellidoEmpleado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        apellidoEmpleado.setForeground(new java.awt.Color(0, 51, 102));
        panelMostrarEmpleado.add(apellidoEmpleado);
        apellidoEmpleado.setBounds(170, 10, 200, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cargo:");
        panelMostrarEmpleado.add(jLabel4);
        jLabel4.setBounds(160, 60, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Fecha de ingreso:");
        panelMostrarEmpleado.add(jLabel10);
        jLabel10.setBounds(100, 100, 130, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Nombre de usuario:");
        panelMostrarEmpleado.add(jLabel11);
        jLabel11.setBounds(90, 140, 140, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Ultimo acceso:");
        panelMostrarEmpleado.add(jLabel12);
        jLabel12.setBounds(100, 220, 130, 20);

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
        panelMostrarEmpleado.add(botonGuardar);
        botonGuardar.setBounds(340, 250, 90, 23);

        editarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pencil.png"))); // NOI18N
        editarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarEmpleadoMouseClicked(evt);
            }
        });
        panelMostrarEmpleado.add(editarEmpleado);
        editarEmpleado.setBounds(400, 10, 30, 40);

        eliminarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarEmpleadoMouseClicked(evt);
            }
        });
        panelMostrarEmpleado.add(eliminarEmpleado);
        eliminarEmpleado.setBounds(440, 10, 30, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/card.png"))); // NOI18N
        panelMostrarEmpleado.add(jLabel2);
        jLabel2.setBounds(20, 80, 70, 90);

        botonCancelar.setBackground(new java.awt.Color(102, 0, 0));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });
        panelMostrarEmpleado.add(botonCancelar);
        botonCancelar.setBounds(70, 250, 90, 23);
        panelMostrarEmpleado.add(editCargo);
        editCargo.setBounds(240, 60, 120, 30);
        panelMostrarEmpleado.add(editUsuario);
        editUsuario.setBounds(240, 140, 120, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Contraseña:");
        panelMostrarEmpleado.add(jLabel5);
        jLabel5.setBounds(110, 180, 120, 30);

        claveEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelMostrarEmpleado.add(claveEmpleado);
        claveEmpleado.setBounds(240, 180, 140, 30);
        panelMostrarEmpleado.add(editClave);
        editClave.setBounds(240, 180, 120, 30);
        panelMostrarEmpleado.add(editApellido);
        editApellido.setBounds(170, 10, 150, 30);
        panelMostrarEmpleado.add(editNombre);
        editNombre.setBounds(70, 10, 90, 30);

        jPanel1.add(panelMostrarEmpleado);
        panelMostrarEmpleado.setBounds(10, 120, 490, 290);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 440);

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

        setBounds(0, 0, 516, 482);
    }// </editor-fold>//GEN-END:initComponents

    private void comboEmpleadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEmpleadosItemStateChanged
        textEmpleados.setText(null);

        this.setOcultarComponentes();
        
        if(comboEmpleados.getSelectedItem() == "Selecciona")
            panelMostrarEmpleado.setVisible(false);
        else
        {
            this.setMostrarEmpleados(comboEmpleados.getSelectedItem().toString().charAt(0));
            panelMostrarEmpleado.setVisible(true);
        }
    }//GEN-LAST:event_comboEmpleadosItemStateChanged

    private void botonBuscarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarEmpleadosMouseClicked
        String consulta = "SELECT COUNT(ID_EMP) FROM empleados WHERE ID_EMP = '" + textEmpleados.getText() + "'";

        if(cnbd.getBuscar(consulta) == 1)
        {
            this.setMostrarEmpleados(textEmpleados.getText().charAt(0));
            comboEmpleados.setSelectedItem(idEmpleado.getText().trim() + " - " + nombreEmpleado.getText().trim() + " " + apellidoEmpleado.getText().trim());                
            panelMostrarEmpleado.setVisible(true);                    
        }
        else
            JOptionPane.showMessageDialog(null,"El empleado no se encuentra registrado","Busqueda", 0);
    }//GEN-LAST:event_botonBuscarEmpleadosMouseClicked

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vpa.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void textEmpleadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEmpleadosKeyTyped
        char car = evt.getKeyChar();
        
        if((car<'0' || car>'9')) 
            evt.consume();
    }//GEN-LAST:event_textEmpleadosKeyTyped

    private void editarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarEmpleadoMouseClicked
        
        botonGuardar.setVisible(true);
        botonCancelar.setVisible(true);
        
        nombreEmpleado.setVisible(false);
        apellidoEmpleado.setVisible(false);
        cargoEmpleado.setVisible(false);
        usuarioEmpleado.setVisible(false);
        claveEmpleado.setVisible(false);
        
        editNombre.setVisible(true);
        editApellido.setVisible(true);
        editCargo.setVisible(true);
        editUsuario.setVisible(true);
        editClave.setVisible(true);
        
        setLLenarComboCargo();
        
        editNombre.setText(nombreEmpleado.getText());
        editApellido.setText(apellidoEmpleado.getText());
        editCargo.setSelectedItem(cargoEmpleado.getText());
        editUsuario.setText(usuarioEmpleado.getText());
        editClave.setText(claveEmpleado.getText());
    }//GEN-LAST:event_editarEmpleadoMouseClicked

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        this.setOcultarComponentes();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked

        if(!editUsuario.getText().equals("") && !editClave.getText().equals("") && !editNombre.getText().equals("") && !editApellido.getText().equals(""))
        {
            String consulta = "SELECT COUNT(ID_EMP) FROM empleados WHERE Usuario_EMP = '" + editUsuario.getText() + "' AND ID_EMP != " + idEmpleado.getText();
            
            if(cnbd.getBuscar(consulta) == 0)
            {   
                GetSetEmpleados gsee = new GetSetEmpleados();
                
                int crg = editCargo.getSelectedIndex() + 1;
                
                gsee.setId(Integer.parseInt(idEmpleado.getText().trim()));
                gsee.setNombre(editNombre.getText().trim());
                gsee.setApellido(editApellido.getText().trim());
                gsee.setUsuario(editUsuario.getText().trim());
                gsee.setClave(editClave.getText().trim());
                gsee.setCargo(crg);
                
                if(cnbd.getModificarEmpleados(gsee))
                {
                    this.setOcultarComponentes();

                    comboEmpleados.setSelectedItem("Selecciona");
                    
                    this.setRemoverItems();

                    if(comboEmpleados.getItemCount() == 1 || comboEmpleados.getItemCount() > 1)
                        this.setRemoverItems();

                    if(comboEmpleados.getItemCount() == 1 || comboEmpleados.getItemCount() > 1)
                        this.setRemoverItems();

                    if(comboEmpleados.getItemCount() == 1 || comboEmpleados.getItemCount() > 1)
                        this.setRemoverItems();                    
                    
                    this.setLLenarComboEmpleados();                       
                    
                    JOptionPane.showMessageDialog(null,"El empleado ha sido modificado","Empleado modificado", 1);
                }
                else
                    JOptionPane.showMessageDialog(null,"No se ha podido modificar al empleado","Modificar empleados", 2);
            }   
            else
                JOptionPane.showMessageDialog(null,"Este usuario ya esta registrado","Usuario ya registrado", 2); 
        }
        else
           JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos","Modificar empleado", 2);
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void eliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarEmpleadoMouseClicked
        int op = 0; 
       
        op = JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar a " + nombreEmpleado.getText() + "?", "Eliminar", JOptionPane.YES_NO_OPTION);
           
        if(op == JOptionPane.YES_OPTION)
        {
            if(cnbd.getEliminar("DELETE FROM empleados WHERE ID_EMP = " + idEmpleado.getText().trim()))
            {
                this.setOcultarComponentes();

                comboEmpleados.setSelectedItem("Selecciona");
                    
                this.setRemoverItems();

                if(comboEmpleados.getItemCount() == 1 || comboEmpleados.getItemCount() > 1)
                    this.setRemoverItems();

                if(comboEmpleados.getItemCount() == 1 || comboEmpleados.getItemCount() > 1)
                    this.setRemoverItems();

                if(comboEmpleados.getItemCount() == 1 || comboEmpleados.getItemCount() > 1)
                    this.setRemoverItems();                    
                    
                this.setLLenarComboEmpleados();                
                
                JOptionPane.showMessageDialog(null, nombreEmpleado.getText() + " ha sido eliminado","Empleado eliminado", 1);                 
            }
            else
                JOptionPane.showMessageDialog(null,"No se ha podido eliminar al empleado","Eliminar empleado", 2); 
        }
    }//GEN-LAST:event_eliminarEmpleadoMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaVerEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVerEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVerEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVerEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVerEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accesoEmpleado;
    private javax.swing.JLabel apellidoEmpleado;
    private javax.swing.JButton botonBuscarEmpleados;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel cargoEmpleado;
    private javax.swing.JLabel claveEmpleado;
    private javax.swing.JComboBox comboEmpleados;
    private javax.swing.JTextField editApellido;
    private javax.swing.JComboBox editCargo;
    private javax.swing.JTextField editClave;
    private javax.swing.JTextField editNombre;
    private javax.swing.JTextField editUsuario;
    private javax.swing.JLabel editarEmpleado;
    private javax.swing.JLabel eliminarEmpleado;
    private javax.swing.JLabel idEmpleado;
    private javax.swing.JLabel ingresoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JPanel panelMostrarEmpleado;
    private javax.swing.JTextField textEmpleados;
    private javax.swing.JLabel usuarioEmpleado;
    // End of variables declaration//GEN-END:variables
    private GetSetEmpleados gse;    
    private ConsultasBD cnbd;
}
