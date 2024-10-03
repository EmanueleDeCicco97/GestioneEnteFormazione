package com.emanuele.gestioneEnte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Rata {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rata;
	@Column
	private double importo;
	@Column
	private String data_versamento;
	
	@JoinColumn(name = "n_iscrizione")
	@ManyToOne(fetch = FetchType.EAGER)
	private Partecipazione partecipazione;
	

	public int getId_rata() {
		return id_rata;
	}

	public void setId_rata(int id_rata) {
		this.id_rata = id_rata;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getData_versamento() {
		return data_versamento;
	}

	public void setData_versamento(String data_versamento) {
		this.data_versamento = data_versamento;
	}

	public Partecipazione getPartecipazione() {
		return partecipazione;
	}

	public void setPartecipazione(Partecipazione partecipazione) {
		this.partecipazione = partecipazione;
	}

}
