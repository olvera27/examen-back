package com.examen.login.service;

import java.util.Calendar;
import java.util.Date;

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

	public void updateVigencia(Usuario usuario) {
		System.out.println("service vigencia");
		
		Calendar c = Calendar.getInstance();
		c.setTime(usuario.getFechaVigencia());
		c.add(Calendar.DAY_OF_YEAR, 30);
		System.out.println("FECHA MAS UN MES " + c.getTime());
		usuario.setFechaVigencia(c.getTime());
		usuario.setFechaModificacion(new Date());
		usuarioRepository.save(usuario);
	}

}
