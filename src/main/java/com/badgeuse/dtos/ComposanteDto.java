package com.badgeuse.dtos;

import com.badgeuse.entities.FiliereLangue;
import lombok.Data;

import java.util.List;

@Data
public class ComposanteDto {
    private Long Id;
    private String nomComposante;
    private List<Long> responsablesId;
    private List<Long> filiereLanguesId;
}