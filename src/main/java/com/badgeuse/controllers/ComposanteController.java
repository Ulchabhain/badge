package com.badgeuse.controllers;

import com.badgeuse.dtos.ComposanteDto;
import com.badgeuse.services.ComposanteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composante")
public class ComposanteController {

    private final ComposanteServiceImpl composanteService;

    public ComposanteController(ComposanteServiceImpl composanteService) { this.composanteService = composanteService; }

    /**
     * <p>Get all composantes in the system</p>
     * @return List<ComposanteDto>
     */
    @GetMapping
    public List<ComposanteDto> getComposante() {
        return composanteService.getAllComposante();
    }

    /**
     * Method to get the composante based on the ID
     */
    @GetMapping("/{id}")
    public ComposanteDto getComposante(@PathVariable Long id){
        return composanteService.getComposanteById(id);
    }

    /**
     * Create a new Composante in the system
     */
    @PostMapping
    public ComposanteDto saveComposante(final @RequestBody ComposanteDto composanteDto){
        return composanteService.saveComposante(composanteDto);
    }

    /**
     * Delete a composante by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteComposante(@PathVariable Long id){
        return composanteService.deleteComposante(id);
    }
}
