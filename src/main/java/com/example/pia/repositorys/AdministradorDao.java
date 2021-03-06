package com.example.pia.repositorys;

import java.util.List;

import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.pia.controllers.entitys.Administrador;
import com.example.pia.controllers.entitys.Cliente;

public interface AdministradorDao extends Crud<Cliente, Long>{

	List<Cliente> findNombre(String nombre);
	List<Cliente> findMayor();
	
}
