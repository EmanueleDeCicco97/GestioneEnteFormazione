package com.emanuele.gestioneEnte.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.emanuele.gestioneEnte.model.Corsista;
import com.emanuele.gestioneEnte.model.Corso;
import com.emanuele.gestioneEnte.model.Partecipazione;
import com.emanuele.gestioneEnte.repository.CorsoRepository;
import com.emanuele.gestioneEnte.service.PartecipazioneService;

@Controller
public class PartecipazioneController {

	@Autowired
	private PartecipazioneService partecipazioneService;
	@Autowired
	CorsoRepository corsoRepository;

	@GetMapping(path = "/inserimentoPartecipazione")
	public String assegnaPartecipazione(Model model, @ModelAttribute Partecipazione p) {
		List<Corsista> corsisti = partecipazioneService.elencoCorsisti();
		List<Corso> corsi = partecipazioneService.elencoCorsi();

		model.addAttribute("corsisti", corsisti);
		model.addAttribute("corsi", corsi);
		return "inserimentoPartecipazione";
	}

	@GetMapping(path = "/ricercaPartecipazioni")
	public String assegnaPartecipazioneRic(Model model, @ModelAttribute Partecipazione p) {
		List<Corsista> corsisti = partecipazioneService.elencoCorsisti();
		List<Corso> corsi = partecipazioneService.elencoCorsi();
		List<Partecipazione> partecipazioni = partecipazioneService.elencoPartecipazioni();

		model.addAttribute("corsisti", corsisti);
		model.addAttribute("corsi", corsi);
		model.addAttribute("partecipazioni", partecipazioni);
		return "ricercaPartecipazione";
	}

	@GetMapping(path = "/modificaPartecipazione")
	public String assegnaPartecipazioneMod(Model model, @ModelAttribute Partecipazione p) {
		List<Corsista> corsisti = partecipazioneService.elencoCorsisti();
		List<Corso> corsi = partecipazioneService.elencoCorsi();
		List<Partecipazione> partecipazioni = partecipazioneService.elencoPartecipazioni();

		model.addAttribute("corsisti", corsisti);
		model.addAttribute("corsi", corsi);
		model.addAttribute("partecipazioni", partecipazioni);
		return "modificaPartecipazione";
	}

	@GetMapping(path = "/cancellaPartecipazione")
	public String assegnaPartecipazioneCanc(Model model, @ModelAttribute Partecipazione p) {
		List<Partecipazione> partecipazioni = partecipazioneService.elencoPartecipazioni();

		model.addAttribute("partecipazioni", partecipazioni);
		return "cancellaPartecipazione";
	}

	@PostMapping(path = "/assegn_corso")
	public String assegnazione(Model model, @ModelAttribute Partecipazione partecipazione) {
		if (partecipazione.getCorso() != null) {
			int idCorso = partecipazione.getCorso().getId_corso();
			Optional<Corso> corsoOptional = corsoRepository.findById(idCorso);
			if (corsoOptional.isPresent()) {
				Corso corso = corsoOptional.get();
				partecipazione.setCorso(corso);
				String message = "Hai assegnato correttamente il corso al corsista";
				model.addAttribute("message", message);
			} else {
				String message = "Nessun corso trovato con l'ID: " + idCorso;
				model.addAttribute("errorMessage", message);
			}
		} else {
			String message = "Nessun corso selezionato per la partecipazione.";
			model.addAttribute("message", message);
		}
		return "result";
	}


	@GetMapping("/ricercaPartecipazione")
	public String getPartecipazioneByNIscrizione(@ModelAttribute("nIscrizione") int nIscrizione, Model model) {

		String message;
		Partecipazione partecipazione = partecipazioneService.getPartecipazioneBynIscrizione(nIscrizione);
		if (partecipazione != null) {
			message = "La partecipazione trovata ha ID: " + partecipazione.getnIscrizione() + " CF Corsista: "
					+ partecipazione.getCorsista() + " Corso: " + partecipazione.getCorso();
		} else {
			message = "Nessuna partecipazione trovata con ID: " + nIscrizione;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@PostMapping("/modificaPartecipazioni")
    public String modificaPartecipazioni(Model model,
    		@RequestParam("nIscrizione") int idInsegnamento, 
    		@ModelAttribute("partecipazione") Partecipazione partecipazione,
    		@RequestParam("corsi") int idCorso) {
		
        String message;
        Optional<Corso> corsoOptional = corsoRepository.findById(idCorso);
        Partecipazione partecipazioneEsistente = partecipazioneService.getPartecipazioneBynIscrizione(idInsegnamento);
        if (partecipazioneEsistente != null) {
        	Corso corso = corsoOptional.get();
			partecipazioneEsistente.setCorso(corso);
            partecipazioneEsistente.setSaldato(partecipazione.isSaldato());
            
            partecipazioneService.assegnCors(partecipazioneEsistente);
            message = "La partecipazione è stata modificata";
        } else {
            message = "Nessuna partecipazione trovata con ID: " + idInsegnamento;
        }
        model.addAttribute("message", message);
        return "result";
    }

	@PostMapping("/eliminapartecipazione")
	public String deletePartecipazione(Model model, @ModelAttribute("nIscrizione") int nIscrizione) {

		String message;

		Partecipazione partecipazione = partecipazioneService.getPartecipazioneBynIscrizione(nIscrizione);
		if (partecipazione != null) {
			partecipazioneService.deletePartecipazione(nIscrizione);
			message = "La partecipazione è stata eliminata";
		} else {
			message = "Nessuna partecipazione trovata con ID: " + nIscrizione;
		}
		model.addAttribute("message", message);
		return "result";
	}

	@GetMapping(path = "/stampaPartecipazioni")
	public String stampaPartecipazioni(Model model, @ModelAttribute Partecipazione p) {
		List<Partecipazione> partecipazioni = partecipazioneService.elencoPartecipazioni();
		model.addAttribute("partecipazioni", partecipazioni);
		return "listaPartecipazioni";
	}
}