/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 BL validar
 */
public class BLValidar {

    public int validarSeleccion(String validar, String palabra) {
        if ("seleccionar".equals(validar)) {
            Component parentComponent = null;
            //JOptionPane.showMessageDialog(parentComponent, "Seleccione " + palabra);
            return 0;
        }
        return 1;
    }

    public int validaPermiso(int[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                int res = 0;
                return res;
            }
        }
        return 1;
    }

}
