package com.emanuele.gestioneEnte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emanuele.gestioneEnte.model.Corso;
import com.emanuele.gestioneEnte.model.Docente;
import com.emanuele.gestioneEnte.model.Insegna;
import com.emanuele.gestioneEnte.service.CorsoService;
import com.emanuele.gestioneEnte.service.DocenteService;
import com.emanuele.gestioneEnte.service.InsegnaService;

@Controller
public class InsegnaController {

	@Autowired
	private InsegnaService insegnaService;
	@Autowired
	private CorsoService corsoService;
	@Autowired
	private DocenteService docenteService;

	@GetMapping("/inserimentoInsegna")
	public String paginaInsegnaIns(Model model) {
		List<Corso> corsi = corsoService.elencoCorsi();
		model.addAttribute("corsi", corsi);
		List<Docente> docenti = docenteService.stampaTuttiDocenti();
		model.addAttribute("docenti", docenti);
		List<Insegna> insegnamenti = insegnaService.stampaTuttiInsegnamenti();
		model.addAttribute("insegnamenti", insegnamenti);
		return "inserimentoInsegna";
	}

	@GetMapping("/ricercaInsegna")
	public String paginaInsegnaRic(Model model) {
		List<Corso> corsi = corsoService.elencoCorsi();
		model.addAttribute("corsi", corsi);
		List<Docente> docenti = docenteService.stampaTuttiDocenti();
		model.addAttribute("docenti", docenti);
		List<Insegna> insegnamenti = insegnaService.stampaTuttiInsegnamenti();
		model.addAttribute("insegnamenti", insegnamenti);
		return "ricercaInsegna";
	}

	@GetMapping("/modificaInsegna")
	public String paginaInsegnaMod(Model model) {
		List<Corso> corsi = corsoService.elencoCorsi();
		model.addAttribute("corsi", corsi);
		List<Docente> docenti = docenteService.stampaTuttiDocenti();
		model.addAttribute("docenti", docenti);
		List<Insegna> insegnamenti = insegnaService.stampaTuttiInsegnamenti();
		model.addAttribute("insegnamenti", insegnamenti);
		return "modificaInsegna";
	}

	@GetMapping("/cancellaInsegna")
	public String paginaInsegnaCanc(Model model) {
		List<Corso> corsi = corsoService.elencoCorsi();
		model.addAttribute("corsi", corsi);
		List<Docente> docenti = docenteService.stampaTuttiDocenti();
		model.addAttribute("docenti", docenti);
		List<Insegna> insegnamenti = insegnaService.stampaTuttiInsegnamenti();
		model.addAttribute("insegnamenti", insegnamenti);
		return "cancellaInsegna";
	}

	@PostMapping("/inserimentoInsegna")
	public String insertInsegna(Model model, @ModelAttribute Insegna insegna, @ModelAttribute("id_corso") Corso corso,
			@ModelAttribute("cf_docente") Docente docente) {
		String message;

		Docente d = docenteService.cercaDocente(docente.getCf_docente());
		insegna.setCorso(corso);
		insegna.setDocente(d);

		insegnaService.inserimentoInsegna(insegna);

		message = "L'insegnamento è avvenuto con successo";

		model.addAttribute("message", message);

		return "result";
	}

	@PostMapping("/ricercaInsegna")
	public String ricercaInsegna(Model model, @RequestParam("id_insegnamento") int idInsegnamento) {
		String message;
		Insegna insegna = insegnaService.cercaInsegna(idInsegnamento);
		if (insegna != null) {
			message = "L'insegnamento trovato ha ID: " + insegna.getId_insegnamento() + " CF Docente: "
					+ insegna.getDocente() + "  Corso: " + insegna.getCorso();
		} else {
			message = "Nessun insegnamento trovato con ID: " + idInsegnamento;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/modificaInsegna")
	public String modificaInsegna(Model model, @RequestParam("id_insegnamento") int idInsegnamento,
			@ModelAttribute("insegna") Insegna insegna) {
		String message;
		Insegna insegnaEsistente = insegnaService.cercaInsegna(idInsegnamento);
		if (insegnaEsistente != null) {
			insegnaEsistente.setPrezzo_docente(insegna.getPrezzo_docente());
			insegnaEsistente.setPagato(insegna.getPagato());
			insegnaService.modificaInsegna(insegnaEsistente);
			message = "L'insegnamento è stato modificato";
		} else {
			message = "Nessun insegnamento trovato con ID: " + idInsegnamento;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/eliminaInsegna")
	public String eliminaInsegna(Model model, @RequestParam("id_insegnamento") int idInsegnamento) {
		String message;
		Insegna insegna = insegnaService.cercaInsegna(idInsegnamento);
		if (insegna != null) {
			insegnaService.eliminaInsegna(idInsegnamento);
			message = "L'insegnamento è stato eliminato";
		} else {
			message = "Nessun insegnamento trovato con ID: " + idInsegnamento;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@GetMapping("/stampaInsegnamenti")
	public String stampaInsegnamenti(Model model) {
		List<Insegna> insegnamenti = insegnaService.stampaTuttiInsegnamenti();
		model.addAttribute("insegnamenti", insegnamenti);
		return "listaInsegnamenti";
	}
}
