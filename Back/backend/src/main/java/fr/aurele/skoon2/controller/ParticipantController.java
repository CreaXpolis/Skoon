package fr.aurele.skoon2.controller;

import fr.aurele.skoon2.model.Participant;
import fr.aurele.skoon2.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping("/ajouterParticipant")
    @ResponseBody
    public String addParticipant(@RequestBody Participant participant) {
        participantService.ajouterParticipant(participant);
        return "OK";
    }

    @GetMapping("/pseudo/{pseudo}")
    public Participant retrouverParticipantParPseudo(@PathVariable(value = "pseudo") String pseudo) {
        return participantService.retrouverParPseudo(pseudo);
    }

    @GetMapping("/activites/{activites}")
    public Participant retrouverParticipantParActivites(@PathVariable(value = "activites") String activites) {
        return participantService.retrouverParActivites(activites);
    }

}
