package com.example.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Cestas;
import com.example.domain.CestasItens;
import com.example.services.CestasItensService;
import com.example.services.CestasService;


@RestController
@RequestMapping(value = "cestas")
public class CestasResources {
	
@Autowired private CestasService cestasService;
@Autowired private CestasItensService itensService;
	
	@PostMapping
	public ResponseEntity<Cestas> save(@RequestBody Cestas c){
		Cestas cCreated = cestasService.save(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(cCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cestas> update(@PathVariable(name = "id") Long id, @RequestBody Cestas c){
		c.setId(id);
		Cestas cUp = cestasService.update(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(cUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cestas> delete(@PathVariable("id") Long id){
		Cestas c = cestasService.getById(id);
		cestasService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(c);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cestas> getById(@PathVariable("id") Long id){
		Cestas c = cestasService.getById(id);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping
	public ResponseEntity<List<Cestas>> findAll(){
		List<Cestas> lists = cestasService.listAll();
		return ResponseEntity.ok(lists);
	}
	
	@GetMapping("/{id}/itens")
	public ResponseEntity<List<CestasItens>> findAllItensById(@PathVariable("id") Integer id){
		List<CestasItens> lists = itensService.listAllItensById(id);
		return ResponseEntity.ok(lists);
	}

}
