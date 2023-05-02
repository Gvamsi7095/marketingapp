package com.marketing.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component///maintained my springboot then apply auto genrated
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	JavaMailSender JavaMailSender;  /// send email use these knows object to cfreate//inherated from jar file
	

	@Override
	public void sendEmail(String to, String sub, String msg) {
		
	SimpleMailMessage message = new SimpleMailMessage();
	message.setTo(to);
	message.setSubject(sub);
	message.setText(msg);
	JavaMailSender.send(message);    /// it is like send button
	
		
	}

	
	
	
	
	

}
