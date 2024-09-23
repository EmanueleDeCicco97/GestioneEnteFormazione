package com.emanuele.gestionerf.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Corsista {

	@Column
	private String nome_corsista;
	@Column
	private String cognome_corsista;
	@Id
	@Column
	private String cf_corsista;

	@OneToMany(mappedBy = "corsista")
	private List<Partecipazione> partecipazione;

	public String getNome_corsista() {
		return nome_corsista;
	}

	public void setNome_corsista(String nome_corsista) {
		this.nome_corsista = nome_corsista;
	}

	public String getCognome_corsista() {
		return cognome_corsista;
	}

	public void setCognome_corsista(String cognome_corsista) {
		this.cognome_corsista = cognome_corsista;
	}

	public String getCf_corsista() {
		return cf_corsista;
	}

	public void setCf_corsista(String cf_corsista) {
		this.cf_corsista = cf_corsista;
	}

	@Override
	public String toString() {
		return getCf_corsista();
	}

}
