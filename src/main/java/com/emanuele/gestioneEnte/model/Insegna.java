package com.emanuele.gestioneEnte.model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Insegna {
	
	@JoinColumn(name="cf_docente")
	@ManyToOne(fetch = FetchType.EAGER)
	private Docente docente;
	
	@JoinColumn(name="id_corso")
	@ManyToOne(fetch = FetchType.EAGER)
	private Corso corso;

	@OneToMany(mappedBy = "insegna")
	private List<PagamentoDocente> pagamentoDocente;
	
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_insegnamento;
	
	@Column
	private Double prezzo_docente;
	
	@Column
	private Boolean pagato=false;
	
	
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	
	public int getId_insegnamento() {
		return id_insegnamento;
	}
	public void setId_insegnamento(int id_insegnamento) {
		this.id_insegnamento = id_insegnamento;
	}
	public Double getPrezzo_docente() {
		return prezzo_docente;
	}
	public void setPrezzo_docente(Double prezzo_docente) {
		this.prezzo_docente = prezzo_docente;
	}
	public Boolean getPagato() {
		return pagato;
	}
	public void setPagato(Boolean pagato) {
		this.pagato = pagato;
	}
}
