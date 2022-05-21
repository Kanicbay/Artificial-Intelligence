/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentesc;

import agentes.*;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class Contenedor {
    
    //Variable de tipo AgentContainer (Wrapper)
    AgentContainer agentContainer;
    
    public void contenedor() {
        /*Creación y configuración del contenedor
        ------------------------------------------------------------*/
        //Un contenedor es una rutina en tiempo de ejecución (hilo)
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        //Perfil para el contenedor (host, puerto, ID del contenedor)
        Profile p = new ProfileImpl(null, 1099, null);    
        agentContainer = runtime.createMainContainer(p);
    
        /*Funcionamiento del contenedor
        ------------------------------------------------------------*/
        agregarAgentes();
        
    }
    
    private void agregarAgentes() {
        /*Creación de los Agentes
        ------------------------------------------------------------*/
        //Funcionamiento con hilos, para los agentes
        try {
            //Crear contenedor con alias, nombre clase a la que pertenece y conocimiento
            //Con el método start se inicia al agente
            agentContainer.createNewAgent("ReceptorInfo", Agente1.class.getName(), new Object[]{this,1}).start();  //Envio el contenedor como conocimiento. 
            agentContainer.createNewAgent("BuscarDatos", Agente2.class.getName(), null).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearHijos(String alias, Object[] conocimiento) {
        /*Creación de un hijo apartir de un Agente y con conocimiento
        ------------------------------------------------------------*/
        try {
            agentContainer.createNewAgent(alias, Agente1.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
