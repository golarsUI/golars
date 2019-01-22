package com.teluguassociation.util;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.MultivaluedMap;

public class MailUtil {

	static Properties emailProperties = new Properties();
	

	public static void main(String[] args) {

		MailUtil util = new MailUtil();
		util.fetchEmailProperties();
//		String value = MessageFormat.format(emailProperties.getProperty("registerEmail"),new Object[] {"Srinivas ",emailProperties.getProperty("baseURL"),"testusername","testpassword" });
//		System.out.println(value);
		final HashMap<String, String> form = new HashMap<>();
	    form.put("name", "name1");
	    form.put("plan", "plan");
//		util.sendEmail(form);

	}
	
	Message fetchEmailProperties() {

		try {
			Class<MailUtil> cl = MailUtil.class;

			emailProperties.load(cl.getResourceAsStream("/emailconfig.properties"));
		} catch (Exception e1) {
			System.out.println("Email Configuration fiele not found" + e1.getMessage());
		}
		final String username = emailProperties.getProperty("username");
		final String password = emailProperties.getProperty("password");
		String fromAddress = emailProperties.getProperty("from.address");

		Properties props = new Properties();
		props.put("mail.smtp.auth", emailProperties.get("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", emailProperties.get("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", emailProperties.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", emailProperties.getProperty("mail.smtp.port"));
		props.put("mail.debug", emailProperties.getProperty("mail.debug"));

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message message = new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress(fromAddress));
		} catch (MessagingException e) {
			System.out.println("Exception occured during mail send --" + e.getMessage());
		}
		return message;
	}

	public void sendEmail(MultivaluedMap<String, String> form) {

		try {
			Message message = fetchEmailProperties();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("info@indianatelugu.org"));
			String body = new String();
			 body+="<table border=1><thead>";
			for (String key : form.keySet()) {
				body+=("<th>"+key + " </th> ");
			}
			 body+="</thead>";
			 body+="<tbody><tr>";
				for (String key : form.keySet()) {
					body+=("<td>"+ form.get(key)+"</td>");
				}
				 body+="</tr></tbody></table>";
			 
			message.setContent(body, "text/html");
			message.setSubject(emailProperties.getProperty("mailsubject", "Message to Telugu Association"));

			Transport.send(message);

			System.out.println("Mail sent succesfully to telugu association  ");

		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Exception occured during mail send --" + e.getMessage());
		}
	}

}
