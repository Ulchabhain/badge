package com.badgeuse.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Composante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPOSANTE_ID", nullable = false)
    private Long Id;
    @Column(name = "COMPOSANTE_NOM", nullable = false)
    private String nomComposante;

    @OneToMany(mappedBy = "composanteRes")
    private List<Responsable> responsablesCom;

    @OneToMany(mappedBy = "composanteFil")
    private List<FiliereLangue> filiereLanguesCom;
}
