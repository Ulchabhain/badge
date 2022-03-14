package com.badgeuse.services;

import com.badgeuse.dtos.FiliereLangueDto;

import java.util.List;

public interface FiliereLangueService {

    /**
     * Save a filiereLangue
     */
    FiliereLangueDto saveFiliereLangue(FiliereLangueDto filiereLangueDto);

    /**
     * get a filiereLangue by it's id
     */
    FiliereLangueDto getFiliereLangueById(Long filiereLangueId);

    /**
     * Delete a filiereLangue by it's id
     */
    boolean deleteFiliereLangue(Long filiereLangueId);

    /**
     * Get all the filiereLangue
     */
    List<FiliereLangueDto> getAllFiliereLangue();
}
