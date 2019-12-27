package br.com.graac.mailingmaisvida.application.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.graac.mailingmaisvida.application.entity.Campanha;
import br.com.graac.mailingmaisvida.application.service.CampanhaService;

@RestController
@RequestMapping("/campanha")
@CrossOrigin(origins = "*")
public class CampanhaController {

	private CampanhaService campanhaService;
	private final Logger logger = Logger.getLogger("CampanhaService.class");
	
	@GetMapping("/listar")
	public ResponseEntity<List<Campanha>>listarCampanha(){
		return new ResponseEntity<List<Campanha>>(campanhaService.listaTodasCampanhas(), HttpStatus.OK);
	}
	
}
