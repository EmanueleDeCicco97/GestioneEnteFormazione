package com.emanuele.gestionerf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestionerf.model.PagamentoDocente;
import com.emanuele.gestionerf.repository.PagamentoDocenteRepository;

@Service
public class PagamentoDocenteService {

	@Autowired
	private PagamentoDocenteRepository pagamentoDocenteRepository;

	public PagamentoDocente inserimentoPagamentoDocente(PagamentoDocente pagamentoDocente) {
		
		
		
		return pagamentoDocenteRepository.save(pagamentoDocente);

	}
	
}
