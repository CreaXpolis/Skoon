package fr.aurele.skoon2.service;

import fr.aurele.skoon2.model.Adresse;
import fr.aurele.skoon2.repository.AdresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdresseServiceImpl implements AdresseService{

    @Autowired
    private AdresseRepo adresseRepo;

    @Override
    public Adresse retrouverParVille(String ville) {
        return adresseRepo.findAdresseByVille(ville);
    }

    @Override
    public Adresse retrouverParRue(String rue) {
        return adresseRepo.findAdresseByRue(rue);
    }

    @Override
    public Adresse retrouverParCodePostal (int code_postal) {
        return adresseRepo.findAdresseByCode_postal(code_postal);
    }

    @Override
    public Adresse retrouverParGeolocalisation(String geolocalisation) {
        return adresseRepo.findAdresseByGeolocalisation(geolocalisation);
    }
}
