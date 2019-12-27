package br.com.graac.cupomdavida.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.graac.cupomdavida.application.entidades.Desconto;

@Repository
public interface DescontoRepository extends JpaRepository<Desconto, Long> {

	@Query("SELECT d FROM Desconto d WHERE d.pontuacaoMinima=?1")
	List<Desconto> findDescontosPorPontuacaoMinima(Integer pontuacaoMinima);
}
