package com.app.gdmg.repositories;

import com.app.gdmg.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEntityRepository extends JpaRepository<StatusEntity,Long> {
    StatusEntity findByCode(String code);
}
