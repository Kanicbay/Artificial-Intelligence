/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import agentesc.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author brian
 */
public class Agente4 extends Agent{

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

    @Override
    protected void takeDown() {
        /*Acción antes de acabar con el agente
        ------------------------------------------------------------*/
        
        //Recibir conocimiento enviado al Agente
        Contenedor c = (Contenedor)getArguments()[0];
        int i = Integer.parseInt(getArguments()[1].toString());  //i sirve para cambiar el alias
        i++;
        //Se crea hijos
        //Se envía el alias y el contenedor como conocimiento
        c.crearHijos("AgenteHijo"+i, new Object[]{c,i});
        
        System.out.println("Morir");
    }
    
    /*Comportamiento del Agente
    Puede ser un método para comportamiento específico 
    o un comportamiento general*/
    class Comportamiento extends Behaviour{
        boolean terminado = false;   //Estado terminado falso
        //Con cycle se repite el comportamiento ciclicamente
        @Override
        public void action() {
            /*Aqui todo lo que necesite y hace el agente
            Como ANN, AG, Bayes, If else
            --------------------------------------------------------*/
            //System.out.println("Agente4 - "+getLocalName());
            //terminado = true;       //Cambia el estado a terminado
            //doDelete();               //Mata al Agente
            
            /*Envio de mensajes
            --------------------------------------------------------*/
            //Se envia mensaje con tipo, alias receptor, mensaje, cod conversacion y el agente emisor
            //Recibido Temperatura y Estado de Riego
            
            ACLMessage acl = blockingReceive();
            System.out.println(acl.getContent());
            
            Mensajes.enviar(ACLMessage.INFORM, "BuscarDatos", "Temperatura y Estado de Riego Recibidos", "COD0402",getAgent());
            
            /*Recibir mensajes
            --------------------------------------------------------*/
            
        }

        @Override
        public boolean done() {
            /*Método abstracto de Behaviour
            Donde se ejecuta ciclicamente hasta que se realiza una
            acción como done*/
            return terminado;
        }
        
    }
     
    
}
