package com.example.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.Usuario;
import com.example.exception.NotFoundException;
import com.example.repository.UsuarioRepository;
import com.example.services.util.Hash;

@Service
public class UsuarioService {

	@Autowired private UsuarioRepository usuarioRepo;
	
	public Usuario save(Usuario usuario) {
		String hash = Hash.getSecurityHash(usuario.getSenha());
		usuario.setSenha(hash);
		Usuario u = usuarioRepo.save(usuario);
		return u;		
	}
	
	public Usuario update(Usuario usuario) {
		String hash = Hash.getSecurityHash(usuario.getSenha());
		usuario.setSenha(hash);
		Usuario u = usuarioRepo.save(usuario);
		return u;		
	}
	
	public void delete(Long id) {
		usuarioRepo.deleteById(id);
	}
	
	public Usuario getById(Long id) {
		Optional<Usuario> result = usuarioRepo.findById(id);
		return result.orElseThrow(()-> new NotFoundException("ID de Usuário não encontrado"));
	}
	
	public List<Usuario> listAll() {
		List<Usuario> list = usuarioRepo.findAll();
		return list;
	}

	public Usuario login(String usuario, String senha) {
		senha = Hash.getSecurityHash(senha);
		Optional<Usuario> result = usuarioRepo.login(usuario, senha);
		return result.get();
	}	
}