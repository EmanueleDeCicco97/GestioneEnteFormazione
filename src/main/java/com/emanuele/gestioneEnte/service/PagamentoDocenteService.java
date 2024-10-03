package com.emanuele.gestioneEnte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestioneEnte.model.PagamentoDocente;
import com.emanuele.gestioneEnte.repository.PagamentoDocenteRepository;

@Service
public class PagamentoDocenteService {

	@Autowired
	private PagamentoDocenteRepository pagamentoDocenteRepository;

	public PagamentoDocente inserimentoPagamentoDocente(PagamentoDocente pagamentoDocente) {
		
		
		
		return pagamentoDocenteRepository.save(pagamentoDocente);

	}
	
}
