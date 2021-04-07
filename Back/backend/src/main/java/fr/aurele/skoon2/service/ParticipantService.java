package fr.aurele.skoon2.service;

import fr.aurele.skoon2.model.Participant;
import org.springframework.stereotype.Service;

@Service

public interface ParticipantService {
    Participant ajouterParticipant(Participant participant);
    Participant retrouverParPseudo(String pseudo);
    Participant retrouverParActivites(String activites);
}
