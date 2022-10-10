package com.app.gdmg.services;

import com.app.gdmg.entities.ReservationEntity;
import com.app.gdmg.models.ReservationBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    ResponseEntity saveReservation(ReservationBean reservationBean) throws Exception;

    ResponseEntity deleteReservation(ReservationBean reservationBean) throws Exception;

    ResponseEntity updateReservation(ReservationBean reservationBean) throws Exception;
    ResponseEntity<List<ReservationEntity>> getAllReservation();
    ResponseEntity getReservation(String code) throws Exception;

    ReservationEntity reservationBeanToReservationEntity(ReservationBean reservationBean);

}
