/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import CL.Menu;
import CL.Mesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mash
 */
public class DATMesa {

    DATConexion objDATConeccion = new DATConexion();

    public ResultSet ObtNumMesa() {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM mesa";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarMesa(String mesa) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM mesa where  numero = '" + mesa + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarCodM(String codigo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM mesa where cdgmesa = '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregarMesa(Mesa objMesa) {
        try {
            String Sentencia = "INSERT INTO mesa(cdgmesa,numero,comensales) "
                    + "VALUES ( '"
                    + objMesa.getCodigo() + "','"
                    + objMesa.getNumero() + "','"
                    + objMesa.getComensales() + "' )";

            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int EliminarRegistro(String codigo) {
        try {
            String Sentencia = "DELETE FROM mesa WHERE cdgmesa = '" + codigo + "'";
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
