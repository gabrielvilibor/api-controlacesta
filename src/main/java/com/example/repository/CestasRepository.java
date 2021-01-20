package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Cestas;
import com.example.domain.ConfiguracaoCesta;

public interface CestasRepository extends JpaRepository<Cestas, Long>{
	
	//public List<Cestas> findAllByConfiguracaoCestaId(Long id);

}