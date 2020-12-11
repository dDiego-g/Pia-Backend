package com.example.pia.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pia.controllers.entitys.Prestamo;
import com.example.pia.services.PrestamoService;

@Controller
@RequestMapping(path = {"/prestamo","/", "/index",""})
public class PrestamoController {

	@Autowired 
	private PrestamoService as;
	
	@GetMapping(path = {"", "/"})
	public String home(Model model) {
		model.addAttribute("titulo", "Home Prestamo");
		model.addAttribute("prestamos", as.findAll());
		return "prestamo/index";
	}
	
	@GetMapping(path = { "/alta"})
	public String alta(Model model) {
		model.addAttribute("titulo", "Alta Prestamo");
		model.addAttribute("prestamo", new Prestamo());
		return "prestamo/alta";
	}
	
	@GetMapping(path = { "/abonar/{id}"})
	public String abonar(@PathVariable Long id,Model model) {
		model.addAttribute("titulo", "Abonar Prestamo");
		model.addAttribute("prestamo", as.find(id));
		return "prestamo/abonar";
	}
	
	@PostMapping(path = {"/guardar"})
	private String guardar(@Valid Prestamo prestamo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Prestamo");
			return "prestamo/alta";
		}
		prestamo.setActivo(true);
		as.insert(prestamo);
		model.addAttribute("titulo", "Home Prestamo");
		model.addAttribute("prestamos", as.findAll());
		return "prestamo/index";
	}
	@PostMapping(path = {"/update"})
	private String actualizar(@Valid Prestamo prestamo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Prestamo");
			return "prestamo/alta";
		}
		
		if(prestamo.getMonto() == 0){
			prestamo.setActivo(false);
		}
		as.update(prestamo);
		model.addAttribute("titulo", "Home Prestamo");
		model.addAttribute("prestamos", as.findAll());
		
		return "prestamo/index";
	}
	
	@GetMapping(path = {"/eliminar/{id}"})
	private String eliminar(@PathVariable Long id, Model model) {
		
		as.delete(id);
		model.addAttribute("titulo", "Home Prestamo");
		model.addAttribute("prestamos", as.findAll());
		return "prestamo/index";
	}
	
	@GetMapping(path = {"/buscar"})
	public String buscar(Model model) {
		model.addAttribute("titulo", "Busqueda Prestamo");
		model.addAttribute("prestamos", as.findAll());
		return "prestamo/buscar";
	}
	
	@GetMapping(path= {"/buscarID"})
	public String buscarID(Model model) {
		model.addAttribute("prestamo" , new Prestamo());
		return "prestamo/buscarID";
	}
	
	@PostMapping(path= {"/buscarID"})
	public String buscarID(
			Long id,
			Model model) {
		if( id == null ||id < 0) {
			model.addAttribute("error", "ID no es valido, favor de varificarlo.");
			model.addAttribute("prestamo" , new Prestamo());
			return "prestamo/buscarID";
		}
		//Metodo buscar(id)????
		model.addAttribute("prestamo" , as.find(id));
		
		return "prestamo/buscarID";
	}
	
	@GetMapping(path= {"/buscarFecha"})
	public String buscarFecha(Model model) {
		model.addAttribute("prestamo" , new Prestamo());
		return "prestamo/buscarFecha";
	}
	
	@PostMapping(path= {"/buscarFecha"})
	public String buscarFecha(
			Date fechaExpiracion,
			Model model) {
		
		
		
		//Modificar Aqui
		model.addAttribute("listaPrestamo" , as.buscarFecha(fechaExpiracion));
		
		return "prestamo/buscarFecha";
	}
	
	@GetMapping(path= {"/buscarActivo"})
	public String buscarActivo(Model model) {
		model.addAttribute("prestamo" , new Prestamo());
		return "prestamo/buscarActivo";
	}
	
	@PostMapping(path= {"/buscarActivo"})
	public String buscarActivo(
			boolean activo,
			Model model) {
		
		//Modificar Aqui
		model.addAttribute("listaPrestamo" , as.buscarActivo(activo));
		
		return "prestamo/buscarActivo";
	}
	
	
}