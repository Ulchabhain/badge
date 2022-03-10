package com.badgeuse.services;

import com.badgeuse.dtos.SeanceFormationDto;
import com.badgeuse.entities.SeanceFormation;

import java.util.List;

public interface SeanceFormationService {
    /**
     * Save a seance
     */
    SeanceFormationDto saveSeance(SeanceFormationDto seanceFormationDto);

    /**
     * Get a seance by it's id
     */
    SeanceFormationDto getSeanceById(Long seanceFormationId);

    /**
     * Delete a seance by it's id
     */
    boolean deleteSeance(Long seanceId);

    /**
     * Get all the seance
     */
    List<SeanceFormationDto> getAllSeances();
}
