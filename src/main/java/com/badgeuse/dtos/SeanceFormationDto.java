package com.badgeuse.dtos;

import com.badgeuse.entities.Creneau;
import com.badgeuse.entities.Vacataire;
import lombok.Data;

@Data
public class SeanceFormationDto {
    private Long Id;
    private Boolean estEffectue;
    private double dureeEffective;
    private Boolean estValide;
    private String commentaire;
    private Long creneauId;
    private Long vacataireId;
}
