package com.badgeuse.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Vacataire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VACATAIRE_ID", nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "COURS_ID", nullable = true)
    private Cours coursVac;

    @OneToMany(mappedBy = "vacataireSea")
    private List<SeanceFormation> seancesVac;
}
