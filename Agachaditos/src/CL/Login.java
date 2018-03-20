/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CL;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 Clase Loguin
 */
public class Login {

    private String tipo;
    private String ci;
    private String pass;

    public Login(String tipo, String ci, String pass) {
        this.tipo = tipo;
        this.ci = ci;
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
