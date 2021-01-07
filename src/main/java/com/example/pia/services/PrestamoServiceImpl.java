package com.example.pia.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pia.controllers.entitys.Prestamo;
import com.example.pia.repositorys.PrestamoDAO;

@Service
public class PrestamoServiceImpl implements PrestamoService {

	//Patron de diseño Facade -> fachada
	@Autowired
	private PrestamoDAO  a;
	@Override
	public Prestamo find(Long primary) {
		return a.find(primary);
	}

	@Override
	public void insert(Prestamo entity) {
		a.insert(entity);

	}

	@Override
	public void update(Prestamo entity) {
		a.update(entity);
	}

	@Override
	public void delete(Long primary) {
		a.delete(primary);
	}

	@Override
	public List<Prestamo> findAll() {
		return a.findAll();
	}

	@Override
	public List<Prestamo> buscarFecha(Date fecha) {
		return a.findFecha(fecha);
	}
	
	@Override
	public List<Prestamo> buscarActivo(boolean activo) {
		List<Prestamo> result = a.findActivo(activo);
		return result;
	}

}
