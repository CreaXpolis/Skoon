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
@Table(name="Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String administrateur;

    private String nettoyeur;

    private String preteur;

    @OneToMany(mappedBy="role")
    private Set<Participant> participant;

    public Role() {

    }
}
