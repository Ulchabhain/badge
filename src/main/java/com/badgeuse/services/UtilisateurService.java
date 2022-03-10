package com.badgeuse.services;

import com.badgeuse.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     * Save an Utilisateur
     */
    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    /**
     * Get an Utilisateur by it's id
     */
    UtilisateurDto getUtilisateurById(Long utilisateurId);

    /**
     * Delete an Utilisateur by it's id
     */
    boolean deleteUtilisateur(Long utilisateurId);

    /**
     * Get all the Utilisateurs
     */
    List<UtilisateurDto> getAllUtilisateurs();
}