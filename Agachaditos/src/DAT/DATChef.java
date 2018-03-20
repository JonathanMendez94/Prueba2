/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import BL.BLGeneradorCodigos;
import CL.Chef;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 DAT chef
 */
public class DATChef {

    DATConexion objDATConeccion = new DATConexion();
    BLGeneradorCodigos objBLGeneradorCodigos = new BLGeneradorCodigos();

    public ResultSet BuscarChef(String cedula) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM chef  where  cedula = '" + cedula + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregar_chef(Chef objChef) {
        try {
            String cod = objBLGeneradorCodigos.envioCod("cf", "chef");
            String Sentencia = "INSERT INTO chef(cdgchef,cedula,nombre,apellido,clave,cdgusu) "
                    + "VALUES ( '"
                    + cod + "','"
                    + objChef.getCedula() + "','"
                    + objChef.getNombre() + "','"
                    + objChef.getApellido() + "','"
                    + objChef.getClave() + "','"
                    + objChef.getTipo() + "' )";

            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATChef.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet consultarCodigos(String codigo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT cdgchef FROM chef where cdgchef = '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int EliminarRegistro(String opcion, String tipo, String codigo) {
        try {
            String Sentencia = "DELETE FROM " + opcion + " WHERE " + tipo + " = '" + codigo + "'";
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATChef.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
