package com.badgeuse.services;

import com.badgeuse.dtos.CoursDto;
import com.badgeuse.dtos.CreneauDto;
import com.badgeuse.dtos.UtilisateurDto;
import com.badgeuse.entities.*;
import com.badgeuse.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

import java.util.List;

@Service
public class CoursServiceImpl implements CoursService{
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    CreneauService creneauService;

    @Override
    public CoursDto saveCours(CoursDto coursDto) {
        // Converts the cours to the cours entity
        Cours cours = coursDtoToEntity(coursDto);
        // Save the utilisateur entity
        cours = coursRepository.save(cours);
        // Return the new dto
        return coursEntityToDto(cours);
    }

    @Override
    public CoursDto getCoursById(Long coursId) {
        Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new EntityNotFoundException("Cours not found"));
        return coursEntityToDto(cours);
    }

    @Override
    public boolean deleteCours(Long coursId) {
        coursRepository.deleteById(coursId);
        return true;
    }

    @Override
    public List<CoursDto> getAllCours() {
        List<CoursDto> coursDtos = new ArrayList<>();
        List<Cours> cours = coursRepository.findAll();
        cours.forEach(cours1 -> {
            coursDtos.add(coursEntityToDto(cours1));
        });
        return coursDtos;
    }

    /**
     * Map cours dto to cours entity
     */
    private CoursDto coursEntityToDto(Cours cours){
        CoursDto coursDto = new CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());

        ArrayList<Long> vacatairesId = new ArrayList<>();
        for (int i = 0; i < cours.getVacatairesCou().size(); i++) {
            vacatairesId.add(cours.getVacatairesCou().get(i).getId());
        }
        coursDto.setVacatairesId(vacatairesId);

        ArrayList<Long> creneauxId = new ArrayList<>();
        for (int i = 0; i < cours.getCreneauxCou().size(); i++) {
            vacatairesId.add(cours.getCreneauxCou().get(i).getId());
        }
        coursDto.setCreneauxId(creneauxId);

        return coursDto;
    }

    /**
     * Map cours entity to cours dto
     */
    private Cours coursDtoToEntity(CoursDto coursDto){
        Cours cours = new Cours();
        cours.setId(coursDto.getId());
        cours.setIntitule(coursDto.getIntitule());

        List<Utilisateur> utilisateurs = new ArrayList<>();
        if (coursDto.getCreneauxId() != null) {
            for (int i = 0; i < coursDto.getVacatairesId().size(); i++) {
                UtilisateurDto utilisateur = utilisateurService.getUtilisateurById(coursDto.getVacatairesId().get(i));
                utilisateurs.add(utilisateurDtoToEntity(utilisateur));
            }
        }
        cours.setVacatairesCou(utilisateurs);

        List<Creneau> creneaux = new ArrayList<>();
        if (coursDto.getCreneauxId() != null) {
            for (int i = 0; i < coursDto.getCreneauxId().size(); i++) {
                CreneauDto creneau = creneauService.getCreneauById(coursDto.getCreneauxId().get(i));
                creneaux.add(creneauDtoToEntity(creneau));
            }
        }
        cours.setCreneauxCou(creneaux);

        return cours;
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
