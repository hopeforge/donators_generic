package br.com.graac.cupomdavida.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.graac.cupomdavida.application.entidades.Desconto;
import br.com.graac.cupomdavida.application.entidades.Doador;
import br.com.graac.cupomdavida.application.service.DescontoService;
import br.com.graac.cupomdavida.application.service.DoadorService;

@RestController
@RequestMapping("/parceiros")
@CrossOrigin(origins = "*")
public class DescontoController {

	@Autowired
	private DescontoService descService;
	
	@Autowired
	private DoadorService doadorService;
	
	@GetMapping("/listaDescontos")
	public ResponseEntity<List<Desconto>> listaDescontos(@RequestParam("email") String email) {
		Doador doador = doadorService.findByEmail(email);
		if(doador == null) {
			 return new ResponseEntity<List<Desconto>>(new ArrayList<Desconto>(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Desconto>>(descService.listaDescontosPorPontuacao(doador.getPontuacao()), HttpStatus.OK);
	}
	
	@PostMapping("/resgatar")
	public void resgatar(@RequestParam("id") Long id, @RequestParam("email") String email) {
		Doador doador = doadorService.findByEmail(email);
		Desconto desconto = descService.findById(id);
		Long jaUsado = doadorService.vericaDescontoPorDoador(doador.getId(), desconto.getId());
		if(jaUsado == null || jaUsado < 1) {
			doador.setPontuacao(doador.getPontuacao()-desconto.getPontuacaoMinima());
			doador.getMeusCuponsDescontos().add(desconto);
			doadorService.cadastrar(doador);
		}
	}
	
}
