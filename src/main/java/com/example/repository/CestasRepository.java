package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Cestas;

public interface CestasRepository extends JpaRepository<Cestas, Long>{
	
	@Query("SELECT c FROM cestas c WHERE id_conf_cesta = ?1")
	public List<Cestas> findAllbyConf(Integer id);

}