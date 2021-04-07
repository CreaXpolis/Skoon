package fr.aurele.skoon2.controller;

import fr.aurele.skoon2.model.Skooner;
import fr.aurele.skoon2.service.SkoonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

public class SkoonerController {

    @Autowired
    private SkoonerService skoonerService;

    @PostMapping("/ajouterSkooner")
    @ResponseBody
    public String addSkooner(@RequestBody Skooner skooner) {
        skoonerService.ajouterSkooner(skooner);
        return "OK";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Skooner retrouverSkooner(@RequestParam(value="name") String nom) {
        return skoonerService.retrouverParNom(nom);
    }

    @GetMapping("/prenom/{prenom}")
    public Skooner retrouverSkoonerParPrenom(@PathVariable(value = "prenom") String prenom) {
        return skoonerService.retrouverParPrenom(prenom);
    }

    @GetMapping("/age/{age}")
    public Skooner retrouverSkoonerParAge(@PathVariable(value = "age") int age) {
        return skoonerService.retrouverParAge(age);
    }

    @GetMapping("/mail/{mail}")
    public Skooner retrouverSkoonerParMail(@PathVariable(value = "mail") String mail) {
        return skoonerService.retrouverParMail(mail);
    }
}
