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
public class DATFactura {

    DATConexion objDATConeccion = new DATConexion();

    public ResultSet consultarCodigos(String codigo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM factura where codfac = '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregar_factura(String[] codigos, Float total) {
        try {
            String Sentencia = "INSERT INTO factura(codfac,totalCom,cdgCliente,cdgmesro,cdgmesa,cdgorden) "
                    + "VALUES ( '"
                    + codigos[0] + "','"
                    + total + "','"
                    + codigos[1] + "','"
                    + codigos[2] + "','"
                    + codigos[3] + "','"
                    + codigos[4] + "' )";
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
