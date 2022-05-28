/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import GUI.AgentGUI;
import agentesc.Contenedor;
import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;

/**
 *
 * @author brian
 */
public class Agente3 extends Agent{

    //Pagos Ventas
    private ArrayList<Pagos> pagos = new ArrayList();
    private ArrayList<Ventas> ventas = new ArrayList();
    
    //Variable para continuar
    private boolean continuar = false;
    
    @Override
    protected void setup() {
        //Funcionamiento agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        /*Acción antes de acabar con el agente
        ------------------------------------------------------------*/
        System.out.println("Morir");
    }
    
    class Comportamiento extends Behaviour{
        boolean terminado = false;   //Estado terminado falso
        //Con cycle se repite el comportamiento ciclicamente
        
        @Override
        public void action() {
            
            //Obtener instancia de la GUI
            AgentGUI gui = (AgentGUI)getArguments()[0];
            
            if(gui.isPressBotonPagosVentas()){
                System.out.println("Agente3: Enviando Pagos Ventas Agente2....");
                PagosVentas pagosVentas = new PagosVentas();
                pagos = gui.getPagos();
                ventas = gui.getVentas();
                pagosVentas.setPagos(pagos);
                pagosVentas.setVentas(ventas);
                Mensajes.enviarS(ACLMessage.INFORM, "Unirinformacion", pagosVentas, "COD0302", getAgent());
                gui.setPressBotonPagosVentas(false);
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
