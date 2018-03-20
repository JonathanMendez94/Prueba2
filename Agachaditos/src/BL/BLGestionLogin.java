/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CL.Login;
import DAT.DATLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author Santiago Aguirre, Jonathan Méndez
 * Fecha: 26-07-2017
 * BL gestion loguin 
 */
public class BLGestionLogin {

    DATLogin objDATLogin = new DATLogin();

    public String valiIngreso(Login objLogin) {
        try {
            String tipo = "";
            ResultSet rs = objDATLogin.consultarLogin(objLogin);
            while (rs.next()) {
                tipo = rs.getString("cdgusu");
            }
            return tipo;
        } catch (SQLException ex) {
            Logger.getLogger(BLGestionLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
