/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Sensores;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class Agente2 extends Agent {

    //String que guarda mensajes de los agentes 1 y 3
    Object[] mensajes = new Object[2];

    //Datos para pagosVentas
    private ArrayList<Cliente> clientes = new ArrayList();
    private Cliente cliente;
    private ArrayList<Pagos> pagos = new ArrayList();
    private ArrayList<Ventas> ventas = new ArrayList();
    private PagosVentas pagosVentas;

    @Override
    //Setup siempre se ejecuta primero
    protected void setup() {
        /*Configuración del agente
        ------------------------------------------------------------*/
        //Funcionamiento agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        //Con cycle se repite el comportamiento ciclicamente
        @Override
        public void action() {
            //Bloqueado hasta que reciba mensaje
            ACLMessage msj = blockingReceive();

            //Control por ID de conversacion
            String idC = msj.getConversationId();

            //Controlar respuesta por el ID
            if (idC.equalsIgnoreCase("COD0102")) {
                try {
                    System.out.println("Agente2: Recibiendo Cliente");
                    cliente = (Cliente) msj.getContentObject();
                    System.out.println("Cliente: " + cliente.toString());
                    
                    mensajes[0] = cliente;

                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (idC.equalsIgnoreCase("COD0302")) {
                    try {
                        System.out.println("Agente2: Recibiendo PagosVentas");
                        pagosVentas = (PagosVentas) msj.getContentObject();
                        System.out.println("PagosVentas: " + pagosVentas.toString());
                        mensajes[1] = pagosVentas;

                    } catch (UnreadableException ex) {
                        Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    if (idC.equalsIgnoreCase("COD0402")) {
                        System.out.println("Agente2: Recibiendo respuesta de Agente4\nEnviando mensajes a Agente1 y Agente3");
                        Mensajes.enviar(ACLMessage.INFORM, "ReceptorInfoCliente", "Agente2: Cliente Recibido", "COD0201", getAgent());
                        Mensajes.enviar(ACLMessage.INFORM, "ReceptorInfoClientePagosVentas", "Agente2: Cliente Recibido", "COD0203", getAgent());
                    }

                }
            }

            if (mensajes[0] != null && mensajes[1] != null) {
                /*Enviando Mensaje de Respuesta a 4, dado que se ha recibio
                mensajes de 1 y 3
                --------------------------------------------------------*/
                System.out.println("Enviando Clientes y PagosVentas");
                Mensajes.enviarS(ACLMessage.INFORM, "ProcesarInfo", mensajes, "COD0204", getAgent());
                mensajes[0] = null;
                mensajes[1] = null;
            }

        }

    }

}
