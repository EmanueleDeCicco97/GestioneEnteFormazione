package com.emanuele.gestioneEnte.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.emanuele.gestioneEnte.model.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Integer> {

}
