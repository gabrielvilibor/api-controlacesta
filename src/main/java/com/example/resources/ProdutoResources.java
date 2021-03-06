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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Produto;
import com.example.domain.ProdutosImagem;
import com.example.domain.Usuario;
import com.example.services.ProdutoService;
import com.example.services.ProdutosImagemService;
import com.example.services.UsuarioService;

@RestController
@RequestMapping(value = "produto")
public class ProdutoResources {
	@Autowired private ProdutoService prodService;
	@Autowired private ProdutosImagemService imgService;
	@Autowired private UsuarioService uService;
	
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
		ProdutosImagem pi = imgService.getById(id);
		imgService.delete(pi.getId());
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
	
	@GetMapping("/{id}/usuario")
	public ResponseEntity<List<Produto>> getByUsuario(@PathVariable("id") Long id){
		Usuario u = uService.getById(id);
		List<Produto> lists = prodService.listByUsuario(u);
		return ResponseEntity.ok(lists);
	}
	
	@GetMapping("/{id}/files")
	public ResponseEntity<ProdutosImagem> getByProdutoImagem(@PathVariable("id") Long id){
		ProdutosImagem pi = imgService.getById(id);
		return ResponseEntity.ok(pi);
	}
	
	@PostMapping("/{id}/files")
	public ResponseEntity<List<ProdutosImagem>> upload(@PathVariable("id") Long id, @RequestPart("files") MultipartFile[] files){
		if(imgService.getById(id) != null) {
			ProdutosImagem pi = imgService.getById(id);
			imgService.delete(pi.getId());
		}
		List<ProdutosImagem> lists = imgService.upload(id, files);
		Produto p = prodService.getById(id);
		lists.forEach(pim -> p.setFoto(pim.getNome()));
		prodService.update(p);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(lists);
	}
}