package fr.aurele.skoon2.service;

import fr.aurele.skoon2.model.Participant;
import fr.aurele.skoon2.repository.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ParticipantServiceImpl implements ParticipantService{
    @Autowired
    private ParticipantRepo participantRepo;

    @Override
    public Participant ajouterParticipant(Participant participant) {
        Participant participantAjouter = participantRepo.save(participant);
        return participantAjouter;
    }

    @Override
    public Participant retrouverParPseudo(String pseudo) {
        return participantRepo.findParticipantByPseudo(pseudo);
    }

    @Override
    public Participant retrouverParActivites(String activites) {
        return participantRepo.findParticipantByActivites(activites);
    }
}
