package fr.aurele.skoon2.controller;

import fr.aurele.skoon2.model.Adresse;
import fr.aurele.skoon2.repository.AdresseRepo;
import fr.aurele.skoon2.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @GetMapping("/ville/{ville}")
    public Adresse retrouverAdresseParVille(@PathVariable(value = "ville") String ville) {
        return adresseService.retrouverParVille(ville);
    }

    @GetMapping("/rue/{rue}")
    public Adresse retrouverAdresseParRue(@PathVariable(value = "rue") String rue) {
        return adresseService.retrouverParRue(rue);
    }

    @GetMapping("/code_postal/{code_postal}")
    public Adresse retrouverAdresseParCodePostal(@PathVariable(value = "code_postal") int code_postal) {
        return adresseService.retrouverParCodePostal(code_postal);
    }

    @GetMapping("/geolocalisation/{geolocalisation}")
    public Adresse retrouverAdresseParGeolocalisation(@PathVariable(value = "geolocalisation") String geolocalisation) {
        return adresseService.retrouverParGeolocalisation(geolocalisation);
    }
}

