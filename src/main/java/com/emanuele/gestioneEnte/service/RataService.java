package com.emanuele.gestioneEnte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emanuele.gestioneEnte.model.Rata;
import com.emanuele.gestioneEnte.repository.RataRepository;

@Service
public class RataService {

	@Autowired
	private RataRepository rataRepository;

	public Rata inserimentoRata(Rata rata) {

		return rataRepository.save(rata);

	}
}