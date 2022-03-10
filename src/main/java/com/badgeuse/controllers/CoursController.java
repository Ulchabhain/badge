package com.badgeuse.controllers;

import com.badgeuse.dtos.CoursDto;
import com.badgeuse.services.CoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    public CoursServiceImpl coursService;


    /**
     * <p>Get all cours in the system</p>
     * @return List<CoursDto>
     */
    @GetMapping
    public List<CoursDto> getCours() {
        return coursService.getAllCours();
    }

    /**
     * Method to get the cours based on the ID
     */
    @GetMapping("/{id}")
    public CoursDto getCours(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    /**
     * Create a new cours in the system
     */
    @PostMapping
    public CoursDto saveUtilisateur(final @RequestBody CoursDto coursDto){
        return coursService.saveCours(coursDto);
    }

    /**
     * Delete a cours by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCours(@PathVariable Long id){
        return coursService.deleteCours(id);
    }
}
