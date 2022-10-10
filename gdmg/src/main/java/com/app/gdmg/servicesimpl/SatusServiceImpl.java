package com.app.gdmg.servicesimpl;

import com.app.gdmg.entities.StatusEntity;
import com.app.gdmg.models.StatusBean;
import com.app.gdmg.repositories.StatusEntityRepository;
import com.app.gdmg.services.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SatusServiceImpl implements StatusService {
    public final StatusEntityRepository statusEntityRepository;
    static Logger log = Logger.getLogger(SatusServiceImpl.class.getName());

    @Override
    public ResponseEntity saveStatus(StatusBean status) {
        StatusEntity statusEntity = statusBeanToStatusEntity(status);
        statusEntityRepository.save(statusEntity);
        return ResponseEntity.ok().body(statusEntityRepository.findByCode(statusEntity.getCode()));
    }

    @Override
    public ResponseEntity updateStatus(StatusBean status) throws Exception {
            StatusEntity statusEntity = statusEntityRepository.findByCode(status.getCode());
            if (statusEntity != null){
                statusEntity.setLabel(status.getLabel());
                statusEntityRepository.save(statusEntity);
                return ResponseEntity.ok().body(statusEntityRepository.findByCode(statusEntity.getCode()));
            }else {
                log.info("Le status '"+status.getLabel()+"' n'existe pas");
                return ResponseEntity.notFound().build();
            }
    }

    @Override
    public ResponseEntity deleteStatus(StatusBean status) throws Exception {

        StatusEntity statusEntity = statusEntityRepository.findByCode(status.getCode());
        if(statusEntity != null) {
            statusEntityRepository.delete(statusEntity);
            StatusEntity result = statusEntityRepository.findByCode(status.getCode());
            return ResponseEntity.ok().body(result);
        }else {
            log.info("Le status '"+status.getLabel()+"' n'existe pas");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity getStatus(String code) throws Exception {
        StatusEntity statusEntity = statusEntityRepository.findByCode(code);
        if(statusEntity != null){
            return ResponseEntity.ok().body(statusEntity);
        }else {
            log.info("Le status '"+code+"' n'existe pas");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity getAllStatus() {
        List<StatusEntity> statusEntityList = statusEntityRepository.findAll();
        return ResponseEntity.ok().body(statusEntityList);
    }

    @Override
    public StatusEntity statusBeanToStatusEntity(StatusBean status) {
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setCode(status.getCode());
        statusEntity.setLabel(status.getLabel());

        return statusEntity;
    }

    @Override
    public StatusBean statusEntityToStatusBean(StatusEntity status) {
        StatusBean statusBean = new StatusBean();
        statusBean.setCode(status.getCode());
        statusBean.setLabel(status.getLabel());
        return statusBean;
    }

    @Override
    public List<StatusEntity> listStatusBeanToListStatusEntity(List<StatusBean> status) {
        List<StatusEntity> statusEntityList = new ArrayList<>();
        for(int i = 0;i < status.size(); i++){
            statusEntityList.add(statusBeanToStatusEntity(status.get(i)));
        }
        return statusEntityList;
    }

    @Override
    public List<StatusBean> listStatusEntityToListStatusBean(List<StatusEntity> status) {
        List<StatusBean> statusEntityList = new ArrayList<>();
        for(int i = 0;i < status.size(); i++){
            statusEntityList.add(statusEntityToStatusBean(status.get(i)));
        }
        return statusEntityList;
    }


    public SatusServiceImpl(StatusEntityRepository statusEntityRepository) {
        this.statusEntityRepository = statusEntityRepository;
    }

}
