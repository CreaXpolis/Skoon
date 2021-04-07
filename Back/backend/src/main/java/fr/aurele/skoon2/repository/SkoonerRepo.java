package fr.aurele.skoon2.repository;

import fr.aurele.skoon2.model.Skooner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkoonerRepo extends JpaRepository<Skooner, Integer> {
    Skooner findSkoonerByNom(String nom);
    Skooner findSkoonerByPrenom(String prenom);
    Skooner findSkoonerByAge(int age);
    Skooner findSkoonerByMail(String mail);
}
