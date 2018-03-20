/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DATUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 BL gestionar
 * usuario
 */
public class BLGestionarUsuario {

    DATUsuario objDATUsuario = new DATUsuario();

    public ArrayList<String> obtNomUsua() {
        try {
            ResultSet rs = objDATUsuario.ObtNomUsua();
            ArrayList<String> nomUsua = new ArrayList<String>();
            while (rs.next()) {
                nomUsua.add(rs.getString("tipoU"));
            }
            return nomUsua;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[] datUsu(String tipo) {
        try {
            String[] datos = new String[2];
            ResultSet rs = objDATUsuario.ObtDatUsua(tipo);
            rs.next();
            datos[0] = rs.getString("tipoU");
            datos[1] = rs.getString("cdgusu");
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
