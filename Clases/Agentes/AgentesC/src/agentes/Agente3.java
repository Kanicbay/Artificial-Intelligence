/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import agentesc.Contenedor;
import contenidoSerializado.Pagos;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author brian
 */
public class Agente3 extends Agent{

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
            //System.out.println(getLocalName());
            //terminado = true;       //Cambia el estado a terminado
            //doDelete();               //Mata al Agente
            
            /*Envio de mensajes
            --------------------------------------------------------*/
            //Se envia mensaje con tipo, alias receptor, mensaje, cod conversacion y el agente emisor
            //Sensor de temperatura
            //Alto Baja
            //Mensajes.enviar(ACLMessage.INFORM, "BuscarDatos", "baja", "COD0302",getAgent()); //<--
            
            /*Contenido Serializado*/
            // --> Pagos[] p = new Pagos[]{GUI};  --> Variables Globales
            // --> Ventas[] p = new Ventas[]{GUI}; --> Variables Globales
            // --> PagosVentas pv = --> Enviar la clase PagosVentas
            Object[] pagosVentas = new Object[]{new Pagos(1, 1, 100, "2022-10-10"), new Ventas(1, 1, 20221, 100, true, "2022-10-01", "Producto 1 Descripcion")};
            Mensajes.enviarS(ACLMessage.INFORM, "Unirinformacion", pagosVentas, "COD0302",getAgent());
            
            /*Recibir mensajes
            --------------------------------------------------------*/
            ACLMessage acl = blockingReceive(); //<--
            System.out.println(acl.getContent()); //<--
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
