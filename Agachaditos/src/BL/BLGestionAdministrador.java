/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DATAdministrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez
 * Fecha: 26-07-2017
 * BL gestion administrador 
 */
public class BLGestionAdministrador {

    DATAdministrador objDATAdministrador = new DATAdministrador();

    public String[][] Datos(String tipo) {
        try {
            ArrayList<String> cedula = new ArrayList<String>();
            ArrayList<String> nombre = new ArrayList<String>();
            ArrayList<String> apellido = new ArrayList<String>();

            ResultSet rs = objDATAdministrador.Presentar(tipo);

            while (rs.next()) {
                cedula.add(rs.getString("cedula"));
                nombre.add(rs.getString("nombre"));
                apellido.add(rs.getString("apellido"));
            }

            //pasamos los valores al arreglo bidimensional
            String[][] valores = new String[cedula.size()][3];
            for (int i = 0; i < cedula.size(); i++) {
                valores[i][0] = cedula.get(i);
                valores[i][1] = nombre.get(i);
                valores[i][2] = apellido.get(i);
            }
            return valores;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int confElimina(String tipo, String cedula) {
        int restElimi = objDATAdministrador.EliminarRegistro(tipo, cedula);
        return restElimi;
    }
}
