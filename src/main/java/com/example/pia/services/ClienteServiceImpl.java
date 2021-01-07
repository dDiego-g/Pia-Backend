package com.example.pia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pia.controllers.entitys.Cliente;
import com.example.pia.repositorys.ClienteDao;

@Service
public class ClienteServiceImpl implements ClienteService {

	//Patron de diseño Facade -> fachada
	@Autowired
	private ClienteDao  a;
	@Override
	public Cliente find(Long primary) {
		return a.find(primary);
	}

	@Override
	public void insert(Cliente entity) {
		a.insert(entity);

	}

	@Override
	public void update(Cliente entity) {
		a.update(entity);
	}

	@Override
	public void delete(Long primary) {
		a.delete(primary);
	}

	@Override
	public List<Cliente> findAll() {
		return a.findAll();
	}

	@Override
	public List<Cliente> buscarName(String nombre) {
		//List<Cliente> result = a.findNombre(nombre);
		//return result;
		return a.findNombre(nombre);
	}

	@Override
	public List<Cliente> findMayor() {
		return a.findMayor();
	}

	@Override
	public List<Cliente> findMonto() {
		
		return a.findMonto();
	}

	@Override
	public Cliente findTotal() {
		return a.findTotal();
	}

	@Override
	public Cliente retirar(Long id, float monto) {
		return a.retirar(id, monto);
		
	}
	
	@Override
	public Cliente abonar(Long id, float monto) {
		return a.abonar(id, monto);
		
	}

	

}
