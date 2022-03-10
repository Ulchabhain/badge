package com.badgeuse.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UTILISATEUR_ID", nullable = false)
    private Long Id;

    @Column(name = "UTILISATEUR_TYPE", nullable = false)
    private TypeUtilisateur type;

    @Column(name = "UTILISATEUR_LOGIN", nullable = false)
    private String login;
    @Column(name = "UTILISATEUR_MDP", nullable = false)
    private String motDePasse;
    @Column(name = "UTILISATEUR_NOM", nullable = false)
    private String nom;
    @Column(name = "UTILISATEUR_PRENOM", nullable = false)
    private String prenom;
    @Column(name = "UTILISATEUR_MAIL", nullable = false)
    private String mail;

    //si l'utilisateur est un vacataire
    @ManyToOne
    @JoinColumn(name = "COURS_ID", nullable = true)
    private Cours coursVac;
    @OneToMany(mappedBy = "vacataireSea")
    private List<SeanceFormation> seancesVac;

    //si l'utilisateur est un responsable
    @ManyToOne
    @JoinColumn(name = "COMPOSANTE_ID", nullable = true)
    private Composante composanteRes;
}
