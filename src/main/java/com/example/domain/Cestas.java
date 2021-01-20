package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "cestas")
public class Cestas implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_new;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_cesta;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private Integer id_conf_cesta;
	
	@OneToMany
	@JoinColumn(name = "cesta")
    private List<CestasItens> itens;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Usuario usuario;
}
