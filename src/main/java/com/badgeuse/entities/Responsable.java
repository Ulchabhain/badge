package com.badgeuse.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Responsable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESPONSABLE_ID", nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "COMPOSANTE_ID", nullable = false)
    private Composante composanteRes;
}
