package com.snail.spring.ch04;

public interface NewletterSender {
	public void setSmtpServer(String smtpServer);
	public String getSmtpServer();
	public void setFromAddress(String fromAddress);
	public String getFromAddress();
	
	public void send();
}
