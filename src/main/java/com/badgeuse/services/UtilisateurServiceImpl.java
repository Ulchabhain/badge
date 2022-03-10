package com.badgeuse.services;

import com.badgeuse.dtos.UtilisateurDto;
import com.badgeuse.entities.*;
import com.badgeuse.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {
        // Converts the utilisateur to the utilisateur entity
        Utilisateur utilisateur = utilisateurDtoToEntity(utilisateurDto);
        // Save the utilisateur entity
        utilisateur = utilisateurRepository.save(utilisateur);
        // Return the new dto
        return utilisateurEntityToDto(utilisateur);
    }

    @Override
    public UtilisateurDto getUtilisateurById(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        return utilisateurEntityToDto(utilisateur);
    }

    @Override
    public boolean deleteUtilisateur(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
        return true;
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        utilisateurs.forEach(utilisateur -> {
            utilisateurDtos.add(utilisateurEntityToDto(utilisateur));
        });
        return utilisateurDtos;
    }
    /**
     * Map utilisateur dto to utilisateur entity
     */
    private UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur){
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMdp(utilisateur.getMotDePasse());
        utilisateurDto.setNom(utilisateur.getNom());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMail(utilisateur.getMail());

        switch (utilisateur.getType()) {
            case VACATAIRE:
                utilisateurDto.setType(TypeUtilisateur.VACATAIRE);
                break;

            case RESPONSABLE:
                utilisateurDto.setType(TypeUtilisateur.RESPONSABLE);
                break;

            case GESTIONNAIRE:
                utilisateurDto.setType(TypeUtilisateur.GESTIONNAIRE);
                break;

            default:
                break;
        }

        return utilisateurDto;
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
