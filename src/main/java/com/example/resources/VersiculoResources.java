package com.example.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Versiculo;
import com.example.services.VersiculoService;

@RestController
@RequestMapping(value = "versiculo")
public class VersiculoResources {
	
	@Autowired private VersiculoService vServ;
	
	@PostMapping
	public ResponseEntity<Versiculo> save(@RequestBody Versiculo vs){
		Versiculo v = vServ.save(vs);
		return ResponseEntity.status(HttpStatus.CREATED).body(v);
	}
	
	@PutMapping
	public ResponseEntity<Versiculo> update(@RequestBody Versiculo vs){
		Versiculo v = vServ.save(vs);
		return ResponseEntity.status(HttpStatus.CREATED).body(v);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Versiculo> getById(@PathVariable("id") Long id){
		Versiculo v = vServ.findById(id);
		return ResponseEntity.ok(v);
	}
	
	@PostMapping("/hoje")
	public ResponseEntity<Versiculo> getByDate(@RequestBody Versiculo vs){
		Versiculo v = vServ.findByDate(vs.getDt_versiculo());
		return ResponseEntity.ok(v);
	}

}
