package com.examen.login.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegistroDTO {

	@NotBlank
	private String nombre;
	@Email
	private String email;
	@NotBlank
	private String password;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistroDTO [nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}

}
