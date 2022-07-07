package com.qts.tracker.demo_filling_tracker.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Mail {
	private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType = "text/html";
//    private List <Object> attachments;
    
    public String getMailFrom() {
		return mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public String getMailCc() {
		return mailCc;
	}

	public String getMailBcc() {
		return mailBcc;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public String getMailContent() {
		return mailContent;
	}

	public String getContentType() {
		return contentType;
	}

//	public List<Object> getAttachments() {
//		return attachments;
//	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public void setMailBcc(String mailBcc) {
		this.mailBcc = mailBcc;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

//	public void setAttachments(List<Object> attachments) {
//		this.attachments = attachments;
//	}


}
