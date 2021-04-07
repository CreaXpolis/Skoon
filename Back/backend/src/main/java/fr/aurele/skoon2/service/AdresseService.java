package fr.aurele.skoon2.service;

import fr.aurele.skoon2.model.Adresse;
import org.springframework.stereotype.Service;


public interface AdresseService {
    Adresse retrouverParVille(String ville);
    Adresse retrouverParRue(String rue);
    Adresse retrouverParCodePostal(int code_postal);
    Adresse retrouverParGeolocalisation(String geolocalisation);

    }
