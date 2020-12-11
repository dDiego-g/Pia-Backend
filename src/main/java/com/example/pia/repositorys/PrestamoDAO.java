package com.example.pia.repositorys;

import java.sql.Date;
import java.util.List;

import com.example.pia.controllers.entitys.Prestamo;

public interface PrestamoDAO extends Crud<Prestamo, Long>{
	
	List<Prestamo> findFecha(Date fechaExpiracion);
	List<Prestamo> findActivo(boolean activo);

}
