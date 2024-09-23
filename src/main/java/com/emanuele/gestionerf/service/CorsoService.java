package com.emanuele.gestionerf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestionerf.model.Corso;
import com.emanuele.gestionerf.repository.CorsoRepository;

@Service
public class CorsoService {

	@Autowired
	private CorsoRepository corsoRepository;

	public Corso inserimentoCorso(Corso corso) {
		return corsoRepository.save(corso);
	}
	 public List<Corso> elencoCorsi() {
	        return corsoRepository.findAll();
	    }

	public Corso cercaCorso(int idCorso) {
		Optional<Corso> optionalCorso = corsoRepository.findById(idCorso);
		return optionalCorso.orElse(null);
	}

	public Corso modificaCorso(Corso corso) {
		return corsoRepository.save(corso);
	}

	public void eliminaCorso(int idCorso) {
		corsoRepository.deleteById(idCorso);
	}

	public List<Corso> stampaTuttiCorsi() {
		return corsoRepository.findAll();
	}
}
