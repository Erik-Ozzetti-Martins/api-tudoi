package com.erik.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erik.todo.domain.Tudo;
import com.erik.todo.service.TudoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value= "/todos")
public class TodoResource {
	
	@Autowired
	private TudoService service;
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Tudo> findById(@PathVariable Integer id){
		Tudo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value= "/open")
	public ResponseEntity<List<Tudo>> listOpen(){
		List<Tudo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/close")
	public ResponseEntity<List<Tudo>> listClose(){
		List<Tudo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping
	public ResponseEntity<List<Tudo>> listAll(){
		List<Tudo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Tudo> create(@RequestBody Tudo obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value = "/{id}")
	public  ResponseEntity<Tudo> update(@PathVariable Integer id, @RequestBody Tudo obj ){
		Tudo newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
}
