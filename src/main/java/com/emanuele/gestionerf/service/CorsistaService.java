package com.emanuele.gestionerf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestionerf.model.Corsista;
import com.emanuele.gestionerf.repository.CorsistaRepository;

@Service
public class CorsistaService {

	@Autowired
	private CorsistaRepository corsistaRepository;

	public Corsista inserimentoCorsista(Corsista corsista) {
		return corsistaRepository.save(corsista);
	}

	public Corsista cercaCorsista(String cf) {
		Optional<Corsista> optionalCorsista = corsistaRepository.findById(cf);
		return optionalCorsista.orElse(null);
	}

	public Corsista modificaCorsista(Corsista corsista) {
		return corsistaRepository.save(corsista);
	}

	public void eliminaCorsista(String cf) {
		corsistaRepository.deleteById(cf);
	}

	public List<Corsista> stampaTuttiCorsisti() {
		return corsistaRepository.findAll();
	}
}
