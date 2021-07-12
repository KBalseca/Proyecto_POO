/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnviarCorreo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author EVELYN
 */
public class Correo {
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
    
    String remitente = "muebleriaproyecto3@gmail.com";  
    
    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com"); 
    props.put("mail.smtp.user", remitente);
    props.put("mail.smtp.clave", "Clave123");    
    props.put("mail.smtp.auth", "true");    
    props.put("mail.smtp.starttls.enable", "true"); 
    props.put("mail.smtp.port", "587"); 

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario)); 
        message.setSubject(asunto);
        message.setText(cuerpo);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, "Clave123");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();  
    }
    }
}
