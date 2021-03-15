package com.example.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Versiculo;

public interface VersiculoRepository extends JpaRepository<Versiculo, Long>{
	
	@Query("SELECT v FROM versiculos v WHERE dt_versiculo = ?1")
	public Optional<Versiculo> versHoje(Date dt_versiculo);

}
