/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

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
            blockingReceive();
        }
        
    }
    
    
}
