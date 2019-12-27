package br.com.graac.mailingmaisvida.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.graac.mailingmaisvida.application.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {
	Email findByEmail1(String email);
	
	@Query("SELECT e FROM Email e WHERE e.email=?1")
	Email findByEmail(String email);

}
