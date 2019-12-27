package br.com.graac.cupomdavida.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.graac.cupomdavida.application.entidades.Doador;
import br.com.graac.cupomdavida.application.service.DoadorService;

@RestController
@RequestMapping("/doador")
@CrossOrigin(origins = "*")
public class DoadorController {

	@Autowired
	private DoadorService doadorService;

	@GetMapping("/listaPorEmail")
	public ResponseEntity<Doador> listaPorEmail(@RequestParam("email") String email) {
		Doador doador = doadorService.findByEmail(email);
		return new ResponseEntity<Doador>(doador, HttpStatus.OK);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Doador> cadastrar(@RequestParam("nome") String nome, @RequestParam("email") String email) {
		Doador doador = doadorService.findByEmail(email);
		if(doador == null || doador.getId() == null) {
			doador = new Doador(nome, email, 1);
			doadorService.cadastrar(doador);
		}
		return new ResponseEntity<>(doador, HttpStatus.OK);
	}
	
	

}
