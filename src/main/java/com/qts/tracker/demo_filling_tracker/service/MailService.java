package com.qts.tracker.demo_filling_tracker.service;

import org.springframework.stereotype.Service;

import com.qts.tracker.demo_filling_tracker.model.Mail;

@Service
public interface MailService {

	void sendEmail(Mail mail);

}
