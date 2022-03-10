package com.badgeuse.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SeanceFormation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEANCE_ID", nullable = false)
    private Long Id;
    @Column(name = "SEANCE_EST_EFFECTUE", nullable = false)
    private Boolean estEffectue;
    @Column(name = "SEANCE_DUREE", nullable = false)
    private double dureeEffective;
    @Column(name = "SEANCE_VALIDE", nullable = false)
    private Boolean estValide;
    @Column(name = "SEANCE_COMMENTAIRE", nullable = false)
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "CRENEAU_ID", nullable = false)
    private Creneau creneauSea;

    @ManyToOne
    @JoinColumn(name = "VACATAIRE_ID", nullable = false)
    private Utilisateur vacataireSea;
}
