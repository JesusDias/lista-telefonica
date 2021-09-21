 package com.jesusDias.listatelefones.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jesusDias.listatelefones.dto.ContatoDTO;
import com.jesusDias.listatelefones.entities.Contato;
import com.jesusDias.listatelefones.services.ContatoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/contatos")
@Api(value="API REST LISTA TELEFONICA")
@CrossOrigin(origins="*")
public class ContatoResource {
	
	
	@Autowired
	private ContatoService service;
	
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de contatos")
	public ResponseEntity<List<ContatoDTO>> findAll(){
		List<Contato> list = service.findAll();
		List<ContatoDTO> listDTO = list.stream().map(obj -> new ContatoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value="Retorna um único contato")
	public ResponseEntity<Contato> findById(@PathVariable Long id){
		Contato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@PostMapping
	@ApiOperation(value="Salva um contato")
	public ResponseEntity<Contato> insert(@Valid  @RequestBody Contato obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value="Edita um contato")
	public ResponseEntity<Contato> update(@Valid @RequestBody ContatoDTO objDTO, @PathVariable Long id){
		Contato obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value="Deleta um contato")
	public ResponseEntity<Contato> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	@GetMapping("/page")
	@ApiOperation(value="Retorna uma lista de contatos paginados")
	public ResponseEntity<Page<ContatoDTO>> findPage(
			
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linensPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		
		Page<Contato> list = service.findPage(page, linensPerPage, orderBy, direction);
		Page<ContatoDTO> listDTO = list.map(obj -> new ContatoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
