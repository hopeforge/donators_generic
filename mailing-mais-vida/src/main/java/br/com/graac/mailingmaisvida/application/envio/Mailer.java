package br.com.graac.mailingmaisvida.application.envio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.graac.mailingmaisvida.application.impl.JavaMailSenderImpl;
@Component
public class Mailer {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviar(MailMensagem mensagem) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mensagem.getRemetente());
		simpleMailMessage.setTo(mensagem.getDestinatarios().toArray(new String[mensagem.getDestinatarios().size()]));
	
		simpleMailMessage.setSubject(mensagem.getAssunto());
		simpleMailMessage.setText(mensagem.getCorpo());
		
		
		javaMailSender.send(simpleMailMessage);
	}
	
	

}
