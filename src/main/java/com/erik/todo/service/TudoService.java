package com.erik.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.todo.domain.Tudo;
import com.erik.todo.repositories.TudoRepository;
import com.erik.todo.service.exceptions.ObjectNotFoundException;

@Service
public class TudoService {
	@Autowired
	private TudoRepository repository;
	
	public Tudo findById(Integer id) {
		Optional<Tudo> obj =repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto  não  encontrado id"+id));
	}

	public List<Tudo> findAllOpen() {
		List <Tudo> list = repository.findAllOpen();
		return list;
		
	}
	public List<Tudo> findAllClose() {
		List <Tudo> list = repository.findAllClose();
		return list;
		
	}

	public List<Tudo> findAll() {
		List<Tudo> list = repository.findAll();
		return list;
	}

	public Tudo create(Tudo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	public Tudo update(Integer id, Tudo obj) {
		Tudo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}

	
	
}
