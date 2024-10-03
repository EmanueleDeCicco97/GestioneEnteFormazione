package com.emanuele.gestioneEnte.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Corso {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_corso;

	@Column
	private String tipologia;

	@Column
	private String data_inizio;

	@Column
	private String data_fine;

	@Column
	private double prezzo;

	@Column
	private int n_rate;

	@OneToMany(mappedBy = "corso")
	private List<Insegna> insegna;

	@OneToMany(mappedBy = "corso")
	private List<Partecipazione> partecipazione;

	public int getId_corso() {
		return id_corso;
	}

	public void setId_corso(int id_corso) {
		this.id_corso = id_corso;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(String data_inizio) {
		this.data_inizio = data_inizio;
	}

	public String getData_fine() {
		return data_fine;
	}

	public void setData_fine(String data_fine) {
		this.data_fine = data_fine;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getN_rate() {
		return n_rate;
	}

	public void setN_rate(int n_rate) {
		this.n_rate = n_rate;
	}

	@Override
	public String toString() {
		return "" + getId_corso();
	}
}
