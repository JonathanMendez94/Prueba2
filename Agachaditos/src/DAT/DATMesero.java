/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import BL.BLGeneradorCodigos;
import CL.Cliente;
import CL.Mesero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mash
 */
public class DATMesero {

    DATConexion objDATConeccion = new DATConexion();
    BLGeneradorCodigos objBLGeneradorCodigos = new BLGeneradorCodigos();

    public ResultSet ObtNomMeseros() {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM mesero";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarMesero(String nombre) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM mesero where  nombre = '" + nombre + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregar_mesero(Mesero objMesero) {
        try {
            String cod = objBLGeneradorCodigos.envioCod("cm", "mesero");
            String Sentencia = "INSERT INTO mesero(cdgmesero,cedula,nombre,apellido,clave,cdgusu) "
                    + "VALUES ( '"
                    + cod + "','"
                    + objMesero.getCedula() + "','"
                    + objMesero.getNombre() + "','"
                    + objMesero.getApellido() + "','"
                    + objMesero.getClave() + "','"
                    + objMesero.getTipo() + "' )";

            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet consultarCodigos(String codigo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT cdgmesero FROM mesero where cdgmesero= '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet BuscarMesero(String cedula) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM mesero  where  cedula = '" + cedula + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
