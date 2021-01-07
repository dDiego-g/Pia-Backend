package com.example.pia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pia.controllers.entitys.Administrador;
import com.example.pia.controllers.entitys.Cliente;
import com.example.pia.services.ClienteService;

@Controller
@RequestMapping(path = {"/administrador"})
public class AdministradorController {

	@Autowired 
	private ClienteService as;
	
	@GetMapping(path = {"", "/","/home"})
	public String home(Model model) {
		model.addAttribute("titulo", "Home Administrador");
		model.addAttribute("clientes", as.findAll());
		return "administrador/index";
	}
	
	@GetMapping(path = { "/alta"})
	public String alta(Model model) {
		model.addAttribute("titulo", "Alta Administrador");
		model.addAttribute("cliente", new Cliente());
		return "administrador/alta";
	}
	
	@GetMapping(path = {"/buscar"})
	public String buscar(Model model) {
		model.addAttribute("titulo", "Busqueda Administrador");
		model.addAttribute("clientes", as.findAll());
		return "administrador/buscar";
	}
	
	@GetMapping(path = { "/editar/{id}"})
	public String editar(@PathVariable Long id,Model model) {
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("cliente", as.find(id));
		return "administrador/editar";
	}
	
	@GetMapping(path= {"/buscarID"})
	public String buscarID(Model model) {
		model.addAttribute("cliente" , new Cliente());
		return "administrador/buscarID";
	}
	
	@PostMapping(path= {"/buscarID"})
	public String buscarID(
			Long id,
			Model model) {
		if( id == null ||id < 0) {
			model.addAttribute("error", "ID no es valido, favor de varificarlo.");
			model.addAttribute("cliente" , new Cliente());
			return "administrador/buscar_ID";
		}
		//Metodo buscar(id)????
		model.addAttribute("cliente" , as.find(id));
		
		return "administrador/buscarID";
	}
	
	@GetMapping(path= {"/buscarNombre"})
	public String buscarNombre(Model model) {
		model.addAttribute("cliente" , new Cliente());
		return "administrador/buscarNombre";
	}
	
	@PostMapping(path= {"/buscarNombre"})
	public String buscarNombre(
			String nombre,
			Model model) {
		
		if( nombre == null || nombre == "") {
			model.addAttribute("error", "Nombre no valido");
			model.addAttribute("cliente" , new Cliente());
			return "administrador/buscarNombre";
		}
		
		//Modificar Aqui
		model.addAttribute("titulo", "Clientes por nombre");
		model.addAttribute("clientes" , as.buscarName(nombre));
		
		return "administrador/buscarNombre";
	}
	
	@GetMapping(path= {"/buscarMayor"})
	public String buscarMayor(Model model) {
		model.addAttribute("titulo","Cliente con mas dinero");
		model.addAttribute("clientes" , as.findMayor());
		return "administrador/buscarMayor";
	}
	
	/*@PostMapping(path= {"/buscarMayor"})
	public String buscarMayor(
			Model model) {

		//Modificar Aqui
		model.addAttribute("titulo","Cliente con mas dinero");
		model.addAttribute("clientes" , as.findMayor());
		return "administrador/buscarMayor";
	}*/
	
	@GetMapping(path= {"/montoTotal"})
	public String montoTotal(Model model) {
		model.addAttribute("titulo","Monto total en banco");
		model.addAttribute("cliente" , as.findTotal());
		return "administrador/montoTotal";
	}
	
	@PostMapping(path= {"/montoTotal"})
	public String montoTotal(
			float monto,
			Model model) {

		//Modificar Aqui
		model.addAttribute("listaCliente" , as.findMayor());
		return "administrador/montoTotal";
	}
	
	@PostMapping(path = {"/guardar"})
	private String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Administrador");
			return "administrador/alta";
		}
		as.insert(cliente);
		model.addAttribute("titulo", "Home Administrador");
		model.addAttribute("clientes", as.findAll());
		return "administrador/index";
	}
	@PostMapping(path = {"/update"})
	private String actualizar(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Administrador");
			return "administrador/alta";
		}
		as.update(cliente);
		model.addAttribute("titulo", "Home Administrador");
		model.addAttribute("clientes", as.findAll());
		return "administrador/index";
	}
	
	@GetMapping(path = {"/eliminar/{id}"})
	private String eliminar(@PathVariable Long id, Model model) {
		
		as.delete(id);
		model.addAttribute("titulo", "Home Administrador");
		model.addAttribute("clientes", as.findAll());
		return "administrador/index";
	}
	
	
}
