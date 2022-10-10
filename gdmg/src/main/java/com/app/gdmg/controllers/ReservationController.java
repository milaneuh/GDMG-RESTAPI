package com.app.gdmg.controllers;


import com.app.gdmg.entities.ReservationEntity;
import com.app.gdmg.models.ReservationBean;
import com.app.gdmg.services.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController extends BaseController{

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAllReservation")
    public ResponseEntity<List<ReservationEntity>> getAllReservation(){
        return reservationService.getAllReservation();
    }

    @GetMapping("/getReservation")
    public ResponseEntity getReservation(@RequestParam String code) throws Exception {
        return reservationService.getReservation(code);
    }

    @PostMapping(
            value = "/saveReservation",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity saveReservation(@RequestBody ReservationBean reservationBean) throws Exception {
        return reservationService.saveReservation(reservationBean);
    }

    @PostMapping(
            value = "/updateReservation",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity updateReservation(@RequestBody ReservationBean reservationBean) throws Exception{
        return reservationService.updateReservation(reservationBean);
    }

    @PostMapping(
            value = "/deleteReservation",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity deleteReservation(@RequestBody ReservationBean reservationBean)throws Exception{
        return reservationService.deleteReservation(reservationBean);
    }

}
