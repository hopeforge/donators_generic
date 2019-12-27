package br.com.graac.mailingmaisvida.application.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.graac.mailingmaisvida.application.entity.Email;
import br.com.graac.mailingmaisvida.application.service.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "*")
public class EmailController {

	private EmailService emailService; 
	private final Logger logger = Logger.getLogger(EmailService.class);
	
	@GetMapping("/listar")
	public ResponseEntity<Email>listaCupom(){
		return null;
		
	}
	
	
}
