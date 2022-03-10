package com.badgeuse.dtos;

import com.badgeuse.entities.TypeCours;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreneauDto {
    private Long Id;
    private Date date_heure;
    private double duree;
    private TypeCours type;

    private Long cours;
    private List<Long> seances;
}
