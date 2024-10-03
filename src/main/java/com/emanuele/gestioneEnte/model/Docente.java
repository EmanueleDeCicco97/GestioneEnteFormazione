package com.emanuele.gestioneEnte.model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Docente {
	
	@Column
	private String nome_docente;
	@Column
	private String cognome_docente;
	@Id
	@Column
	private String cf_docente;
	
	@OneToMany(mappedBy = "docente")
	private List<Insegna> insegna;
	
	
	public String getNome_docente() {
		return nome_docente;
	}
	public void setNome_docente(String nome_docente) {
		this.nome_docente = nome_docente;
	}
	public String getCognome_docente() {
		return cognome_docente;
	}
	public void setCognome_docente(String cognome_docente) {
		this.cognome_docente = cognome_docente;
	}
	public String getCf_docente() {
		return cf_docente;
	}
	public void setCf_docente(String cf_docente) {
		this.cf_docente = cf_docente;
	}
	@Override
	public String toString() {
		return  cf_docente ;
	}
	
}
