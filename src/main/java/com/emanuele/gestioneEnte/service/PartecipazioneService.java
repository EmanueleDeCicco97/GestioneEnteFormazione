package com.emanuele.gestioneEnte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuele.gestioneEnte.model.Corsista;
import com.emanuele.gestioneEnte.model.Corso;
import com.emanuele.gestioneEnte.model.Partecipazione;
import com.emanuele.gestioneEnte.repository.CorsistaRepository;
import com.emanuele.gestioneEnte.repository.CorsoRepository;
import com.emanuele.gestioneEnte.repository.PartecipazioneRepository;

@Service
public class PartecipazioneService {

    @Autowired
    private PartecipazioneRepository partecipazioneRepository;

    @Autowired
    private CorsistaRepository corsistaRepository;

    @Autowired
    private CorsoRepository corsoRepository;

    public List<Corsista> elencoCorsisti() {
        return corsistaRepository.findAll();
    }

    public List<Corso> elencoCorsi() {
        return corsoRepository.findAll();
    }

    public List<Partecipazione> elencoPartecipazioni() {
        return partecipazioneRepository.findAll();
    }

    public Partecipazione assegnCors(Partecipazione p) {
        return partecipazioneRepository.save(p);
    }

    public Partecipazione getPartecipazioneBynIscrizione(int nIscrizione) {
        return partecipazioneRepository.findBynIscrizione(nIscrizione);
    }

    public void updatePartecipazione(Partecipazione updatedPartecipazione) {
        partecipazioneRepository.save(updatedPartecipazione);
    }

    public void deletePartecipazione(int nIscrizione) {
        Partecipazione partecipazione = partecipazioneRepository.findBynIscrizione(nIscrizione);
        if (partecipazione != null) {
            partecipazioneRepository.delete(partecipazione);
        }
    }
}
