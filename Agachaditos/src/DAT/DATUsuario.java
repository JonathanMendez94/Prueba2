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
public class DATUsuario {

    DATConexion objDATConeccion = new DATConexion();

    public ResultSet ObtNomUsua() {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM usuario";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet ObtDatUsua(String tipo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM usuario WHERE tipoU = '" + tipo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
