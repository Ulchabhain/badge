package com.badgeuse.dtos;

import com.badgeuse.entities.Composante;
import com.badgeuse.entities.Cours;
import lombok.Data;

import java.util.List;

@Data
public class FiliereLangueDto {
    private Long id;
    private int codeFiliereLangue;
    private String nomFiliereLangue;

    private Composante composanteFil;
    private List<Cours> coursFil;
}
