package com.examen.login.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.login.dto.JwtDTO;
import com.examen.login.dto.LoginUsuarioDTO;
import com.examen.login.dto.ResponseDTO;
import com.examen.login.entity.Usuario;
import com.examen.login.service.UsuarioService;

@RestController
@RequestMapping("/vigencia")
@CrossOrigin(origins = "*")
public class VigenciaController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/consulta")
	public ResponseEntity<Usuario> consultaVigencia(@RequestParam String nombre) {
		System.out.println("HOLA");
		System.out.println(nombre);
		Usuario usuario = usuarioService.getByNombre(nombre);
		
		return new ResponseEntity(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/actualizarVigencia")
	public ResponseEntity<?> actualiza(@RequestBody Usuario usuario) {		
		System.out.println("usuario " + usuario.toString());
		usuarioService.updateVigencia(usuario);		
		return new ResponseEntity(new ResponseDTO(1, "La vigencia se ha actualizado"), HttpStatus.OK);	
	}
}
