package com.emanuele.gestionerf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emanuele.gestionerf.model.Corsista;
import com.emanuele.gestionerf.service.CorsistaService;

@Controller
public class CorsistaController {

	@Autowired
	private CorsistaService corsistaService;

	@GetMapping("/index")
	public String paginaHome() {
		return "index";
	}

	@GetMapping("/inserimentoCorsista")
	public String paginaCorsistaIns() {
		return "inserimentoCorsista";
	}

	@GetMapping("/ricercaCorsista")
	public String paginaCorsistaRic() {
		return "ricercaCorsista";
	}

	@GetMapping("/modificaCorsista")
	public String paginaCorsistaMod() {
		return "modificaCorsista";
	}

	@GetMapping("/cancellaCorsista")
	public String paginaCorsistaCanc() {
		return "cancellaCorsista";
	}

	@PostMapping("/insertCorsista")
	public String insertCorsista(Model model, @ModelAttribute Corsista corsista) {
		String message = "";

		// Verifico se il CF del corsista è già presente nel database
		Corsista corsistaExists = corsistaService.cercaCorsista(corsista.getCf_corsista());

		if (corsistaExists != null) {
			message = "Il CF del corsista è già presente nel database";

		} else {
			corsistaService.inserimentoCorsista(corsista);

			message = "Il corsista è stato inserito";

		}

		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/ricercaCorsista")
	public String ricercaCorsista(Model model, @RequestParam("cf") String cf) {
		String message = "";
		Corsista corsista = corsistaService.cercaCorsista(cf);
		if (corsista != null) {
			message = "Il corsista trovato è: " + corsista.getNome_corsista() + " " + corsista.getCognome_corsista();
		} else {
			message = "Nessun corsista trovato con il codice fiscale: " + cf;
		}
		model.addAttribute("message", message);
		return "resultRicerca";
	}

	@PostMapping("/modificaCorsista")
	public String modificaCorsista(Model model, @RequestParam("cf_corsista") String id,
			@ModelAttribute Corsista corsista) {
		String message = "";
		Corsista corsistaEsistente = corsistaService.cercaCorsista(id);
		if (corsistaEsistente != null) {
			corsistaEsistente.setNome_corsista(corsista.getNome_corsista());
			corsistaEsistente.setCognome_corsista(corsista.getCognome_corsista());
			corsistaService.modificaCorsista(corsistaEsistente);
			message = "Il corsista è stato modificato";
		} else {
			message = "Nessun corsista trovato con il codice fiscale: " + id;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/eliminaCorsista")
	public String eliminaCorsista(Model model, @RequestParam("cf") String cf) {
		String message = "";
		Corsista corsista = corsistaService.cercaCorsista(cf);
		if (corsista != null) {
			corsistaService.eliminaCorsista(cf);
			message = "Il corsista è stato eliminato";
		} else {
			message = "Nessun corsista trovato con il codice fiscale: " + cf;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@GetMapping("/stampaCorsisti")
	public String stampaCorsisti(Model model) {
		List<Corsista> corsisti = corsistaService.stampaTuttiCorsisti();
		model.addAttribute("corsisti", corsisti);
		return "listaCorsisti";
	}
}
