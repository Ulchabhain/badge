package com.badgeuse.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Gestionnaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GESTIONNAIRE_ID", nullable = false)
    private Long Id;
}
