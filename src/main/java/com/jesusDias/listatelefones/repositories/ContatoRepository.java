package com.jesusDias.listatelefones.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jesusDias.listatelefones.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	@Transactional(readOnly=true)
	Page<Contato> findByNomeContains(String nome, Pageable pageRequest);
	
}
