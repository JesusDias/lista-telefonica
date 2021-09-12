package com.jesusDias.listatelefones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusDias.listatelefones.entities.Contato;
import com.jesusDias.listatelefones.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll(){
		return repository.findAll();
	}
	
	public Contato findById(Long id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.get();
	}
}
