/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Orden;
import DAT.DATMenu;
import DAT.DATOrden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 BL gestionar orden
 */
public class BLGestionarOrden {

    BLGestionarCliente objBLGestionarCliente = new BLGestionarCliente();
    BLGestionarMesero objBLGestionarMesero = new BLGestionarMesero();
    BLGestionarMesa objBLGestionarMesa = new BLGestionarMesa();
    BLGestionarMenu objBLGestionarMenu = new BLGestionarMenu();
    DATOrden objDATOrden = new DATOrden();

    public int registrarOrden(Orden objOrden) {
        Float pPedido;

        String[] valEntrada = objBLGestionarMenu.obtCodMenu(objOrden.getEntrada());
        pPedido = calcularPrecio(valEntrada[1], objOrden.getCantEntrada());
        objDATOrden.agregar_orden(objOrden.getCodigo(), objOrden.getCantEntrada(), pPedido, valEntrada[0]);

        String[] valFuerte = objBLGestionarMenu.obtCodMenu(objOrden.getFuerte());
        pPedido = calcularPrecio(valFuerte[1], objOrden.getCantFuete());
        objDATOrden.agregar_orden(objOrden.getCodigo(), objOrden.getCantFuete(), pPedido, valFuerte[0]);

        String[] valBebida = objBLGestionarMenu.obtCodMenu(objOrden.getBebida());
        pPedido = calcularPrecio(valBebida[1], objOrden.getCantBebida());
        objDATOrden.agregar_orden(objOrden.getCodigo(), objOrden.getCantBebida(), pPedido, valBebida[0]);
        return 1;
    }

    public String[][] DatosOrden(String codOrden) {
        try {
            ArrayList<String> pedido = new ArrayList<String>();
            ArrayList<String> cantidad = new ArrayList<String>();
            ArrayList<String> precio = new ArrayList<String>();

            ResultSet rsT1 = objDATOrden.SacarCodOrdenDist(codOrden);

            while (rsT1.next()) {
                //obtenemos el nombre del plato de la orden
                ResultSet rsT2 = new DATMenu().buscarNomMenu(rsT1.getString("cdgmenu"));
                rsT2.next();
                pedido.add(rsT2.getString("nombre"));
                //obtenemos cantidades del plato de la orden
                ResultSet rsT3 = objDATOrden.ValoresMenu(rsT1.getString("cdgmenu"), codOrden);
                int cantTotal = 0;
                double precTotal = 0;
                while (rsT3.next()) {
                    //sumamos todas las cantidades del plato
                    cantTotal = (cantTotal + rsT3.getInt("cantpedido"));
                    //obtenemos precios del plato de la orden
                    String temPrecio = rsT3.getString("precioOrden");
                    precTotal = (precTotal + (Float.parseFloat(temPrecio)));
                }
                cantidad.add(cantTotal + "");
                precio.add(precTotal + "");
            }

            //pasamos los valores al arreglo bidimensional
            String[][] valores = new String[pedido.size()][3];
            for (int i = 0; i < pedido.size(); i++) {
                valores[i][0] = pedido.get(i);
                valores[i][1] = cantidad.get(i);
                valores[i][2] = precio.get(i);
            }
            return valores;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int eliminarOrden(String codOrden) {
        int resEliOrde = objDATOrden.EliminarOrden(codOrden);
        return resEliOrde;
    }

    Float calcularPrecio(String precio, int cantidad) {
        Float precioU = Float.parseFloat(precio);
        Float pPedido = (precioU * cantidad);
        return pPedido;
    }
}
