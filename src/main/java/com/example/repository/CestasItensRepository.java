package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.CestasItens;

public interface CestasItensRepository extends JpaRepository<CestasItens, Long>{
	
	public List<CestasItens> findAllByCesta(Integer cesta);

}