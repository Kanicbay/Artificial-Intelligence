/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.Sensores;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class Agente2 extends Agent{
    //String que guarda mensajes de los agentes 1 y 3
    String[] mensajes = new String[2];
    @Override
    //Setup siempre se ejecuta primero
    protected void setup() {
        /*Configuración del agente
        ------------------------------------------------------------*/
        //Llamado al funcionamiento del agente
        //System.out.println(getLocalName());   //Prueba con LocalName
        
        //Funcionamiento agregar comportamiento
        addBehaviour(new Comportamiento());
    }
    
    /*Comportamiento del Agente
    Puede ser un método para comportamiento específico 
    o un comportamiento general*/
    class Comportamiento extends CyclicBehaviour{
        //Con cycle se repite el comportamiento ciclicamente
        @Override
        public void action() {
            /*Aqui todo lo que necesite y hace el agente
            Como ANN, AG, Bayes, If else
            --------------------------------------------------------*/
            //System.out.println(getLocalName());
            
            /*Recibiendo Mensaje
            --------------------------------------------------------*/
            ACLMessage msj = blockingReceive();  //Bloqueado hasta que reciba mensaje
            
            //System.out.println(msj);                        // Mensaje
            //System.out.println(msj.getContent());           //Contenido del mensaje
            //System.out.println(msj.getConversationId());    //ID de conversacion
            
            //Control por ID de conversacion
            String idC = msj.getConversationId();
            
            //Controlar respuesta por el ID
            //ID para Agente 1 a 2 - Temperatura
            if(idC.equalsIgnoreCase("COD0102")){
                try {
                    //System.out.println(msj); //<--
                    Cliente cliente = (Cliente)msj.getContentObject();  //<--
                    System.out.println(cliente);
                    //System.out.println("Mensaje de Agente1 - Agente2: "+msj.getContent());
                    //String temperatura = msj.getContent(); //<--
                    //if(Integer.parseInt(temperatura)>35){ //<--
                        //System.out.println("Mensaje de Agente 1 - "+temperatura); //<--
                        //...............
                        
                        /*Enviando Mensaje de Respuesta <--
                        ----------------------------------------------------*/ //<--
                        //Mensaje respuesta a enviar <--
                        //Mensajes.enviar(ACLMessage.INFORM, "ReceptorInfo", "Agente2: Temperatura Recibida", "COD0201", getAgent()); //<--
                        
                        //Almacenar mensaje de 1 a 2
                        //mensajes[0] = temperatura;
                    //}
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //ID para Agente 3 a 2 - Humedad
                if(idC.equalsIgnoreCase("COD0302")){
                    /*String humedadHoja = msj.getContent();
                    if(humedadHoja.equalsIgnoreCase("alta")){
                        System.out.println("Accion Agente 2 - No regar");
                    }else{
                        System.out.println("Accion Agente 2 - Regar");
                    }*/
                    
                    /*Enviando Mensaje de Respuesta
                    ----------------------------------------------------*/
                    Mensajes.enviar(ACLMessage.INFORM, "Ag3", "Agente2: Estado de Riego Recibido", "COD0203", getAgent());
                    //Almacenar mensaje de 3 a 2
                    //mensajes[1] = humedadHoja;
                    try {
                        /*Contenido Serializado*/
                        Object[] pagosVentas = (Object[]) msj.getContentObject();
                        System.out.println(pagosVentas.length);
                        Pagos pago = (Pagos) pagosVentas[0];
                        Ventas venta = (Ventas) pagosVentas[1];
                        System.out.println(pago);
                        System.out.println(venta);
                        
                    } catch (UnreadableException ex) {
                        Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    if(idC.equalsIgnoreCase("COD0402")){
                        System.out.println("Mensaje de Agente4 - Agente2: "+msj.getContent());
                        System.out.println("Agente2: Respuesta recibida de Agente4");
                    }
                    blockingReceive();
                }
            }
            
            if (mensajes[0]!=null && mensajes[1]!=null) {
                /*Enviando Mensaje de Respuesta a 4, dado que se ha recibio
                mensajes de 1 y 3
                --------------------------------------------------------*/
                Mensajes.enviar(ACLMessage.INFORM, "Ag4", "Agente2: enviando "+mensajes[0]+" y "+mensajes[1], "COD0204", getAgent());
                mensajes[0]=null;
                mensajes[1]=null;
            }
            
        }
        
    }
    
    
}
