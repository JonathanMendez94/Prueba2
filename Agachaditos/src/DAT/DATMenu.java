/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import CL.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mash
 */
public class DATMenu {

    DATConexion objDATConeccion = new DATConexion();

    public ResultSet obtMenu(String tipo) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT nombre FROM menu where tipo = '" + tipo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarCodMenu(String menu) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM menu where nombre = '" + menu + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarNomMenu(String cogMenu) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM menu where  cgdmenu = '" + cogMenu + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarTipoM(String tipoM) {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM tipo_menu where tipo = '" + tipoM + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet CCTipoMenu(String codigo) {//consultar codigo existe
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT cdgtipomenu FROM tipo_menu where cdgtipomenu = '" + codigo + "'";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregarTipoMenu(String codigo, String tipo) {
        try {
            String Sentencia = "INSERT INTO tipo_menu(cdgtipomenu,tipo) "
                    + "VALUES ( '"
                    + codigo + "','"
                    + tipo + "' )";

            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet obtTipo() {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM tipo_menu";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregarMenu(Menu objMenu) {
        try {
            String Sentencia = "INSERT INTO menu(cgdmenu,nombre,precio,tipo) "
                    + "VALUES ( '"
                    + objMenu.getCodigo() + "','"
                    + objMenu.getNombre() + "','"
                    + objMenu.getPrecio() + "','"
                    + objMenu.getTipo() + "' )";

            Statement st = objDATConeccion.AbrirConexion().createStatement();
            return st.executeUpdate(Sentencia);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet obtMenu() {
        try {
            Statement st = objDATConeccion.AbrirConexion().createStatement();
            String Sentencia = "SELECT * FROM menu";
            ResultSet rs = st.executeQuery(Sentencia);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
