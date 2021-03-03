package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ProdutoPA;
import com.example.exception.NotFoundException;
import com.example.repository.LojaPARepository;
import com.example.repository.ProdutoPARepository;

@Service
public class ProdutoPAService {
	
	@Autowired private ProdutoPARepository paRepo;
	
	public ProdutoPA save(ProdutoPA prod) {
		ProdutoPA pa = paRepo.save(prod);
		return pa;
	}
	
	public ProdutoPA update(ProdutoPA prod) {
		ProdutoPA pa = paRepo.save(prod);
		return pa;
	}
	
	public void delete(Long id) {
		paRepo.deleteById(id);
	}
	
	public ProdutoPA getByID(Long id) {
		Optional<ProdutoPA> result = paRepo.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de cestas não encontrado"));
	}
	
	public List<ProdutoPA> findAll(){
		List<ProdutoPA> list = paRepo.findAll();
		return list;
	}

}
