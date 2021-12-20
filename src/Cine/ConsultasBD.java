package Cine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConsultasBD
{
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private ConexionBD cbd;
    
    ConsultasBD()
    {
        cbd = new ConexionBD();
        
        try 
        {
            st = cbd.getConectar().createStatement();
        }         
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Conexion BD", 2);
        } 
        
        ps = null;
        rs = null;
    }
    
    public int getGenerarId(String consulta)
    {
        int id = 0;
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                id = rs.getInt(1) + 1;
            }
            
            ps.close();
            rs.close();
            cbd.getDesconectar();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Generar ID", 2);
        }
    
        return id;
    }    

    public ResultSet getLlenarComboBox(String consulta)
    {
        try 
        {
            rs = st.executeQuery(consulta);
            
            cbd.getDesconectar();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Llenar combo box", 2);
        }
        
       return rs;
    }        
    
    public int getComprobarUsuario(String usuario)
    {
        try 
        {
            String consulta = "SELECT COUNT(ID_EMP) FROM empleados WHERE Usuario_EMP = ? ";
            
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setString(1, usuario);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                return rs.getInt(1);
            }
            
            return 1;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar usuarios", 2);
            return 1;
        }
    }    
    
    public boolean getRegistrarUsuarios(GetSetEmpleados gse)
    {
        String consulta = "";
        
        consulta = "INSERT INTO EMPLEADOS (ID_EMP, Nombre_EMP, Apellido_EMP, Usuario_EMP , Clave_EMP, FechaIngreso_EMP,"
                + "UltimoAcceso_EMP ,ID_CRG) VALUES(?,?,?,?,?,?,?,?)";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setInt(1, gse.getId());
            ps.setString(2, gse.getNombre());
            ps.setString(3, gse.getApellido());
            ps.setString(4, gse.getUsuario());
            ps.setString(5, gse.getClave());
            ps.setString(6, gse.getFechaIngreso());
            ps.setString(7, null);
            ps.setInt(8, gse.getCargo());
            
            ps.execute();

            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar empleados", 2);
            return false;
        }
    }
        
    public boolean getComprobarLogin(GetSetEmpleados gse)
    {
        try 
        {
            String consulta = "SELECT e.ID_EMP, e.Usuario_EMP, e.Clave_EMP, e.Nombre_EMP, e.Apellido_EMP, e.ID_CRG, c.Nombre_CRG FROM empleados AS e "
                    + "INNER JOIN cargo AS c ON e.ID_CRG = c.ID_CRG WHERE Usuario_EMP = ?";
            
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setString(1, gse.getUsuario());
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                if(gse.getClave().equals(rs.getString("Clave_EMP")))
                {
                    String modificacion = "UPDATE empleados SET UltimoAcceso_EMP = ? WHERE ID_EMP = ?";
                    
                    ps = cbd.getConectar().prepareStatement(modificacion);
                    
                    ps.setString(1, gse.getUltimoAcceso());
                    ps.setInt(2, rs.getInt("ID_EMP"));
                    
                    ps.execute();
                    
                    gse.setId(rs.getInt("ID_EMP"));
                    gse.setNombre(rs.getString("Nombre_EMP"));
                    gse.setApellido(rs.getString("Apellido_EMP"));
                    gse.setCargo(rs.getInt("ID_CRG"));
                    gse.setNombreCargo(rs.getString("Nombre_CRG"));
                    
                    cbd.getDesconectar();
                    
                    return true;
                }
                else
                    return false;
            }
            
            return false;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Login", 2);
            return false;
        }
    }
    
    public boolean getRegistrarPeliculas(GetSetPeliculas gsp)
    {
        String consulta = "";
        
        consulta = "INSERT INTO PELICULAS (ID_PLC, Poster_PLC, Nombre_PLC, Ano_PLC, Duracion_PLC, Sinopsis_PLC,"
                + " ID_CFC) VALUES(?,?,?,?,?,?,?)";
        
        try 
        {
            FileInputStream fis = new FileInputStream(gsp.getPoster());
            
            try 
            {
                ps = cbd.getConectar().prepareStatement(consulta);
                        
                ps.setInt(1, gsp.getId());
                ps.setBinaryStream(2, fis, (int) gsp.getPoster().length());
                ps.setString(3, gsp.getTitulo());
                ps.setInt(4, gsp.getAno());
                ps.setInt(5, gsp.getDuracion());
                ps.setString(6, gsp.getSinopsis());
                ps.setInt(7, gsp.getClasificacion());
            
                ps.execute();

                cbd.getDesconectar();
                
                return true;
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar empleados", 2);
                return false;
            }       
        } 
        catch (FileNotFoundException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar empleados", 2);
            return false;
        }
    }   
    
    public int getConsultarPeliculas(String pelicula)
    {
        String consulta = "SELECT ID_PLC FROM peliculas WHERE Nombre_PLC = '" + pelicula + "'";
        int id = 0;
        
        try 
        {
            rs = st.executeQuery(consulta);
            
            if(rs.next())
                id = rs.getInt("ID_PLC");
            
            cbd.getDesconectar();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Consultar pelicula", 2);
        }
        
        return id;
    }
    
    public boolean getRegistrarFuncion(GetSetFunciones gsf)
    {
        String consulta = "";
        
        consulta = "INSERT INTO FUNCIONES (ID_FNC, Dia_FNC, Hora_FNC, ID_PLC, ID_SL, ID_AD) VALUES(?,?,?,?,?,?)";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, gsf.getId());
            ps.setString(2, gsf.getDia());
            ps.setString(3, gsf.getHora());
            ps.setInt(4, gsf.getPelicula());
            ps.setInt(5, gsf.getSala());
            ps.setInt(6, gsf.getAudio());
            
            ps.execute();
            
            cbd.getDesconectar();
 
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar funciones", 2);
            return false;
        }        
    }    
    
    public boolean getRegistrarAsientos(GetSetFunciones gsf, int capacidad)
    {
        String consulta = "";
        
        consulta = "INSERT INTO ASIENTOS (ID_AST, Numero_AST, ID_FNC, ID_SL, ID_EST) VALUES(?,?,?,?,?)";
        
        int cont = 1;
            
        try 
        {
            int idAst = getGenerarId("SELECT MAX(ID_AST) FROM asientos");
            
            for (int i = 0; i < capacidad; i++) 
            {
                ps = cbd.getConectar().prepareStatement(consulta);

                ps.setInt(1, idAst++);
                ps.setInt(2, cont++);
                ps.setInt(3, gsf.getId());
                ps.setInt(4, gsf.getSala());
                ps.setInt(5, 1);

                ps.execute();
            }
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar asientos", 2);
            return false;
        }
    }   

    public boolean getRegistrarPrecioBoleto(GetSetPrecioBoleto gspb)
    {
        String consulta = "";
        
        consulta = "INSERT INTO TIPO_BOLETO (ID_TBLT, Nombre_TBLT, Precio_TBLT) VALUES(?,?,?)";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, 1);
            ps.setString(2, "Niño");
            ps.setFloat(3, gspb.getPrecioNino());
            
            ps.execute();
            
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, 2);
            ps.setString(2, "Adulto");
            ps.setFloat(3, gspb.getPrecioAdulto());
            
            ps.execute();
            
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, 3);
            ps.setString(2, "Anciano");
            ps.setFloat(3, gspb.getPrecioAnciano());
            
            ps.execute();            
            
            cbd.getDesconectar();

            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar precios", 2);
            return false;
        }           
    }
    
    public boolean getRegistrarSala(GetSetSala gss)
    {
        String consulta = "";
        
        consulta = "INSERT INTO SALAS (ID_SL, Numero_SL, Capacidad_SL, ID_TSL) VALUES(?,?,?,?)";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, gss.getId());
            ps.setInt(2, gss.getNumero());
            ps.setInt(3, gss.getCapacidad());
            ps.setInt(4, gss.getTipo());
            
            ps.execute();
            
            cbd.getDesconectar();

            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar salas", 2);
            return false;
        }        
    }  
    
    public boolean getRegistrarClientes(GetSetBoletos gsb)
    {
        String consulta = "";
        
        consulta = "INSERT INTO CLIENTES (ID_CL, Nombre_CL) VALUES(?,?)";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, gsb.getIdCl());
            ps.setString(2, gsb.getNombreCl());
            
            ps.execute();
            
            cbd.getDesconectar();

            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar clientes", 2);
            return false;
        }        
    }      
   
    public boolean getRegistrarBoletos(GetSetBoletos gsb)
    {
        String consulta = "";
        
        consulta = "INSERT INTO BOLETOS (ID_BLT, Pelicula_BLT, Vendedor_BLT, FechaCompra_BLT, NumeroSala_BLT, Cantidad_BLT, Asientos_BLT, Dia_BLT, Hora_BLT, Total_BLT, ID_CL) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setInt(1, gsb.getIdBl());
            ps.setString(2, gsb.getNombrePelicula());
            ps.setString(3, gsb.getVendedor());
            ps.setString(4, gsb.getFechaCmp());
            ps.setInt(5, gsb.getNumSala());
            ps.setInt(6, gsb.getCantBl());
            ps.setString(7, gsb.getAsientos());
            ps.setString(8, gsb.getDia());
            ps.setString(9, gsb.getHora());
            ps.setFloat(10, gsb.getTotalBl());
            ps.setInt(11, gsb.getIdCl());
            
            ps.execute();
            
            cbd.getDesconectar();

            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Registrar compra de boletos", 2);
            return false;
        }        
    } 
    
    public boolean getModificarEmpleados(GetSetEmpleados gse)
    {
        String consulta = "";
        
        consulta = "UPDATE empleados SET Nombre_EMP = ?, Apellido_EMP = ?, Usuario_EMP = ?, Clave_EMP = ?, ID_CRG = ? WHERE ID_EMP = ?";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setString(1, gse.getNombre());
            ps.setString(2, gse.getApellido());
            ps.setString(3, gse.getUsuario());
            ps.setString(4, gse.getClave());
            ps.setInt(5, gse.getCargo());
            ps.setInt(6, gse.getId());
            
            ps.executeUpdate();
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Modificar salas", 2);
            return false;
        }           
    }
    
    public boolean getModificarPeliculas(GetSetPeliculas gsp)
    {
        String consulta = "";
        
        consulta = "UPDATE peliculas SET Nombre_PLC = ?, Ano_PLC = ?, Duracion_PLC = ?, Sinopsis_PLC = ?, ID_CFC = ? WHERE ID_PLC = ?";
                
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setString(1, gsp.getTitulo());
            ps.setInt(2, gsp.getAno());
            ps.setInt(3, gsp.getDuracion());
            ps.setString(4, gsp.getSinopsis());
            ps.setInt(5, gsp.getClasificacion());
            ps.setInt(6, gsp.getId());
            
            ps.executeUpdate();
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Modificar peliculas", 2);
            return false;
        }          
    }
    
    public boolean getModificarPrecios(GetSetPrecioBoleto gspb)
    {
        String consulta = "";
        
        consulta = "UPDATE TIPO_BOLETO SET Precio_TBLT = ? WHERE ID_TBLT = ?";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);

            ps.setFloat(1, gspb.getPrecioNino());
            ps.setInt(2, 1);
            
            ps.executeUpdate();
            
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setFloat(1, gspb.getPrecioAdulto());
            ps.setInt(2, 2);
            
            ps.executeUpdate();
            
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setFloat(1, gspb.getPrecioAnciano());
            ps.setInt(2, 3);
            
            ps.executeUpdate();            
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Modificar precios", 2);
            return false;
        }        
    }
    
    public boolean getModificarFunciones(GetSetFunciones gsf)
    {
        String consulta = "", consulta2 = "";
        
        consulta = "UPDATE funciones SET Dia_FNC = ?, Hora_FNC = ?, ID_PLC = ?, ID_SL = ? WHERE ID_FNC = ?";
        consulta2 = "UPDATE asientos SET ID_SL = ? WHERE ID_FNC = ?";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta2);
            
            ps.setInt(1, gsf.getSala());
            ps.setInt(2, gsf.getId());
            
            ps.executeUpdate();           
            
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setString(1, gsf.getDia());
            ps.setString(2, gsf.getHora());
            ps.setInt(3, gsf.getPelicula());
            ps.setInt(4, gsf.getSala());
            ps.setInt(5, gsf.getId());
            
            ps.executeUpdate();
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Modificar funciones", 2);
            return false;
        }        
    }    
    
    public boolean getModificarSalas(GetSetSala gss)
    {
        String consulta = "";
        
        consulta = "UPDATE salas SET Numero_SL = ?, ID_TSL = ? WHERE ID_SL = ?";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setInt(1, gss.getNumero());
            ps.setInt(2, gss.getTipo());
            ps.setInt(3, gss.getId());            
            
            ps.executeUpdate();
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Modificar salas", 2);
            return false;
        }        
    }
    
    public boolean getModificarAsientos(GetSetAsientos gsa)
    {
        String consulta = "";
        
        consulta = "UPDATE ASIENTOS SET ID_EST = 2, ID_CL = ? WHERE Numero_AST = ? AND ID_FNC = ? ";
        
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);
            
            ps.setInt(1, gsa.getIdCl());
            ps.setInt(2, gsa.getNumAsiento());
            ps.setInt(3, gsa.getIdFuncion());
            
            ps.executeUpdate();
            
            cbd.getDesconectar();
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Reservar asientos", 2);
            return false;
        }
    }
    
    public boolean getEliminar(String consulta)
    {
        try
        {         
            ps = cbd.getConectar().prepareStatement(consulta);
            
            //ps.executeUpdate(consulta);   
            
            ps.executeUpdate();
            
            cbd.getDesconectar();
            
            return true;
        }
        catch(Exception e)
        {
            return false;
        }         
    }
    
    public int getBuscar(String consulta)
    {
        try 
        {
            ps = cbd.getConectar().prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                return rs.getInt(1);
            }
            
            return 1;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Buscar existentes", 2);
            return 1;
        }        
    }
    
    public ResultSet getConsultas(String consulta)
    {
        try 
        {                   
            rs = st.executeQuery(consulta);
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Busqueda", 2);
        }
        
        return rs;        
    } 
}
