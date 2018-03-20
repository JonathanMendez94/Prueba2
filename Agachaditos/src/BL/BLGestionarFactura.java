/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Factura;
import DAT.DATFactura;
import DAT.DATOrden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez
 * Fecha: 26-07-2017
 * BL gestionar factura 
 */
public class BLGestionarFactura {

    DATFactura objDATFactura = new DATFactura();
    BLGeneradorCodigos objBLGeneradorCodigos = new BLGeneradorCodigos();
    DATOrden objDATOrden = new DATOrden();
    BLGestionarCliente objBLGestionarCliente = new BLGestionarCliente();
    BLGestionarMesero objBLGestionarMesero = new BLGestionarMesero();
    BLGestionarMesa objBLGestionarMesa = new BLGestionarMesa();

    public int procesarFactura(Factura objFactura) {
        try {
            String cod = objBLGeneradorCodigos.envioCod("cf", "factura");//codigo de factura
            //obtenemos precio total de la orden
            ResultSet rs = objDATOrden.consultarCodigos(objFactura.getOrden());
            double precTotal = 0;
            while (rs.next()) {
                String temPrecio = rs.getString("precioOrden");
                precTotal = (precTotal + (Float.parseFloat(temPrecio)));
            }
            Float total = Float.parseFloat(precTotal + "");
            //obtenemos codigos
            String codCliente = objBLGestionarCliente.obtCodCliente(objFactura.getCliente());//codigo de cliente
            String codMesero = objBLGestionarMesero.obtCodMesero(objFactura.getMesero());//codigo de mesero
            String codMesa = objBLGestionarMesa.obtCodMesa(objFactura.getMesa());
            //arreglo con codigos para la factura
            String[] codigos = {cod, codCliente, codMesero, codMesa, objFactura.getOrden()};
            int resFact = objDATFactura.agregar_factura(codigos, total);
            return resFact;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
