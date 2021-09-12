package com.jesusDias.listatelefones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jesusDias.listatelefones.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
}
