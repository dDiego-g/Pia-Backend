package com.example.pia.repositorys;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pia.controllers.entitys.Prestamo;

@Repository
public class PrestamoDAOImpl implements PrestamoDAO {

	@Autowired
	private EntityManager en;
	
	@Override
	@Transactional(readOnly = true)
	public Prestamo find(Long primary) {
		return en.find(Prestamo.class, primary);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findFecha(Date fecha){
		return en.createQuery("from Prestamo p where p.fechaExpiracion = :activoP ").setParameter("activoP", fecha).getResultList();
		//return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findActivo(boolean activo){
		List<Prestamo> result = en.createQuery("from Prestamo p where p.activo = :activoP ").setParameter("activoP", activo).getResultList();
		return result;
	}

	@Override
	@Transactional
	public void insert(Prestamo entity) {
		en.persist(entity);

	}

	@Override
	@Transactional
	public void update(Prestamo entity) {
		en.merge(entity);

	}

	@Override
	@Transactional
	public void delete(Long primary) {
		Prestamo eliminar  = find(primary);
		en.remove(eliminar);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findAll() {
		return en.createQuery("from Prestamo").getResultList();
	}

	

}
