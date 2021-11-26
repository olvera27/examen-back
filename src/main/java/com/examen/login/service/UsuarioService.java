package com.examen.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.login.entity.Usuario;
import com.examen.login.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario getByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		System.out.println("service update usuario");
		usuarioRepository.save(usuario);
	}

}
