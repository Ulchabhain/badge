package com.badgeuse.services;

import com.badgeuse.dtos.ComposanteDto;

import java.util.List;

public interface ComposanteService {
    /**
     * Save a Composante
     */
    ComposanteDto saveComposante(ComposanteDto composanteDto);

    /**
     * Get a Composante by it's id
     */
    ComposanteDto getComposanteById(Long composanteId);

    /**
     * Delete a Composante by it's id
     */
    boolean deleteComposante(Long composanteId);

    /**
     * Get all the creneaux
     */
    List<ComposanteDto> getAllComposante();
}
