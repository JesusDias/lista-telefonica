package com.jesusDias.listatelefones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusDias.listatelefones.entities.Contato;
import com.jesusDias.listatelefones.repositories.ContatoRepository;
import com.jesusDias.listatelefones.services.exceptions.ObjectNotFoundException;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll(){
		return repository.findAll();
	}
	
	
	public Contato findById(Long id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", tipo: " + Contato.class.getName()));
	}
	
	
	public Contato insert(Contato obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Contato update(Contato obj) {
		findById(obj.getId());
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
