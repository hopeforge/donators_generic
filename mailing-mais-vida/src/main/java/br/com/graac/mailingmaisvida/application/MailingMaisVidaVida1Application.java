package br.com.graac.mailingmaisvida.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MailingMaisVidaVida1Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringMailMain.class.getPackage().getName());
		
		SpringApplication.run(MailingMaisVidaVida1Application.class, args);
		applicationContext.close();
		
	}

}
