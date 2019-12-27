package br.com.graac.cupomdavida.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.graac.cupomdavida.application.entidades.Doador;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {

	Doador findByEmail(String email);
	
	@Query(nativeQuery = true, value ="SELECT count(*) FROM tb_meus_cup_descontos md WHERE md.id_doador=?1 and md.id_desconto=?2")
	Long verificaDescontoJaUtilizadoPorDoador(Long idDoador, Long idDesconto);
	
}
