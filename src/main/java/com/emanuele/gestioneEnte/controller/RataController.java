package com.emanuele.gestioneEnte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emanuele.gestioneEnte.model.Rata;
import com.emanuele.gestioneEnte.service.RataService;

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
