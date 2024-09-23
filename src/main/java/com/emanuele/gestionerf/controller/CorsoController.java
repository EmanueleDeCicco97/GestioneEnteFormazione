package com.emanuele.gestionerf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emanuele.gestionerf.model.Corso;
import com.emanuele.gestionerf.service.CorsoService;

@Controller
public class CorsoController {

	@Autowired
	private CorsoService corsoService;

	@GetMapping("/inserimentoCorso")
	public String paginaCorsoIns(Model model) {
		return "inserimentoCorso";
	}
	@GetMapping("/ricercaCorso")
		public String paginaCorsoRic(Model model) {
			List<Corso> corsi = corsoService.elencoCorsi();
			 model.addAttribute("corsi", corsi);
		
		return "ricercaCorso";
	}
	@GetMapping("/modificaCorso")
	public String paginaCorsoMod(Model model) {
		List<Corso> corsi = corsoService.elencoCorsi();
		 model.addAttribute("corsi", corsi);
	
	return "modificaCorso";
}
	@GetMapping("/cancellaCorso")
	public String paginaCorsoCanc(Model model) {
		List<Corso> corsi = corsoService.elencoCorsi();
		 model.addAttribute("corsi", corsi);
	
	return "cancellaCorso";
}
	
	

	@PostMapping("/insertCorso")
	public String insertCorso(Model model, @ModelAttribute Corso corso) {
		String message = "";
		corsoService.inserimentoCorso(corso);
		message = "Il corso è stato inserito";
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/ricercaCorso")
	public String ricercaCorso(Model model, @RequestParam("id_corso") int idCorso) {
		String message = "";
		Corso corso = corsoService.cercaCorso(idCorso);
		if (corso != null) {
			message = "Il corso trovato ha tipologia: " + corso.getTipologia()+" "+"ID Corso: "+ corso.getId_corso()+" "+"Prezzo: "+ corso.getPrezzo()+" "+"Rate: "+corso.getN_rate()+" "+"Data Inizio: "+corso.getData_inizio()+" "+"Data Fine: "+corso.getData_fine();
		} else {
			message = "Nessun corso trovato con ID: " + idCorso;
		}
		model.addAttribute("message", message);
		return "resultRicerca";
	}

	@PostMapping("/modificaCorso")
	public String modificaCorso(Model model, @RequestParam("id_corso") int idCorso, @ModelAttribute Corso corso) {
		String message = "";
		Corso corsoEsistente = corsoService.cercaCorso(idCorso);
		if (corsoEsistente != null) {
			corsoEsistente.setTipologia(corso.getTipologia());
			corsoEsistente.setData_inizio(corso.getData_inizio());
			corsoEsistente.setData_fine(corso.getData_fine());
			corsoEsistente.setPrezzo(corso.getPrezzo());
			corsoEsistente.setN_rate(corso.getN_rate());
			corsoService.modificaCorso(corsoEsistente);
			message = "Il corso è stato modificato";
		} else {
			message = "Nessun corso trovato con ID: " + idCorso;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/eliminaCorso")
	public String eliminaCorso(Model model, @RequestParam("id_corso") int idCorso) {
		String message = "";
		Corso corso = corsoService.cercaCorso(idCorso);
		if (corso != null) {
			corsoService.eliminaCorso(idCorso);
			message = "Il corso è stato eliminato";
		} else {
			message = "Nessun corso trovato con ID: " + idCorso;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@GetMapping("/stampaCorsi")
	public String stampaCorsi(Model model) {
		List<Corso> corsi = corsoService.stampaTuttiCorsi();
		model.addAttribute("corsi", corsi);
		return "listaCorsi";
	}
}
