package com.badgeuse.controllers;

import com.badgeuse.dtos.CreneauDto;
import com.badgeuse.entities.Creneau;
import com.badgeuse.services.CreneauServiceImpl;
import com.badgeuse.services.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creneaux")
public class CreneauController {
    @Autowired
    public CreneauServiceImpl creneauService;

    /**
     * <p>Get all creneaux in the system</p>
     * @return List<CreneauDto>
     */
    @GetMapping
    public List<CreneauDto> getCreneaux() {
        return creneauService.getAllCreneaux();
    }

    /**
     * Method to get the creneau based on the ID
     */
    @GetMapping("/{id}")
    public CreneauDto getCreneau(@PathVariable Long id){
        return creneauService.getCreneauById(id);
    }

    /**
     * Create a new creneau in the system
     */
    @PostMapping
    public CreneauDto saveCreneau(final @RequestBody CreneauDto creneauDto){
        return creneauService.saveCreneau(creneauDto);
    }

    /**
     * Delete a creneau by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCreneau(@PathVariable Long id){
        return creneauService.deleteCreneau(id);
    }

}