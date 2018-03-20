/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DATChef;
import DAT.DATCliente;
import DAT.DATFactura;
import DAT.DATMenu;
import DAT.DATMesa;
import DAT.DATMesero;
import DAT.DATOrden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jrmjo
 */
public class BLGeneradorCodigos {

    public String envioCod(String clave, String tipo) {
        String cod = codigoCliente(clave, tipo);
        while ("".equals(cod)) {
            cod = codigoCliente(clave, tipo);
        }
        return cod;
    }

    //concatenamos el codigo
    String codigoCliente(String clave, String tipo) {
        int num = generarAleatorio();
        String cod = (clave + num);
        int resValida = valCcliente(cod, tipo);
        if (resValida == 1) {
            return cod;
        }
        return "";
    }

    int valCcliente(String cod, String tipo) {
        try {
            ResultSet rs;
            switch (tipo) {
                case "cliente":
                    rs = new DATCliente().consultarCodigos(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "orden":
                    rs = new DATOrden().consultarCodigos(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "factura":
                    rs = new DATFactura().consultarCodigos(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "mesero":
                    rs = new DATMesero().consultarCodigos(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "chef":
                    rs = new DATChef().consultarCodigos(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "tipoMenu":
                    rs = new DATMenu().CCTipoMenu(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "menu":
                    rs = new DATMenu().buscarNomMenu(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
                case "mesa":
                    rs = new DATMesa().buscarCodM(cod);
                    if (rs.next() == false) {
                        return 1;
                    }
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BLGeneradorCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    int generarAleatorio() {
        int num = (int) (Math.random() * 20) + 1;
        return num;
    }

}
