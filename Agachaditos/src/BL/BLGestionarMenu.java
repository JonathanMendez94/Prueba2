/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Menu;
import DAT.DATMenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 BL gestionar menu
 */
public class BLGestionarMenu {

    DATMenu objDATMenu = new DATMenu();
    BLGeneradorCodigos objBLGeneradorCodigos = new BLGeneradorCodigos();

    public ArrayList<String> obtMenu(String tipo) {
        try {
            ResultSet rs = objDATMenu.obtMenu(tipo);
            ArrayList<String> pMenu = new ArrayList<String>();
            while (rs.next()) {
                pMenu.add(rs.getString("nombre"));
            }
            return pMenu;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[] obtCodMenu(String menu) {
        try {
            String[] valores = new String[2];
            ResultSet rs = objDATMenu.buscarCodMenu(menu);
            while (rs.next()) {
                valores[0] = rs.getString("cgdmenu");
                valores[1] = rs.getString("precio");
                return valores;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int consTipo(String tipoM) {
        try {
            ResultSet rs = objDATMenu.buscarTipoM(tipoM);
            if (rs.next() == false) {
                return 1; //no hay datos semejante
            } else {
                return 0; //si hay datos semajentes
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; //si hay datos semajentes
    }

    public int envioTipoM(String tipoM) {
        String codigo = objBLGeneradorCodigos.envioCod("ct", "tipoMenu");
        int resTM = objDATMenu.agregarTipoMenu(codigo, tipoM);
        return resTM;
    }

    public ArrayList<String> obtTipo() {
        try {
            ResultSet rs = objDATMenu.obtTipo();
            ArrayList<String> tipoM = new ArrayList<String>();
            while (rs.next()) {
                tipoM.add(rs.getString("tipo"));
            }
            return tipoM;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String traeCodTipo(String tipo) {
        try {
            String codTipo = "";
            ResultSet rs = objDATMenu.buscarTipoM(tipo);
            while (rs.next()) {
                codTipo = rs.getString("cdgtipomenu");
            }
            return codTipo;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionarMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int agregarMenu(Menu objMenu) {
        int resMenu = objDATMenu.agregarMenu(objMenu);
        return resMenu;
    }

}
