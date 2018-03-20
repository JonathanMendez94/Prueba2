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
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 DAT adiministrador
 */
public class DATAdministrador {

    DATConexion objDATConeccion = new DATConexion();

    public ResultSet Presentar(String tipo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM " + tipo;
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int EliminarRegistro(String tipo, String cedula) {
        try {
            String Sentencia = "DELETE FROM " + tipo + " WHERE cedula = '" + cedula + "'";
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
