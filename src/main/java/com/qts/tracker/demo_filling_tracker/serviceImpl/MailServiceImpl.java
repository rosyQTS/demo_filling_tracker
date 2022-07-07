package com.qts.tracker.demo_filling_tracker.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.Mail;
import com.qts.tracker.demo_filling_tracker.service.MailService;

@Component
public class MailServiceImpl implements MailService{
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(Mail mail) {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setCc(mail.getMailCc());
			mimeMessageHelper.setBcc(mail.getMailBcc());
			mimeMessageHelper.setText(mail.getMailContent(),true);
			
			
			/*
			 * FileSystemResource file = new FileSystemResource(mail.getAttachments());
			 * mimeMessageHelper.addAttachment(file.getFilename(), file);
			 */
			
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
