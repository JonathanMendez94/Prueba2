/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Cliente;
import CL.Mesero;
import DAT.DATMesero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 BL gestionar
 * mesero
 */
public class BLGestionarMesero {

    DATMesero objDATMesero = new DATMesero();

    public ArrayList<String> obtNomMesero() {
        try {
            ResultSet rs = objDATMesero.ObtNomMeseros();
            ArrayList<String> nomMeseros = new ArrayList<String>();
            while (rs.next()) {
                nomMeseros.add(rs.getString("nombre"));
            }
            return nomMeseros;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String obtCodMesero(String nombre) {
        try {
            ResultSet rs = objDATMesero.buscarMesero(nombre);
            rs.next();
            String codigo = rs.getString("cdgmesero");
            return codigo;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String comprobarExistenciaMesero(String cedula) {
        try {
            ResultSet rs = new DAT.DATMesero().BuscarMesero(cedula);
            if (rs.next() == false) {
                return "no";
            } else {
                return "si";
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no";
    }

    public int envioMesero(Mesero objMesero) {
        int resCliente = objDATMesero.agregar_mesero(objMesero);
        return resCliente;
    }

}
