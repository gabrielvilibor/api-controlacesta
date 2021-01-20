package com.example.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Cestas;
import com.example.domain.ConfiguracaoCesta;
import com.example.domain.ConfiguracaoItens;
import com.example.services.CestasService;
import com.example.services.ConfiguracaoCestaService;
import com.example.services.ConfiguracaoItensService;

@RestController
@RequestMapping(value = "configuracaocesta")
public class ConfiguracaoCestaResources {
	
	@Autowired private ConfiguracaoCestaService confService;
	@Autowired private CestasService cestasService;
	@Autowired private ConfiguracaoItensService itensService;
	
	@PostMapping
	public ResponseEntity<ConfiguracaoCesta> save(@RequestBody ConfiguracaoCesta cc){
		ConfiguracaoCesta ccCreated = confService.save(cc);
		return ResponseEntity.status(HttpStatus.CREATED).body(ccCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConfiguracaoCesta> update(@PathVariable(name = "id") Long id, @RequestBody ConfiguracaoCesta cc){
		cc.setId(id);
		ConfiguracaoCesta ccUp = confService.update(cc);
		return ResponseEntity.status(HttpStatus.CREATED).body(ccUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConfiguracaoCesta> delete(@PathVariable(name = "id") Long id){
		ConfiguracaoCesta cc = confService.getById(id);
		confService.delete(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(cc);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConfiguracaoCesta> getById(@PathVariable("id") Long id){
		ConfiguracaoCesta cc = confService.getById(id);
		return ResponseEntity.ok(cc);
	}
	
	@GetMapping
	public ResponseEntity<List<ConfiguracaoCesta>> findAll(){
		List<ConfiguracaoCesta> lists = confService.listAll();
		return ResponseEntity.ok(lists);
	}
	
	
	/*@GetMapping("/{id}/cestas")
	public ResponseEntity<List<Cestas>> listAllCestasById(@PathVariable(name = "id") Long id){
		List<Cestas> lists = cestasService.listAllCestasById(id);
		return ResponseEntity.ok(lists);
	}*/
	
	@GetMapping("/{id}/itens")
	public ResponseEntity<List<ConfiguracaoItens>> getItens(@PathVariable("id") Integer id){
		List<ConfiguracaoItens> ci = itensService.listAllItensById(id);
		return ResponseEntity.ok(ci);
	}

}
