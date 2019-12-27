package br.com.graac.cupomdavida.application.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.graac.cupomdavida.application.entidades.Cupom;
import br.com.graac.cupomdavida.application.repository.CupomRepository;

@Service
public class CupomService {
	
	private final Logger logger = Logger.getLogger(CupomService.class);
	
	@Autowired
	private CupomRepository repository;
	
	
	public Cupom listarCupomPorCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}

	public List<Cupom> listaTodosCupons() {
		return repository.findAll();
	}
	
	public void cadastrar(Cupom cupom) {
		repository.save(cupom);
	}
	
}
