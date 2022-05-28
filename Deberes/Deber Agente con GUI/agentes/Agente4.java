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
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class Agente4 extends Agent {

    Object[] datos;
    private ArrayList<Object> clientesBD = new ArrayList();
    private Object[] datosRegreso = new Object[4];
    private Cliente cliente;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pagos> pagos;
    private ArrayList<Ventas> ventas;
    private PagosVentas pagosVentas;

    @Override
    //Setup siempre se ejecuta primero
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Morir");
    }

    class Comportamiento extends Behaviour {

        boolean terminado = false;   

        @Override
        public void action() {

            ACLMessage msj = blockingReceive();
            try {
                AgentGUI gui = (AgentGUI)getArguments()[0];
                //Recibir datos
                datos = (Object[]) msj.getContentObject();
                
                //Base de Datos
                //Cliente
                cliente = (Cliente)datos[0];
                
                //Pagos Ventas
                pagosVentas = (PagosVentas)datos[1];
                pagos = pagosVentas.getPagos();
                ventas = pagosVentas.getVentas();
                
                double deuda = deuda(pagos, ventas);
                double monto = monto(cliente, deuda);
                cliente.setMonto(monto);
                gui.getTxtAreaDatos().append("Cliente: "+cliente.getNombre()+cliente.getApellido()+"\nPagos: "+pagos+"\nVentas: "+ventas+"\nDeuda: "+deuda+"\nMonto: "+monto+"\n\n");
                
                System.out.println("Agente4: Enviando Respuesta a 2");
                Mensajes.enviar(ACLMessage.INFORM, "Unirinformacion", "Datos Recibidos", "COD0402", getAgent());
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente4.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public boolean done() {
            /*Método abstracto de Behaviour
            Donde se ejecuta ciclicamente hasta que se realiza una
            acción como done*/
            return terminado;
        }
        
        public double deuda(ArrayList<Pagos> p, ArrayList<Ventas> v){
            double totalVentas=0;
            double totalPagos=0;
            
            //Ventas
            for(int i=0;i<v.size();i++){
                if(v.get(i).isIsIva()==true){
                   totalVentas+= v.get(i).getValorNeto()*1.12;
                }
                else{
                    totalVentas+= v.get(i).getValorNeto();
                }
            }
            
            //Pagos
            for(int i=0;i<v.size();i++){
                totalPagos += p.get(i).getValor();
            }
            
            //Valor deuda
            return totalVentas - totalPagos;
        }
        
        public double monto(Cliente c, double d){
            return c.getMonto() - d;
        }

    }

}
