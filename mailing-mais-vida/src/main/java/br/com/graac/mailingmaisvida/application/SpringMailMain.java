package br.com.graac.mailingmaisvida.application;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import br.com.graac.mailingmaisvida.application.envio.MailMensagem;
import br.com.graac.mailingmaisvida.application.envio.Mailer;


public class SpringMailMain {
	
public static void main(String [] args) {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			SpringMailMain.class.getPackage().getName());
	
	Mailer mail = applicationContext.getBean(Mailer.class);
	mail.enviar(new MailMensagem("Agenor barbosa <agenorbsn853@gmail.com>", Arrays.asList("teste de envio de e-mail"), "vamor enviar o mailing", "OI etamos enviando nosso disparo"));
	applicationContext.close();
	
	System.out.println("fim");
}
}
