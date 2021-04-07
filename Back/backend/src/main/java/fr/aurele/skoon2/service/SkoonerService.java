package fr.aurele.skoon2.service;

import fr.aurele.skoon2.model.Skooner;
import org.springframework.stereotype.Service;

@Service
public interface SkoonerService {

    Skooner ajouterSkooner(Skooner skooner);
    Skooner retrouverParNom(String nom);
    Skooner retrouverParPrenom(String prenom);
    Skooner retrouverParAge(int age);
    Skooner retrouverParMail(String mail);
}
