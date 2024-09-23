package com.emanuele.gestionerf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emanuele.gestionerf.model.Rata;
import com.emanuele.gestionerf.repository.RataRepository;

@Service
public class RataService {

	@Autowired
	private RataRepository rataRepository;

	public Rata inserimentoRata(Rata rata) {

		return rataRepository.save(rata);

	}
}