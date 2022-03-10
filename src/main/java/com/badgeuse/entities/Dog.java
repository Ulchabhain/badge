package com.badgeuse.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Dog {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String race;
	private LocalDate birthDate;	
	
}
