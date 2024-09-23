package com.emanuele.gestionerf.repository;

import com.emanuele.gestionerf.model.Partecipazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartecipazioneRepository extends JpaRepository<Partecipazione, Integer> {
	Partecipazione findBynIscrizione(int nIscrizione);
}