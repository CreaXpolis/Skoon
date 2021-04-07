package fr.aurele.skoon2.repository;

import fr.aurele.skoon2.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {
    Participant findParticipantByPseudo(String pseudo);
    Participant findParticipantByActivites(String activites);
}
