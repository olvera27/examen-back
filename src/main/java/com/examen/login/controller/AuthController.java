package com.examen.login.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.login.dto.JwtDTO;
import com.examen.login.dto.LoginUsuarioDTO;
import com.examen.login.dto.RegistroDTO;
import com.examen.login.dto.ResponseDTO;
import com.examen.login.entity.Usuario;
import com.examen.login.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginUsuarioDTO loginUsuarioDTO)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Usuario usuario = usuarioService.getByNombre(loginUsuarioDTO.getUsuario());
		if (usuario != null) {
			if (loginUsuarioDTO.getPassword().equals(decode(usuario.getPassword()))) {				
				JwtDTO jwtDTO = new JwtDTO(getJWTToken(loginUsuarioDTO.getUsuario()), loginUsuarioDTO.getUsuario());
				return new ResponseEntity(jwtDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity(new ResponseDTO(0, "Contraseña incorreta"), HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity(new ResponseDTO(0, "El usuario no existe"), HttpStatus.UNAUTHORIZED);
		}
			
	}

	@PostMapping("/registro")
	public ResponseEntity<?> nuevo(@Valid @RequestBody RegistroDTO nuevoUsuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Usuario usuario;
		usuario = new Usuario(encode(nuevoUsuario.getPassword()), nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), 1, new Date(), "A", new Date());
		usuarioService.save(usuario);
		return new ResponseEntity(new ResponseDTO(1, "Usuario generado correctamente."), HttpStatus.CREATED);
	}

	public String encode(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(input.getBytes());
	}

	public String decode(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return new String(Base64.getDecoder().decode(input));
	}	

	private String getJWTToken(String username) {
		String secretKey = "examenSecret";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("examenJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
