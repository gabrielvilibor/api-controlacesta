package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.LojaPA;
import com.example.exception.NotFoundException;
import com.example.repository.LojaPARepository;

@Service
public class LojaPAService {
	
	@Autowired private LojaPARepository ljRepo;
	
	public LojaPA save(LojaPA loja) {
		LojaPA l = ljRepo.save(loja);
		return l;
	}
	
	public LojaPA update(LojaPA loja) {
		LojaPA l = ljRepo.save(loja);
		return l;
	}
	
	public void delete(Long id) {
		ljRepo.deleteById(id);
	}
	
	public LojaPA getByID(Long id) {
		Optional<LojaPA> result = ljRepo.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de cestas não encontrado"));
	}
	
	public List<LojaPA> findAll(){
		List<LojaPA> list = ljRepo.findAll();
		return list;
	}

}
