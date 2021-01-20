package com.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserLoginDto {
	
	@NotBlank(message = "Campo Obrigatório")
	private String usuario;	
	
	@NotBlank(message = "Campo Obrigatório")
	private String senha;

}