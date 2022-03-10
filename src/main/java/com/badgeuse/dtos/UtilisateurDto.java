package com.badgeuse.dtos;

import com.badgeuse.entities.TypeUtilisateur;
import lombok.Data;

@Data
public class UtilisateurDto {
    private Long Id;
    private TypeUtilisateur type;
    private String login;
    private String mdp;
    private String nom;
    private String prenom;
    private String mail;
}