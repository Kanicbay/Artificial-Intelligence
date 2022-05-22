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
public class Sensores implements Serializable{
    
    //Se envia un paquete de bits como un objeto
    
    private String riego;
    private int temperatura;

    public Sensores() {
    }

    public Sensores(String riego, int temperatura) {
        this.riego = riego;
        this.temperatura = temperatura;
    }

    public String getRiego() {
        return riego;
    }

    public void setRiego(String riego) {
        this.riego = riego;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    
    
}
