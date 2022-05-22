/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class Mensajes {
    //Metodo para enviar mensajes
    public static void enviar(int tipo, String receptor,String contenidoMSJ, String codigoConversacionID,
            Agent emisor) {
        //Message ACL
        ACLMessage acl = new ACLMessage(tipo);
        //Identificador del que recibe
        AID aid = new AID();
        aid.setLocalName(receptor);
        
        //Quien recibe el mensaje
        acl.addReceiver(aid);
        //Quien envia el mensaje
        acl.setSender(emisor.getAID());
        //Establecer el Lenguaje
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        //Contenido del mensaje
        acl.setContent(contenidoMSJ);
        //Codigo de conversaciòn
        acl.setConversationId(codigoConversacionID);
        
        //Enviar mensaje del emisor
        emisor.send(acl);
        
    }
    
    public static void enviarS(int tipo, String receptor,Serializable object, String codigoConversacionID,
            Agent emisor){
        
        //Message ACL
        ACLMessage acl = new ACLMessage(tipo);
        //Identificador del que recibe
        AID aid = new AID();
        aid.setLocalName(receptor);
        
        //Quien recibe el mensaje
        acl.addReceiver(aid);
        //Quien envia el mensaje
        acl.setSender(emisor.getAID());
        //Establecer el Lenguaje
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        try {
            //Contenido del mensaje Objeto Serializado
            acl.setContentObject(object);
        } catch (IOException ex) {
            Logger.getLogger(Mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Codigo de conversaciòn
        acl.setConversationId(codigoConversacionID);
        
        //Enviar mensaje del emisor
        emisor.send(acl);
        
    }
}
