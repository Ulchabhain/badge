package com.badgeuse.services;

import com.badgeuse.dtos.CoursDto;

import java.util.List;

public interface CoursService {
    /**
     * Save a Cours
     */
    CoursDto saveCours(CoursDto coursDto);

    /**
     * Get a cours by it's id
     */
    CoursDto getCoursById(Long courId);

    /**
     * Delete a cours by it's id
     */
    boolean deleteCours(Long courId);

    /**
     * Get all the Cours
     */
    List<CoursDto> getAllCours();
}
