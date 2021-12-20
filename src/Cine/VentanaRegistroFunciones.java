package Cine;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class VentanaRegistroFunciones extends javax.swing.JFrame {

    public VentanaRegistroFunciones()
    {
        initComponents();
    }
    
    public VentanaRegistroFunciones(GetSetEmpleados gse) 
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
        
        idFuncion.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_FNC) FROM funciones")));        
        
        idFuncion.setEditable(false);
        
        fechaFuncion.setMinSelectableDate(new Date());
        fechaFuncion.setDate(new Date());
        
        setComboPeliculas();
        setComboAudio();
        setComboSala();
        
        setSpinner();
        
        errorAudio.setText(null);
        errorPelicula.setText(null);
        errorSala.setText(null);
        
        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }
    
    public void setSpinner()
    {
        try 
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");            
            
            Date hora = sdf.parse("00:00:00");
            
            SpinnerDateModel sdm = new SpinnerDateModel(hora, null, null, Calendar.HOUR_OF_DAY);
            
            horaFuncion.setModel(sdm);
            
            JSpinner.DateEditor de = new JSpinner.DateEditor(horaFuncion, "HH:mm:ss");
            
            horaFuncion.setEditor(de);
        } 
        catch (ParseException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Seleccionar hora", 2);
        }        
    }
    
    public void setComboPeliculas()
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

    public void setComboAudio()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM audio");
        
        comboAudio.addItem("Selecciona");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Tipo_AD"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboAudio.addItem(lista.get(i));        
    }    
    
    public void setComboSala()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM salas");
        
        comboSala.addItem("Selecciona");
        
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("Numero_SL"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
        for(int i = 0; i < lista.size(); i++)
            comboSala.addItem(lista.get(i));        
    }       
    
    public void setLimpiarFormulario()
    {
        comboPeliculas.setSelectedIndex(0);
        comboSala.setSelectedIndex(0);
        comboAudio.setSelectedIndex(0);
        fechaFuncion.setDate(null);

        setSpinner();
        
        errorPelicula.setText(null);
        errorAudio.setText(null);
        errorSala.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        idFuncion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboPeliculas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboAudio = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboSala = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        fechaFuncion = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        errorPelicula = new javax.swing.JLabel();
        errorAudio = new javax.swing.JLabel();
        errorSala = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        horaFuncion = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar funciones");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Registro de funciones");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 0, 200, 40);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(410, 0, 40, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 480, 40);
        jPanel1.add(idFuncion);
        idFuncion.setBounds(30, 90, 90, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 60, 40, 30);

        comboPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboPeliculas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPeliculasItemStateChanged(evt);
            }
        });
        jPanel1.add(comboPeliculas);
        comboPeliculas.setBounds(250, 90, 170, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Pelicula:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 70, 120, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Audio:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 140, 70, 20);

        comboAudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboAudio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAudioItemStateChanged(evt);
            }
        });
        jPanel1.add(comboAudio);
        comboAudio.setBounds(30, 160, 140, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Sala:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 210, 80, 20);

        comboSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSalaItemStateChanged(evt);
            }
        });
        jPanel1.add(comboSala);
        comboSala.setBounds(30, 230, 120, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Dia:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(250, 130, 70, 20);

        fechaFuncion.setDateFormatString("yyyy/MM/dd");
        jPanel1.add(fechaFuncion);
        fechaFuncion.setBounds(250, 150, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Hora:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(250, 200, 60, 20);

        errorPelicula.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorPelicula.setForeground(new java.awt.Color(153, 0, 0));
        errorPelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(errorPelicula);
        errorPelicula.setBounds(250, 110, 170, 20);

        errorAudio.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorAudio.setForeground(new java.awt.Color(153, 0, 0));
        errorAudio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(errorAudio);
        errorAudio.setBounds(30, 180, 180, 20);

        errorSala.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        errorSala.setForeground(new java.awt.Color(153, 0, 0));
        errorSala.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(errorSala);
        errorSala.setBounds(30, 250, 170, 20);

        jPanel3.setBackground(new java.awt.Color(0, 32, 86));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 330, 480, 30);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(200, 290, 100, 23);
        jPanel1.add(horaFuncion);
        horaFuncion.setBounds(250, 220, 120, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 380);

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
        menuInicio.setToolTipText("");
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });
        jMenu2.add(menuInicio);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 483, 403);
    }// </editor-fold>//GEN-END:initComponents

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vpa = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vpa.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        this.setLimpiarFormulario();
    }//GEN-LAST:event_menuLimpiarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void comboAudioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAudioItemStateChanged
        if(comboAudio.getSelectedItem() == "Selecciona")
            errorAudio.setText("*Seleccione una opcion valida");
        else
            errorAudio.setText(null);
    }//GEN-LAST:event_comboAudioItemStateChanged

    private void comboSalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSalaItemStateChanged
        if(comboSala.getSelectedItem() == "Selecciona")
            errorSala.setText("*Seleccione una opcion valida");
        else
            errorSala.setText(null);
    }//GEN-LAST:event_comboSalaItemStateChanged

    private void comboPeliculasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPeliculasItemStateChanged
        if(comboPeliculas.getSelectedItem() == "Selecciona")
            errorPelicula.setText("*Seleccione una opcion valida");
        else
            errorPelicula.setText(null);
    }//GEN-LAST:event_comboPeliculasItemStateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        GetSetFunciones gsf = new GetSetFunciones();
        
        if(comboAudio.getSelectedItem() == "Selecciona")
            errorAudio.setText("*Seleccione una opcion valida");
        else
            errorAudio.setText(null);
        
        if(comboSala.getSelectedItem() == "Selecciona")
            errorSala.setText("*Seleccione una opcion valida");
        else
            errorSala.setText(null);        
        
        if(comboPeliculas.getSelectedItem() == "Selecciona")
            errorPelicula.setText("*Seleccione una opcion valida");
        else
            errorPelicula.setText(null);        

        if(comboPeliculas.getSelectedItem() != "Selecciona" && comboAudio.getSelectedItem() != "Selecciona" && 
                comboSala.getSelectedItem() != "Selecciona")
        {
            int plc = cnbd.getConsultarPeliculas(comboPeliculas.getSelectedItem().toString());
                      
            Date dt = fechaFuncion.getDate();
            
            long tmp = dt.getTime();
            
            java.sql.Date fecha = new java.sql.Date(tmp);            
            
            Date hr = (Date) horaFuncion.getValue();
            
            long tmpo = hr.getTime();
            
            java.sql.Time hora = new java.sql.Time(tmpo); 
            
            String consulta = "SELECT ID_SL FROM salas WHERE Numero_SL = " + comboSala.getSelectedItem();
            
            int sl = 0;
            
            ResultSet rs = cnbd.getConsultas(consulta);            
            
            try 
            {
                if(rs.next())            
                    sl = rs.getInt("ID_SL");
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Sala de cine", 2);
            }             
            
            String consultaComp = "SELECT COUNT(ID_FNC) FROM funciones WHERE ID_PLC = " + plc + " AND ID_SL = " + sl + " AND DIA_FNC = '" + fecha.toString() + "' AND Hora_FNC = '" + hora.toString() + "'";
            
            if(cnbd.getBuscar(consultaComp) == 0)
            {                   
                    
                gsf.setId(Integer.parseInt(idFuncion.getText()));
                gsf.setDia(fecha.toString());
                gsf.setHora(hora.toString());
                gsf.setPelicula(plc);
                gsf.setSala(sl);
                gsf.setAudio(comboAudio.getSelectedIndex());
            
                String consultaCp = "SELECT Capacidad_SL FROM salas WHERE ID_SL = " + sl;
                int capacidad = 0;
        
                ResultSet rs2 = cnbd.getConsultas(consultaCp);
            
                try 
                {
                    if(rs2.next())
                        capacidad = rs2.getInt("Capacidad_SL");
                } 
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Consultar asientos", 2);
                }             
            
                
                if(cnbd.getRegistrarFuncion(gsf) & cnbd.getRegistrarAsientos(gsf, capacidad))
                {
                    JOptionPane.showMessageDialog(null,"La funcion ha sido guardada","Funcion agregada", 1);  
                    setLimpiarFormulario();
                    idFuncion.setText(String.valueOf(cnbd.getGenerarId("SELECT MAX(ID_FNC) FROM funciones")));
                }
                else
                    JOptionPane.showMessageDialog(null,"No se han podido guardar los datos","Registrar funcion", 2); 
            }
            else
                JOptionPane.showMessageDialog(null,"La funcion ya ha sido registrada","Funcion ya registrada", 2);              
        }
        else
            JOptionPane.showMessageDialog(null,"Los campos seleccionados son incorrectos","Datos incorrectos", 2);    
        
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(VentanaRegistroFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroFunciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboAudio;
    private javax.swing.JComboBox comboPeliculas;
    private javax.swing.JComboBox comboSala;
    private javax.swing.JLabel errorAudio;
    private javax.swing.JLabel errorPelicula;
    private javax.swing.JLabel errorSala;
    private com.toedter.calendar.JDateChooser fechaFuncion;
    private javax.swing.JSpinner horaFuncion;
    private javax.swing.JTextField idFuncion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;
    private ConsultasBD cnbd;
    private GetSetEmpleados gse;
}
