package br.com.graac.mailingmaisvida.application.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.graac.mailingmaisvida.application.entity.Campanha;
import br.com.graac.mailingmaisvida.application.repository.CampanhaRepository;

@Service
public class CampanhaService {
	private final Logger logger  = Logger.getLogger(CampanhaService.class);
	
	@Autowired
	private CampanhaRepository repository;
	
	public Campanha listarCampanhaPorNome(String campanha) {
		
		return repository.findByNomeCampanha(campanha);
		
	}
	
	public List<Campanha> listaTodasCampanhas(){
		return repository.findAll();
	}
	
	

}
