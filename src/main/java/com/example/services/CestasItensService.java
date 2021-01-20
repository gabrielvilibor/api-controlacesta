package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.CestasItens;
import com.example.exception.NotFoundException;
import com.example.repository.CestasItensRepository;

@Service
public class CestasItensService {
	
	
@Autowired private CestasItensRepository cestasItensRepository;
	
	public CestasItens save(CestasItens itens) {
		CestasItens ci = cestasItensRepository.save(itens);
		return ci;		
	}
	
	public CestasItens update(CestasItens itens) {
		CestasItens ci = cestasItensRepository.save(itens);
		return ci;
	}
	
	public void delete(Long id) {
		cestasItensRepository.deleteById(id);
	}	
	
	public CestasItens getById(Long id) {
		Optional<CestasItens> result = cestasItensRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de itens não encontrado"));
	}
	public List<CestasItens> listAll() {
		List<CestasItens> list = cestasItensRepository.findAll();
		return list;
	}
	
	public List<CestasItens> listAllItensById(Integer id) {
		List<CestasItens> list = cestasItensRepository.findAllByCesta(id);
		return list;
	}

}
