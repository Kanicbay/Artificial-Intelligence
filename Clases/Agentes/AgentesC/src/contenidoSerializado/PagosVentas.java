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
public class PagosVentas implements Serializable{
    Pagos[] pagos;
    Ventas[] ventas;

    public PagosVentas() {
    }

    public PagosVentas(Pagos[] pagos, Ventas[] ventas) {
        this.pagos = pagos;
        this.ventas = ventas;
    }    
    
    public Pagos[] getPagos() {
        return pagos;
    }

    public void setPagos(Pagos[] pagos) {
        this.pagos = pagos;
    }

    public Ventas[] getVentas() {
        return ventas;
    }

    public void setVentas(Ventas[] ventas) {
        this.ventas = ventas;
    }
    
    
}
