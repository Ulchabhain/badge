package com.badgeuse.services;

import com.badgeuse.dtos.FiliereLangueDto;
import com.badgeuse.entities.*;
import com.badgeuse.repositories.FiliereLangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("filiereLangueService")
public class FiliereLangueServiceImpl implements FiliereLangueService{

    FiliereLangueRepository filiereLangueRepository;

    CoursService coursService;

    public FiliereLangueServiceImpl(FiliereLangueRepository filiereLangueRepository){
        this.filiereLangueRepository = filiereLangueRepository;
    }

    @Override
    public FiliereLangueDto saveFiliereLangue(FiliereLangueDto filiereLangueDto){
        FiliereLangue filiereLangue = filiereLangueDtoToEntity(filiereLangueDto);
        filiereLangue = filiereLangueRepository.save(filiereLangue);
        return filiereLangueEntityToDto(filiereLangue);
    }

    @Override
    public FiliereLangueDto getFiliereLangueById(Long filiereLangueId) {
        return null;
    }

    @Override
    public boolean deleteFiliereLangue(Long filiereLangueId) {
        return false;
    }

    @Override
    public List<FiliereLangueDto> getAllFiliereLangue() {
        return null;
    }


    private FiliereLangueDto filiereLangueEntityToDto(FiliereLangue filiereLangue){
        FiliereLangueDto filiereLangueDto = new FiliereLangueDto();
        filiereLangueDto.setId(filiereLangue.getId());
        filiereLangueDto.setCodeFiliereLangue(filiereLangue.getCodeFiliereLangue());
        filiereLangueDto.setNomFiliereLangue(filiereLangue.getNomFiliereLangue());
        filiereLangueDto.setComposanteFil(filiereLangue.getComposanteFil());
        //List<Cours> coursList = new ArrayList<>();
        //coursList.addAll(filiereLangue.getCoursFil());
        List<Cours> coursList = new ArrayList<>(filiereLangue.getCoursFil());
        filiereLangueDto.setCoursFil(coursList);
        return filiereLangueDto;
    }

    private FiliereLangue filiereLangueDtoToEntity(FiliereLangueDto filiereLangueDto){
        FiliereLangue filiereLangue = new FiliereLangue();
        filiereLangue.setId(filiereLangueDto.getId());
        filiereLangue.setCodeFiliereLangue(filiereLangueDto.getCodeFiliereLangue());
        filiereLangue.setNomFiliereLangue(filiereLangueDto.getNomFiliereLangue());
        filiereLangue.setComposanteFil(filiereLangueDto.getComposanteFil());
        List<Cours> cours = new ArrayList<>(filiereLangueDto.getCoursFil());
        filiereLangue.setCoursFil(cours);
        return filiereLangue;
    }
}
