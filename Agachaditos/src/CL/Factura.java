/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CL;

/**
 * author Santiago Aguirre, Jonathan Méndez Fecha: 26-07-2017 Clase Factura
 */
public class Factura {

    private String cliente;
    private String mesero;
    private String mesa;
    private String orden;

    public Factura(String cliente, String mesero, String mesa, String orden) {
        this.cliente = cliente;
        this.mesero = mesero;
        this.mesa = mesa;
        this.orden = orden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
}
