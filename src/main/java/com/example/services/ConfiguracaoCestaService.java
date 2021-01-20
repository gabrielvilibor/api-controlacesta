package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Cestas;
import com.example.domain.ConfiguracaoCesta;
import com.example.exception.NotFoundException;
import com.example.repository.ConfiguracaoCestaRepository;

@Service
public class ConfiguracaoCestaService {
	
@Autowired private ConfiguracaoCestaRepository confRepository;
	
	public ConfiguracaoCesta save(ConfiguracaoCesta config) {
		ConfiguracaoCesta cc = confRepository.save(config);
		return cc;		
	}
	
	public ConfiguracaoCesta update(ConfiguracaoCesta config) {
		ConfiguracaoCesta cc = confRepository.save(config);
		return cc;	
	}
	
	public void delete(Long id) {
		confRepository.deleteById(id);
	}
	
	public ConfiguracaoCesta getById(Long id) {
		Optional<ConfiguracaoCesta> result = confRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de Configuração não encontrado"));
	}
	
	public List<ConfiguracaoCesta> listAll() {
		List<ConfiguracaoCesta> list = confRepository.findAll();
		return list;
	}

}
