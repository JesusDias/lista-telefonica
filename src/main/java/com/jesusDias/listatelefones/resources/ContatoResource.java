 package com.jesusDias.listatelefones.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesusDias.listatelefones.entities.Contato;

@RestController
@RequestMapping(value = "/Contatos")
public class ContatoResource {
	
	@GetMapping
	public ResponseEntity<Contato> finfAll(){
		
		Contato con = new Contato(1L, "Jesus", "9999999", "22/06/1991", "Jesus@gmail.com");
		return ResponseEntity.ok().body(con);
	}

}