package com.examen.login.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuarioDTO {

	@NotBlank
	private String usuario;
	@NotBlank
	private String password;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUsuarioDTO [usuario=" + usuario + ", password=" + password + "]";
	}

}
