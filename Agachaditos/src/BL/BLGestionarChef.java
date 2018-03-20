/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Chef;
import DAT.DATChef;
import DAT.DATMenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez
 * Fecha: 26-07-2017
 * BL gestionar chef 
 */
public class BLGestionarChef {
    
    DATChef objDATChef = new DATChef();
    DATMenu objDATMenu = new DATMenu();
    
    public String comprobarExistenciaChef(String cedula) {
        try {
            ResultSet rs = objDATChef.BuscarChef(cedula);
            if (rs.next() == false) {
                return "no";
            } else {
                return "si";
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarChef.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no";
    }
    
    public int envioChef(Chef objChef) {
        int resCliente = objDATChef.agregar_chef(objChef);
        return resCliente;
    }
    
    public String[][] DatosTipo() {
        try {
            ArrayList<String> codi = new ArrayList<String>();
            ArrayList<String> tipo = new ArrayList<String>();

            ResultSet rs = objDATMenu.obtTipo();

            while (rs.next()) {
                codi.add(rs.getString("cdgtipomenu"));
                tipo.add(rs.getString("tipo"));
            }

            //pasamos los valores al arreglo bidimensional
            String[][] valores = new String[codi.size()][2];
            for (int i = 0; i < codi.size(); i++) {
                valores[i][0] = codi.get(i);
                valores[i][1] = tipo.get(i);
            }
            return valores;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarChef.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String[][] DatosMenu() {
        try {
            ArrayList<String> codi = new ArrayList<String>();
            ArrayList<String> nombre = new ArrayList<String>();
            ArrayList<String> precio = new ArrayList<String>();

            ResultSet rs = objDATMenu.obtMenu();

            while (rs.next()) {
                codi.add(rs.getString("cgdmenu"));
                nombre.add(rs.getString("nombre"));
                precio.add(rs.getString("precio"));
            }

            //pasamos los valores al arreglo bidimensional
            String[][] valores = new String[codi.size()][3];
            for (int i = 0; i < codi.size(); i++) {
                valores[i][0] = codi.get(i);
                valores[i][1] = nombre.get(i);
                valores[i][2] = precio.get(i);
            }
            return valores;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarChef.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int confElimina(String opcion, String tipo, String codigo) {
        int restElimi = objDATChef.EliminarRegistro(opcion, tipo, codigo);
        return restElimi;
    }
    
}
