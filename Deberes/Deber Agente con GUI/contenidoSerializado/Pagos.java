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
public class Pagos implements Serializable{
    private int idPago, idCliente;
    private double valor;
    private String fecha;

    public Pagos() {
    }

    public Pagos(int idPago, int idCliente, double valor, String fecha) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pagos{" + "idPago=" + idPago + ", idCliente=" + idCliente + ", valor=" + valor + ", fecha=" + fecha + '}';
    }
    
    
}
