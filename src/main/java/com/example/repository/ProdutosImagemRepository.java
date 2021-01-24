package com.example.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.ProdutosImagem;

@Repository
public interface ProdutosImagemRepository extends JpaRepository<ProdutosImagem, Long> {
	
	public Optional<ProdutosImagem> findAllByProdutoId(Long id);

}
