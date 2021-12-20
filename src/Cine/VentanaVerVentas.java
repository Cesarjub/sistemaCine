package Cine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class VentanaVerVentas extends javax.swing.JFrame {

    public VentanaVerVentas() 
    {
        initComponents();
    }    
    
    public VentanaVerVentas(GetSetEmpleados gse) 
    {
        this.gse = gse;
        
        initComponents();
        
        cnbd = new ConsultasBD();
        
        this.setLocationRelativeTo(null); 
        
        th = tablaVentas.getTableHeader();        
        
        dtm = new DefaultTableModel(filas, columnas)
        {
            public boolean isCellEditable(int fil, int col)
            {
                return false;
            }
        };         
        
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) 
                tablaVentas.getTableHeader().getDefaultRenderer(); 
        
        renderer1.setHorizontalAlignment(0);        
        
        th.setReorderingAllowed(false);

        th.setFont(new Font("Calibri", Font.PLAIN, 13));
        
        th.setForeground(Color.BLACK);  
        
        th.setResizingAllowed(false);

        dtm.fireTableDataChanged();
        
        tablaVentas.setModel(dtm);  
        
        this.setLLenarTablaVentas("SELECT * FROM boletos");
        
        comboPeliculas.addItem("Todas");
        
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
    
    public void setLLenarTablaVentas(String consulta)
    {
        try 
        {    
            ResultSet rs = cnbd.getLlenarComboBox(consulta);            

            while(rs.next())
            {
                    dtm.addRow(new Object[] {rs.getInt("ID_BLT"), rs.getString("Pelicula_BLT"), rs.getString("FechaCompra_BLT"), rs.getInt("NumeroSala_BLT"), rs.getInt("Cantidad_BLT"), rs.getString("Dia_BLT") + " " + rs.getString("Hora_BLT"), rs.getFloat("Total_BLT")});
            }                
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: "+e,"!! ERROR !!", 2);
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        filtroNumero = new javax.swing.JTextField();
        comboPeliculas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Boletos vendidos");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 10, 990, 22);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaVentas);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 970, 370);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 970, 370);

        filtroNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtroNumeroKeyTyped(evt);
            }
        });
        jPanel1.add(filtroNumero);
        filtroNumero.setBounds(10, 40, 180, 30);

        comboPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboPeliculas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPeliculasItemStateChanged(evt);
            }
        });
        jPanel1.add(comboPeliculas);
        comboPeliculas.setBounds(746, 50, 220, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Peliculas:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(750, 30, 210, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("No. de boleto:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 180, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 990, 480);

        jMenu1.setText("File");

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

        setBounds(0, 0, 994, 525);
    }// </editor-fold>//GEN-END:initComponents

    private void filtroNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroNumeroKeyTyped
        char car = evt.getKeyChar();
        
        if((car<'0' || car>'9')) 
            evt.consume();        
        
        TableRowSorter trs = new TableRowSorter(dtm);
        
        filtroNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
                trs.setRowFilter(RowFilter.regexFilter(filtroNumero.getText(), 0));
            }
        });
        
        tablaVentas.setRowSorter(trs);
    }//GEN-LAST:event_filtroNumeroKeyTyped

    private void comboPeliculasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPeliculasItemStateChanged
        int a = tablaVentas.getRowCount()-1;
        
        if(comboPeliculas.getSelectedItem().equals("Todas"))
        {
            for (int i = a; i >= 0; i--) 
            {
                dtm.removeRow(dtm.getRowCount()-1);             
            }
            
            this.setLLenarTablaVentas("SELECT * FROM boletos");
        }
        else  
        {            
            for (int i = a; i >= 0; i--) 
            {
                dtm.removeRow(dtm.getRowCount()-1);             
            }            
            
            this.setLLenarTablaVentas("SELECT * FROM boletos WHERE Pelicula_BLT = '" + comboPeliculas.getSelectedItem().toString().trim() + "'");
        }
    }//GEN-LAST:event_comboPeliculasItemStateChanged

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
            java.util.logging.Logger.getLogger(VentanaVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVerVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboPeliculas;
    private javax.swing.JTextField filtroNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
    private GetSetEmpleados gse;
    private ConsultasBD cnbd;    
    private DefaultTableModel dtm;
    private JTableHeader th;   
    
    String filas [][] = {};
    String columnas [] = {"No. Boleto", "Pelicula", "Fecha de compra", "No. Sala", "Cantidad", "Funcion", "Total"}; 
}
