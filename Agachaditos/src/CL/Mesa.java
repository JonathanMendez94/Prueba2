/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CL;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 Clase Mesa
 */
public class Mesa {

    private String codigo;
    private int numero;
    private int comensales;

    public Mesa(int numero, int comensales) {
        this.numero = numero;
        this.comensales = comensales;
    }

    public Mesa(String codigo, int numero, int comensales) {
        this.codigo = codigo;
        this.numero = numero;
        this.comensales = comensales;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }
}
