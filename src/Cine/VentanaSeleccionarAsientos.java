package Cine;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class VentanaSeleccionarAsientos extends javax.swing.JFrame 
{
    private int filas, columnas;
    
    public VentanaSeleccionarAsientos()
    {
        initComponents();
    }

    public VentanaSeleccionarAsientos(GetSetEmpleados gse, int idPl, int idFn, float pr, int totAsnt) 
    {
        initComponents();
        
        this.gse = gse;
        this.idPl = idPl;
        this.idFn = idFn;
        this.totAsnt = totAsnt;
        this.pr = pr;
        
        //
        this.setLocationRelativeTo(null);  
        
        cnbd = new ConsultasBD();
        
        setNumerosAsientos(idFn);
        setBotones();
        
        ic = new ImageIcon("src/Imagenes/claquetaDeCine.png");
        
        icn = new ImageIcon(ic.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));        
          
        labelLogo.setIcon(icn);
        
        labelLogo.repaint();
        
        this.setBuscarAsientosReservados();

        //Icono de la Ventana
        try{
            Image img = ImageIO.read(new File("boleto.png"));
            this.setIconImage(img);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana", 2);
        }         
    }
    
    public void setNumerosAsientos(int fnc)
    {
        String consulta = "SELECT sl.Capacidad_SL FROM salas sl INNER JOIN funciones fc ON sl.ID_SL = fc.ID_SL WHERE fc.ID_FNC = " + fnc;
        int asientos = 0;
        
        ResultSet rs1 = cnbd.getConsultas(consulta);
            
        try 
        {
            if(rs1.next())
                asientos = rs1.getInt("Capacidad_SL");
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Consultar sala", 2);
        }  
                
        if(asientos == 45)
        {
            filas = 5;
            columnas = 9;
        }
        else if(asientos == 54)
        {
            filas = 6;
            columnas = 9;            
        }
        else if(asientos == 63)
        {
            filas = 7;
            columnas = 9;            
        }
        else if(asientos == 72)
        {
            filas = 8;
            columnas = 9;            
        }
    }
    
    private JToggleButton [][] botonSel = new JToggleButton[filas][columnas];
    
    public void setBotones()
    {
        int cnt = 1;
        
        Font fuente = new Font("Arial", Font.BOLD, 12);
        
        botonSel = new JToggleButton[filas][columnas];
        
        for(int i = 0; i < filas; i++)
        {
            for(int j = 0; j < columnas; j++)
            {
                botonSel[i][j] = new JToggleButton();
                
                botonSel[i][j].setText("" + cnt);
                
                botonSel[i][j].setFont(fuente);
                
                botonSel[i][j].setBackground(new Color(31, 222, 101));
                
                botonSel[i][j].setCursor(new Cursor(HAND_CURSOR));
                
                //JTBotones[i][j].setForeground(Color.WHITE);
                
                AccionBotones acb = new AccionBotones();
                
                botonSel[i][j].addActionListener(acb);
                
                panelAsientos.add(botonSel[i][j]);
                
                cnt ++;
            }
        }
    }
    
    public void setBuscarAsientosReservados()
    {
        ResultSet rs = cnbd.getConsultas("SELECT Numero_AST, ID_EST FROM asientos WHERE ID_FNC = " + idFn);
               
        String numeroAst = "";
        int estadoAst = 0;
        
        try 
        {
            while(rs.next())
            {
                numeroAst = String.valueOf(rs.getInt("Numero_AST"));
                estadoAst = rs.getInt("ID_EST");
                
                for(int i = 0; i < filas; i++)
                {
                    for(int j = 0; j < columnas; j++)
                    {    
                        if(botonSel[i][j].getText().equals(numeroAst) && estadoAst == 2)
                        {
                            botonSel[i][j].setBackground(new Color(153,0,0));
                            botonSel[i][j].setForeground(Color.WHITE);
                            //botonSel[i][j].setSelected(true);
                            botonSel[i][j].setEnabled(false);
                        }
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Consultar asientos disponibles", 2);
        }
    }
    
    public class AccionBotones implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ev) 
        {
            for(int i = 0; i < filas; i ++)
            {
                for(int j = 0; j < columnas; j++)
                {
                    if(ev.getSource().equals(botonSel[i][j]))
                    {
                        if(botonSel[i][j].isSelected())
                        {
                            botonSel[i][j].setBackground(new Color(0, 204, 204));   
                        }
                        else
                        {
                            botonSel[i][j].setBackground(new Color(31, 222, 101));    
                        }
                    }
                }
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        panelAsientos = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botonContinuar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccion de asientos");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 32, 86));
        jPanel3.setLayout(null);
        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 380, 710, 20);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(null);

        panelAsientos.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(panelAsientos);
        panelAsientos.setBounds(90, 40, 430, 270);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pantalla");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(0, 0, 390, 20);

        jPanel7.add(jPanel4);
        jPanel4.setBounds(110, 10, 390, 20);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(40, 10, 610, 320);

        botonContinuar.setBackground(new java.awt.Color(51, 51, 51));
        botonContinuar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonContinuar.setForeground(new java.awt.Color(255, 255, 255));
        botonContinuar.setText("Siguiente");
        botonContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonContinuarMouseClicked(evt);
            }
        });
        jPanel1.add(botonContinuar);
        botonContinuar.setBounds(550, 340, 110, 23);

        jPanel8.setBackground(new java.awt.Color(31, 222, 101));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(30, 340, 30, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Disponible");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 340, 90, 30);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(170, 340, 30, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Ocupado");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 340, 70, 30);

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(290, 340, 30, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Seleccionado");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(330, 340, 110, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 710, 410);

        jPanel2.setBackground(new java.awt.Color(0, 32, 86));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccion de asientos");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 0, 190, 40);
        jPanel2.add(labelLogo);
        labelLogo.setBounds(630, 0, 40, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 710, 40);

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

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void botonContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonContinuarMouseClicked
        
        ArrayList lista = new ArrayList <Integer>(); 
       
        ResultSet rs = cnbd.getConsultas("SELECT Numero_AST, ID_EST FROM asientos WHERE ID_FNC = " + idFn);
               
        String numeroAst = "";
        int estadoAst = 0;
        
        try 
        {
            while(rs.next())
            {
                numeroAst = String.valueOf(rs.getInt("Numero_AST"));
                estadoAst = rs.getInt("ID_EST");
                
                for(int i = 0; i < filas; i++)
                {
                    for(int j = 0; j < columnas; j++)
                    {    
                        if(botonSel[i][j].isSelected() && botonSel[i][j].getText().equals(numeroAst) && estadoAst != 2)
                        {
                            lista.add(botonSel[i][j].getText());

                        }
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Consultar asientos disponibles", 2);
        }        
        
        if(lista.size() == totAsnt)
        {
            VentanaComprar vcr = new VentanaComprar(gse, idFn, idPl, lista, pr, totAsnt);
        
            this.dispose();
            vcr.setVisible(true);
        }
        else
           JOptionPane.showMessageDialog(null,"Seleccione la cantidad de asientos correcta (" + totAsnt + ")","Seleccionar asientos", 2);  
        
    }//GEN-LAST:event_botonContinuarMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaSeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSeleccionarAsientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelAsientos;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ic;
    private Icon icn;      
    private GetSetEmpleados gse;
    private ConsultasBD cnbd;
    private int idFn, idPl, totAsnt;
    private float pr;
}
