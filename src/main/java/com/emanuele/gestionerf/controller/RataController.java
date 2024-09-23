package com.emanuele.gestionerf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emanuele.gestionerf.model.Rata;
import com.emanuele.gestionerf.service.RataService;

@Controller
public class RataController {
	
	@Autowired
	private RataService rataService;
	
	@PostMapping(path = "/insertRata")
	public String insertRata(@ModelAttribute Rata rata) {
		
		rataService.inserimentoRata(rata);

		return "result";
	}

}
