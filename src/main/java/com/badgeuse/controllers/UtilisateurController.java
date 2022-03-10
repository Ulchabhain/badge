package com.badgeuse.controllers;

import com.badgeuse.dtos.UtilisateurDto;
import com.badgeuse.services.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    @Autowired
    public UtilisateurServiceImpl utilisateurService;


    /**
     * <p>Get all utilisateurs in the system</p>
     * @return List<UtilisateurDto>
     */
    @GetMapping
    public List<UtilisateurDto> getUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    /**
     * Method to get the utilisateur based on the ID
     */
    @GetMapping("/{id}")
    public UtilisateurDto getUtilisateur(@PathVariable Long id){
        return utilisateurService.getUtilisateurById(id);
    }

    /**
     * Create a new utilisateur in the system
     */
    @PostMapping
    public UtilisateurDto saveUtilisateur(final @RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.saveUtilisateur(utilisateurDto);
    }

    /**
     * Delete an utilisateur by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteUtilisateur(@PathVariable Long id){
        return utilisateurService.deleteUtilisateur(id);
    }
}
