/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import contenidoSerializado.Sensores;
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
            System.out.println(getLocalName());
            
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
                    System.out.println(msj); //<--
                    Sensores s = (Sensores)msj.getContentObject();  //<--
                    System.out.println(s.getRiego()+ " " + s.getTemperatura());  //<--
                    //String temperatura = msj.getContent(); <--
                    //if(Integer.parseInt(temperatura)>35){ <--
                    //    System.out.println("Prendiendo Ventiladores"); <--
                    //    //............... <--
                    // 
                    //    /*Enviando Mensaje de Respuesta <--
                    //    ----------------------------------------------------*/ <--
                    //    //Mensaje respuesta a enviar <--
                    //    Mensajes.enviar(ACLMessage.INFORM, "ReceptorInfo", "Ventilador Prendido", "COD0201", getAgent()); <--
                    //}
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //ID para Agente 3 a 2 - Humedad
                if(idC.equalsIgnoreCase("COD0302")){
                    String humedadHoja = msj.getContent();
                    if(humedadHoja.equalsIgnoreCase("alta")){
                        System.out.println("No regar");
                    }else{
                        System.out.println("Regar");
                    }
                    
                    /*Enviando Mensaje de Respuesta
                    ----------------------------------------------------*/
                    Mensajes.enviar(ACLMessage.INFORM, "Ag3", "Estado de riego", "COD0203", getAgent());
                }
            }
            
            
        }
        
    }
    
    
}
