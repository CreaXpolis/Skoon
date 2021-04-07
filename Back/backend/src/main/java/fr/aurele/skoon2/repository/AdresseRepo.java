package fr.aurele.skoon2.repository;

import fr.aurele.skoon2.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Integer> {
    Adresse findAdresseByVille(String ville);
    Adresse findAdresseByRue(String rue);
    Adresse findAdresseByCode_postal(int code_postal);
    Adresse findAdresseByGeolocalisation(String geolocalisation);
}
