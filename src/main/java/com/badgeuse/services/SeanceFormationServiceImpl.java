package com.badgeuse.services;

import com.badgeuse.dtos.CreneauDto;
import com.badgeuse.dtos.SeanceFormationDto;
import com.badgeuse.dtos.UtilisateurDto;
import com.badgeuse.entities.*;
import com.badgeuse.repositories.CreneauRepository;
import com.badgeuse.repositories.SeanceFormationRepository;
import com.badgeuse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceFormationServiceImpl implements SeanceFormationService {
    @Autowired
    SeanceFormationRepository seanceRepository;
    @Autowired
    CreneauService creneauService;
    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public SeanceFormationDto saveSeance(SeanceFormationDto seanceFormationDto) {
        // Converts the seance to the seeance entity
        SeanceFormation seance = seanceDtoToEntity(seanceFormationDto);
        // Save the seance entity
        seance = seanceRepository.save(seance);
        // Return the new dto
        return seanceEntityToDto(seance);
    }

    @Override
    public SeanceFormationDto getSeanceById(Long seanceFormationId) {
        SeanceFormation seance = seanceRepository.findById(seanceFormationId).orElseThrow(() -> new EntityNotFoundException("Seance not found"));
        return seanceEntityToDto(seance);
    }

    @Override
    public boolean deleteSeance(Long seanceId) {
        seanceRepository.deleteById(seanceId);
        return true;
    }

    @Override
    public List<SeanceFormationDto> getAllSeances() {
        List<SeanceFormationDto> seanceDtos = new ArrayList<>();
        List<SeanceFormation> seances = seanceRepository.findAll();
        seances.forEach(seance -> {
            seanceDtos.add(seanceEntityToDto(seance));
        });
        return seanceDtos;
    }

    /**
     * Map utilisateur dto to utilisateur entity
     */
    private SeanceFormationDto seanceEntityToDto(SeanceFormation seance){
        SeanceFormationDto seanceDto = new SeanceFormationDto();
        seanceDto.setId(seance.getId());
        seanceDto.setEstEffectue(seance.getEstEffectue());
        seanceDto.setEstValide(seance.getEstValide());
        seanceDto.setCommentaire(seance.getCommentaire());
        seanceDto.setCreneauId(seance.getCreneauSea().getId());
        seanceDto.setVacataireId(seance.getVacataireSea().getId());
        return seanceDto;
    }

    /**
     * Map utilisateur entity to utilisateur dto
     */
    private SeanceFormation seanceDtoToEntity(SeanceFormationDto seanceDto){
        SeanceFormation seance = new SeanceFormation();
        seance.setId(seanceDto.getId());
        seance.setEstEffectue(seanceDto.getEstEffectue());
        seance.setEstValide(seanceDto.getEstValide());
        seance.setCommentaire(seanceDto.getCommentaire());

        CreneauDto creneauDto = creneauService.getCreneauById(seanceDto.getCreneauId());
        seance.setCreneauSea(creneauDtoToEntity(creneauDto));

        UtilisateurDto utilisateurDto = utilisateurService.getUtilisateurById(seanceDto.getVacataireId());
        seance.setVacataireSea(utilisateurDtoToEntity(utilisateurDto));

        return seance;
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

    /**
     * Map utilisateur entity to utilisateur dto
     */
    private Utilisateur utilisateurDtoToEntity(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setType(utilisateurDto.getType());
        utilisateur.setLogin(utilisateurDto.getLogin());
        utilisateur.setMotDePasse(utilisateurDto.getMdp());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMail(utilisateurDto.getMail());

        switch (utilisateurDto.getType()) {
            case VACATAIRE:

                break;

            case RESPONSABLE:

                break;

            case GESTIONNAIRE:

                break;

            default:
                break;
        }
        return utilisateur;
    }
}
