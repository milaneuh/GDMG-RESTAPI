package com.app.gdmg.repository;

import com.app.gdmg.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationEntityRepository extends JpaRepository<ReservationEntity,Long> {
}
