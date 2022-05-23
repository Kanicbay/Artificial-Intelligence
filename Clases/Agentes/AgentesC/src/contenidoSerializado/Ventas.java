/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenidoSerializado;

import java.io.Serializable;

/**
 *
 * @author brian
 */
public class Ventas implements Serializable{
    private int idVenta, idCliente, numerofactura;
    private double valorNeto;
    private boolean isIva; //1.12
    private String fecha, descripcionProducto;

    public Ventas() {
    }

    public Ventas(int idVenta, int idCliente, int numerofactura, double valorNeto, boolean isIva, String fecha, String descripcionProducto) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.numerofactura = numerofactura;
        this.valorNeto = valorNeto;
        this.isIva = isIva;
        this.fecha = fecha;
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(int numerofactura) {
        this.numerofactura = numerofactura;
    }

    public double getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(double valorNeto) {
        this.valorNeto = valorNeto;
    }

    public boolean isIsIva() {
        return isIva;
    }

    public void setIsIva(boolean isIva) {
        this.isIva = isIva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    @Override
    public String toString() {
        return "Ventas{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", numerofactura=" + numerofactura + ", valorNeto=" + valorNeto + ", isIva=" + isIva + ", fecha=" + fecha + ", descripcionProducto=" + descripcionProducto + '}';
    }
    
    
}
