package br.com.graac.cupomdavida.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.graac.cupomdavida.application.entidades.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long>{

	Cupom findByCnpj(String cnpj);
	
	@Query("SELECT c FROM Cupom c where c.numeroCupom=?1")
	Cupom findByNumeroCupom(String numeroCupom);
	
}
