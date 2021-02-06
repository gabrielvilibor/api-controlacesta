package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Produto;
import com.example.domain.Usuario;
import com.example.exception.NotFoundException;
import com.example.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		Produto p = produtoRepository.save(produto);
		return p;		
	}
	
	public Produto update(Produto produto) {
		Produto p = produtoRepository.save(produto);
		return p;	
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto getById(Long id) {
		Optional<Produto> result = produtoRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de Produto não encontrado"));
	}
	
	public List<Produto> listAll() {
		List<Produto> list = produtoRepository.findAll();
		return list;
	}
	
	public List<Produto> listByUsuario(Usuario u){
		List<Produto> list = produtoRepository.findByUsuario(u);
		return list;
	}
	

}
