package com.example.pia.repositorys;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pia.controllers.entitys.Administrador;
import com.example.pia.controllers.entitys.Cliente;

@Repository
public class AdministradorDaoImpl implements AdministradorDao {

	@Autowired
	private EntityManager en;
	
	@Override
	@Transactional(readOnly = true)
	public Cliente find(Long primary) {
		return en.find(Cliente.class, primary);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findNombre(String nombre){
		List<Cliente> result = en.createQuery("Select c From Cliente c Where c.nombre=:nombreC").setParameter("nombreC", nombre).getResultList();
		return result;
	}

	@Override
	@Transactional
	public void insert(Cliente entity) {
		en.persist(entity);

	}

	@Override
	@Transactional
	public void update(Cliente entity) {
		en.merge(entity);

	}

	@Override
	@Transactional
	public void delete(Long primary) {
		Cliente eliminar  = find(primary);
		en.remove(eliminar);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return en.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public List<Cliente> findMayor() {
		float mayor=0;
		
		for(Cliente cliente: findAll()) {
			if(mayor < cliente.getMonto()) {
				mayor=cliente.getMonto();	
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Cliente> resultado = en.createQuery("SELECT c FROM Cliente c WHERE c.monto=:monto")
				.setParameter("monto", mayor)
				.getResultList();
		return resultado;
	}


	

}
