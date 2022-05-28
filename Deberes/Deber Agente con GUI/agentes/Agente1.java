/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import GUI.AgentGUI;
import agentesc.Contenedor;
import contenidoSerializado.Cliente;
import contenidoSerializado.Sensores;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.gui.GuiEvent;
import jade.gui.GuiAgent;
import jade.lang.acl.MessageTemplate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class Agente1 extends Agent {

    //Cliente a guardar
    private Cliente cliente;

    //Variable para continuar
    private boolean continuar = false;

    @Override
    protected void setup() {
        //Comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        /*Acción antes de acabar con el agente
        ------------------------------------------------------------*/
        System.out.println("Morir");
    }

    /*Comportamiento del Agente
    Puede ser un método para comportamiento específico 
    o un comportamiento general*/
    class Comportamiento extends Behaviour {

        boolean terminado = false;   //Estado terminado falso
        //Con cycle se repite el comportamiento ciclicamente

        @Override
        public void action() {
            //Instancia ACL 
            
            //Obtener instancia de la GUI
            AgentGUI gui = (AgentGUI)getArguments()[2];
            gui.setVisible(true); //Mostrar GUI en pantalla
            
            if(gui.isPressBotonClientes()){
                System.out.println("Agente1: Enviando Cliente Agente2....");
                cliente = gui.getCliente();
                Mensajes.enviarS(ACLMessage.INFORM, "Unirinformacion", cliente, "COD0102", getAgent());
                gui.setPressBotonClientes(false);
                blockingReceive();
            }
          
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
