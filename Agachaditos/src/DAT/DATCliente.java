/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import BL.BLGeneradorCodigos;
import CL.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jrmjo
 */
public class DATCliente {

    DATConexion objDATConeccion = new DATConexion();
    BLGeneradorCodigos objBLGeneradorCodigos = new BLGeneradorCodigos();

    //metodo que va a a consultar codigos de la BD
    public ResultSet consultarCodigos(String codigo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
    
        String Sentencia = "SELECT cdgcl FROM cliente where cdgcl= '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet BuscarCliente(String cedula) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM cliente  where  cedula = '" + cedula + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregar_cliente(Cliente objCliente) {
        try {
            String cod = objBLGeneradorCodigos.envioCod("cc","cliente");
            String Sentencia = "INSERT INTO cliente(cdgcl,cedula,nombre,apellido) "
                    + "VALUES ( '"
                    + cod + "','"
                    + objCliente.getIdentificacion() + "','"
                    + objCliente.getNombre() + "','"
                    + objCliente.getApellido() + "' )";
            
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
