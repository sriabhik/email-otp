package com.emailcode;

import java.util.Properties;

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
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "sending message" );
        String message ="Hello,Dear,This is message for security check";
        String subject ="Email Code";
        String to ="abhi.srivastava7631@gmail.com";
        String from="sriabhik763131@gmail.com";
        
        sendEmail(message,subject,to,from);
    }
    
    //send email
    public static void sendEmail(String message,String subject,String to,String from) {
    	//gmail host varaible
    	
    	String host="smtp.gmail.com";
    	
    	//get system property
    	
    	Properties properties  = System.getProperties();
    	System.out.print(properties);
    	
    	//setting important properties
    	
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port","465");
    	properties.put("mail.smtp.ssl.enable","true");
    	properties.put("mail.smtp.auth","true");
    	
    	//step 1: get session object
    	
    	Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sriabhik763131@gmail.com","Abhi7631@@@");
			}
    		
    	});
    	
    	session.setDebug(true);
    	//step 2compose the message
    	
    	MimeMessage m = new MimeMessage(session);
    	
    	try {
    		//from email
			m.setFrom(from);
			//to
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//subject 
			m.setSubject(subject);
			//message
			m.setText(message);
			
			//step 3 send
	    	Transport.send(m);
	    	System.out.println("Sent");
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
}
