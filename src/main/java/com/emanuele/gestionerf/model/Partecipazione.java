package com.emanuele.gestionerf.model;

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
public class Partecipazione {

	@JoinColumn(name = "cf_corsista")
	@ManyToOne(fetch = FetchType.EAGER)
	private Corsista corsista;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_corso")
	private Corso corso;

	@OneToMany(mappedBy = "partecipazione")
	private List<Rata> rata;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "n_iscrizione")
	private int nIscrizione;

	@Column
	private boolean saldato;

	public Corsista getCorsista() {
		return corsista;
	}

	public void setCorsista(Corsista corsista) {
		this.corsista = corsista;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public List<Rata> getRata() {
		return rata;
	}

	public void setRata(List<Rata> rata) {
		this.rata = rata;
	}

	public int getnIscrizione() {
		return nIscrizione;
	}

	public void setnIscrizione(int nIscrizione) {
		this.nIscrizione = nIscrizione;
	}

	public boolean isSaldato() {
		return saldato;
	}

	public void setSaldato(boolean saldato) {
		this.saldato = saldato;
	}

	@Override
	public String toString() {
		return "Partecipazione corsista=" + corsista + ", corso=" + corso + ", rata=" + rata + ", nIscrizione="
				+ nIscrizione + ", saldato=" + saldato + "";
	}

}