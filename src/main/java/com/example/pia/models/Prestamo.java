package com.example.pia.models;

import java.sql.Date;

public class Prestamo {

	private Long id;
	private Date fechaCreacion;
	private Date fechaExpiracion;
	private String tipo;
	private float monto;
	private boolean activo;
	

	public Prestamo() {
	}

	public Prestamo(Long id, Date fechaCreacion, Date fechaExpiracion, String tipo, float monto) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaExpiracion = fechaExpiracion;
		this.tipo = tipo;
		this.monto = monto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	

	
}