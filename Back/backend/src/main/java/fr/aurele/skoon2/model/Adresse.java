package fr.aurele.skoon2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String ville;

    private String rue;

    private int code_postal;

    private String geolocalisation;

    @OneToMany(mappedBy="adresse")
    private Set<Skooner> skooner;

    @OneToOne(mappedBy = "adresse")
    private Evenement evenement;


    public Adresse() {

    }
}
