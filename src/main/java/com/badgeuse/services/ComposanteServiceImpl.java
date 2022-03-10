package com.badgeuse.services;

import com.badgeuse.dtos.ComposanteDto;
import com.badgeuse.dtos.UtilisateurDto;
import com.badgeuse.entities.*;
import com.badgeuse.repositories.ComposanteRepository;
import com.badgeuse.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ComposanteServiceImpl implements ComposanteService {

    private final ComposanteRepository composanteRepository;

    public ComposanteServiceImpl(ComposanteRepository composanteRepository){
        this.composanteRepository = composanteRepository;
    }

    @Override
    public ComposanteDto saveComposante(ComposanteDto composanteDto) {
        // Converts the dto composante to the composante entity
        Composante composante = composanteDtoToEntity(composanteDto);
        // Save the composante entity
        composante = composanteRepository.save(composante);
        // Return the new dto
        return composanteEntityToDto(composante);
    }

    @Override
    public ComposanteDto getComposanteById(Long composanteId) {
        Composante composante = composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
        return composanteEntityToDto(composante);
    }

    @Override
    public boolean deleteComposante(Long composanteId) {
        composanteRepository.deleteById(composanteId);
        return true;
    }

    @Override
    public List<ComposanteDto> getAllComposante() {
        List<ComposanteDto> composanteDtos = new ArrayList<>();
        List<Composante> composantes = composanteRepository.findAll();
        composantes.forEach(composante -> {
            composanteDtos.add(composanteEntityToDto(composante));
        });
        return composanteDtos;
    }

    /**
     * Map utilisateur dto to utilisateur entity
     */
    private ComposanteDto composanteEntityToDto(Composante composante){
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setId(composante.getId());
        composanteDto.setNomComposante(composante.getNomComposante());

        return composanteDto;
    }

    /**
     * Map utilisateur entity to utilisateur dto
     */
    private Composante composanteDtoToEntity(ComposanteDto composanteDto){
        Composante composante = new Composante();
        composante.setId(composante.getId());
        composante.setNomComposante(composante.getNomComposante());


        return composante;
    }
}
