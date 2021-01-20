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

import com.example.domain.CestasItens;
import com.example.services.CestasItensService;

@RestController
@RequestMapping(value = "cestasitens")
public class CestasItensResources {
	@Autowired private CestasItensService itensServices;
	
	@PostMapping
	public ResponseEntity<CestasItens> save(@RequestBody CestasItens ci){
		CestasItens ciCreated = itensServices.save(ci);
		return ResponseEntity.status(HttpStatus.CREATED).body(ciCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CestasItens> update(@PathVariable(name = "id") Long id, @RequestBody CestasItens ci){
		ci.setId(id);
		CestasItens ciUp = itensServices.update(ci);
		return ResponseEntity.status(HttpStatus.CREATED).body(ciUp);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CestasItens> getById(@PathVariable("id") Long id){
		CestasItens ci = itensServices.getById(id);
		return ResponseEntity.ok(ci);
	}
	
	@GetMapping("/{id}/itens")
	public ResponseEntity<List<CestasItens>> getItens(@PathVariable("id") Integer id){
		List<CestasItens> ci = itensServices.listAllItensById(id);
		return ResponseEntity.ok(ci);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CestasItens> delete(@PathVariable("id") Long id){
		CestasItens ci = itensServices.getById(id);
		itensServices.delete(id);
		return ResponseEntity.ok(ci);
	}
}
