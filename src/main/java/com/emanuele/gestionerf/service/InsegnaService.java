package com.emanuele.gestionerf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestionerf.model.Insegna;
import com.emanuele.gestionerf.repository.InsegnaRepository;

@Service
public class InsegnaService {

	@Autowired
	private InsegnaRepository insegnaRepository;

	public Insegna inserimentoInsegna(Insegna insegna) {
		return insegnaRepository.save(insegna);
	}

	public Insegna cercaInsegna(int idInsegnamento) {
		Optional<Insegna> optionalInsegna = insegnaRepository.findById(idInsegnamento);
		return optionalInsegna.orElse(null);
	}

	public Insegna modificaInsegna(Insegna insegna) {
		return insegnaRepository.save(insegna);
	}

	public void eliminaInsegna(int idInsegnamento) {
		insegnaRepository.deleteById(idInsegnamento);
	}

	public List<Insegna> stampaTuttiInsegnamenti() {
		return insegnaRepository.findAll();
	}
}
