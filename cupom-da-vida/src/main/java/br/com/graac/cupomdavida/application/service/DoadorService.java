package br.com.graac.cupomdavida.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.graac.cupomdavida.application.entidades.Doador;
import br.com.graac.cupomdavida.application.repository.DoadorRepository;

@Service
public class DoadorService {

	@Autowired
	private DoadorRepository repository;
	
	public Doador findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public void cadastrar(Doador doador) {
		repository.save(doador);
	}
	
	public Long vericaDescontoPorDoador(Long idDoador, Long idDesconto) {
		return repository.verificaDescontoJaUtilizadoPorDoador(idDoador, idDesconto);
	}
}
