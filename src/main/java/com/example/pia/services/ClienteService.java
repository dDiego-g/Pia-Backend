package com.example.pia.services;

import java.util.List;

import com.example.pia.controllers.entitys.Cliente;

public interface ClienteService {

	Cliente find(Long primary);
	void insert(Cliente entity);
	void update(Cliente entity);
	void delete(Long primary);
	List<Cliente> findAll();
	List<Cliente> buscarName(String nombre);
	List<Cliente> findMayor();
	List<Cliente> findMonto();

}
