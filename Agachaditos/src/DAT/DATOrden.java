/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mash
 */
public class DATOrden {

    DATConexion objDATConeccion = new DATConexion();

    public ResultSet consultarCodigos(String codigo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM orden where codOrden = '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregar_orden(String codOrden, int cantidad, Float precio, String codigoMenu) {
        try {
            String Sentencia = "INSERT INTO orden(codOrden,cantpedido,precioOrden,cdgmenu) "
                    + "VALUES ( '"
                    + codOrden + "','"
                    + cantidad + "','"
                    + precio + "','"
                    + codigoMenu + "' )";

            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet SacarCodOrdenDist(String codOrden) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT DISTINCT cdgmenu FROM orden WHERE codOrden = '" + codOrden + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet ValoresMenu(String codMenu, String codOrden) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM orden WHERE cdgmenu = '" + codMenu + "' and codOrden = '" + codOrden + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int EliminarOrden(String codOrden) {
        try {
            String Sentencia = "DELETE FROM orden WHERE codOrden = '" + codOrden + "'";
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
