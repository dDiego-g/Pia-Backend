package com.example.pia.repositorys;

import java.util.List;

import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.pia.controllers.entitys.Cliente;

public interface ClienteDao extends Crud<Cliente, Long>{

	List<Cliente> findNombre(String nombre);
	List<Cliente> findMayor();
	List<Cliente> findMonto();
	Cliente findTotal();
	Cliente retirar(Long id, float monto);
	Cliente abonar(Long id, float monto);
}
