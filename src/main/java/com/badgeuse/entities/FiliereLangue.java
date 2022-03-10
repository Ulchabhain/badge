package com.badgeuse.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class FiliereLangue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILIERE_ID", nullable = false)
    private Long Id;
    @Column(name = "FILIERE_CODE", nullable = false)
    private int codeFiliereLangue;
    @Column(name = "FILIERE_NOM", nullable = false)
    private String nomFiliereLangue;

    @ManyToOne
    @JoinColumn(name = "COMPOSANTE_ID", nullable = false)
    private Composante composanteFil;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "FILIERE_LANGUE_COURS",
            joinColumns = @JoinColumn(referencedColumnName = "FILIERE_ID"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "COURS_ID")
    )
    private List<Cours> coursFil;
}
