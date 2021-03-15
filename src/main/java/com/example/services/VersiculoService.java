package com.example.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Versiculo;
import com.example.exception.NotFoundException;
import com.example.repository.VersiculoRepository;

@Service
public class VersiculoService {
	
	@Autowired private VersiculoRepository vRepo;
	
	public Versiculo save(Versiculo vd) {
		Versiculo v = vRepo.save(vd);
		return v;
	}
	
	public Versiculo update(Versiculo vd) {
		Versiculo v = vRepo.save(vd);
		return v;
	}
	
	public Versiculo findById(Long id) {
		Optional<Versiculo> result = vRepo.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de versiculo não encontrado"));
	}
	
	public Versiculo findByDate(Date dt_versiculo) {
		Optional<Versiculo> result = vRepo.versHoje(dt_versiculo);
		return result.orElseThrow(()-> new NotFoundException("ID de versiculo não encontrado"));
	}

}
