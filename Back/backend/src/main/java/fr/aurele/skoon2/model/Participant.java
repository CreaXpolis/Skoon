package fr.aurele.skoon2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="Participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pseudo;

    private String activites;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="evenement_id", nullable=false)
    private Evenement evenement;

    public Participant() {

    }
}
