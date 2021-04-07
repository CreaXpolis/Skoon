package fr.aurele.skoon2.repository;

import fr.aurele.skoon2.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EvenementRepo extends JpaRepository<Evenement, Integer> {
}
