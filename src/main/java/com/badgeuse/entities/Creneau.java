package com.badgeuse.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Creneau {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRENEAU_ID", nullable = false)
    private Long Id;

    @Column(name = "CRENEAU_DATE", nullable = false)
    private Date date_heure;
    @Column(name = "CRENEAU_DUREE", nullable = false)
    private double duree;
    @Column(name = "CRENEAU_TYPE", nullable = false)
    private TypeCours type;

    @ManyToOne
    @JoinColumn(name = "COURS_ID", nullable = false)
    private Cours coursCre;

    @OneToMany(mappedBy = "creneauSea")
    private List<SeanceFormation> seancesCre;
}
