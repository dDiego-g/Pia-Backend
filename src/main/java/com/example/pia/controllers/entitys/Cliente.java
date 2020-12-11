package com.example.pia.controllers.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.pia.validations.MontoMinimo;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@NotNull
	private Long id;
	
	@NotEmpty
	//@Column(name="nombre")
	private String nombre;
	
	@NotEmpty
	//@CorreoValid
	private String correo;
	
	@NotNull
	private int telefono;
	
	@NotEmpty
	private String direccion;
	
	//@MontoMinimo
	private float monto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

}
