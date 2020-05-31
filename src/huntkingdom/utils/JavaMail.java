/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author AmineMissaoui
 */
public class JavaMail {

    public static void sendMail(String recepient) throws MessagingException {
        System.out.println("ending email in progress");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myEmailAccount = "missaoui.amine.1988@gmail.com";
        String myEmailPassword = "19880130##{[zetsu12";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmailAccount, myEmailPassword);
            }
            
        });

        //mail.smtp.auth
        //mail.smtp.starttls.enable
        //mail.smtp.host
        //mail.smtp.port 587
        
        Message message = prepareMessage( session, myEmailAccount, recepient);
        Transport.send(message);
        System.out.println("sucess mail sending");
    }

    private static Message prepareMessage(Session session, String myEmailAccount, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmailAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Bienvenue sur Huntkingdom");
            message.setText("email core");
            return message;
        } catch (Exception ex) {
            System.out.println("Error sending email" + ex.getMessage());
        }
        return null;
    }

}
