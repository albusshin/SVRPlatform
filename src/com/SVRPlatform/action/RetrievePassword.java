package com.SVRPlatform.action;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class RetrievePassword extends ActionSupport implements ServletRequestAware,			//sign in~login						
ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3583001188704482138L;
	public static final String FAIL = "fail";
	final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	//private HttpServletResponse response;
	//private HttpServletRequest request;
	String email;
	String retrieveHash;
	public String execute() {  
        try {  
           email = "albusshin@gmail.com";
           Properties props = System.getProperties();  
           props.setProperty("mail.smtp.host", "smtp.gmail.com");
           props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
           props.setProperty("mail.smtp.socketFactory.fallback", "false");
           props.setProperty("mail.smtp.port", "465");
           props.setProperty("mail.smtp.socketFactory.port", "465");
           props.put("mail.smtp.auth", "true");
           final String username = "SVRPlatform";
           final String password = "MROFTALprvs";
           Session session = Session.getDefaultInstance(props, new Authenticator(){
        	   protected PasswordAuthentication getPasswordAuthentication() {
        	   return new PasswordAuthentication(username, password);
        	   }});

        	   // -- Create a new message --
        	   Message msg = new MimeMessage(session);
        	   
        	   // -- Set the FROM and TO fields --
        	   msg.setFrom(new InternetAddress(username + "@gmail.com"));
        	   msg.setRecipients(Message.RecipientType.TO, 
        	   InternetAddress.parse(email,false));
        	   retrieveHash = "1f25e2d2a152c5f1e2d22a158587d";
        	   msg.setSubject("You've gotta reset your password");
        	   msg.setText("Hey there,\n\n\n We've heard you lost your SVRPlatform password. Is it so?\n\n" +
        			   "Use the following link within the next 24 hours to reset your password:\n\n" +
        			   "http://svrplatform.com/login/" + retrieveHash + "\n\n\n\n" +
        			   "Best wishes and kind regards,\n\n\n\n" +
        			   "The NBGroup \n\n" +
        			   "Albus Shin | Gokeii  | Povergo | Gousheng | Shaoye\n\nwww.svrplatform.com");
        	   msg.setSentDate(new Date());
        	   Transport.send(msg);

        	   System.out.println("Message sent.");
        	   return SUCCESS;  
   
        } catch (Exception e) {  
            e.printStackTrace();  
    		return FAIL;
        }
    }
	public String getEmail() {
		return email;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		//this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//this.request = request;
	}
}
