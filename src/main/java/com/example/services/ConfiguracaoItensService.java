package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.CestasItens;
import com.example.domain.ConfiguracaoItens;
import com.example.domain.Produto;
import com.example.exception.NotFoundException;
import com.example.repository.ConfiguracaoItensRepository;

@Service
public class ConfiguracaoItensService {
	
@Autowired private ConfiguracaoItensRepository itensRepository;
	
	public ConfiguracaoItens save(ConfiguracaoItens config) {
		ConfiguracaoItens cc = itensRepository.save(config);
		return cc;		
	}
	
	public ConfiguracaoItens update(ConfiguracaoItens config) {
		ConfiguracaoItens cc = itensRepository.save(config);
		return cc;	
	}
	
	public void delete(Long id) {
		itensRepository.deleteById(id);
	}
	
	public ConfiguracaoItens getById(Long id) {
		Optional<ConfiguracaoItens> result = itensRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de Itens de Configuração não encontrado"));
	}
	
	public ConfiguracaoItens getByProdutoConf(Produto p, Long idconf) {
		Optional<ConfiguracaoItens> result = itensRepository.findByProdConf(idconf, p.getId());
		return result.orElseThrow(()-> new NotFoundException("ID de Itens de Configuração não encontrado"));
	}
	
	public List<ConfiguracaoItens> listAll() {
		List<ConfiguracaoItens> list = itensRepository.findAll();
		return list;
	}
	
	public List<ConfiguracaoItens> listAllItensById(Integer id) {
		List<ConfiguracaoItens> list = itensRepository.findAllByConfig(id);
		return list;
	}

}