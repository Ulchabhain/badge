package com.badgeuse.controllers;

import com.badgeuse.dtos.SeanceFormationDto;
import com.badgeuse.dtos.UtilisateurDto;
import com.badgeuse.entities.SeanceFormation;
import com.badgeuse.services.SeanceFormationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceFormationController {
    @Autowired
    public SeanceFormationServiceImpl seanceService;

    /**
     * <p>Get all seances in the system</p>
     * @return List<SeanceFormationDto>
     */
    @GetMapping
    public List<SeanceFormationDto> getSeances() {
        return seanceService.getAllSeances();
    }

    /**
     * Method to get the seance based on the ID
     */
    @GetMapping("/{id}")
    public SeanceFormationDto getUtilisateur(@PathVariable Long id){
        return seanceService.getSeanceById(id);
    }

    /**
     * Create a new seance in the system
     */
    @PostMapping
    public SeanceFormationDto saveSeance(final @RequestBody SeanceFormationDto seanceDto){
        return seanceService.saveSeance(seanceDto);
    }

    /**
     * Delete an seance by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSeance(@PathVariable Long id){
        return seanceService.deleteSeance(id);
    }
}
