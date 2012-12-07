package com.SVRPlatform.service.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.SVRPlatform.dao.HashForPasswordRetrieveDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.HashForPasswordRetrieve;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.PasswordRetrieveService;

public class PasswordRetrieveServiceImpl implements PasswordRetrieveService {
	
	private HashForPasswordRetrieveDAO hashForPasswordRetrieveDAO;
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setHashForPasswordRetrieveDAO(
			HashForPasswordRetrieveDAO hashForPasswordRetrieveDAO) {
		this.hashForPasswordRetrieveDAO = hashForPasswordRetrieveDAO;
	}

	final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	final String username = "SVRPlatform";
    final String password = "MROFTALprvs";
    
	protected HashForPasswordRetrieve hfpr;
	
	@Override
	public boolean sendCheckingEmail(String email) {
		// TODO Auto-generated method stub
		try{
			//email = "albusshin@gmail.com";
	        Properties props = System.getProperties();  
	        props.setProperty("mail.smtp.host", "smtp.gmail.com");
	        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	        props.setProperty("mail.smtp.socketFactory.fallback", "false");
	        props.setProperty("mail.smtp.port", "465");
	        props.setProperty("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.auth", "true");
	        
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
     	   // -- generate the hash and save
     	   this.setRetrieveHash(email);
     	   // -- get the hash 
     	   String retrieveHash = this.hfpr.getHashValue();
     	   
     	   //set the content
     	   msg.setSubject("You've gotta reset your password");
     	   msg.setText("Hey there,\n\n\n We've heard you lost your SVRPlatform password. Is it so?\n\n" +
     			   "Use the following link within the next 24 hours to reset your password:\n\n" +
     			   "http://svrplatform.com/login/" + retrieveHash + "\n\n\n\n" +
     			   "Best wishes and kind regards,\n\n\n\n" +
     			   "The NBGroup \n\n" +
     			   "Albus Shin | Gokeii  | Povergo | Gousheng | Shaoye\n\nwww.svrplatform.com");
     	   msg.setSentDate(new Date());
     	   Transport.send(msg);
     	   return true;
		} catch(Exception e){
			 e.printStackTrace(); 
			 return false;
		}
	}
	
	protected void setRetrieveHash(String email){
		
		User u = userDAO.getUserByEmail(email);//get user
 
		String str = new String(new Date() +u.getPassword());
		//set the string to hash ( value = date + user's password)
		this.hfpr = new HashForPasswordRetrieve();
		//create the model of HashForPasswordRetrieve
		this.hfpr.setUserId(u.getUserId());
		this.hfpr.setHashValue(PasswordEncoder.EncoderByMd5(str));
		//set the data of this model
		this.hashForPasswordRetrieveDAO.add(this.hfpr);
		//save it
	}

}
