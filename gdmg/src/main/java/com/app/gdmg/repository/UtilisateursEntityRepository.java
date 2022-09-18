package com.app.gdmg.repository;

import com.app.gdmg.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursEntityRepository extends JpaRepository<UtilisateurEntity,Long> {
        UtilisateurEntity findByMail(String mail);
}
