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

	

}
