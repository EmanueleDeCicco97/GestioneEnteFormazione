package com.emanuele.gestioneEnte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emanuele.gestioneEnte.model.Corsista;

public interface CorsistaRepository extends JpaRepository<Corsista, String> {

    @Query("SELECT c FROM Corsista c WHERE c.cf_corsista = ?1")
    Corsista findByCf_corsista(String cf);
    
}
