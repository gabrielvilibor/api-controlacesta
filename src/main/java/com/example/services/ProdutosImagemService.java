package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Produto;
import com.example.domain.ProdutosImagem;
import com.example.domain.Usuario;
import com.example.exception.NotFoundException;
import com.example.model.UploadFileModel;
import com.example.repository.ProdutosImagemRepository;
import com.example.services.s3.S3Service;

@Service
public class ProdutosImagemService {
	
	@Autowired private ProdutosImagemRepository piRepository;
	@Autowired private S3Service s3Service;
	
	public List<ProdutosImagem> upload(Long id_produto, Long id_user, MultipartFile[] files){
		
		List<UploadFileModel> uploadFiles = s3Service.upload(files);
		List<ProdutosImagem> produtosImagem = new ArrayList<ProdutosImagem>();
		
		uploadFiles.forEach(uploadFile -> {
			ProdutosImagem file = new ProdutosImagem();
			file.setNome(uploadFile.getName());
			file.setLocalizacao(uploadFile.getLocalizao());
			
			Produto produto = new Produto();
			produto.setId(id_produto);			
			file.setProduto(produto);
			
			Usuario user = new Usuario();
			user.setId(id_user);			
			file.setUsuario(user);
			
			produtosImagem.add(file);
		});
		
		return piRepository.saveAll(produtosImagem);
	}
	
	public ProdutosImagem getById(Long id) {
		Optional<ProdutosImagem> result = piRepository.findAllByProdutoId(id);
		return result.orElseThrow(()-> new NotFoundException("ID de Produto Imagem não encontrado"));
	}

}
