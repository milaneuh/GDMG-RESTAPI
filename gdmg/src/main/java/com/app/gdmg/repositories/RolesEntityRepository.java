package com.app.gdmg.repository;

import com.app.gdmg.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesEntityRepository extends JpaRepository<RolesEntity,Long> {
    RolesEntity findByLabel(String label);
    RolesEntity findByCode(String code);
}
