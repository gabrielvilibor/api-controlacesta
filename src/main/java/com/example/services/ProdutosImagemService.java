package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ProdutosImagem;
import com.example.exception.NotFoundException;
import com.example.repository.ProdutosImagemRepository;

@Service
public class ProdutosImagemService {
	
	@Autowired private ProdutosImagemRepository piRepository;
	
	public ProdutosImagem getById(Long id) {
		Optional<ProdutosImagem> result = piRepository.findAllByProdutoId(id);
		return result.orElseThrow(()-> new NotFoundException("ID de Produto Imagem não encontrado"));
	}

}
