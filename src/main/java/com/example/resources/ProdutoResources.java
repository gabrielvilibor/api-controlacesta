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

import com.example.domain.Produto;
import com.example.services.ProdutoService;

@RestController
@RequestMapping(value = "produto")
public class ProdutoResources {
	@Autowired private ProdutoService prodService;
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto p){
		Produto pCreated = prodService.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable(name = "id") Long id, @RequestBody Produto p){
		p.setId(id);
		Produto pUp = prodService.update(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> delete(@PathVariable(name = "id") Long id){
		Produto p = prodService.getById(id);
		prodService.delete(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable("id") Long id){
		Produto p = prodService.getById(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> lists = prodService.listAll();
		return ResponseEntity.ok(lists);
	}
}