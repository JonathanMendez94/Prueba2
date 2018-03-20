/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Cliente;
import DAT.DATCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez
 * Fecha: 26-07-2017
 * BL gestionar cliente 
 */
public class BLGestionarCliente {
    
    DATCliente objDATCliente = new DATCliente();

    public Cliente comprobarExistenciaCliente(String cedula) {
        try {
            Cliente objCliente = new Cliente();
            ResultSet rs = new DAT.DATCliente().BuscarCliente(cedula);
            if (rs.next() == false) {
                return objCliente;
            } else {
                objCliente = new Cliente(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"));
                return objCliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //cliente a registrar
    public int envioCliente(Cliente objCliente) {
        int resCliente = objDATCliente.agregar_cliente(objCliente);
        return resCliente;
    }
    
    public String obtCodCliente(String cedula){
        try {
            ResultSet rs = objDATCliente.BuscarCliente(cedula);
            rs.next();
            String codigo = rs.getString("cdgcl");
            return codigo;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
}
