 package com.jesusDias.listatelefones.resources;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jesusDias.listatelefones.entities.Contato;
import com.jesusDias.listatelefones.services.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	private ContatoService service;
	
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> list  = service.findAll();
		//Contato c = new Contato(2L, "jesua", "999", "222", "haufhuifhi");
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{/id}")
	public ResponseEntity<Contato> findById(@PathVariable Long id){
		Contato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		}
}
