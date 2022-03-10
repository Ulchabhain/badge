package com.badgeuse.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURS_ID", nullable = false)
    private Long Id;
    @Column(name = "COURS_INTITULE", nullable = false)
    private String intitule;

    @OneToMany(mappedBy = "coursVac")
    private List<Utilisateur> vacatairesCou;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "FILIERE_LANGUE_COURS",
            joinColumns = @JoinColumn(referencedColumnName = "COURS_ID"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "FILIERE_ID")
    )
    private List<FiliereLangue> filiereLanguesCou;

    @OneToMany(mappedBy = "coursCre")
    private List<Creneau> creneauxCou;
}
