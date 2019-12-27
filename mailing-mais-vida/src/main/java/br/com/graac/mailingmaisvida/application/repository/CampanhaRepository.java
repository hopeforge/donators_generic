package br.com.graac.mailingmaisvida.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.graac.mailingmaisvida.application.entity.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Integer>{
	Campanha findByNome(String nome);
	
	@Query("SELECT C FROM campanha c WHERE c.campanha=?1")
	Campanha findByNomeCampanha(String campanha);
	

}
