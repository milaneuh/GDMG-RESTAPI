package com.app.gdmg.repositories;

import com.app.gdmg.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationEntityRepository extends JpaRepository<ReservationEntity,Long> {

    ReservationEntity findByDateDebut(Date date);
    ReservationEntity findByDateFin(Date date);
    ReservationEntity findByCode(String code);
    ReservationEntity findByDateCreation(Date date);



}
