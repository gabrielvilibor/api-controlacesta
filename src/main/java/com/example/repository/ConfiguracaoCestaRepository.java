package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.ConfiguracaoCesta;
import com.example.domain.Usuario;

public interface ConfiguracaoCestaRepository extends JpaRepository<ConfiguracaoCesta, Long>{
	
	public List<ConfiguracaoCesta> findByUsuario(Usuario usuario);

}