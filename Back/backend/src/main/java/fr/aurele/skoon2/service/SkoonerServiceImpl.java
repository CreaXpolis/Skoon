package fr.aurele.skoon2.service;

import fr.aurele.skoon2.model.Skooner;
import fr.aurele.skoon2.repository.SkoonerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkoonerServiceImpl implements SkoonerService{
    @Autowired
    private SkoonerRepo skoonerRepo;

    @Override
    public Skooner ajouterSkooner(Skooner skooner) {
        Skooner skoonerAjouter = skoonerRepo.save(skooner);
        return skoonerAjouter;
    }

    @Override
    public Skooner retrouverParNom(String nom) {
        return skoonerRepo.findSkoonerByNom(nom) ;
    }

    @Override
    public Skooner retrouverParPrenom(String prenom) {
        return skoonerRepo.findSkoonerByPrenom(prenom) ;
    }

    @Override
    public Skooner retrouverParAge(int age) {
        return skoonerRepo.findSkoonerByAge(age) ;
    }

    @Override
    public Skooner retrouverParMail(String mail) {
        return skoonerRepo.findSkoonerByMail(mail) ;
    }
}
