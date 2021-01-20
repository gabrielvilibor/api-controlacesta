package com.example.resources;

import java.util.List;

import javax.validation.Valid;

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
import com.example.domain.Usuario;
import com.example.dto.UserLoginDto;
import com.example.services.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioResources {
	
	@Autowired private UsuarioService userService;
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario u){
		Usuario pCreated = userService.save(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(pCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable(name = "id") Long id, @RequestBody Usuario u){
		u.setId(id);
		Usuario uUp = userService.update(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(uUp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable(name = "id") Long id){
		Usuario u = userService.getById(id);
		userService.delete(id);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
		Usuario u = userService.getById(id);
		return ResponseEntity.ok(u);
	}	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lists = userService.listAll();
		return ResponseEntity.ok(lists);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody @Valid UserLoginDto u){
		Usuario user = userService.login(u.getUsuario(), u.getSenha());
		return ResponseEntity.ok(user);
	}

}