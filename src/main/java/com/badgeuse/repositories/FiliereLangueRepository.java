package com.badgeuse.repositories;

import com.badgeuse.entities.FiliereLangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereLangueRepository extends JpaRepository<FiliereLangue, Long> {

}
