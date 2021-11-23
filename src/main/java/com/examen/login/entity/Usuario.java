package com.examen.login.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	private String login;
	@NotNull
	private String password;
	@NotNull
	private String nombre;
	@NotNull
	private double cliente;
	private String email;
	@NotNull
	private Date fechaAlta;
	private Date fechaBaja;
	@NotNull
	@Column(length = 1)
	private String status;
	@NotNull
	private double intentos;
	private Date fechaRevocado;
	private Date fechaVigencia;
	private int noAcceso;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int area;
	@NotNull
	private Date fechaModificacion;

	public Usuario() {
	}

	public Usuario(@NotNull String password, @NotNull String nombre, String email, @NotNull double cliente,
			@NotNull Date fechaAlta, @NotNull String status, @NotNull Date fechaModificacion) {		
		this.password = password;
		this.nombre = nombre;
		this.cliente = cliente;
		this.email = email;
		this.fechaAlta = fechaAlta;
		this.status = status;
		this.fechaModificacion = fechaModificacion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCliente() {
		return cliente;
	}

	public void setCliente(double cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getIntentos() {
		return intentos;
	}

	public void setIntentos(double intentos) {
		this.intentos = intentos;
	}

	public Date getFechaRevocado() {
		return fechaRevocado;
	}

	public void setFechaRevocado(Date fechaRevocado) {
		this.fechaRevocado = fechaRevocado;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public int getNoAcceso() {
		return noAcceso;
	}

	public void setNoAcceso(int noAcceso) {
		this.noAcceso = noAcceso;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", password=" + password + ", nombre=" + nombre + ", cliente=" + cliente
				+ ", email=" + email + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", status=" + status
				+ ", intentos=" + intentos + ", fechaRevocado=" + fechaRevocado + ", fechaVigencia=" + fechaVigencia
				+ ", noAcceso=" + noAcceso + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", area=" + area + ", fechaModificacion=" + fechaModificacion + "]";
	}

}