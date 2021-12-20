package Cine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class VentanaVerFunciones extends javax.swing.JFrame {

    public VentanaVerFunciones() 
    {
        initComponents();
    }     
    
    public VentanaVerFunciones(GetSetEmpleados gse) 
    {
        initComponents();
        
        this.gse = gse;
        
        cnbd = new ConsultasBD();
        
        this.setLocationRelativeTo(null); 
        
        th = tablaFunciones.getTableHeader();        
        
        dtm = new DefaultTableModel(filas, columnas)
        {
            public boolean isCellEditable(int fil, int col)
            {
                return false;
            }
        };         
        
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) 
                tablaFunciones.getTableHeader().getDefaultRenderer(); 
        
        renderer1.setHorizontalAlignment(0);        
        
        th.setReorderingAllowed(false);

        th.setFont(new Font("Calibri", Font.PLAIN, 13));
        
        th.setForeground(Color.BLACK);  
        
        th.setResizingAllowed(false);

        dtm.fireTableDataChanged();
        
        tablaFunciones.setModel(dtm);  
        
        this.setLLenarTablaFunciones("SELECT f.*, s.Numero_SL, p.Nombre_PLC FROM funciones f INNER JOIN peliculas p ON f.ID_PLC = p.ID_PLC INNER JOIN salas s on f.ID_SL = s.ID_SL");
        
        fechaFuncion.setMinSelectableDate(new Date());
        fechaFuncion.setDate(new Date());
        
        setComboPeliculas();
        setComboSala();
        
        textoId.setEditable(false);
        
        setSpinner(); 
        
        panelEditar.setVisible(false);
        
        botonEliminar.setVisible(false);
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
       //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }
     
    public void setLLenarTablaFunciones(String consulta)
    {
        try 
        {    
            ResultSet rs = cnbd.getLlenarComboBox(consulta);            

            while(rs.next())
            {
                dtm.addRow(new Object[] {rs.getInt("ID_FNC"), rs.getString("Nombre_PLC"), rs.getString("Dia_FNC"), rs.getString("Hora_FNC"), rs.getInt("Numero_SL")});
            }                
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: "+e,"!! ERROR !!", 2);
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
    
    public void setComboSala()
    {
        ArrayList<String> lista = new ArrayList <String>();        
        ResultSet rs = cnbd.getLlenarComboBox("SELECT * FROM salas");
        
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
    
    public void setOcultarComponentes()
    {
        panelEditar.setVisible(false);
        
        botonEliminar.setVisible(false);
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        
        textoId.setVisible(false);
        textoPelicula.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFunciones = new javax.swing.JTable();
        textoPelicula = new javax.swing.JTextField();
        panelEditar = new javax.swing.JPanel();
        comboPeliculas = new javax.swing.JComboBox();
        horaFuncion = new javax.swing.JSpinner();
        fechaFuncion = new com.toedter.calendar.JDateChooser();
        comboSala = new javax.swing.JComboBox();
        textoId = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ver funciones");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Funciones");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 10, 710, 22);

        tablaFunciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No. Funcion", "Pelicula", "Num. Sala", "Dia", "Hora"
            }
        ));
        tablaFunciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaFunciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFuncionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFunciones);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 680, 300);

        textoPelicula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoPeliculaKeyTyped(evt);
            }
        });
        jPanel1.add(textoPelicula);
        textoPelicula.setBounds(10, 50, 130, 30);

        panelEditar.setBackground(new java.awt.Color(255, 255, 255));
        panelEditar.setLayout(null);

        comboPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEditar.add(comboPeliculas);
        comboPeliculas.setBounds(0, 0, 130, 30);
        panelEditar.add(horaFuncion);
        horaFuncion.setBounds(270, 0, 130, 30);

        fechaFuncion.setDateFormatString("yyyy/MM/dd");
        panelEditar.add(fechaFuncion);
        fechaFuncion.setBounds(140, 0, 120, 30);

        comboSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEditar.add(comboSala);
        comboSala.setBounds(410, 0, 130, 30);

        jPanel1.add(panelEditar);
        panelEditar.setBounds(150, 50, 540, 30);
        jPanel1.add(textoId);
        textoId.setBounds(10, 50, 130, 30);

        botonCancelar.setBackground(new java.awt.Color(255, 102, 0));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });
        jPanel1.add(botonCancelar);
        botonCancelar.setBounds(320, 390, 100, 23);

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
        jPanel1.add(botonGuardar);
        botonGuardar.setBounds(140, 390, 90, 23);

        botonEliminar.setBackground(new java.awt.Color(153, 0, 0));
        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("Eliminar");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(botonEliminar);
        botonEliminar.setBounds(490, 390, 90, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 720, 450);

        jMenu1.setText("File");

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
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

        menuInicio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
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

        setBounds(0, 0, 713, 492);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaFuncionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFuncionesMouseClicked
        int fila = tablaFunciones.getSelectedRow();        
        
        if(fila == -1) 
        {
            
        }
        else 
        {
            textoPelicula.setVisible(false);
            textoId.setVisible(true);
            
            panelEditar.setVisible(true);
        
            botonEliminar.setVisible(true);
            botonGuardar.setVisible(true);
            botonCancelar.setVisible(true);            
            
            textoId.setText(tablaFunciones.getValueAt(fila, 0).toString());
            
            comboPeliculas.setSelectedItem(tablaFunciones.getValueAt(fila, 1).toString());
 
            try 
            {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                String diaString = format.format(new Date());
            
                Date dia = format.parse(tablaFunciones.getValueAt(fila, 2).toString()); 

                horaFuncion.setValue(dia);
            } 
            catch (ParseException ex) 
            {
                Logger.getLogger(VentanaVerFunciones.class.getName()).log(Level.SEVERE, null, ex);
            }            
            
            try 
            {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                
                Date hora = sdf.parse(tablaFunciones.getValueAt(fila, 3).toString());
                
                horaFuncion.setValue(hora);
            } 
            catch (ParseException ex) 
            {
                Logger.getLogger(VentanaVerFunciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            comboSala.setSelectedItem(tablaFunciones.getValueAt(fila, 4).toString());
            
        }
    }//GEN-LAST:event_tablaFuncionesMouseClicked

    private void textoPeliculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoPeliculaKeyTyped
        
        TableRowSorter trs = new TableRowSorter(dtm);
        
        textoPelicula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
                trs.setRowFilter(RowFilter.regexFilter(textoPelicula.getText(), 1));
            }
        });
        
        tablaFunciones.setRowSorter(trs);
    }//GEN-LAST:event_textoPeliculaKeyTyped

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        this.setOcultarComponentes();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        
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
            
        String consultaComp = "SELECT COUNT(ID_FNC) FROM funciones WHERE ID_PLC = " + plc + " AND ID_SL = " + sl + " AND DIA_FNC = '" + fecha.toString() + "' AND Hora_FNC = '" + hora.toString() + "' AND ID_FNC != " + textoId.getText().trim();
            
        if(cnbd.getBuscar(consultaComp) == 0)
        {   
            GetSetFunciones gsf = new GetSetFunciones();
            
            gsf.setId(Integer.parseInt(textoId.getText().trim()));
            gsf.setDia(fecha.toString());
            gsf.setHora(hora.toString());
            gsf.setPelicula(plc);
            gsf.setSala(sl);    
            
            if(cnbd.getModificarFunciones(gsf))
            {
                JOptionPane.showMessageDialog(null,"La funcion ha sido modificada","Funcion modificada", 1);  
                
                /*int a = dtm.getRowCount()-1;
                
                for(int i = 0; i < a; i++)
                    dtm.removeRow(i);*/

                //this.setLLenarTablaFunciones("SELECT f.*, s.Numero_SL, p.Nombre_PLC FROM funciones f INNER JOIN peliculas p ON f.ID_PLC = p.ID_PLC INNER JOIN salas s on f.ID_SL = s.ID_SL");
                
                this.setOcultarComponentes();
            }
            else
                JOptionPane.showMessageDialog(null,"No se han podido modificar los datos","Modificar funcion", 2);             
        }
        else
           JOptionPane.showMessageDialog(null,"La funcion ya ha sido registrada","Funcion ya registrada", 2);  
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        VentanaPrincipalAdministrador vps = new VentanaPrincipalAdministrador(gse);
        
        this.dispose();
        vps.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        int op = 0; 
       
        op = JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar esta funcion?", "Eliminar", JOptionPane.YES_NO_OPTION);
           
        if(op == JOptionPane.YES_OPTION)
        {
            if(cnbd.getEliminar("DELETE FROM asientos WHERE ID_FNC = " + textoId.getText().trim()))
            {
                if(cnbd.getEliminar("DELETE FROM funciones WHERE ID_FNC = " + textoId.getText().trim()))
                {                
                    JOptionPane.showMessageDialog(null,"La funcion ha sido eliminada","Funcion eliminada", 1);
                
                    this.setOcultarComponentes();
                }
                else
                    JOptionPane.showMessageDialog(null,"No se ha podido eliminar la funcion","Eliminar funcion", 2);                
            }
            else
                JOptionPane.showMessageDialog(null,"No se ha podido eliminar los asientos","Eliminar funcion", 2); 
        }
    }//GEN-LAST:event_botonEliminarMouseClicked


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
            java.util.logging.Logger.getLogger(VentanaVerFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVerFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVerFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVerFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVerFunciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox comboPeliculas;
    private javax.swing.JComboBox comboSala;
    private com.toedter.calendar.JDateChooser fechaFuncion;
    private javax.swing.JSpinner horaFuncion;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelEditar;
    private javax.swing.JTable tablaFunciones;
    private javax.swing.JTextField textoId;
    private javax.swing.JTextField textoPelicula;
    // End of variables declaration//GEN-END:variables
    private GetSetEmpleados gse;
    private ConsultasBD cnbd;    
    private DefaultTableModel dtm;
    private JTableHeader th;   
    
    String filas [][] = {};
    String columnas [] = {"No. Funcion", "Pelicula", "Dia", "Hora", "Sala"}; 
}
