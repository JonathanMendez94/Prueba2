/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CL;

/**
 * author Santiago Aguirre, Jonathan Méndez
 * Fecha: 26-07-2017
 * Clase Orden 
 */
public class Orden {
    private String codigo;
    private String Entrada;
    private String Fuerte;
    private String Bebida;
    private int cantEntrada;
    private int cantFuete;
    private int cantBebida;

    public Orden(String codigo, String Entrada, String Fuerte, String Bebida, int cantEntrada, int cantFuete, int cantBebida) {
        this.codigo = codigo;
        this.Entrada = Entrada;
        this.Fuerte = Fuerte;
        this.Bebida = Bebida;
        this.cantEntrada = cantEntrada;
        this.cantFuete = cantFuete;
        this.cantBebida = cantBebida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getEntrada() {
        return Entrada;
    }

    public void setEntrada(String Entrada) {
        this.Entrada = Entrada;
    }

    public String getFuerte() {
        return Fuerte;
    }

    public void setFuerte(String Fuerte) {
        this.Fuerte = Fuerte;
    }

    public String getBebida() {
        return Bebida;
    }

    public void setBebida(String Bebida) {
        this.Bebida = Bebida;
    }

    public int getCantEntrada() {
        return cantEntrada;
    }

    public void setCantEntrada(int cantEntrada) {
        this.cantEntrada = cantEntrada;
    }

    public int getCantFuete() {
        return cantFuete;
    }

    public void setCantFuete(int cantFuete) {
        this.cantFuete = cantFuete;
    }

    public int getCantBebida() {
        return cantBebida;
    }

    public void setCantBebida(int cantBebida) {
        this.cantBebida = cantBebida;
    }
    
}
