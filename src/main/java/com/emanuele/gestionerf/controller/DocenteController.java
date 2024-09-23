package com.emanuele.gestionerf.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emanuele.gestionerf.model.Docente;
import com.emanuele.gestionerf.service.DocenteService;

@Controller
public class DocenteController {
	@Autowired
	private DocenteService docenteService;

	@GetMapping("/inserimentoDocente")
	public String paginaDocenteIns() {
		return "inserimentoDocente";
	}
	
	@GetMapping("/ricercaDocente")
	public String paginaDocenteRic() {
		return "ricercaDocente";
	}
	
	@GetMapping("/modificaDocente")
	public String paginaDocenteMod() {
		return "modificaDocente";
	}
	@GetMapping("/cancellaDocente")
	public String paginaDocenteCanc() {
		return "cancellaDocente";
	}

	@PostMapping("/insertDocente")
	public String insertDocente(Model model, @ModelAttribute Docente docente) {
	    String message;
	   
	    if (docenteService.cercaDocente(docente.getCf_docente()) != null) {
	        message = "Il codice fiscale del docente è già presente nel database.";
	    } else {
	        docenteService.inserimentoDocente(docente);
	        message = "Il docente è stato inserito.";
	    }

	    model.addAttribute("message", message);
	    return "result";
	}

	@PostMapping("/ricercaDocente")
	public String ricercaDocente(Model model, @RequestParam("cf") String cf) {
		String message = "";
		Docente docente = docenteService.cercaDocente(cf);
		if (docente != null) {
			message = "Il docente trovato è: " + docente.getNome_docente() + " " + docente.getCognome_docente();
		} else {
			message = "Nessun docente trovato con il codice fiscale: " + cf;
		}
		model.addAttribute("message", message);
		return "resultRicerca";
	}

	@PostMapping("/modificaDocente")
	public String modificaDocente(Model model, @RequestParam("cf_docente") String cf, @ModelAttribute Docente docente) {
		String message = "";
		Docente docenteEsistente = docenteService.cercaDocente(cf);
		if (docenteEsistente != null) {
			docenteEsistente.setNome_docente(docente.getNome_docente());
			docenteEsistente.setCognome_docente(docente.getCognome_docente());
			docenteService.modificaDocente(docenteEsistente);
			message = "Il docente è stato modificato";
		} else {
			message = "Nessun docente trovato con il codice fiscale: " + cf;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/eliminaDocente")
	public String eliminaDocente(Model model, @RequestParam("cf") String cf) {
		String message = "";
		Docente docente = docenteService.cercaDocente(cf);
		if (docente != null) {
			docenteService.eliminaDocente(cf);
			message = "Il docente è stato eliminato";
		} else {
			message = "Nessun docente trovato con il codice fiscale: " + cf;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@GetMapping("/stampaDocenti")
	public String stampaDocenti(Model model) {
		List<Docente> docenti = docenteService.stampaTuttiDocenti();
		model.addAttribute("docenti", docenti);
		return "listaDocenti";
	}
}
