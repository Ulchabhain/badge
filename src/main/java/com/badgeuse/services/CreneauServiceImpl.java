package com.badgeuse.services;


import com.badgeuse.dtos.CreneauDto;
import com.badgeuse.entities.Creneau;
import com.badgeuse.entities.SeanceFormation;
import com.badgeuse.repositories.CreneauRepository;
import com.badgeuse.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("creneauService")
public class CreneauServiceImpl implements CreneauService {

    private final CreneauRepository creneauRepository;

    public CreneauServiceImpl(CreneauRepository creneauRepository){
        this.creneauRepository = creneauRepository;
    }

    @Override
    public CreneauDto saveCreneau(CreneauDto creneauDto) {
        // Converts the creneau to the creneau entity
        Creneau creneau = creneauDtoToEntity(creneauDto);
        // Save the creneau entity
        creneau = creneauRepository.save(creneau);
        // Return the new dto
        return creneauEntityToDto(creneau);
    }

    @Override
    public CreneauDto getCreneauById(Long creneauId) {
        Creneau creneau = creneauRepository.findById(creneauId).orElseThrow(() -> new EntityNotFoundException("Creneau not found"));
        return creneauEntityToDto(creneau);
    }

    @Override
    public boolean deleteCreneau(Long creneauId) {
        creneauRepository.deleteById(creneauId);
        return true;
    }

    @Override
    public List<CreneauDto> getAllCreneaux() {
        List<CreneauDto> creneauDtos = new ArrayList<>();
        List<Creneau> creneaux = creneauRepository.findAll();
        creneaux.forEach(creneau -> {
            creneauDtos.add(creneauEntityToDto(creneau));
        });
        return creneauDtos;
    }


    /**
     * Map creneau dto to creneau entity
     */
    private CreneauDto creneauEntityToDto(Creneau creneau){
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setId(creneau.getId());
        creneauDto.setDate_heure(creneau.getDate_heure());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setType(creneau.getType());
        creneauDto.setCours(creneau.getCoursCre().getId());
        List<Long> seances = new ArrayList<>();
        for (int i = 0; i < creneau.getSeancesCre().size(); i++) {
            seances.add(creneau.getSeancesCre().get(i).getId());
        }
        creneauDto.setSeances(seances);
        return creneauDto;
    }

    /**
     * Map creneau entity to creneau dto
     */
    private Creneau creneauDtoToEntity(CreneauDto creneauDto){
        Creneau creneau = new Creneau();
        creneau.setId(creneauDto.getId());
        creneau.setDate_heure(creneauDto.getDate_heure());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setType(creneauDto.getType());
        //creneau.setCoursCre(creneauDto.getCours());
        List<SeanceFormation> seances = new ArrayList<>();
        for (int i = 0; i < creneau.getSeancesCre().size(); i++) {
        }
        creneau.setSeancesCre(seances);
        return creneau;
    }
}
