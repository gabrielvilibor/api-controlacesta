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

import com.example.domain.ConfiguracaoItens;
import com.example.services.ConfiguracaoItensService;

@RestController
@RequestMapping(value = "configuracaoitens")
public class ConfiguracaoItensResources {
	
	@Autowired private ConfiguracaoItensService itemService;
	
	@PostMapping
	public ResponseEntity<ConfiguracaoItens> save(@RequestBody ConfiguracaoItens cc){
		ConfiguracaoItens ccCreated = itemService.save(cc);
		return ResponseEntity.status(HttpStatus.CREATED).body(ccCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConfiguracaoItens> update(@PathVariable(name = "id") Long id, @RequestBody ConfiguracaoItens cc){
		cc.setId(id);
		ConfiguracaoItens ccUp = itemService.update(cc);
		return ResponseEntity.status(HttpStatus.CREATED).body(ccUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConfiguracaoItens> delete(@PathVariable("id") Long id){
		ConfiguracaoItens ci = itemService.getById(id);
		itemService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ci);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<ConfiguracaoItens> getById(@PathVariable("id") Long id){
		ConfiguracaoItens cc = itemService.getById(id);
		return ResponseEntity.ok(cc);
	}

}