/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Mesa;
import DAT.DATMesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 gestionar mesa
 */
public class BLGestionarMesa {

    DATMesa objDATMesa = new DATMesa();

    public ArrayList<String> obtNumMesa() {
        try {
            ResultSet rs = objDATMesa.ObtNumMesa();
            ArrayList<String> nomMesa = new ArrayList<String>();
            while (rs.next()) {
                nomMesa.add(rs.getString("numero"));
            }
            return nomMesa;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String obtCodMesa(String mesa) {
        try {
            String codigo = null;
            ResultSet rs = objDATMesa.buscarMesa(mesa);
            while (rs.next()) {
                codigo = rs.getString("cdgmesa");
            }
            return codigo;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int envioMesa(Mesa objMesa) {
        int resMesa = objDATMesa.agregarMesa(objMesa);
        return resMesa;
    }

    public String[][] DatosMesa() {
        try {
            ArrayList<String> codi = new ArrayList<String>();
            ArrayList<String> numero = new ArrayList<String>();
            ArrayList<String> comensales = new ArrayList<String>();

            ResultSet rs = objDATMesa.ObtNumMesa();

            while (rs.next()) {
                codi.add(rs.getString("cdgmesa"));
                numero.add(rs.getString("numero"));
                comensales.add(rs.getString("comensales"));
            }

            //pasamos los valores al arreglo bidimensional
            String[][] valores = new String[codi.size()][3];
            for (int i = 0; i < codi.size(); i++) {
                valores[i][0] = codi.get(i);
                valores[i][1] = numero.get(i);
                valores[i][2] = comensales.get(i);
            }
            return valores;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int confElimina(String codigo) {
        int restElimi = objDATMesa.EliminarRegistro(codigo);
        return restElimi;
    }

}
