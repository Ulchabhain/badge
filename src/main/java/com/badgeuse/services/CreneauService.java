package com.badgeuse.services;


import com.badgeuse.dtos.CreneauDto;

import java.util.List;

public interface CreneauService {
    /**
     * Save a Creneau
     */
    CreneauDto saveCreneau(CreneauDto creneauDto);

    /**
     * Get a creneau by it's id
     */
    CreneauDto getCreneauById(Long creneauId);

    /**
     * Delete a creneau by it's id
     */
    boolean deleteCreneau(Long creneauId);

    /**
     * Get all the creneaux
     */
    List<CreneauDto> getAllCreneaux();
}
