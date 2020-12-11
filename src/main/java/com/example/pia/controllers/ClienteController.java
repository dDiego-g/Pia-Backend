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

import com.example.pia.controllers.entitys.Cliente;
import com.example.pia.services.ClienteService;

@Controller
@RequestMapping(path = {"/cliente","/", "/index",""})
public class ClienteController {

	@Autowired 
	private ClienteService as;
	
	@GetMapping(path = {"", "/"})
	public String home(Model model) {
		model.addAttribute("titulo", "Home Cliente");
		model.addAttribute("clientes", as.findAll());
		return "cliente/index";
	}
	
	@GetMapping(path = { "/alta"})
	public String alta(Model model) {
		model.addAttribute("titulo", "Alta Cliente");
		model.addAttribute("cliente", new Cliente());
		return "cliente/alta";
	}
	
	@GetMapping(path = { "/editar/{id}"})
	public String editar(@PathVariable Long id,Model model) {
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("cliente", as.find(id));
		return "cliente/editar";
	}
	
	@PostMapping(path = {"/guardar"})
	private String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Cliente");
			return "cliente/alta";
		}
		as.insert(cliente);
		model.addAttribute("titulo", "Home Cliente");
		model.addAttribute("clientes", as.findAll());
		return "cliente/index";
	}
	@PostMapping(path = {"/update"})
	private String actualizar(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Cliente");
			return "cliente/alta";
		}
		as.update(cliente);
		model.addAttribute("titulo", "Home Cliente");
		model.addAttribute("clientes", as.findAll());
		return "cliente/index";
	}
	
	@GetMapping(path = {"/eliminar/{id}"})
	private String eliminar(@PathVariable Long id, Model model) {
		
		as.delete(id);
		model.addAttribute("titulo", "Home Cliente");
		model.addAttribute("clientes", as.findAll());
		return "cliente/index";
	}
	
	
}
