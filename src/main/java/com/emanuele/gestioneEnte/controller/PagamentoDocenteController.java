package com.emanuele.gestioneEnte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emanuele.gestioneEnte.model.PagamentoDocente;

import com.emanuele.gestioneEnte.service.PagamentoDocenteService;

@Controller
public class PagamentoDocenteController {

	@Autowired
	private PagamentoDocenteService pagamentoDocenteService;

	@PostMapping(path = "/insertPagamentoDocente")
	public String insertPagamentoDocente(@ModelAttribute PagamentoDocente pagamentoDocente) {

		pagamentoDocenteService.inserimentoPagamentoDocente(pagamentoDocente);

		return "result";
	}
}
