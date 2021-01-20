package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.ConfiguracaoItens;

public interface ConfiguracaoItensRepository extends JpaRepository<ConfiguracaoItens, Long> {
	
	public List<ConfiguracaoItens> findAllByConfig(Integer config);

}