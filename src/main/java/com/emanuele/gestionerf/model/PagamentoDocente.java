package com.emanuele.gestionerf.model;

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
@Table(name = "pagamento_docente")
public class PagamentoDocente {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pagamento;
	@Column
	private Double importo;
	@Column
	private String data_pagamento;

	@JoinColumn(name = "id_insegnamento")
	@ManyToOne(fetch = FetchType.EAGER)
	private Insegna insegna;

	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public Insegna getInsegna() {
		return insegna;
	}

	public void setInsegna(Insegna insegna) {
		this.insegna = insegna;
	}

}
