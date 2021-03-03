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

import com.example.domain.ProdutoPA;
import com.example.services.ProdutoPAService;

@RestController
@RequestMapping(value = "produtopa")
public class ProdutoPAResouces {
	
	@Autowired private ProdutoPAService paService;
	
	@PostMapping
	public ResponseEntity<ProdutoPA> save(@RequestBody ProdutoPA p){
		ProdutoPA pCreated = paService.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoPA> update(@PathVariable(name = "id") Long id, @RequestBody ProdutoPA p){
		p.setId(id);
		ProdutoPA pUp = paService.update(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoPA> delete(@PathVariable(name = "id") Long id){
		ProdutoPA p = paService.getByID(id);
		paService.delete(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoPA> getById(@PathVariable("id") Long id){
		ProdutoPA p = paService.getByID(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoPA>> findAll(){
		List<ProdutoPA> lists = paService.findAll();
		return ResponseEntity.ok(lists);
	}
}
