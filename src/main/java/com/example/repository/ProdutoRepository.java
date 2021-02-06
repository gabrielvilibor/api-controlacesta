package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Produto;
import com.example.domain.Usuario;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("SELECT p FROM produto p WHERE p.descritivo like '%?1%'")
	public Optional<Produto> findByDescritivo(String descritivo);
	
	public List<Produto> findByUsuario(Usuario usuario);

}