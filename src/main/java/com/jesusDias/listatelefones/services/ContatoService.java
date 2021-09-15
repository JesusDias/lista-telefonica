package com.jesusDias.listatelefones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
		findById(id);
		repository.deleteById(id);
	}
	
	public Page<Contato> findPage(Integer page, Integer linensPerPage, String orderBy, String direction){
		PageRequest  pageRequest = PageRequest.of(page, linensPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	
}
