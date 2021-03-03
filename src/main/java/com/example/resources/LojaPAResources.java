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

import com.example.domain.LojaPA;
import com.example.services.LojaPAService;

@RestController
@RequestMapping(value = "lojapa")
public class LojaPAResources {
	
	@Autowired private LojaPAService lJServ;
	
	@PostMapping
	public ResponseEntity<LojaPA> save(@RequestBody LojaPA p){
		LojaPA pCreated = lJServ.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LojaPA> update(@PathVariable(name = "id") Long id, @RequestBody LojaPA p){
		p.setId(id);
		LojaPA pUp = lJServ.update(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LojaPA> delete(@PathVariable(name = "id") Long id){
		LojaPA p = lJServ.getByID(id);
		lJServ.delete(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LojaPA> getById(@PathVariable("id") Long id){
		LojaPA p = lJServ.getByID(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping
	public ResponseEntity<List<LojaPA>> findAll(){
		List<LojaPA> lists = lJServ.findAll();
		return ResponseEntity.ok(lists);
	}

}
