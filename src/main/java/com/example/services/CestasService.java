package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Cestas;
import com.example.exception.NotFoundException;
import com.example.repository.CestasRepository;

@Service
public class CestasService {
	
	
@Autowired private CestasRepository cestasRepository;
	
	public Cestas save(Cestas cesta) {
		Cestas c = cestasRepository.save(cesta);
		return c;		
	}
	
	public Cestas update(Cestas cesta) {
		Cestas c = cestasRepository.save(cesta);
		return c;
	}
	
	public void delete(Long id) {
		cestasRepository.deleteById(id);
	}
	
	public Cestas getById(Long id) {
		Optional<Cestas> result = cestasRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de cestas não encontrado"));
	}
	
	public List<Cestas> listAll() {
		List<Cestas> list = cestasRepository.findAll();
		return list;
	}
	
	public List<Cestas> listAllbyConf(Integer id) {
		List<Cestas> list = cestasRepository.findAllbyConf(id);
		return list;
	}

}
