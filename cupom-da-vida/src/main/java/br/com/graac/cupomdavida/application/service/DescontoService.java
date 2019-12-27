package br.com.graac.cupomdavida.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.graac.cupomdavida.application.entidades.Desconto;
import br.com.graac.cupomdavida.application.repository.DescontoRepository;

@Service
public class DescontoService {

	@Autowired
	private DescontoRepository repository;

	public List<Desconto> listaDescontosPorPontuacao(Integer pontuacao) {
		return repository.findDescontosPorPontuacaoMinima(pontuacao);
	}
	
	public Desconto findById(Long id) {
		return repository.getOne(id);
	}
}
