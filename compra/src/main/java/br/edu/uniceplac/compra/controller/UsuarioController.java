package br.edu.uniceplac.compra.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.uniceplac.compra.entidade.UsuarioEntity;
import br.edu.uniceplac.compra.pojo.Usuario;
import br.edu.uniceplac.compra.repository.UsuarioRepository;

@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;

	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNome(usuario.getNome());
		usuarioEntity.setSenha(usuario.getSenha());
		usuarioEntity = usuarioRepository.save(usuarioEntity);
		usuarioEntity.setId(usuario.getId());
		
	return usuario;
	}
	
	

}
