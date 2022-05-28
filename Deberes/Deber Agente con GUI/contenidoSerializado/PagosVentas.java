/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenidoSerializado;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author brian
 */
public class PagosVentas implements Serializable{
    private ArrayList<Pagos> pagos;
    private ArrayList<Ventas> ventas;

    public PagosVentas() {
    }

    public PagosVentas(ArrayList<Pagos> pagos, ArrayList<Ventas> ventas ) {
        this.pagos = pagos;
        this.ventas = ventas;
    }    

    public ArrayList<Pagos> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pagos> pagos) {
        this.pagos = pagos;
    }

    public ArrayList<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Ventas> ventas) {
        this.ventas = ventas;
    }
    
    

    @Override
    public String toString() {
        return "PagosVentas{" + "pagos=" + pagos + ", ventas=" + ventas + '}';
    }
    
    
}
