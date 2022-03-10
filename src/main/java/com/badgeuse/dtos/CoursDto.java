package com.badgeuse.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CoursDto {
    private Long Id;
    private String intitule;

    private List<Long> vacatairesId;
    private List<Long> creneauxId;
}