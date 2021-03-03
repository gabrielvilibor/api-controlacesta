package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.ConfiguracaoItens;
import com.example.domain.Produto;
import com.example.domain.Usuario;

public interface ConfiguracaoItensRepository extends JpaRepository<ConfiguracaoItens, Long> {
	
	public List<ConfiguracaoItens> findAllByConfig(Integer config);
	
	public Optional<ConfiguracaoItens> findByProduto(Produto produto);
	
	@Query("SELECT ci FROM configuracaoitens ci WHERE id_conf_cesta = ?1 AND id_produto = ?2")
	public Optional<ConfiguracaoItens> findByProdConf(Long idconf, Long idproduto);

}