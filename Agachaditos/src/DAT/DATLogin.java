/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import CL.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mash
 */
public class DATLogin {

    DATConexion objDATConeccion = new DATConexion();

    //metodo que va a a consultar codigos de la BD
    public ResultSet consultarLogin(Login objLogin) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM " + objLogin.getTipo() + " where cedula = '" + objLogin.getCi() + "' AND clave = '" + objLogin.getPass() + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
