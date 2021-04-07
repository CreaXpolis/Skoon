package fr.aurele.skoon2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "skooner")
public class Skooner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    private int age;

    private String mail;

    @ManyToOne
    @JoinColumn(name="adresse_id", nullable=false)
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="participant_id", nullable=false)
    private Participant participant;

    public Skooner() {}

}
