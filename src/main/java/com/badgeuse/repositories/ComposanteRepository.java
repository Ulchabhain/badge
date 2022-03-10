package com.badgeuse.repositories;

import com.badgeuse.entities.Composante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposanteRepository extends JpaRepository<Composante, Long> {
}