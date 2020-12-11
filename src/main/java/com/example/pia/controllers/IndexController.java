package com.example.pia.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path = "/app")
public class IndexController {

	@RequestMapping(path = { "/index", }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", "Home Banco");
		return "index";
	}

}
