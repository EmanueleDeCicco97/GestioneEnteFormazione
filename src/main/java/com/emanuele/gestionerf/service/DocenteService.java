package com.emanuele.gestionerf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestionerf.model.Docente;
import com.emanuele.gestionerf.repository.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;

	public Docente inserimentoDocente(Docente docente) {
		return docenteRepository.save(docente);
	}

	public Docente cercaDocente(String cf) {
		Optional<Docente> optionalDocente = docenteRepository.findById(cf);
		return optionalDocente.orElse(null);
	}

	public Docente modificaDocente(Docente docente) {
		return docenteRepository.save(docente);
	}

	public void eliminaDocente(String cf) {
		docenteRepository.deleteById(cf);
	}

	public List<Docente> stampaTuttiDocenti() {
		return docenteRepository.findAll();
	}
}
