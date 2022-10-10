package com.app.gdmg.servicesimpl;

import com.app.gdmg.entities.ReservationEntity;
import com.app.gdmg.entities.StatusEntity;
import com.app.gdmg.entities.UtilisateurEntity;
import com.app.gdmg.models.ReservationBean;
import com.app.gdmg.repositories.ReservationEntityRepository;
import com.app.gdmg.repositories.StatusEntityRepository;
import com.app.gdmg.repositories.UtilisateursEntityRepository;
import com.app.gdmg.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService
{
    ReservationEntityRepository reservationEntityRepository;
    UtilisateursEntityRepository utilisateursEntityRepository;

    StatusEntityRepository statusEntityRepository;

    public ReservationServiceImpl(ReservationEntityRepository reservationEntityRepository, UtilisateursEntityRepository utilisateursEntityRepository, StatusEntityRepository statusEntityRepository) {
        this.reservationEntityRepository = reservationEntityRepository;
        this.utilisateursEntityRepository = utilisateursEntityRepository;
        this.statusEntityRepository = statusEntityRepository;
    }

    @Override
    public ResponseEntity saveReservation(ReservationBean reservationBean) throws Exception {
        if (checkReservationDates(reservationBean)){
            if(reservationClientExist(reservationBean.getClientMail()) && reservationStatusExist(reservationBean.getCodeStatus())){
                UtilisateurEntity client = utilisateursEntityRepository.findByMail(reservationBean.getClientMail());
                StatusEntity status = statusEntityRepository.findByCode(reservationBean.getCodeStatus());

                ReservationEntity reservationEntityToReturn = reservationBeanToReservationEntity(reservationBean);

                reservationEntityToReturn.setStatut(status);

                reservationEntityToReturn.setClient(client);

                reservationEntityRepository.save(reservationEntityToReturn);
                return ResponseEntity.ok().body(reservationEntityRepository.findByCode(reservationEntityToReturn.getCode()));
            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity deleteReservation(ReservationBean reservationBean) throws Exception {

        ReservationEntity reservationEntity = reservationEntityRepository.findByCode(reservationBean.getCode());
        if (reservationEntity != null){
            reservationEntityRepository.delete(reservationEntity);
            return  ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity updateReservation(ReservationBean reservationBean) throws Exception {
        ReservationEntity reservationEntity = reservationEntityRepository.findByCode(reservationBean.getCode());
        if (reservationEntity != null){
            reservationEntity = parseBeanDataIntoEntity(reservationEntity,reservationBean);
            reservationEntityRepository.save(reservationEntity);
            return ResponseEntity.ok().body(reservationEntityRepository.findByCode(reservationEntity.getCode()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<ReservationEntity>> getAllReservation() {
        return ResponseEntity.ok().body(reservationEntityRepository.findAll());
    }

    @Override
    public ResponseEntity getReservation(String code) throws Exception {
        ReservationEntity reservationEntity = reservationEntityRepository.findByCode(code);
        if (reservationEntity != null){
            return ResponseEntity.ok().body(reservationEntity);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ReservationEntity reservationBeanToReservationEntity(ReservationBean reservationBean) {
        return  new ReservationEntity(
                reservationBean.getCode(),
                reservationBean.getOrigine(),
                reservationBean.getAdulte(),
                reservationBean.getEnfant(),
                reservationBean.getBebe(),
                reservationBean.getAnimaux(),
                reservationBean.getPrecisionAnimaux(),
                reservationBean.getPrecisionEnfants(),
                reservationBean.getDateDebut(),
                reservationBean.getDateFin(),
                reservationBean.getAdresse(),
                reservationBean.getComplementAdresse(),
                reservationBean.getCodePostal(),
                reservationBean.getVille(),
                reservationBean.getPays(),
                reservationBean.getDateCreation(),
                reservationBean.getPrixLocation(),
                reservationBean.getTaxeSejour(),
                reservationBean.getPrixMenage(),
                reservationBean.getPrixChauffage(),
                reservationBean.getPrixServiettes(),
                reservationBean.getMontantRegle(),
                reservationBean.getResteAPercevoir());
    }


    public Boolean checkReservationDates(ReservationBean reservationBean){
        if (reservationEntityRepository.findByDateDebut(reservationBean.getDateDebut()) == null){
            if (reservationEntityRepository.findByDateFin(reservationBean.getDateFin()) == null){
                return true;
            }else return false;
        }else return false;
    }

    public Boolean reservationClientExist(String mail){
        if (utilisateursEntityRepository.findByMail(mail) != null){
            return true;
        }else return false;
    }

    public Boolean reservationStatusExist(String code){
        if (statusEntityRepository.findByCode(code) != null){
            return true;
        }else return false;
    }

    public ReservationEntity parseBeanDataIntoEntity(ReservationEntity reservationEntity,ReservationBean reservationBean){
        reservationEntity.setOrigine(reservationBean.getOrigine());
        reservationEntity.setAdresse(reservationBean.getAdresse());
        reservationEntity.setVille(reservationBean.getVille());
        reservationEntity.setCodePostal(reservationBean.getCodePostal());
        reservationEntity.setPays(reservationBean.getPays());
        reservationEntity.setComplementAdresse(reservationBean.getComplementAdresse());
        reservationEntity.setAdulte(reservationBean.getAdulte());
        reservationEntity.setEnfant(reservationBean.getEnfant());
        reservationEntity.setBebe(reservationBean.getBebe());
        reservationEntity.setPrecisionAnimaux(reservationBean.getPrecisionAnimaux());
        reservationEntity.setPrecisionAnimaux(reservationBean.getPrecisionAnimaux());
        reservationEntity.setDateDebut(reservationBean.getDateDebut());
        reservationEntity.setDateFin(reservationBean.getDateFin());
        reservationEntity.setPrixLocation(reservationBean.getPrixLocation());
        reservationEntity.setPrixMenage(reservationBean.getPrixMenage());
        reservationEntity.setPrixChauffage(reservationBean.getPrixChauffage());
        reservationEntity.setPrixServiettes(reservationBean.getPrixServiettes());
        reservationEntity.setTaxeSejour(reservationBean.getTaxeSejour());
        reservationEntity.setResteAPercevoir(reservationBean.getResteAPercevoir());
        reservationEntity.setMontantRegle(reservationBean.getMontantRegle());
        return reservationEntity;
    }


}
