package com.example.pia.services;

import java.sql.Date;
import java.util.List;

import com.example.pia.controllers.entitys.Prestamo;

public interface PrestamoService {

	Prestamo find(Long primary);
	void insert(Prestamo entity);
	void update(Prestamo entity);
	void delete(Long primary);
	List<Prestamo> findAll();
	List<Prestamo> buscarFecha(Date fecha);
	List<Prestamo> buscarActivo(boolean activo);

}