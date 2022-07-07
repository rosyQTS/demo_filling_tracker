package com.qts.tracker.demo_filling_tracker.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qts.tracker.demo_filling_tracker.model.Mail;
import com.qts.tracker.demo_filling_tracker.service.MailService;

@RestController
public class MailController {
     @Autowired
      MailService mailService;
     @Autowired
 	private Mail mail;
     private Object email;
     
     @PostMapping(value = "/sendEmail" , produces =MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> healthcheckPut(@RequestBody Mail mail) {
 			
// 		mail.setMailTo(mailTo);
// 			
// 	 mail.setMailFrom("rajeswari0000@gmail.com");
// 	  mail.setMailCc("mahapatrarajeswari9938@gmail.com");
// 	 mail.setMailBcc("swainmonalisa2901@gmail.com");
// 	mail.setMailSubject("Statutory-Filling-Tracker");
 			 	
 			  Random rand=new Random();
 			  int otp=rand.nextInt(100000);
 			 
 			  
 	mail.setMailContent("<h2 style=\"color:#2955c8;\">Statutory Return Filling Tracker</h2><br>Hii User,<br>This is to inform you that you have not fill your Statutory Report yet,Please fill it before 12/12/12<br>");
 					
 		mailService.sendEmail(mail);
 		return new ResponseEntity<>(HttpStatus.ACCEPTED);


}
}
