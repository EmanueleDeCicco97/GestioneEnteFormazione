package com.emanuele.gestioneEnte.repository;

import com.emanuele.gestioneEnte.model.Partecipazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartecipazioneRepository extends JpaRepository<Partecipazione, Integer> {
	Partecipazione findBynIscrizione(int nIscrizione);
}